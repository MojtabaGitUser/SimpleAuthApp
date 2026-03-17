package com.example.simpleauthapp.ui.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleauthapp.data.repository.UserRepository
import com.example.simpleauthapp.model.UserDto
import com.example.simpleauthapp.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel()  {

    private val repository = UserRepository()

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var users by mutableStateOf<List<UserDto>>(emptyList())
    var loading by mutableStateOf(false)

    fun login() {
        if (username.isBlank()){
            errorMessage = "Username is required"
            return
        }
        if (password.isBlank()){
            errorMessage = "Password is required"
            return
        }

        errorMessage = ""
        //Perform login here
    }
    fun fetchUsers(){
        viewModelScope.launch{
            loading = true
            try{
                users = repository.getUsers()
                Log.d("API", users.toString())
            }catch (e: Exception){
                Log.e("API",e.message ?: "error")
            }
            loading = false
        }
    }
}