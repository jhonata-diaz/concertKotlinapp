package com.thejebereal.thejeberealapp.domain.use_cases.auth

import com.thejebereal.thejeberealapp.domain.repository.AuthRepository
import com.thejebereal.thejeberealapp.domain.model.User

import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}