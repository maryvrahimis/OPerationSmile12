package com.example.myapplication

import android.util.Log
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.internal.platform.runBlocking
import io.realm.mongodb.App
import io.realm.mongodb.Credentials
import io.realm.mongodb.SyncConfiguration
import io.realm.notifications.InitialResults
import io.realm.notifications.ResultsChange
import io.realm.query
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow


class Lessons : RealmObject {
    var image: String = ""
    var sound: String = ""
    var syllables: String = ""
    var word: String = ""
    var phrase: String = ""
    var instructions: String = ""
    var videoInstructions: String = ""
}

class RealmApp {
    val app: App = App.create("opsmiletracker-fbjym")
    val realm: Realm

    init {
        realm = runBlocking {
            val user = app.login(Credentials.emailPassword("davion226@gmail.com","oogabooga"))
            val config = SyncConfiguration.Builder(
                user = user,
                partitionValue = "_partition",
                schema = setOf(Lessons::class),
            ).build()

            Realm.open(config)


        }
    }


}