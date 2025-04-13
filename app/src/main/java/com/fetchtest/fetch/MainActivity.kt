package com.fetchtest.fetch

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.fetchtest.fetch.ui.view.adapter.MainAdapter
import com.fetchtest.fetch.ui.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var mainSwipeToRefresh: SwipeRefreshLayout
    private lateinit var mainProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRecyclerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel.getFetchListFromRemoteAndSort()

        mainRecyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView)
        mainSwipeToRefresh = findViewById<SwipeRefreshLayout>(R.id.mainSwipeToRefresh)
        mainProgressBar = findViewById<ProgressBar>(R.id.mainProgressBar)

        mainSwipeToRefresh.setOnRefreshListener {
            mainViewModel.getFetchListFromRemoteAndSort()
            mainSwipeToRefresh.isRefreshing = false
            Toast.makeText(this, R.string.update, Toast.LENGTH_SHORT).show()
        }
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainViewModel.fetchListLiveData.observe(this, Observer{
            when {
                it == null -> {
                    mainRecyclerView.visibility = View.GONE
                    mainProgressBar.visibility = View.VISIBLE
                    Toast.makeText(this, R.string.smthWrong, Toast.LENGTH_SHORT).show()
                }
                it.isEmpty() -> mainProgressBar.visibility = View.VISIBLE
                else -> {
                    mainRecyclerView.visibility = View.VISIBLE
                    mainRecyclerView.adapter = MainAdapter(it)
                    mainProgressBar.visibility = View.GONE
                }
            }
        })
    }
}