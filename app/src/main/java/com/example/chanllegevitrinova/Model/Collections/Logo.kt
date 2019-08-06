package com.example.chanllegevitrinova.Model.Collections


import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class Logo(

	@field:SerializedName("featuredThumbnail")
	val thumbnail: Thumbnail? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("featuredMedium")
	val medium: Medium? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readParcelable(Thumbnail::class.java.classLoader),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readParcelable(Medium::class.java.classLoader),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(thumbnail, flags)
		parcel.writeValue(width)
		parcel.writeParcelable(medium, flags)
		parcel.writeString(url)
		parcel.writeValue(height)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Logo> {
		override fun createFromParcel(parcel: Parcel): Logo {
			return Logo(parcel)
		}

		override fun newArray(size: Int): Array<Logo?> {
			return arrayOfNulls(size)
		}
	}
}