package com.ismail.creatvt.moviemania

object Utility {

    const val API_KEY = "25611267ecba2d97519b04498964b070"
    const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/"
    const val POSTER_THUMBNAIL_SIZE = "w154"

    fun getImageURL(imagePath:String):String{
        return IMAGE_BASE_URL + POSTER_THUMBNAIL_SIZE + imagePath
    }
}