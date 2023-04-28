package com.example.mvvmdemoproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemoproject.adapter.UsersAdapter
import com.example.mvvmdemoproject.data.User
import com.example.mvvmdemoproject.viewmodel.UserViewModel
import com.example.mvvmdemoproject.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var listUsers: MutableList<User>
    private lateinit var adapter: UsersAdapter
    private lateinit var rvRecyclerView:RecyclerView

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvRecyclerView = findViewById(R.id.recycler_main)
        rvRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        listUsers = mutableListOf<User>()
        adapter = UsersAdapter(this)
        adapter.differ.submitList(listUsers)
        rvRecyclerView.adapter = adapter


        val userViewModel = ViewModelProviders.of(this,UserViewModelFactory(this))[UserViewModel::class.java]

        userViewModel.getData().observe(this
        ) { t ->
            listUsers.clear()
            t?.let { listUsers.addAll(it) }
            adapter.notifyDataSetChanged()
        }

    }
}