package com.example.mvvmdemoproject.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemoproject.APIUtils.ApiClient
import com.example.mvvmdemoproject.Utility.hideProgressBar
import com.example.mvvmdemoproject.Utility.showProgressBar
import com.example.mvvmdemoproject.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepo {

    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<User>> {

        val mutableLiveData = MutableLiveData<ArrayList<User>>()

        context.showProgressBar()

        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                hideProgressBar()
               // Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                hideProgressBar()
                val usersResponse = response.body()
                usersResponse?.let { mutableLiveData.value = it as ArrayList<User> }
            }
        })

        return mutableLiveData
    }
}