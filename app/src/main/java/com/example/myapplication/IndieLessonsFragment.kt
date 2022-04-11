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
        val query = realm.where(Lesson::class.java)
        val lesson = query.rawPredicate("word = 'pollo'").findAll()
        //val lesson : RealmQuery<Lesson>? = realm.where<Lesson>().beginsWith("image","pollo")
        Log.v("QUICKSTART", lesson.toString())
        //val results = lesson.equalTo("word","pollo")
        //var hello : RealmQuery<Lesson>? = lesson
        Log.v("QUICKSTART", lesson.toString())
        realm.close()
        _binding = IndieLessonsBinding.inflate(inflater, container, false)
        binding.textView6.text = "Hi"
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




