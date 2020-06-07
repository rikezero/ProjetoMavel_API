package com.example.comicviewer.model

import android.os.Parcelable
import com.example.comicviewer.model.comic.Image
import com.example.comicviewer.model.comic.Thumbnail
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DBComic(
    var title: String,
    var date: String,
    var thumbnail: Thumbnail,
    var header: Image,
    var price: String,
    var pages: Int,
    var summary: String
) : Parcelable {

}