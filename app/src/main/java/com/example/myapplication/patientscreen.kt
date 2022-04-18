package com.example.myapplication

import android.app.Activity
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.operationsmile.ui.theme.BgColor
import android.widget.TextView
import java.text.SimpleDateFormat
import io.realm.Realm
import org.bson.types.ObjectId
//import com.example.myapplication.databinding.ActivityPatientscreenBinding
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*


class patientscreen : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //private var _binding: ActivityPatientscreenBinding? = null
    //private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patientscreen)
        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.names_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        /*
        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy' at ' HH:mm:ss z")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime */



        /*
        val realm = Realm.getDefaultInstance()
        Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")

        //val patients = realm.where(Patients::class.java)
        realm.executeTransaction { r: Realm ->
            // Instantiate the class using the factory function.
            val patients = r.createObject(Patients::class.java, ObjectId())
            // Configure the instance.
            patients.name = "this is a test"
        }

        val task2 = realm.where(Patients::class.java).equalTo("name","John Smith").findFirst()
        if (task2 != null) {
            println("THIS IS A TEST ${task2.name}")
            // binding.textView6.text = "${task2.word}"
        }
        val opa = "${task2!!.name}"
        realm.close()
        binding.testName.text = opa */
    }

    override fun onItemSelected(parent: AdapterView<*>? , view: View?, position: Int, id: Long) {
        lateinit var realm: Realm
        //try {
        //FRAGMENT LISTEN
        //FRAGMENT LISTEN

        realm = Realm.getDefaultInstance()
        Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")

        // THIS EXECUTES A WRITE TO THE DATABASE (LIKE IN MAIN ACTIVITY)
        realm.executeTransaction { r: Realm ->
            // Instantiate the class using the factory function.
            val turtle = r.createObject(Lessons::class.java, ObjectId())
            // Configure the instance.
            turtle.word = "pina"
        }

        // IT PULLS INFO FROM DATABASE AND PUTS IT INTO A VARIABLE
        // THE VARIABLE IS THEN PRINTED TO SCREEN
        val task2 = realm.where(Lessons::class.java).equalTo("word", "pan").findFirst()
        if (task2 != null) {
            println("THIS IS A TEST ${task2.image}")
            // binding.textView6.text = "${task2.word}"
        }

        val text = parent?.getItemIdAtPosition(position).toString()

        if (parent?.getItemAtPosition(position).toString() == "Mike") {
            val nameField: TextView = findViewById(R.id.test_name)
            val ageField: TextView = findViewById(R.id.test_name2)
            val usernameField: TextView = findViewById(R.id.test_name3)
            val passwordField: TextView = findViewById(R.id.test_name4)
            val p_sounds_completed: TextView = findViewById(R.id.testname5)
            val k_sounds_completed: TextView = findViewById(R.id.testname6)
            val t_sounds_completed: TextView = findViewById(R.id.testname7)
            val l_sounds_completed: TextView = findViewById(R.id.testname8)
            nameField.text = task2.toString()
            ageField.text = "19"
            usernameField.text = "mguy12"
            passwordField.text = "mgopsmile"
            p_sounds_completed.text = "yes"
            k_sounds_completed.text = "yes"
            t_sounds_completed.text = "yes"
            l_sounds_completed.text = "yes"
        }
        if (parent?.getItemAtPosition(position).toString() == "Vinny"){
            val nameField: TextView = findViewById(R.id.test_name)
            val ageField: TextView = findViewById(R.id.test_name2)
            val usernameField: TextView = findViewById(R.id.test_name3)
            val passwordField: TextView = findViewById(R.id.test_name4)
            val p_sounds_completed: TextView = findViewById(R.id.testname5)
            val k_sounds_completed: TextView = findViewById(R.id.testname6)
            val t_sounds_completed: TextView = findViewById(R.id.testname7)
            val l_sounds_completed: TextView = findViewById(R.id.testname8)
            nameField.text = "Vinny Winny"
            ageField.text = "18"
            usernameField.text = "vwinny66"
            passwordField.text = "vwopsmile"
            p_sounds_completed.text = "no"
            k_sounds_completed.text = "yes"
            t_sounds_completed.text = "no"
            l_sounds_completed.text = "yes"
        }
        if (parent?.getItemAtPosition(position).toString() == "Gia") {
            val nameField: TextView = findViewById(R.id.test_name)
            val ageField: TextView = findViewById(R.id.test_name2)
            val usernameField: TextView = findViewById(R.id.test_name3)
            val passwordField: TextView = findViewById(R.id.test_name4)
            val p_sounds_completed: TextView = findViewById(R.id.testname5)
            val k_sounds_completed: TextView = findViewById(R.id.testname6)
            val t_sounds_completed: TextView = findViewById(R.id.testname7)
            val l_sounds_completed: TextView = findViewById(R.id.testname8)
            nameField.text = "Gia Hanes"
            ageField.text = "19"
            usernameField.text = "ghanes5"
            passwordField.text = "ghopsmile"
            p_sounds_completed.text = "no"
            k_sounds_completed.text = "no"
            t_sounds_completed.text = "no"
            l_sounds_completed.text = "no"
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}

open class Patients(
    @PrimaryKey
    var _id: ObjectId? = null,
    var name: String? = null,
    var age: String? = null,
    var username: String? = null,
    var password: String? = null,
    var points: String? = null,
    var k_sounds_completed: Boolean? = null,
    var p_sounds_completed: Boolean? = null,
    var l_sounds_completed: Boolean? = null,
    var t_sounds_completed: Boolean? = null,
    var k_sounds_completed_time: String? = null,
    var p_sounds_completed_time: String? = null,
    var l_sounds_completed_time: String? = null,
    var t_sounds_completed_time: String? = null,
    var stickerIDCloset: String? = null): RealmObject()



