package com.example.comicviewer.model.comic


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Image(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) : Parcelable{
    fun getImage(): String? {
        return "$path.$extension"
    }
}