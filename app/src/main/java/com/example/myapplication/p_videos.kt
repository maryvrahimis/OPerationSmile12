package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPVideosBinding
import com.google.android.exoplayer2.upstream.RawResourceDataSource


class p_videos : Fragment() {

   private var bindingg: FragmentPVideosBinding? = null
   private val binding get() = bindingg!!
   lateinit var mediaController: MediaController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //return inflater.inflate(R.layout.fragment_p_videos, container, false)
       bindingg = FragmentPVideosBinding.inflate(inflater, container, false)
       return binding.root
    }
    //private var mediaController:  MediaController? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding.skipToLessons.setOnClickListener { findNavController().navigate(R.id.action_p_videos_to_lasSilabasFragment) }
        val videoView: VideoView = binding.videoView
        val videoPath = RawResourceDataSource.buildRawResourceUri(R.raw.p_sound_instructions)
      //val VideoView: VideoView = binding.(R.id.videoView)
      //val videoPath: String = "android.resource://" + packageName + "/" + R.raw.p_sound_front
      val uri: Uri = Uri.parse(videoPath.toString())
       videoView.setVideoURI(uri)
        mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
   }

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
   }
   override fun onDestroyView() {
      super.onDestroyView()
      bindingg = null
   }
}