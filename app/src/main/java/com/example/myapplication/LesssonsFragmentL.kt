package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLesssonsLBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LessonsFragmentL : Fragment() {

    private var _binding: FragmentLesssonsLBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLesssonsLBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_LessonsFragment_to_lasFrasesFragment)
            if (timerCheck == true) {               // Button that takes you to lasSilibasFragment
                val lessonCounter = lessonCounterL + 1
                val check = SimpleDateFormat("MM/dd/yyyy")
                val currentDate = check.format(Date())
                /*
                if (currentDateAndTime == currentDate){
                }
                 */
            }
        }

        binding.luz.setOnClickListener {
            val id = R.id.luz
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.leche.setOnClickListener {
            val id = R.id.leche
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.libro.setOnClickListener {
            val id = R.id.libro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lapiz.setOnClickListener {
            val id = R.id.lapiz
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lata.setOnClickListener {
            val id = R.id.lata
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lobo.setOnClickListener {
            val id = R.id.lobo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lago.setOnClickListener {
            val id = R.id.lago
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lecho.setOnClickListener {
            val id = R.id.lecho
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lechuga.setOnClickListener {
            val id = R.id.lechuga
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.pastel.setOnClickListener {
            val id = R.id.pastel
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.arbol.setOnClickListener {
            val id = R.id.arbol
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.papel.setOnClickListener {
            val id = R.id.papel
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.lectura.setOnClickListener {
            val id = R.id.lectura
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.sol.setOnClickListener {
            val id = R.id.sol
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.azul.setOnClickListener {
            val id = R.id.azul
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.aguila.setOnClickListener {
            val id = R.id.aguila
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.bailar.setOnClickListener {
            val id = R.id.bailar
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
        binding.regalo.setOnClickListener {
            val id = R.id.regalo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentL_to_indieLessonsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}