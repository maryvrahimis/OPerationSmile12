package com.example.myapplication

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



        val realm = Realm.getDefaultInstance()
        val lesson : RealmQuery<Lesson>? = realm.where<Lesson>().equalTo("word","pollo")
        //val results = lesson.equalTo("word","pollo")
        var hello : String = lesson.toString()
        _binding = IndieLessonsBinding.inflate(inflater, container, false)
        binding.Lessonid.text = hello
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
