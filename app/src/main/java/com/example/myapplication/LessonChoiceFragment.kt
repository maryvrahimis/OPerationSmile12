package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
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


    public val timer = object : CountDownTimer(5000, 1000) {
        override fun onTick(p0: Long) {

        }
        override fun onFinish() {
        timerCheck = true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.PsoundsButton.setOnClickListener { findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabasFragment2)
        timer.start()
        }
        binding.TsoundsButton.setOnClickListener{findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabaT)}
        binding.KsoundsButton.setOnClickListener{findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabaKFragment)}
        binding.LsoundsButton.setOnClickListener { findNavController().navigate(R.id.action_lessonChoiceFragment_to_lasSilabas_l) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}