package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.FIND_VIEWS_WITH_TEXT
import android.widget.ImageView
import android.widget.TextView

import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentHomeBinding
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var imageView: ImageView




        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var isDailyLessonDone: Boolean = false
        var points: Int = 0
        var days: Int = 0
        super.onViewCreated(view, savedInstanceState)


        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getBoolean("bundleKey")
            if (result){
                binding.completedLesson.isVisible = true
                binding.notCompletedLesson.isVisible = false
                //binding.totalPointsText.text = opa

            }
        }

        binding.streakText.setText((days.toString() + " dias"))
        binding.lessonsButton.setOnClickListener {

            findNavController().navigate(R.id.action_Home_to_Lessons)

        }

        binding.storeButton.setOnClickListener {
            findNavController().navigate(R.id.to_Third_fragment)
        }
        binding.homeToPatients.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_updated_patients_screen)
        }
        binding.reportsButton.setOnClickListener {
            findNavController().navigate(R.id.go_to_reports)
        }

        binding.homeToVideo.setOnClickListener{
            findNavController().navigate(R.id.action_HomeFragment_to_videoTest)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
    }
    fun pointsFunc (isdone: Boolean, points: Int){
        val po: TextView = binding.totalPointsText
        if(isdone){
            po.text = (points + 1).toString() + " points"
            // binding.totalPointsText.setText(points)
        }
        else{
            po.text = points.toString() + "points"
        }
    }




}