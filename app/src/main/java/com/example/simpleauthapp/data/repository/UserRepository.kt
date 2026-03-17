package com.example.simpleauthapp.data.repository

import com.example.simpleauthapp.model.UserDto
import com.example.simpleauthapp.network.RetrofitClient

class UserRepository {
    suspend fun getUsers(): List<UserDto>{
        return RetrofitClient.api.getUsers()

    }
}