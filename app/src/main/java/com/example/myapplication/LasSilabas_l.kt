package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.LasSilabasBinding

class LasSilabas_l : Fragment() {

    private var _binding: LasSilabasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LasSilabasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.next.setOnClickListener { findNavController().navigate(R.id.action_lasSilabasFragment_to_LessonsFragment) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}