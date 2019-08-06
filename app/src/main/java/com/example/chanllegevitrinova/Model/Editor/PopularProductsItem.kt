package com.example.chanllegevitrinova.Model.Editor

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize

@ProductImagesThumbnail.Parcelize
data class PopularProductsItem(
	@field:SerializedName("comment_count")
	val commentCount: Int? = null,
//	@field:SerializedName("max_installment")
//	val maxInstallment: Any? = null,
	@field:SerializedName("is_editor_choice")
	val isEditorChoice: Boolean? = null,
//	@field:SerializedName("code")
//	val code: Any? = null,
	@field:SerializedName("title")
	val title: String? = null,
	@field:SerializedName("category_id")
	val categoryId: Int? = null,
	@field:SerializedName("price")
	val price: Int? = null,
	@field:SerializedName("definition")
	val definition: String? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("stock")
	val stock: Int? = null,
	@field:SerializedName("slug")
	val slug: String? = null,
	@field:SerializedName("is_liked")
	val isLiked: Boolean? = null,
	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,
	@field:SerializedName("is_active")
	val isActive: Boolean? = null,
	@field:SerializedName("like_count")
	val likeCount: Int? = null,
	@field:SerializedName("is_new")
	val isNew: Boolean? = null,
	@field:SerializedName("is_owner")
	val isOwner: Boolean? = null,
//	@field:SerializedName("old_price")
//	val oldPrice: Any? = null,
	@field:SerializedName("cargo_time")
	val cargoTime: Int? = null,
//	@field:SerializedName("reject_reason")
//	val rejectReason: Any? = null,
	@field:SerializedName("share_url")
	val shareUrl: String? = null,
	@field:SerializedName("difference")
	val difference: String? = null,
	@field:SerializedName("is_approved")
	val isApproved: Boolean? = null,
	@field:SerializedName("commission_rate")
	val commissionRate: Int? = null,
	@field:SerializedName("category")
	val category: Category? = null,
	@field:SerializedName("is_cargo_free")
	val isCargoFree: Boolean? = null,
	@field:SerializedName("view_count")
	val viewCount: Int? = null
):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.createTypedArrayList(ImagesItem.CREATOR),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readParcelable(Category::class.java.classLoader),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(commentCount)
		parcel.writeValue(isEditorChoice)
		parcel.writeString(title)
		parcel.writeValue(categoryId)
		parcel.writeValue(price)
		parcel.writeString(definition)
		parcel.writeValue(id)
		parcel.writeValue(stock)
		parcel.writeString(slug)
		parcel.writeValue(isLiked)
		parcel.writeTypedList(images)
		parcel.writeValue(isActive)
		parcel.writeValue(likeCount)
		parcel.writeValue(isNew)
		parcel.writeValue(isOwner)
		parcel.writeValue(cargoTime)
		parcel.writeString(shareUrl)
		parcel.writeString(difference)
		parcel.writeValue(isApproved)
		parcel.writeValue(commissionRate)
		parcel.writeParcelable(category, flags)
		parcel.writeValue(isCargoFree)
		parcel.writeValue(viewCount)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PopularProductsItem> {
		override fun createFromParcel(parcel: Parcel): PopularProductsItem {
			return PopularProductsItem(parcel)
		}

		override fun newArray(size: Int): Array<PopularProductsItem?> {
			return arrayOfNulls(size)
		}
	}
}
