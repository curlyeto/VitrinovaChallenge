package com.example.chanllegevitrinova.Model.Categories

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize


@ProductImagesThumbnail.Parcelize
data class Categori(
	@field:SerializedName("logo")
	val logo: Logo? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("cover")
	val cover:Cover?=null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readParcelable(Logo::class.java.classLoader),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readParcelable(Cover::class.java.classLoader)
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(logo, flags)
		parcel.writeValue(id)
		parcel.writeString(name)
		parcel.writeParcelable(cover, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Categori> {
		override fun createFromParcel(parcel: Parcel): Categori {
			return Categori(parcel)
		}

		override fun newArray(size: Int): Array<Categori?> {
			return arrayOfNulls(size)
		}
	}
}
