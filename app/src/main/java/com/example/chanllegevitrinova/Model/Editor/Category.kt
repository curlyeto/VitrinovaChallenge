package com.example.chanllegevitrinova.Model.Editor

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class Category(
	@field:SerializedName("parentId")
	val parentId: Int? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("parentCategory")
	val parentCategory: ParentCategory? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("order")
	val order: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readParcelable(ParentCategory::class.java.classLoader),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(parentId)
		parcel.writeString(name)
		parcel.writeParcelable(parentCategory, flags)
		parcel.writeValue(id)
		parcel.writeValue(order)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Category> {
		override fun createFromParcel(parcel: Parcel): Category {
			return Category(parcel)
		}

		override fun newArray(size: Int): Array<Category?> {
			return arrayOfNulls(size)
		}
	}
}
