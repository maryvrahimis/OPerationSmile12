package com.example.myapplication

import io.realm.Realm
import io.realm.RealmObject
import io.realm.internal.platform.runBlocking
import io.realm.mongodb.App
import io.realm.mongodb.Credentials
import io.realm.mongodb.SyncConfiguration



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
    /*
        val config = SyncConfiguration.Builder(
            user = user,
            partitionValue = PARTITION,
            schema = setOf(Lessons::class)
        ).build()
        val realm = Realm.open(config)

     */
    /*
        val user = app.login(Credentials.anonymous())
        val config = SyncConfiguration.Builder(user, "partition-value", setOf(Lessons::class)).build()
        val realm = Realm.open(config)*/




}