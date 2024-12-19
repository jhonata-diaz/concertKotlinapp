package  com.thejebereal.thejeberealapp.domain.use_cases.users

import com.thejebereal.thejeberealapp.domain.model.User
import com.thejebereal.thejeberealapp.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(user: User) = repository.create(user)

}