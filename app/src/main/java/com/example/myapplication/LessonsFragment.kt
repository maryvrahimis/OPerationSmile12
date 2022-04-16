package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLessonsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LessonsFragment : Fragment() {

    private var _binding: FragmentLessonsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLessonsBinding.inflate(inflater, container, false)
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
        binding.pan.setOnClickListener {
            val id = R.id.pan
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