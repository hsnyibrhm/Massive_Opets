package com.example.opets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class diskon(
    val photo: Int,
    val nama:String
): Parcelable
