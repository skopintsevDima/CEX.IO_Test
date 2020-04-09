package com.test.cexiotest.movies.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.cexiotest.movies.domain.model.Movie
import com.test.cexiotest.movies.domain.usecase.GetMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel()  {
    private val movies = MutableLiveData<Result<List<Movie>>>()
    private var subscription: Disposable? = null

    fun getMovies(): LiveData<Result<List<Movie>>> {
        subscription = getMoviesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    movies.value = if (it.isNotEmpty()) Result.success(it)
                    else Result.failure(Throwable("No connection."))
                },
                {
                    Log.d(TAG, "Getting movies failed: ${it.message}")
                    movies.value = Result.failure(it)
                })
        return movies
    }

    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }

    companion object {
        const val TAG = "MoviesViewModel"
    }
}
