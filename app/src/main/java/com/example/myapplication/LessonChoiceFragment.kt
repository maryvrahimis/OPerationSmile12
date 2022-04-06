package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.LessonChoiceBinding

class LessonChoiceFragment : Fragment() {

    private var _binding: LessonChoiceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LessonChoiceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.PsoundsButton.setOnClickListener { findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabasFragment) }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}