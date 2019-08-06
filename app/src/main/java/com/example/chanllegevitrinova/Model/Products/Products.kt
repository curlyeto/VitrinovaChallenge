package com.example.chanllegevitrinova


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.example.chanllegevitrinova.Model.Products.ProductImagesThumbnail
import com.google.gson.annotations.SerializedName



@ProductImagesThumbnail.Parcelize
data class Products(
	 @field:SerializedName("comment_count")
	 val commentCount: Int? = null,

	 @field:SerializedName("is_editor_choice")
	 val isEditorChoice: Boolean? = null,

	 @field:SerializedName("shop")
	 val shop: Shop? = null,

	 @field:SerializedName("title")
	 var title: String? = null,

	 @field:SerializedName("category_id")
	 val categoryId: Int? = null,

	 @field:SerializedName("price")
	 var price: Int? = null,

	 @field:SerializedName("definition")
	 val definition: String? = null,

	 @field:SerializedName("id")
	 var id: Int? = null,

	 @field:SerializedName("stock")
	 val stock: Int? = null,

	 @field:SerializedName("slug")
	 val slug: String? = null,

	 @field:SerializedName("is_liked")
	 val isLiked: Boolean? = null,

	 @field:SerializedName("images")
	 var images: List<ImagesItem?>? = null,

//	@field:SerializedName("is_active")
//	val isActive: Boolean? = null,

	 @field:SerializedName("like_count")
	 val likeCount: Int? = null,

	 @field:SerializedName("is_new")
	 val isNew: Boolean? = null,

	 @field:SerializedName("is_owner")
	 val isOwner: Boolean? = null,

	 @field:SerializedName("old_price")
	 var oldPrice: Int? = null,

	 @field:SerializedName("cargo_time")
	 val cargoTime: Int? = null,

	 @field:SerializedName("share_url")
	 val shareUrl: String? = null,

	 @field:SerializedName("difference")
	 val difference: String? = null,

	 @field:SerializedName("is_approved")
	 val isApproved: Boolean? = null,
	 @field:SerializedName("commission_rate")
	 val commissionRate: Int? = null,


	 @field:SerializedName("is_cargo_free")
	 val isCargoFree: Boolean? = null

):Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readParcelable(Shop::class.java.classLoader),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.createTypedArrayList(ImagesItem),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(commentCount)
		parcel.writeValue(isEditorChoice)
		parcel.writeParcelable(shop, flags)
		parcel.writeString(title)
		parcel.writeValue(categoryId)
		parcel.writeValue(price)
		parcel.writeString(definition)
		parcel.writeValue(id)
		parcel.writeValue(stock)
		parcel.writeString(slug)
		parcel.writeValue(isLiked)
		parcel.writeTypedList(images)
		parcel.writeValue(likeCount)
		parcel.writeValue(isNew)
		parcel.writeValue(isOwner)
		parcel.writeValue(oldPrice)
		parcel.writeValue(cargoTime)
		parcel.writeString(shareUrl)
		parcel.writeString(difference)
		parcel.writeValue(isApproved)
		parcel.writeValue(commissionRate)
		parcel.writeValue(isCargoFree)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Products> {
		override fun createFromParcel(parcel: Parcel): Products {
			return Products(parcel)
		}

		override fun newArray(size: Int): Array<Products?> {
			return arrayOfNulls(size)
		}
	}
}