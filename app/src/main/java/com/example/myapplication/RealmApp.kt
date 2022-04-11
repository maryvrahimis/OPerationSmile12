package com.example.myapplication







/*
open class Lesson(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var image: String? = null,

    var instructions: String? = null,

    var phrase: String? = null,

    var sound: String? = null,

    var syllables: String? = null,

    var videoInstructions: String? = null,

    var word: String? = null
): RealmObject() {}

 */
/*
open class Mascot(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    @Required
    var currentAccessories: RealmList<String> = RealmList(),

    var patientId: ObjectId? = null,

    var stickerList: String? = null
): RealmObject() {}

open class Parent_Guardian(
@PrimaryKey var _id: ObjectId? = null,

var _partition: String = "",

var parent_guardianID: ObjectId? = null,

var password: String? = null,

var patientID: ObjectId? = null,

var therapistID: ObjectId? = null,

var username: String? = null
): RealmObject() {}

open class Patient(
    @PrimaryKey var _id: ObjectId? = null,

    var Recordings: Patient_Recordings? = null,

    var _partition: String = "",

    var accountType: String? = null,

    var age: Long = 0,

    var lessons: Patient_lessons? = null,

    var mascot: Patient_mascot? = null,

    var name: String = "",

    var numOfPoints: Long? = null,

    var parent_guardianID: ObjectId? = null,

    var password: String = "",

    var patientID: ObjectId? = null,

    var username: String = ""
): RealmObject() {}



open class Recording(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var audioRecordings: String? = null,

    var date: Date? = null,

    var soundType: String? = null
): RealmObject() {}

open class Therapist(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var accountType: String? = null,

    var age: Long? = null,

    var email: String? = null,

    var name: String? = null,

    var password: String? = null,

    @Required
    var patientList: RealmList<String> = RealmList(),

    var phone: String? = null,

    var tID: ObjectId? = null,

    var username: String? = null
): RealmObject() {}

open class Purchase(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var patientID: ObjectId? = null,

    var sticker: String? = null,

    var stickerPrice: Long? = null
): RealmObject() {}

open class stickerList(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var numOfPoints: Long? = null,

    var sticker: String? = null,

    var stickerPrice: Long? = null
): RealmObject() {}

open class Login(
    @PrimaryKey var _id: ObjectId? = null,

    var _partition: String = "",

    var email: String? = null,

    var name: String? = null,

    var password: String? = null,

    var salt: String? = null
): RealmObject() {}
*/
/*
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


}*/