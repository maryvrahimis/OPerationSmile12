package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.IndieLessonsBinding
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import io.realm.Sort
import io.realm.annotations.PrimaryKey
import io.realm.kotlin.where
import io.realm.mongodb.sync.SyncConfiguration
import io.realm.RealmObject;
import io.realm.exceptions.RealmFileException
import io.realm.kotlin.createObject
import org.bson.types.ObjectId;

class IndieLessonsFragment : Fragment() {

    private var _binding: IndieLessonsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // THIS EXECUTES A WRITE TO THE DATABSE (LIKE IN MAIN ACTIVITY)
        // IT PULLS INFO FROM DATABASE AND PUTS IT INTO A VARIABLE
        // THE VARIABLE IS THEN PRINTED TO SCREEN
        lateinit var realm: Realm
        //try {
            realm = Realm.getDefaultInstance()
            Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")

            realm.executeTransaction { r: Realm ->
                // Instantiate the class using the factory function.
                val turtle = r.createObject(Lessons::class.java, ObjectId())
                // Configure the instance.
                turtle.word = "SLICKBACK"
            }



            val task2 = realm.where(Lessons::class.java).equalTo("word","SLICKBACK").findFirst()
            if (task2 != null) {
                println("THIS IS A TEST ${task2.word}")
               // binding.textView6.text = "${task2.word}"
            }
            val opa = "${task2!!.word}"
            Log.v("EXAMPLE", "Fetched Max: $task2")
            realm.close()
        //} catch(ex: RealmFileException) {
          //  Log.v("EXAMPLE", "Error opening the realm.")
            //Log.v("EXAMPLE", ex.toString())
        //}
        _binding = IndieLessonsBinding.inflate(inflater, container, false)
        //THIS PRINTS INFO FROM THE DATABASE TO SCREEN
        binding.textView6.text = opa
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
       // binding.backButton.setOnClickListener {
         //   findNavController().navigate(R.id.action_indieLessonsFragment_to_LessonsFragment)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




