package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLessonsKBinding

class Lessons_k_page : Fragment() {

    private var _binding: FragmentLessonsKBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLessonsKBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.Tsoundsbutton.setOnClickListener { findNavController().navigate(R.id.action_lasSilabaT_to_lessonChoiceFragment) }

        binding.cola.setOnClickListener {
            val id = R.id.cola
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.cubo.setOnClickListener {
            val id = R.id.cubo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.capa.setOnClickListener {
            val id = R.id.capa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.quatro.setOnClickListener {
            val id = R.id.quatro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.cafe.setOnClickListener {
            val id = R.id.cafe
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.cura.setOnClickListener {
            val id = R.id.cura
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.coche.setOnClickListener {
            val id = R.id.coche
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.calle.setOnClickListener {
            val id = R.id.calle
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.carro.setOnClickListener {
            val id = R.id.carro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.kiwi.setOnClickListener {
            val id = R.id.kiwi
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.cachete.setOnClickListener {
            val id = R.id.cachete
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.coco.setOnClickListener {
            val id = R.id.coco
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.cuchara.setOnClickListener {
            val id = R.id.cuchara
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.calabaza.setOnClickListener {
            val id = R.id.calabaza
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.vaca.setOnClickListener {
            val id = R.id.vaca
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.casa.setOnClickListener {
            val id = R.id.casa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.caja.setOnClickListener {
            val id = R.id.caja
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
        binding.queso.setOnClickListener {
            val id = R.id.queso
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_lessons_k_page_to_indieLessonsFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}