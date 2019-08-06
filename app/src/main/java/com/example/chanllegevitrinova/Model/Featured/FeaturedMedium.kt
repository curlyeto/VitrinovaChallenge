package com.example.chanllegevitrinova


import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName


@ProductImagesThumbnail.Parcelize
data class FeaturedMedium(

	@field:SerializedName("width")
	val featuredMediumwidth: Int? = null,

	@field:SerializedName("url")
	val featuredMediumurl: String? = null,

	@field:SerializedName("height")
	val featuredMediumheight: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(featuredMediumwidth)
		parcel.writeString(featuredMediumurl)
		parcel.writeValue(featuredMediumheight)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<FeaturedMedium> {
		override fun createFromParcel(parcel: Parcel): FeaturedMedium {
			return FeaturedMedium(parcel)
		}

		override fun newArray(size: Int): Array<FeaturedMedium?> {
			return arrayOfNulls(size)
		}
	}
}