package com.fetchtest.fetch

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fetchtest.fetch.ui.view.adapter.MainAdapter
import com.fetchtest.fetch.ui.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var mainRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel.getFetchListFromRemoteAndSort()

        mainRecyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView)
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainViewModel.fetchListLiveData.observe(this, Observer{
            if (it != null) mainRecyclerView.adapter = MainAdapter(it)
        })
    }
}