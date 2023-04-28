package com.example.mvvmdemoproject.APIUtils

import com.example.mvvmdemoproject.data.User
import retrofit2.Call
import retrofit2.http.GET

interface APICallback {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>
}