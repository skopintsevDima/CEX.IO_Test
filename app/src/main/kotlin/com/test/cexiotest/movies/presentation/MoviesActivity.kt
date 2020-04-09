package com.test.cexiotest.movies.presentation

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.checkSelfPermission
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.test.cexiotest.R
import com.test.cexiotest.app.App
import com.test.cexiotest.di.ActivityComponent
import com.test.cexiotest.movies.domain.model.Movie
import com.test.cexiotest.movies.presentation.list.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    private lateinit var activityComponent: ActivityComponent
    private lateinit var viewModel: MoviesViewModel
    private var moviesAdapter: MoviesAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = (applicationContext as App).appComponent.activityComponent().create()
        activityComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
        setContentView(R.layout.activity_main)
        initListView()
        initSwipeRefreshLayout()
    }

    private fun initListView() {
        val llm = LinearLayoutManager(parent)
        llm.orientation = RecyclerView.VERTICAL
        moviesList.layoutManager = llm
        moviesList.addItemDecoration(DividerItemDecoration(this, llm.orientation))
    }

    private fun initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener { loadMovies() }
    }

    override fun onResume() {
        super.onResume()
        if (hasPermissions()){
            loadMovies()
        }
    }

    private fun hasPermissions(): Boolean {
        var permissionsToRequest = arrayOf<String>()
        if (checkSelfPermission(this, Manifest.permission.INTERNET) != PERMISSION_GRANTED){
            permissionsToRequest += Manifest.permission.INTERNET
        }
        val hasPermissions = permissionsToRequest.isEmpty()
        if (!hasPermissions) requestPermissions(this, permissionsToRequest, RC_INTERNET_PERMISSION)
        return hasPermissions
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            RC_INTERNET_PERMISSION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED &&
                            grantResults[1] == PERMISSION_GRANTED)) {
                    loadMovies()
                } else {
                    showMsg("Internet permission denied")
                }
                return
            }
        }
    }

    private fun loadMovies() {
        swipeRefreshLayout.isRefreshing = true
        viewModel.getMovies().observe(this, Observer { movies ->
            swipeRefreshLayout.isRefreshing = false
            movies.fold(
                { updateList(it) },
                { showMsg(it.message?:"Unknown issue.") }
            )
        })
    }

    private fun showMsg(message: String) {
        Snackbar.make(swipeRefreshLayout, message, Snackbar.LENGTH_LONG).show()
    }

    private fun updateList(movies: List<Movie>) {
        if (moviesAdapter == null) { moviesAdapter = MoviesAdapter(movies) }
        moviesList.adapter = moviesAdapter
        moviesAdapter?.setItems(movies)
    }

    companion object {
        const val RC_INTERNET_PERMISSION = 100
    }
}