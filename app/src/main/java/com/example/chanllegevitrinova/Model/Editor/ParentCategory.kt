package com.example.chanllegevitrinova.Model.Editor

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class ParentCategory(
//	@field:SerializedName("parentId")
//	val parentId: Any? = null,
	@field:SerializedName("name")
	val name: String? = null,
//	@field:SerializedName("parentCategory")
//	val parentCategory: Any? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("order")
	val order: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeValue(id)
		parcel.writeValue(order)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ParentCategory> {
		override fun createFromParcel(parcel: Parcel): ParentCategory {
			return ParentCategory(parcel)
		}

		override fun newArray(size: Int): Array<ParentCategory?> {
			return arrayOfNulls(size)
		}
	}
}
