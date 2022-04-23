package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLesssonsLBinding

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
        }

        binding.luz.setOnClickListener {
            val id = R.id.pato
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.leche.setOnClickListener {
            val id = R.id.pan
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.libro.setOnClickListener {
            val id = R.id.perro
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lapiz.setOnClickListener {
            val id = R.id.papaya
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lata.setOnClickListener {
            val id = R.id.parque
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lobo.setOnClickListener {
            val id = R.id.pera
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lago.setOnClickListener {
            val id = R.id.pepino
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lecho.setOnClickListener {
            val id = R.id.pez
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lechuga.setOnClickListener {
            val id = R.id.pina
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.pastel.setOnClickListener {
            val id = R.id.pollo
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.arbol.setOnClickListener {
            val id = R.id.pies
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.papel.setOnClickListener {
            val id = R.id.papel
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.papel.setOnClickListener {
            val id = R.id.pinata
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.lectura.setOnClickListener {
            val id = R.id.pintura
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.sol.setOnClickListener {
            val id = R.id.pelota
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.azul.setOnClickListener {
            val id = R.id.peine
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.aguila.setOnClickListener {
            val id = R.id.mapa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.bailar.setOnClickListener {
            val id = R.id.sopa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
        binding.regalo.setOnClickListener {
            val id = R.id.capa
            val result = resources.getResourceEntryName(id)
            println("THIS IS R.id.pan $result")
            // Use the Kotlin extension in the fragment-ktx artifact

            //SENDS THE RESOURCE ID OF THE BUTTON TO INDIE LESSONS
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(R.id.action_LessonsFragment_to_indieLessonsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}