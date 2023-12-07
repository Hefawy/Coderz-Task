package com.example.thirdtest.data

data class ResponseEntity<T> (
    val status: Int,
    val resultMessage:String,
    val body:T?
)