package com.example.myapplication

import android.content.Context
import android.view.View
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import com.example.operationsmile.ui.theme.*

/*
import com.example.operationsmile.ui.theme.*
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util
import java.io.File
*/

/*
* Lessons Page
* This shows all Lesson "packs" and the progress bar
* (P sounds K sounds etc)
*
* Lessons List
* This will show all lessons belonging to the chosen lesson pack
* (List all p sounds or K sounds)
*
* Individual Lesson page
* This shows the chosen lesson from the lessons list
* (Show picture and help video for "Pollo")
* */

// Lessons Page (Showing all packs)
// Lessons Page (Showing all packs)
@Composable
fun LessonScreen()
{

}

/*
@Preview(showBackground = true)
@Composable
fun LessonPreview() {
    MaterialTheme {
        LessonScreen()
    }
}*/

// Lessons List (Listing all lessons of a certain sound)
// Lessons List (Listing all lessons of a certain sound)
@Composable
fun LessonListScreen()
{

}


/*@Preview(showBackground = true)
@Composable
fun LessonPreview() {
    MaterialTheme {
        LessonScreen()
    }
}
*/

//Lessons page (NOT VIDEO HELP PART)
//Lessons page (NOT VIDEO HELP PART)
@Composable
fun IndieLessonScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BgColor)
    ) {
        Row(
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(
                text = "Lessons",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(60.dp))// Spacer separating heading and the body

        Image(
            painterResource(id = R.drawable.bird),
            contentDescription = "Lessons Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = .5f)
        )
        /*Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(fraction = .5f)
                .fillMaxWidth(fraction = .8f)
                .background(color = ErrorText)
        ){
            Image(
                painterResource(id = R.drawable.bird),
                contentDescription = "Lessons Image",
                contentScale = ContentScale.FillHeight
            )
        }*/

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(fraction = .15f)
                .fillMaxWidth()
        )
        {
            Text(
                text = "Bird",
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText,
                modifier = Modifier.fillMaxSize()
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(fraction = .3f)
                .fillMaxWidth()
        )
        {
            Text(
                text = "Slowly and as best that you can, say the given word.",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Icon(
                painterResource(id = R.drawable.ic_record_fill),
                contentDescription = null,
                tint = ErrorText,
                modifier = Modifier
                    .size(80.dp)
            )

            Icon(
                painterResource(id = R.drawable.ic_download_simple_fill),
                contentDescription = null,
                tint = IconColor,
                modifier = Modifier
                    .size(80.dp)
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun LessonPreview() {
    MaterialTheme {
        IndieLessonScreen()
    }
}


//Video Help part of the Individual Lessons page
//Video Help part of the Individual Lessons page
@Composable
fun VideoHelpScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(IntrinsicSize.Max)
            .background(color = BgColor)
    ) {
        Row(
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(
                text = "Lessons",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(60.dp))// Spacer separating heading and the body
/*
        Image(
            painterResource(id = R.drawable.bird),
            contentDescription = "Lessons Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = .5f)
        )
*/
        /*
        Row() {
            mediaplay()
        }*/

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxHeight(fraction = .25f)
                .fillMaxWidth()
        )
        {

            Text(
                text = "Bird",
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Carefully listen to the video and repeat",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Chango,
                color = DefaultText
            )

        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun VideoHelpPreview() {
    MaterialTheme {
        VideoHelpScreen()
    }
}*/



/*

@Composable
fun mediaplay(){
    val context = LocalContext.current
    /*
    SimpleExoPlayer.Builder(context).build().apply {
        val uri = RawResourceDataSource.buildRawResourceUri(R.raw.thetroll)
        setMediaItem(MediaItem.fromUri(uri))
        prepare()
        playWhenReady = true
    }*/
    //val sampleVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val uri = RawResourceDataSource.buildRawResourceUri(R.raw.ocean2)
    val player = SimpleExoPlayer.Builder(context).build()
    val playerView = PlayerView(context)
    val mediaItem = MediaItem.fromUri(uri)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    player.setMediaItem(mediaItem)
    playerView.player = player
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady

    }
    AndroidView(
        modifier = Modifier
            .fillMaxWidth(),
        factory = {
        playerView
    })
}
*/

/*
@Preview(showBackground = true)
@Composable
fun mediaplayview() {
    mediaplay()
}*/