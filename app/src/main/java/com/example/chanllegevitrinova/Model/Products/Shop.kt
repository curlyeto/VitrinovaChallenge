package com.example.chanllegevitrinova




import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Model.Editor.Cover
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize


data class Shop(

    @field:SerializedName("comment_count")
    @Expose
    val commentCount: Int? = null,

    @field:SerializedName("is_editor_choice")
    @Expose
    val isEditorChoice: Boolean? = null,

    @field:SerializedName("name_updateable")
    @Expose
    val nameUpdateable: Boolean? = null,

    @field:SerializedName("product_count")
    @Expose
    val productCount: Int? = null,

    @field:SerializedName("created_at")
    @Expose
    val createdAt: String? = null,

    @field:SerializedName("vacation_mode")
    @Expose
    val vacationMode: Int? = null,

    @field:SerializedName("follower_count")
    @Expose
    val followerCount: Int? = null,

    @field:SerializedName("shop_payment_id")
    @Expose
    val shopPaymentId: Int? = null,

    @field:SerializedName("cover")
    @Expose
    val cover: Cover? = null,

    @field:SerializedName("shop_rate")
    @Expose
    val shopRate: Int? = null,

    @field:SerializedName("share_url")
    @Expose
    val shareUrl: String? = null,

    @field:SerializedName("name")
    @Expose
    val name: String? = null,

    @field:SerializedName("definition")
    @Expose
    val definition: String? = null,

    @field:SerializedName("id")
    @Expose
    val id: Int? = null,

    @field:SerializedName("is_following")
    @Expose
    val isFollowing: Boolean? = null,

    @field:SerializedName("slug")
    @Expose
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
        parcel.readString(),
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
        parcel.writeString(name)
        parcel.writeString(definition)
        parcel.writeValue(id)
        parcel.writeValue(isFollowing)
        parcel.writeString(slug)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shop> {
        override fun createFromParcel(parcel: Parcel): Shop {
            return Shop(parcel)
        }

        override fun newArray(size: Int): Array<Shop?> {
            return arrayOfNulls(size)
        }
    }
}