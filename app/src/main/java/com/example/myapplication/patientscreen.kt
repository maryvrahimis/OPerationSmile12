package com.example.myapplication

//import com.example.myapplication.databinding.ActivityPatientscreenBinding
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import org.bson.types.ObjectId


class patientscreen : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //private var _binding: ActivityPatientscreenBinding? = null
    //private val binding get() = _binding!!
    var theSearch: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patientscreen)
        var button: Button
        var body: EditText
        body = findViewById(R.id.search)
        button = findViewById(R.id.searchButton)
        /*
        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.names_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
         */
        //val textView: TextView = findViewById(R.id.textView5)
        //textView.text = LasFrasesFragment().currentDateAndTime
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

        button.setOnClickListener(object : View.OnClickListener{

            override fun onClick(view: View?) {
                val searching = body.text.toString()    //This is what we type into the search bar
                theSearch = searching
                lateinit var realm: Realm
                realm = Realm.getDefaultInstance()

                val patient = realm.where(Patients::class.java).equalTo("name", searching) .findFirst()
                if (searching == patient!!.name) {
                    val nameField: TextView = findViewById(R.id.test_name)
                    nameField.text = patient!!.name.toString()
                    val usernameField: TextView = findViewById(R.id.test_name3)
                    val p_sounds_completed: TextView = findViewById(R.id.testname5)
                    val k_sounds_completed: TextView = findViewById(R.id.testname6)
                    val t_sounds_completed: TextView = findViewById(R.id.testname7)
                    val l_sounds_completed: TextView = findViewById(R.id.testname8)
                    usernameField.text = patient!!.username.toString()

                    p_sounds_completed.text = patient.p_sounds_completed.toString()
                    k_sounds_completed.text = patient.k_sounds_completed.toString()
                    t_sounds_completed.text = patient.t_sounds_completed.toString()
                    l_sounds_completed.text = patient.l_sounds_completed.toString()

                }

            }
        })
/*
        if (searching == patient!!.name) {
            val nameField: TextView = findViewById(R.id.test_name)
            val usernameField: TextView = findViewById(R.id.test_name3)
            val p_sounds_completed: TextView = findViewById(R.id.testname5)
            val k_sounds_completed: TextView = findViewById(R.id.testname6)
            val t_sounds_completed: TextView = findViewById(R.id.testname7)
            val l_sounds_completed: TextView = findViewById(R.id.testname8)

            nameField.text = patient!!.name.toString()
            usernameField.text = patient!!.username.toString()

            p_sounds_completed.text = patient.p_sounds_completed.toString()
            k_sounds_completed.text = patient.k_sounds_completed.toString()
            t_sounds_completed.text = patient.t_sounds_completed.toString()
            l_sounds_completed.text = patient.l_sounds_completed.toString()
        }


 */
    }

    override fun onItemSelected(parent: AdapterView<*>? , view: View?, position: Int, id: Long) {
        /*
        // THIS EXECUTES A WRITE TO THE DATABASE (LIKE IN MAIN ACTIVITY)

        realm.executeTransaction { r: Realm ->
            // Instantiate the class using the factory function.
            val turtle = r.createObject(Patients::class.java, ObjectId())
            // Configure the instance.
            turtle.name = "SLICKBACK"
            turtle.age = 69
            turtle.username = "aPimpNamedSlickback"
            turtle.password = "discordKitt3n"
            turtle.p_sounds_completed = true
            turtle.k_sounds_completed = true
            turtle.t_sounds_completed = true
            turtle.l_sounds_completed = true
        }
         */
        //val results = patient.sort("name", Sort.DESCENDING).findAll()
        //val age = realm.where(Patients::class.java).equalTo("age", "69").findFirst()
        //val text = parent?.getItemIdAtPosition(position).toString()       //We don't need this
    }
    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}


