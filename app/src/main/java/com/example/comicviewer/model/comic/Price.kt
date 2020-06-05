package model.comic


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Price(
    @SerializedName("price")
    val price: Int,
    @SerializedName("type")
    val type: String
) : Parcelable