package com.example.myapplication

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity


class p_lessons_video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_plessons_video)

       // val VideoView: VideoView = findViewById(R.id.videoView)
       // val videoPath: String = "android.resource://" + packageName + "/" + R.raw.p_sound_front
       // val Uri: Uri = Uri.parse(videoPath)
       // VideoView.setVideoURI(Uri)

        val MediaController: MediaController = MediaController(this)
       // VideoView.setMediaController(MediaController)
        //MediaController.setAnchorView(VideoView)


        /*
        skip.setOnClickListener(){
            val intent = Intent(this, LasSilabasFragment::class.java)
            startActivity(intent)
        }
        */


    }

}