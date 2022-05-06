package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.LasFrasesBinding
import java.text.SimpleDateFormat
import java.util.*

class LasFrasesFragment : Fragment() {
    val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy")

    val currentDateAndTime: String?
        get() {
           return currentDateAndTime
        }
    private var _binding: LasFrasesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LasFrasesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        button_start_recording.setOnClickListener {
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
//                ActivityCompat.requestPermissions(this, permissions,0)
//            } else {
//                startRecording()
//            }
//        }
//
//        button_stop_recording.setOnClickListener{
//            stopRecording()
//        }
//
//        button_pause_recording.setOnClickListener {
//            pauseRecording()
//        }
        //binding.textView10.text = "hello"
        setFragmentResultListener("requestKey2")
        { requestKey, bundle ->

            // We use a String here, but any type that can be put in a Bundle is supported
            val result2 = bundle.getString("bundleKey2")
            println("ooga Booga$result2")
            val lessonName = context?.let { getDrawableByFileName(it, result2) }

            //THIS PRINTS INFO FROM THE DATABASE TO SCREEN
            // binding.lessonID.text = result.toString().replaceFirstChar { it.titlecase() }
            //binding.lessonWord.text = result.toString().replaceFirstChar { it.titlecase() }
            //binding.lessonInstruction.text ="Slowly and as best that you can, say " + result.toString().uppercase()//replaceFirstChar { it.uppercase() }
            //wordGlobal = binding.lessonWord.text.toString()
            binding.textView10.text = result2.toString().replaceFirstChar { it.titlecase() }
            binding.imageView7.setImageDrawable(lessonName)
        }

        binding.next.setOnClickListener {
            //val result = true
            // Use the Kotlin extension in the fragment-ktx artifact
            //setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lasFrasesFragment_to_HomeFragment)
            val currentDateAndTime: String = simpleDateFormat.format(Date())

            if (timerCheck == true) {               // Button that takes you to the homepage
                val lessonCounter = lessonCounterP + 1
                val check = SimpleDateFormat("MM/dd/yyyy")
                val currentDate = check.format(Date())
                /*
                if (currentDateAndTime == currentDate){

                }

                 */
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
/*
________00000000000___________000000000000_________
______00000000_____00000___000000_____0000000______
____0000000_____________000______________00000_____
___0000000_______________0_________________0000____
__000000____________________________________0000___
__00000_____________________________________ 0000__
_00000______________________________________00000__
_00000_____________________________________000000__
__000000_________________________________0000000___
___0000000______________________________0000000____
_____000000____________________________000000______
_______000000________________________000000________
__________00000_____________________0000___________
_____________0000_________________0000_____________
_______________0000_____________000________________
_________________000_________000___________________
_________________ __000_____00_____________________
______________________00__00_______________________
________________________00_________________________

 */