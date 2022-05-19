package com.example.retrofitdemopractice.Api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie( @SerializedName("name")
                  @Expose
                  var moviesName: String,
                  @SerializedName("imageUrl")
                  @Expose
                  var moviesPic: String)
