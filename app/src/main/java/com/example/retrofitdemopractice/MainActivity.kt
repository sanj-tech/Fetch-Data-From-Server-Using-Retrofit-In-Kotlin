package com.example.retrofitdemopractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemopractice.Api.Movie
import com.example.retrofitdemopractice.Api.MoviesListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var moviesListAdapter: MoviesListAdapter
    var movieList: MutableList<Movie> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        recyclerViewList.layoutManager = LinearLayoutManager(this)
        recyclerViewList.itemAnimator = DefaultItemAnimator()
        getMovies()
    }

    fun getMovies() {
        pbMoviesList.visibility= View.VISIBLE
        val apiInterface =RetrofitClientInstance().getRetrofitInstance()?.create(ApiInterface::class.java)
        val call=apiInterface?.getMovies()
        call?.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                pbMoviesList.visibility= View.GONE
                if (response.body() != null)
                    movieList = response.body() as MutableList<Movie>
                setUIData(movieList)
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.i("Error", t.message.toString())
                pbMoviesList.visibility= View.GONE
            }
        })
    }

    fun setUIData(movieList: MutableList<Movie>) {
        moviesListAdapter = MoviesListAdapter(this, movieList)
        recyclerViewList.adapter = moviesListAdapter
    }


}