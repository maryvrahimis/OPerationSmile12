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
        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy' at ' HH:mm:ss z")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime


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
        val text = parent?.getItemIdAtPosition(position).toString()

        if (parent?.getItemAtPosition(position).toString() == "Mike"){
            val newname: String = "GOd please work"
            val thishastochange: TextView = findViewById(R.id.test_name)
            thishastochange.text = newname

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}

open class Patients(
    var _id: ObjectId? = null,
    var name: String = "",
    var age: String? = null,
    var username: String? = null,
    var password: String? = null,
    var k_sounds_completed: Boolean? = null,
    var p_sounds_completed: Boolean? = null,
    var l_sounds_completed: Boolean? = null,
    var t_sounds_completed: Boolean? = null,
    var k_sounds_completed_time: String? = null,
    var p_sounds_completed_time: String? = null,
    var l_sounds_completed_time: String? = null,
    var t_sounds_completed_time: String? = null): RealmObject()



