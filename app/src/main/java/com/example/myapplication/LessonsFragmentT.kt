package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLessonsTBinding

class LessonsFragmentT : Fragment(){
    private var _binding: FragmentLessonsTBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLessonsTBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_LessonsFragment_to_lasFrasesFragment)
        }

        binding.tu.setOnClickListener {
            val id = R.id.tu
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tasa.setOnClickListener {
            val id = R.id.tasa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tigre.setOnClickListener {
            val id = R.id.tigre
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tallo.setOnClickListener {
            val id = R.id.tallo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.techo.setOnClickListener {
            val id = R.id.techo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tiza.setOnClickListener {
            val id = R.id.tiza
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.toalla.setOnClickListener {
            val id = R.id.toalla
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tobillo.setOnClickListener {
            val id = R.id.tobillo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tortuga.setOnClickListener {
            val id = R.id.tortuga
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.teatro.setOnClickListener {
            val id = R.id.teatro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.tesoro.setOnClickListener {
            val id = R.id.tesoro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.telescopio.setOnClickListener {
            val id = R.id.telescopio
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.gato.setOnClickListener {
            val id = R.id.gato
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.bate.setOnClickListener {
            val id = R.id.bate
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
        binding.yate.setOnClickListener {
            val id = R.id.yate
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessonsFragmentT_to_indieLessonsFragment)
        }
    }
}