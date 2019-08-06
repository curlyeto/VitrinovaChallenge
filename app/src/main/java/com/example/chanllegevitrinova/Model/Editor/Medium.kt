package com.example.chanllegevitrinova.Model.Editor

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class Medium(
	@field:SerializedName("width")
	val width: Int? = null,
	@field:SerializedName("url")
	val url: String? = null,
	@field:SerializedName("height")
	val height: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(width)
		parcel.writeString(url)
		parcel.writeValue(height)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Medium> {
		override fun createFromParcel(parcel: Parcel): Medium {
			return Medium(parcel)
		}

		override fun newArray(size: Int): Array<Medium?> {
			return arrayOfNulls(size)
		}
	}
}