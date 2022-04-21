package com.example.myapplication

import android.content.ContentValues.TAG
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
import io.realm.*
import io.realm.annotations.PrimaryKey
import io.realm.exceptions.RealmFileException
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
    public var done: Boolean = false
    lateinit var realm: Realm
    lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init Realm
        Realm.init(this)
        val appID : String = "opsmiletracker-awmho";
        app = App(AppConfiguration.Builder(appID)
            .build())
        val credentials: Credentials = Credentials.anonymous()
        //      USER AUTH
        //      USER AUTH
        var user: User? = null
        app.loginAsync(credentials) {
            if (it.isSuccess) {
                Log.v(TAG, "Successfully authenticated anonymously.")
                user = app.currentUser()

                val config = RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .allowQueriesOnUiThread(true)
                    .allowWritesOnUiThread(true)
                    .build()
                // THIS GETS THE INSTANCE
                // EXECUTES A TRANSACTION TO ADD TO THE DATABASE
                // PULLS A NAME(WORD) FROM THE DATABASE

                try {
                    realm = Realm.getInstance(config)
                    Realm.setDefaultConfiguration(config)
                    Log.v(TAG, "Successfully opened a realm at: ${realm.path}")

                    realm.executeTransaction { r: Realm ->
                        // Instantiate the class using the factory function.
                        val turtle = r.createObject(Lessons::class.java, ObjectId())
                        // Configure the instance.
                        turtle.word = "pan"
                    }
                    val task = realm.where(Lessons::class.java).equalTo("word","SLICKBACK").findAll()
                    val task2 = realm.where(Lessons::class.java).equalTo("word","Max").findFirst()
                    if (task2 != null) {
                        println("THIS IS A TEST ${task2.word}")
                    }
                    task.forEach{ task -> println("Turtle: ${task.word}") }



                    Log.v("EXAMPLE", "Fetched Max: $task")
                    realm.close()
                } catch(ex: RealmFileException) {
                    Log.v("EXAMPLE", "Error opening the realm.")
                    Log.v("EXAMPLE", ex.toString())
                }
            } else {
                Log.e(TAG, it.error.toString())
            }
        }




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


    override fun onDestroy() {
        super.onDestroy()


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

open class Lessons(
    @PrimaryKey    var _id: ObjectId? = null,

    var image: String? = null,

    var sound: String? = null,

    var word: String? = null
): RealmObject() {}

open class Stickers(
    @PrimaryKey    var _id: ObjectId? = null,

    var availlable: Boolean? = null,

    var birdWeaaringSticker: String? = null,

    var stickerName: String? = null,

    var stickerPrice: Long? = null
): RealmObject() {}


open class stickerList(
    @PrimaryKey    var _id: ObjectId? = null,

    var stickerName: String? = null,
): RealmObject() {

}

open class Purchase(
    var Points: Int? = null,

): RealmObject() {

}

open class Login(
    @PrimaryKey var _id: ObjectId? = null,

   var email: String? = null,

    var name: String? = null,

    var salt: String? = null,

    var password: String? = null
): RealmObject() {}

//interface CallBackFun2 {
//    fun onSuccess()
//
//    fun onFailure(error: String)
//}

//open class Login(
//    @PrimaryKey var _id: ObjectId? = null,
//
//    var email: String? = null,
//
//    var password: String? = null,
//
//    var salt: String? = null,
//
//    var name: String? = null
//): RealmObject() {}