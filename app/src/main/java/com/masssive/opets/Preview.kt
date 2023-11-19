package com.example.opets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Preview(
    val nameP: String,
    val description: String,
    val photoP: Int
):Parcelable
