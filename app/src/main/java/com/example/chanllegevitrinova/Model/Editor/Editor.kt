package com.example.chanllegevitrinova.Model.Editor

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class Editor(
	@field:SerializedName("comment_count")
	val commentCount: Int? = null,
	@field:SerializedName("is_editor_choice")
	val isEditorChoice: Boolean? = null,
	@field:SerializedName("name_updateable")
	val nameUpdateable: Boolean? = null,
	@field:SerializedName("product_count")
	val productCount: Int? = null,
	@field:SerializedName("created_at")
	val createdAt: String? = null,
	@field:SerializedName("vacation_mode")
	val vacationMode: Int? = null,
	@field:SerializedName("follower_count")
	val followerCount: Int? = null,
	@field:SerializedName("shop_payment_id")
	val shopPaymentId: Int? = null,
	@field:SerializedName("cover")
	val cover: Cover? = null,
	@field:SerializedName("shop_rate")
	val shopRate: Int? = null,
	@field:SerializedName("share_url")
	val shareUrl: String? = null,
	@field:SerializedName("popular_products")
	val popularProducts: List<PopularProductsItem?>? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("logo")
	val logo: Logo? = null,
	@field:SerializedName("definition")
	val definition: String? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("is_following")
	val isFollowing: Boolean? = null,
	@field:SerializedName("slug")
	val slug: String? = null

):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readParcelable(Cover::class.java.classLoader),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.createTypedArrayList(PopularProductsItem),
		parcel.readString(),
		parcel.readParcelable(Logo::class.java.classLoader),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(commentCount)
		parcel.writeValue(isEditorChoice)
		parcel.writeValue(nameUpdateable)
		parcel.writeValue(productCount)
		parcel.writeString(createdAt)
		parcel.writeValue(vacationMode)
		parcel.writeValue(followerCount)
		parcel.writeValue(shopPaymentId)
		parcel.writeParcelable(cover, flags)
		parcel.writeValue(shopRate)
		parcel.writeString(shareUrl)
		parcel.writeTypedList(popularProducts)
		parcel.writeString(name)
		parcel.writeParcelable(logo, flags)
		parcel.writeString(definition)
		parcel.writeValue(id)
		parcel.writeValue(isFollowing)
		parcel.writeString(slug)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Editor> {
		override fun createFromParcel(parcel: Parcel): Editor {
			return Editor(parcel)
		}

		override fun newArray(size: Int): Array<Editor?> {
			return arrayOfNulls(size)
		}
	}
}
