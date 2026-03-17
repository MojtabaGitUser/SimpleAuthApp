package com.example.simpleauthapp.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun LoginScreen(modifier: Modifier = Modifier) {
    //val viewModel = LoginViewModel() // Initialize your ViewModel
    val viewModel: LoginViewModel = viewModel()

    // var username by remember { mutableStateOf("") }
    //var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = viewModel.username,
            onValueChange = { viewModel.username = it },
            placeholder = { Text("Username...") },
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            placeholder = { Text("Password...") }
        )
        Spacer(
            modifier = Modifier
                .width(24.dp)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                viewModel.login()
            }
        ) {
            Text(
                text = "LOGIN",
                fontSize = 18.sp
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                viewModel.fetchUsers()
            }
        ){
            Text("Fetch Users")
        }
        Spacer(
            modifier = Modifier.width(16.dp)
        )
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(viewModel.loading){
                CircularProgressIndicator()
            }
        }

        LazyColumn (
            modifier = Modifier.weight(1f)
        ){
            items(viewModel.users){ user ->
                Text(
                    text = user.name,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        if (viewModel.errorMessage.isNotEmpty()) {
            Text(viewModel.errorMessage)
        }
    }
}
