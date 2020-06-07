package com.example.comicviewer.model.comic


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Url(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) : Parcelable