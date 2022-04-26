package com.example.myapplication

import android.graphics.drawable.Drawable
import androidx.annotation.IntegerRes

//import io.realm.RealmObject

open class StickerBundle(
    val stickerName: String = "",
    val stickerPrice: Int = 0,
    val birdWeaaringSticker: String = "",
    val stickerId: Int = 0,
    val stickerBirdId: Int = 0,
    val stickerDetailId: Int = 0){



    override fun toString (): String {
        return "Sticker Name:  ('$stickerName') | Price: ('$stickerPrice') "
    }

}
