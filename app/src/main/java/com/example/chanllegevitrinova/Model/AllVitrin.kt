package com.example.chanllegevitrinova.Model

import android.os.Parcel
import android.os.Parcelable
import com.example.chanllegevitrinova.Featured
import com.example.chanllegevitrinova.Model.Categories.Categori
import com.example.chanllegevitrinova.Model.Collections.Collection
import com.example.chanllegevitrinova.Model.Editor.Editor

import com.example.chanllegevitrinova.Products
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Parcelize
data class AllVitrin(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("featured")
    @Expose
    var featured: List<Featured>? = null,
    @SerializedName("products")
    @Expose
    var products: List<Products>? = null,
    @SerializedName("categories")
    @Expose
    var categori: List<Categori>? = null,
    @SerializedName("collections")
    @Expose
    var collection: List<Collection>? = null,
    @SerializedName("shops")
    @Expose
    var editor: List<Editor>? = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Featured),
        parcel.createTypedArrayList(Products),
        parcel.createTypedArrayList(Categori),
        parcel.createTypedArrayList(Collection),
        parcel.createTypedArrayList(Editor)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeTypedList(featured)
        parcel.writeTypedList(products)
        parcel.writeTypedList(categori)
        parcel.writeTypedList(collection)
        parcel.writeTypedList(editor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AllVitrin> {
        override fun createFromParcel(parcel: Parcel): AllVitrin {
            return AllVitrin(parcel)
        }

        override fun newArray(size: Int): Array<AllVitrin?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize

