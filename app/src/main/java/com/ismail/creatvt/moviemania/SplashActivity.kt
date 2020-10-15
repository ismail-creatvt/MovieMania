package com.ismail.creatvt.moviemania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.ismail.creatvt.moviemania.api.GenreListService
import com.ismail.creatvt.moviemania.model.GenreItem
import com.ismail.creatvt.moviemania.model.GenreListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity(), Callback<GenreListResponse> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Sets the layout to the activity
        setContentView(R.layout.activity_splash)

        /*
         * Here we are getting a list of genres
         * We will move to next screen only if we get this genre list
         * otherwise we will stay on this screen
         */

        //Get the retrofit object
        val retrofit = RetrofitFactory.getInstance()

        //Use retrofit to create an object of GenreListService interface
        val genreListService = retrofit.create(GenreListService::class.java)

        //Get the call object for genre list
        val call = genreListService.getGenreList()

        // Enqueue this call object
        // If you don't enqueue this call, the api will not work
        // so this is very important
        call.enqueue(this)

    }

    // Below are the two callbacks that Retrofit will give us


    /**
     * onResponse: This callback function will be called when
     * we have some response from the api
     *
     * The response can be empty
     */
    override fun onResponse(call: Call<GenreListResponse>, response: Response<GenreListResponse>) {
        //if the body of the response is not null then only we
        //process it
        // if it is null it means that we have no data
        if(response.body() != null){
            Utility.setGenres((response.body() as GenreListResponse).genres)
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    /**
     * This method will be called when there is some error while the api call
     */
    override fun onFailure(call: Call<GenreListResponse>, t: Throwable) {
        Log.d("Exception", "Reason : ${t.message}")
    }
}