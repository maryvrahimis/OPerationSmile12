package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.IndieLessonsBinding
import io.realm.Realm
import io.realm.exceptions.RealmFileException
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
        var wordGlobal: String = "text1"
        var userWordGlobal: String = "text2"

        /*
        UNUSED BUT MAYBE STILL IMPORTANT

        val imgUri: Uri = Uri.parse("android.resource://com.example.myapplication/bballbird.png")
        uri = Uri.parse("android.resource://your.package.here/drawable/image_name")
        val opa = "${task2!!.word}"
        */

        try
        {
            val realm: Realm = Realm.getDefaultInstance()
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
            val lesson = realm.where(Lessons::class.java).equalTo("word", "pan").findFirst()
            if (lesson != null)
            {
                println("THIS IS A TEST ${lesson.image}")
                // binding.textView6.text = "${task2.word}"
            }else
            {
                realm.executeTransaction { r: Realm ->
                // Instantiate the class using the factory function.
                val turtle = r.createObject(Lessons::class.java, ObjectId())
                // Configure the instance.
                turtle.word = lesson?.word
                }
            }
            Log.v("EXAMPLE", "Fetched Max: $lesson")

            //FRAGMENT LISTEN
            //FRAGMENT LISTEN
            //TAKES THE RESOURCE ID FROM LESSONS FRAGMENT AND FINDS THE IMAGE IN THE DATABASE

            setFragmentResultListener("requestKey")
            { requestKey, bundle ->
                // We use a String here, but any type that can be put in a Bundle is supported
                val result = bundle.getString("bundleKey")
                println("vnkdjkjsdv: $result")
                val lessonName = context?.let { getDrawableByFileName(it, result) }
                realm.close()

                //THIS PRINTS INFO FROM THE DATABASE TO SCREEN
                
                binding.lessonID.text = result.toString().replaceFirstChar { it.titlecase() }
                binding.lessonWord.text = result.toString().replaceFirstChar { it.titlecase() }
                binding.lessonInstruction.text ="Slowly and as best that you can, say " + result.toString().uppercase()//replaceFirstChar { it.uppercase() }
                wordGlobal = binding.lessonWord.text.toString()
                binding.lessonImage.setImageDrawable(lessonName)

                binding.next2.setOnClickListener {
                    //val id = R.id.pato
                    //val result = resources.getResourceEntryName(id)
                    println("THIS IS R.id.pan $result")
                    // Use the Kotlin extension in the fragment-ktx artifact

                    //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
                    setFragmentResult("requestKey2", bundleOf("bundleKey2" to result))
                    findNavController().navigate(R.id.action_indieLessonsFragment_to_lasFrasesFragment)
                }
            }


        }
        catch (ex: RealmFileException)
        {
            Log.v("EXAMPLE", "Error opening the realm.")
            Log.v("EXAMPLE", ex.toString())
        }
        binding.recordButton.setOnClickListener{
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es"); intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "es"); intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,"es");
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something...")

            try {
                activityResultLauncher.launch(intent)
            }catch(exp: ActivityNotFoundException) {
                Toast.makeText(getActivity(),"Device is not supported",Toast.LENGTH_SHORT).show()
            }

        }
        activityResultLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result2: ActivityResult? ->
            if(result2!!.resultCode==RESULT_OK && result2!!.data!=null){
                val speechtext=result2!!.data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<*>
                userWordGlobal = speechtext.toString()
            }
        }
        if(userWordGlobal.equals(wordGlobal)) {

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