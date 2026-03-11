package com.example.simpleauthapp.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleauthapp.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel()  {
    var username = ""
    var password = ""
    var errorMessage = ""

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
            try{
                val users = RetrofitClient.api.getUsers()
                Log.d("API", users.toString())
            }catch (e: Exception){
                Log.e("API",e.message ?: "error")
            }
        }
    }
}