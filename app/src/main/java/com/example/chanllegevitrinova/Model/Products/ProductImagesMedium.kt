package com.example.chanllegevitrinova.Model.Products

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


@ProductImagesThumbnail.Parcelize
data class ProductImagesMedium(

    @field:SerializedName("url")
    val url: String?,

    @field:SerializedName("height")
    val height: Int?,

    @field:SerializedName("width")
    val width: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeValue(height)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductImagesMedium> {
        override fun createFromParcel(parcel: Parcel): ProductImagesMedium {
            return ProductImagesMedium(parcel)
        }

        override fun newArray(size: Int): Array<ProductImagesMedium?> {
            return arrayOfNulls(size)
        }
    }
}