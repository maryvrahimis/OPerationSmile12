package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.exceptions.RealmFileException
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import org.bson.types.ObjectId


//var closetStringList: List<String> = listOf()
var closetStringsArrList = ArrayList<StickerBundle>()
var childName = ""
var closet = listOf<String>()
var currentStickerAppVar = ""
var points1 = 0
var currentStickerI = R.drawable.bird
var closeyString = ""
var nameOfPatient = " "
var res = R.drawable.bird
var timerCheck: Boolean = false
var lessonCounterP = 0
var lessonCounterT = 0
var lessonCounterL = 0
var lessonCounterK = 0
var arr: Array<StickerBundle> = arrayOf(StickerBundle("tshirt",  15,"tshirtbird", stickerId = R.drawable.tshirt, stickerBirdId = R.drawable.tshirtbird, R.id.detailTshirt),
    StickerBundle("flag",  20,"flagbird", R.drawable.flag, R.drawable.flagbird, R.id.flagDetail),
    StickerBundle("hat",  30,"hatbird", R.drawable.hat, R.drawable.hatbird, R.id.hatDetail),
    StickerBundle("sunglasses",  15,"sunglasses", R.drawable.sunglasses, R.drawable.sunglassesbird, R.id.detailSunglasses),
    StickerBundle("sneakers", 30,"sneakersbird", R.drawable.sneakers, R.drawable.sneakersbird, R.id.detailSneaker),
    StickerBundle("pinkboots",  20,"pinkbootsbird", R.drawable.pinkboots, R.drawable.pinkbootsbird, R.id.detailPinkBoots),
    StickerBundle("bball",  50,"bballbird", R.drawable.bball, R.drawable.bballbird, R.id.bballdetail),
    StickerBundle("easter",  50,"easterbird", R.drawable.easter, R.drawable.easterbird, R.id.easterDetail),
    StickerBundle("halloween",  50,"halloweenbird", R.drawable.halloween, R.drawable.halloweenbird, R.id.halloweenDetail),
    StickerBundle("santahat",  10,"santahatbird", R.drawable.santahat, R.drawable.santahatbird, R.id.detailSanta)
)


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
//
                try {
                    realm = Realm.getInstance(config)
                    Realm.setDefaultConfiguration(config)
                    Log.v(TAG, "Successfully opened a realm at: ${realm.path}")

                    realm.executeTransaction { r: Realm ->
                        // Instantiate the class using the factory function.
                        val taskA = realm.where(Patients::class.java).findAll()
                        if(taskA.isEmpty()){
                            val turtle = r.createObject(Patients::class.java, ObjectId())
                            // Configure the instance.
                            turtle.name = "scott"
                            turtle.currentStickerID = R.drawable.bird
                            turtle.points = 100
                            points1 = turtle.points!!
                            nameOfPatient = turtle.name.toString()
                            currentStickerI = turtle.currentStickerID!!
                            closeyString = turtle.closetAsAString.toString()
                            childName = turtle.name!!

                        }
                        else{
                            val taskB = realm.where(Patients::class.java).findFirst()
                            if (taskB != null) {
                                points1 = taskB.points!!
                                nameOfPatient = taskB.name.toString()
                                currentStickerI = taskB.currentStickerID!!
                                currentStickerAppVar = taskB.currentSticker.toString()
                                if (closeyString.length>0){
                                    closet = closeyString.split(" ")
                                    for(d in closet){
                                        for(e in arr){
                                            if(d == e.birdWeaaringSticker){
                                                e.inCloset = true
                                                e.available = false
                                            }
                                        }

                                    }

                                }
                                childName = nameOfPatient
                            }

                        }
                        for(m in closet){
                            for(z in arr){
                                if(m == z.birdWeaaringSticker){
                                    z.available = false
                                    z.inCloset = true
                                }
                            }

                        }

                        /*
                        turtle.name = "sid"
                        turtle.currentStickerID = R.drawable.bird
                        turtle.points = 70

                         */


                    }


                    //val task2 = realm.where(Lessons::class.java).equalTo("word","Max").findFirst()




                    //Log.v("EXAMPLE", "Fetched Max: ${task.toString()}")
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


    }//oncreate end

    // second part of realm


    override fun onDestroy() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { r: Realm ->
            val save = realm.where(Patients::class.java).equalTo("name", "lee").findFirst()
            if (save != null) {

                save.points = points1
                save.currentStickerID = currentStickerI
                save.currentSticker = currentStickerAppVar
                for(i in arr){
                    if(i.inCloset == true){
                        closeyString = "${closeyString} ${i.birdWeaaringSticker}"

                    }

                }
                save.closetAsAString = closeyString
                realm.insertOrUpdate(save)
                // save.closetAsAString = closetString
            }

        }
        realm.close()
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

open class Patients(
    @PrimaryKey    var _id: ObjectId? = null,

    var name: String? = null,

    var Type: String? = null,

    var age: Int? = null,

    var username: String? = null,

    var password: String? = null,

    var points: Int? = null,

    var k_sounds_completed: Boolean? = null,

    var p_sounds_completed: Boolean? = null,

    var l_sounds_completed: Boolean? = null,

    var t_sounds_completed: Boolean? = null,

    var k_sounds_completed_time: String? = null,

    var p_sounds_completed_time: String? = null,

    var l_sounds_completed_time: String? = null,

    var t_sounds_completed_time: String? = null,

    var accountType: String? = null,

  // var closet: List<String> = emptyList(),

    var currentSticker: String? = null,


    var currentStickerID: Int? = null,

    var closetAsAString: String? = null,



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



open class Login(
    @PrimaryKey var _id: ObjectId? = null,

    var email: String? = null,

    var name: String? = null,

    var salt: String? = null,

    var password: String? = null,

    var Type: String? = null
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