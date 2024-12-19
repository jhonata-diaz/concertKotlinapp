package com.thejebereal.thejeberealapp.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thejebereal.thejeberealapp.domain.model.Response
import com.thejebereal.thejeberealapp.presentation.components.ProgressBar
import com.thejebereal.thejeberealapp.presentation.AppNavigation.AppScreen
import com.thejebereal.thejeberealapp.presentation.screens.signup.SignupViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {
    when (val signupResponse = viewModel.signupResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.createUser()
                navController.popBackStack(AppScreen.Login.route, true)
                navController.navigate(AppScreen.Main.route) {
                    popUpTo(AppScreen.Main.route) { inclusive = true }
                }
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, signupResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }
}