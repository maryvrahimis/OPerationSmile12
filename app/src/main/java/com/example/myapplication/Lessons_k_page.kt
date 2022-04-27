package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}