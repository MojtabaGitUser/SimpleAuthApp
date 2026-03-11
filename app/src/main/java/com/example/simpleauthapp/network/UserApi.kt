package com.example.simpleauthapp.network

import com.example.simpleauthapp.model.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}