package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.myapplication.databinding.IndieLessonsBinding
import io.realm.Realm
import org.bson.types.ObjectId

class IndieLessonsFragment : Fragment() {

    private var _binding: IndieLessonsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = IndieLessonsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

        //val imgUri: Uri = Uri.parse("android.resource://com.example.myapplication/bballbird.png")
        //uri = Uri.parse("android.resource://your.package.here/drawable/image_name")

        val opa = "${task2!!.word}"
        val opa3 = "${task2!!.word}"
        Log.v("EXAMPLE", "Fetched Max: $task2")

        //TAKES THE RESOURCE ID FROM LESSONS FRAGMENT AND FINDS THE IMAGE IN THE DATABASE
        setFragmentResultListener("requestKey") { requestKey, bundle ->
        // We use a String here, but any type that can be put in a Bundle is supported
         val result = bundle.getString("bundleKey")

        val opa2 = context?.let { getDrawableByFileName(it, result) }
        realm.close()
        //} catch(ex: RealmFileException) {
        //  Log.v("EXAMPLE", "Error opening the realm.")
        //Log.v("EXAMPLE", ex.toString())
        //}

        //THIS PRINTS INFO FROM THE DATABASE TO SCREEN
        binding.textView6.text = opa
        binding.Lessonid.text = opa3
        binding.imageView3.setImageDrawable(opa2)
         }
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


fun getDrawableByFileName(context: Context, fileName: String?): Drawable? {
    return ContextCompat.getDrawable(
        context,
        context.resources.getIdentifier(fileName, "drawable", context.packageName)
    )
}
