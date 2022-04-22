package com.example.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class VideoTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_test)

        val VideoView: VideoView = findViewById(R.id.videoView)
        val videoPath: String = "android.resource://" + packageName + "/" + R.raw.p_sound_instructions
        val Uri: Uri = Uri.parse(videoPath)
        VideoView.setVideoURI(Uri)

        val MediaController: MediaController = MediaController(this)
        VideoView.setMediaController(MediaController)
        MediaController.setAnchorView(VideoView)
    }
}