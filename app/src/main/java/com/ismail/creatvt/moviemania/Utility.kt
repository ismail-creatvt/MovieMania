package com.ismail.creatvt.moviemania

import com.ismail.creatvt.moviemania.model.GenreItem

object Utility {

    const val API_KEY = "25611267ecba2d97519b04498964b070"

    private const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/"
    private const val POSTER_THUMBNAIL_SIZE = "w154"

    // Key = Genre id
    // value = Genre name
    val genreMap = hashMapOf<Int, String>()

    fun setGenres(genres:List<GenreItem>){
        genreMap.clear()
        for(genre in genres){
            genreMap[genre.id] = genre.name
        }
    }

    fun getImageURL(imagePath:String, imageSize:String):String{
        return IMAGE_BASE_URL + imageSize + imagePath
    }

    /**
     * The imagePath that we will get from the API will not be a full URL
     * we have to construct the URL from the imagePath
     */
    fun getThumbnailURL(imagePath: String) = getImageURL(imagePath, POSTER_THUMBNAIL_SIZE)
}