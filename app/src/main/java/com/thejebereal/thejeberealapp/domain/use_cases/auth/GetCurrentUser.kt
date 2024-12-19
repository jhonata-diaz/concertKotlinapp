package com.thejebereal.thejeberealapp.domain.use_cases.auth


import com.thejebereal.thejeberealapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.currentUser

}