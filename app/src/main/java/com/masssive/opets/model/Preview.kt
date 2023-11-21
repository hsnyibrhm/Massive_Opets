package com.masssive.opets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Preview(
    val photoP: Int,
    val description: String,
    val tanggal: String
):Parcelable
