package com.ismail.creatvt.moviemania

class MovieItem(
    val name:String,
    val overview:String,
    val year: String,
    val imageUrl: String,
    val genres: Array<String> // ["Action", "Adventure", "Science Fiction"]
)