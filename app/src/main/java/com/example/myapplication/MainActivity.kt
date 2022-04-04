package com.example.myapplication

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding
import io.realm.OrderedRealmCollectionChangeListener
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration
import org.bson.types.ObjectId
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    lateinit var uiThreadRealm: Realm
    lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(this) // context, usually an Activity or Application

        val appID : String = "opsmiletracker-fbjym";

        app = App(
            AppConfiguration.Builder(appID)
            .build())

        val credentials: Credentials = Credentials.anonymous()

        app.loginAsync(credentials) {
            if (it.isSuccess) {
                Log.v("QUICKSTART", "Successfully authenticated anonymously.")
                val user: User? = app.currentUser()

                val partitionValue: String = "My Project"
                val config = SyncConfiguration.Builder(user, partitionValue)
                    .build()

                uiThreadRealm = Realm.getInstance(config)

                addChangeListenerToRealm(uiThreadRealm)

                val task : FutureTask<String> = FutureTask(MainActivity.BackgroundQuickStart(app.currentUser()!!), "test")
                val executorService: ExecutorService = Executors.newFixedThreadPool(2)
                executorService.execute(task)

            } else {
                Log.e("QUICKSTART", "Failed to log in. Error: ${it.error}")
            }
        }//part of realm

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }//oncreate end

    // second part of realm
    fun addChangeListenerToRealm(realm : Realm) {
        // all tasks in the realm
        val tasks : RealmResults<Lessons> = realm.where<Lessons>().findAllAsync()

        tasks.addChangeListener(OrderedRealmCollectionChangeListener<RealmResults<Lessons>> { collection, changeSet ->
            // process deletions in reverse order if maintaining parallel data structures so indices don't change as you iterate
            val deletions = changeSet.deletionRanges
            for (i in deletions.indices.reversed()) {
                val range = deletions[i]
                Log.v("QUICKSTART", "Deleted range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }

            val insertions = changeSet.insertionRanges
            for (range in insertions) {
                Log.v("QUICKSTART", "Inserted range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }

            val modifications = changeSet.changeRanges
            for (range in modifications) {
                Log.v("QUICKSTART", "Updated range: ${range.startIndex} to ${range.startIndex + range.length - 1}")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        // the ui thread realm uses asynchronous transactions, so we can only safely close the realm
        // when the activity ends and we can safely assume that those transactions have completed
        uiThreadRealm.close()
        app.currentUser()?.logOutAsync() {
            if (it.isSuccess) {
                Log.v("QUICKSTART", "Successfully logged out.")
            } else {
                Log.e("QUICKSTART", "Failed to log out, error: ${it.error}")
            }
        }
    }

    class BackgroundQuickStart(val user: User) : Runnable {

        override fun run() {
            val partitionValue: String = "_partition"
            val config = SyncConfiguration.Builder(user, partitionValue)
                .build()

            val backgroundThreadRealm : Realm = Realm.getInstance(config)

            val task : Lessons = Lessons("New Task", partitionValue)
            backgroundThreadRealm.executeTransaction { transactionRealm ->
                transactionRealm.insert(task)
            }

            // all tasks in the realm
            val tasks : RealmResults<Lessons> = backgroundThreadRealm.where<Lessons>().findAll()
/*
            // you can also filter a collection
            val tasksThatBeginWithN : List<Lessons> = tasks.where().beginsWith("name", "N").findAll()
            val openTasks : List<Lessons> = tasks.where().equalTo("status", TaskStatus.Open.name).findAll()
*/
            val otherTask: Lessons = tasks[0]!!
/*
            // all modifications to a realm must happen inside of a write block
            backgroundThreadRealm.executeTransaction { transactionRealm ->
                val innerOtherTask : Lessons = transactionRealm.where<Lessons>().equalTo("_id", otherTask._id).findFirst()!!
                innerOtherTask.status = TaskStatus.Complete.name
            }*/

            val yetAnotherTask: Lessons = tasks.get(0)!!
            val yetAnotherTaskId: ObjectId = yetAnotherTask._id
            // all modifications to a realm must happen inside of a write block
            backgroundThreadRealm.executeTransaction { transactionRealm ->
                val innerYetAnotherTask : Lessons = transactionRealm.where<Lessons>().equalTo("_id", yetAnotherTaskId).findFirst()!!
                innerYetAnotherTask.deleteFromRealm()
            }

            // because this background thread uses synchronous realm transactions, at this point all
            // transactions have completed and we can safely close the realm
            backgroundThreadRealm.close()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

/*You wot*/

}//main act end

open class Lessons(_name: String = "Lessons", project: String = "OpSmileTracker") : RealmObject() {
    var _id: ObjectId = ObjectId()
    var image: String = ""
    var sound: String = ""
    var syllables: String = ""
    var word: String = ""
    var phrase: String = ""
    var instructions: String = ""
    var videoInstructions: String = ""
}