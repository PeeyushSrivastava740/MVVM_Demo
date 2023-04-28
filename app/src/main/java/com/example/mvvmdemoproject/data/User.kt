package com.example.mvvmdemoproject.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("username")
    val userName: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("address")
    val addressObject : Address? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("website")
    val website: String? = null
) : Serializable

data class Address(

    @SerializedName("street")
    val street: String? = null,

    @SerializedName("suite")
    val suite: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("zipcode")
    val zipCode: String? = null

) : Serializable

