package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPVideosBinding


class p_videos : Fragment() {

   private var bindingg: FragmentPVideosBinding? = null
   private val binding get() = bindingg!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //return inflater.inflate(R.layout.fragment_p_videos, container, false)
       bindingg = FragmentPVideosBinding.inflate(inflater, container, false)
       return binding.root
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding.skipToLessons.setOnClickListener { findNavController().navigate(R.id.action_p_videos_to_lasSilabasFragment) }

      val videoView: VideoView = binding.videoView
      //val videoPath: String = "android.resource://" + packageName + "/" + R.raw.p_sound_front  //Please help dear god
      //val VideoView: VideoView = binding.(R.id.videoView)
      //val videoPath: String = "android.resource://" + packageName + "/" + R.raw.p_sound_front
      //val Uri: Uri = Uri.parse(videoPath)
      //VideoView.setVideoURI(Uri)
      //val MediaController: MediaController = MediaController(this)
      // VideoView.setMediaController(MediaController)
      //MediaController.setAnchorView(VideoView)
   }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
   }
   override fun onDestroyView() {
      super.onDestroyView()
      bindingg = null
   }
}