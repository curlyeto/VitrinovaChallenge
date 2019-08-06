package com.example.chanllegevitrinova.Model.Collections


import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class Collection(
	@field:SerializedName("cover")
	val cover: Cover? = null,

	@field:SerializedName("share_url")
	val shareUrl: String? = null,

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("logo")
	val logo: Logo? = null,

	@field:SerializedName("definition")
	val definition: String? = null,

//	@field:SerializedName("end")
//	val end: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readParcelable(Cover::class.java.classLoader),
		parcel.readString(),
		parcel.readString(),
		parcel.readParcelable(Logo::class.java.classLoader),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeParcelable(cover, flags)
		parcel.writeString(shareUrl)
		parcel.writeString(start)
		parcel.writeParcelable(logo, flags)
		parcel.writeString(definition)
		parcel.writeValue(id)
		parcel.writeString(title)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Collection> {
		override fun createFromParcel(parcel: Parcel): Collection {
			return Collection(parcel)
		}

		override fun newArray(size: Int): Array<Collection?> {
			return arrayOfNulls(size)
		}
	}
}