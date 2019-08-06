package com.example.chanllegevitrinova


import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName

@ProductImagesThumbnail.Parcelize
data class FeaturedCover(

    @field:SerializedName("thumbnail")
	val featuredthumbnail: FeaturedThumbnail? = null,

    @field:SerializedName("width")
	val featuredwidth: Int? = null,

    @field:SerializedName("medium")
	val featuredmedium: FeaturedMedium? = null,

    @field:SerializedName("url")
	val featuredurl: String? = null,

    @field:SerializedName("height")
	val featuredheight: Int? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(FeaturedThumbnail::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(FeaturedMedium::class.java.classLoader),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(featuredthumbnail, flags)
        parcel.writeValue(featuredwidth)
        parcel.writeParcelable(featuredmedium, flags)
        parcel.writeString(featuredurl)
        parcel.writeValue(featuredheight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeaturedCover> {
        override fun createFromParcel(parcel: Parcel): FeaturedCover {
            return FeaturedCover(parcel)
        }

        override fun newArray(size: Int): Array<FeaturedCover?> {
            return arrayOfNulls(size)
        }
    }
}