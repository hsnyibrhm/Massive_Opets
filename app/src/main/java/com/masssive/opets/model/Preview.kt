package com.masssive.opets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Preview(
    val nameP: String,
    val description: String,
    val tanggal: String,
    val photoP: Int
):Parcelable
