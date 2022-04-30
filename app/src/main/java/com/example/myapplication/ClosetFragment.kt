package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentClosetBinding
import com.example.myapplication.databinding.FragmentLessonsBinding
import io.realm.Realm

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ClosetFragment : Fragment() {

    private var _binding: FragmentClosetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClosetBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var realm: Realm
        //try {

        binding.closetToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.actoinClosetToHome)
        }
       // binding.imageView20.setImageDrawable(opa2)
      //  binding.scrollView3.
        var temp = 0
        var closetIt = binding.lin.iterator()
        while (temp != closet.size){
           val bam = closetIt.next()
            bam.setBackgroundResource(closet[temp].stickerBirdId)
            binding.lin[temp].setOnClickListener {
                currentSticker = closet[temp-1].stickerBirdId
                findNavController().navigate(R.id.actoinClosetToHome)
            }
            temp++
        }

        //for()





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}