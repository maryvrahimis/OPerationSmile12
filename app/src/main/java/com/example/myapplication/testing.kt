package com.example.myapplication

import io.realm.notifications.ResultsChange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import android.content.Context
import android.util.Log
import io.realm.*

val configuration = RealmConfiguration.with(schema = setOf(Lessons::class)) // use the RealmConfiguration.Builder for more options
val realm = Realm.open(configuration)

// All persons


val all = realm.query<Lessons>().find()

// Persons named 'Carlo'
val personsByNameQuery = realm.query<Lessons>("name = $0", "Carlo")
val filteredByName = personsByNameQuery.find()

// Person having a dog aged more than 7 with a name starting with 'Fi'
val filteredByDog = realm.query<Lessons>("dog.age > $0 AND dog.name BEGINSWITH $1", 7, "Fi").find()

// Observing for changes with Coroutine Flows
fun main(){
    val frogs: RealmResults<Lessons> = realm.query<Lessons>().find()
    for(frog in frogs) {
        println(frog)
    }
}