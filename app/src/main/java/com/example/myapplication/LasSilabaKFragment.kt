package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSilabakBinding
import java.text.SimpleDateFormat
import java.util.*

class LasSilabaKFragment : Fragment() {

    private var _binding: FragmentSilabakBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSilabakBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.PsoundsButton.setOnClickListener { findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabasFragment) }
        //binding.TsoundsButton.setOnClickListener{findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabaT)}
        binding.next.setOnClickListener { findNavController().navigate(R.id.action_lasSilabaKFragment_to_lessons_k_page)
            if (timerCheck == true) {               // Button that takes you to the homepage
                lessonCounterK++
                val check = SimpleDateFormat("MM/dd/yyyy")
                val currentDate = check.format(Date())
                /*
                if (currentDateAndTime == currentDate){
                }
                 */
            }}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}