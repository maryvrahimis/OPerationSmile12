package com.example.myapplication

import android.net.Credentials
import io.realm.Realm
import io.realm.internal.platform.runBlocking
import io.realm.mongodb.App
import io.realm.mongodb.Credentials.Companion.emailPassword
import io.realm.mongodb.SyncConfiguration

class RealmApp {
    val app: App = App.create("opsmiletracker-fbjym")
    val realm: Realm = runBlocking {
        val user = app.login(Credentials.emailPassword("ddd@gmail.com","bjhbj"))
        val PARTITION = "_partition"
        val config = SyncConfiguration.Builder(
            user = user,
            partitionValue = PARTITION,
            schema = setOf("OperationSmile"::class),
        ).build()

        Realm.open(config)
    }


}