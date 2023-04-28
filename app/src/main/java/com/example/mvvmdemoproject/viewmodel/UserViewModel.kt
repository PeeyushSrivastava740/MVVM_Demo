package com.example.mvvmdemoproject.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemoproject.Utility.isInternetAvailable
import com.example.mvvmdemoproject.data.User
import com.example.mvvmdemoproject.repo.UserRepo

class UserViewModel (private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<User>>()

    init {
        val userRepository: UserRepo by lazy {
            UserRepo
        }
        if (context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData(): MutableLiveData<ArrayList<User>> {
        return listData
    }

}