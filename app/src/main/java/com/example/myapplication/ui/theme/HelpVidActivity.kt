//package com.example.myapplication
//import android.content.ContentValues.TAG
//import android.net.Uri
//import android.os.Bundle
//import android.util.Log
//import com.google.android.material.snackbar.Snackbar
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.VideoView
//import com.example.myapplication.databinding.ActivityMainBinding
//import io.realm.*
//import io.realm.annotations.PrimaryKey
//import io.realm.exceptions.RealmFileException
//import io.realm.kotlin.where
//import io.realm.mongodb.App
//import io.realm.mongodb.AppConfiguration
//import io.realm.mongodb.Credentials
//import io.realm.mongodb.User
//import io.realm.mongodb.sync.SyncConfiguration
//import org.bson.types.ObjectId
//import java.util.concurrent.ExecutorService
//import java.util.concurrent.Executors
//import java.util.concurrent.FutureTask
//import android.widget.MediaController
//import android.widget.ProgressBar
//import androidx.fragment.app.Fragment
//import com.example.myapplication.databinding.IndieLessonsBinding
//import com.google.android.exoplayer2.ExoPlayer
//import com.google.android.exoplayer2.Player
//import com.google.android.exoplayer2.ui.PlayerView
//
//import android.content.ContentValues.TAG
//import android.view.*
//import androidx.navigation.findNavController
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import io.realm.*
//import io.realm.kotlin.where
//import androidx.navigation.fragment.findNavController
//import com.example.myapplication.databinding.LasSilabasBinding
//import com.google.android.exoplayer2.MediaItem
//
//
//class HelpVidActivity : AppCompatActivity(), Player.Listener{
//
//    private lateinit var player: ExoPlayer
//    private lateinit var playerView: PlayerView
//    private lateinit var progressBar: ProgressBar
//
//    override fun onCreate(savedInstanceState: Bundle?){
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_helpvid)
//        progressBar =findViewById(R.id.progressBar)
//
//        setupPlayer()
//
//    }
//    private fun setupPlayer(){
//        player = ExoPlayer.Builder(this).build()
//        playerView = findViewById(R.id.psoundVid)
//        playerView.player = player
//        player.addListener(this)
//    }
//
//    private fun addMP4(){
//        val mediaItem = MediaItem.fromUri(getString(R.string.psoundsFront))
//        player.addMediaItem(mediaItem)
//        player.prepare()
//    }
//
//    override fun onPlaybackStateChanged(playbackState: Int) {
//        super.onPlaybackStateChanged(playbackState)
//
//        when(playbackState){
//            Player.STATE_BUFFERING -> {
//                progressBar.visibility = View.VISIBLE
//            }
//            Player.STATE_READY ->{
//                progressBar.visibility = View.INVISIBLE
//            }
//        }
//    }
//}