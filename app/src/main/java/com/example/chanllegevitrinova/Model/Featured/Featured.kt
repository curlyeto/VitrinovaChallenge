package com.example.chanllegevitrinova

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName

@ProductImagesThumbnail.Parcelize
data class Featured(
	@SerializedName("id")
	var featuredid:Int,
	@SerializedName("type")
	var featuredtype:String,
	@SerializedName("title")
	var featuredtitle:String,
	@SerializedName("sub_title")
	var featuredsubtitle:String,
	@SerializedName("cover")
	var feturedcover: FeaturedCover
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readInt(),
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.readParcelable(FeaturedCover::class.java.classLoader)!!
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeInt(featuredid)
		parcel.writeString(featuredtype)
		parcel.writeString(featuredtitle)
		parcel.writeString(featuredsubtitle)
		parcel.writeParcelable(feturedcover, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Featured> {
		override fun createFromParcel(parcel: Parcel): Featured {
			return Featured(parcel)
		}

		override fun newArray(size: Int): Array<Featured?> {
			return arrayOfNulls(size)
		}
	}
}
