package com.example.chanllegevitrinova.Model.Products

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class ProductImagesThumbnail(
    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null,

    @field:SerializedName("width")
    val width: Int? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    annotation class Parcelize

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeValue(height)
        parcel.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductImagesThumbnail> {
        override fun createFromParcel(parcel: Parcel): ProductImagesThumbnail {
            return ProductImagesThumbnail(parcel)
        }

        override fun newArray(size: Int): Array<ProductImagesThumbnail?> {
            return arrayOfNulls(size)
        }
    }
}