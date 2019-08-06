package com.example.chanllegevitrinova


import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesMedium
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName

@ProductImagesThumbnail.Parcelize
data class ImagesItem(

    @field:SerializedName("thumbnail")
	val productsThumbnail: ProductImagesThumbnail?,

    @field:SerializedName("width")
	val width: Int?,

    @field:SerializedName("medium")
	val productsMedium: ProductImagesMedium?,

    @field:SerializedName("url")
	val url: String?,

    @field:SerializedName("height")
	val height: Int?

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(ProductImagesThumbnail::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(ProductImagesMedium::class.java.classLoader),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(productsThumbnail, flags)
        parcel.writeValue(width)
        parcel.writeParcelable(productsMedium, flags)
        parcel.writeString(url)
        parcel.writeValue(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImagesItem> {
        override fun createFromParcel(parcel: Parcel): ImagesItem {
            return ImagesItem(parcel)
        }

        override fun newArray(size: Int): Array<ImagesItem?> {
            return arrayOfNulls(size)
        }
    }
}