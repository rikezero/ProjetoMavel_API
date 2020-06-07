package com.example.comicviewer.model.comic


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Price(
    @SerializedName("type")
    val type: String,
    @SerializedName("price")
    val price: Float
) : Parcelable