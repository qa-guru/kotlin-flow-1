package backend

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import org.example.kotlin.backend.api.extension.Extensions.Companion.checkIsSuccessful
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.models.users.UpdateRequest
import org.example.kotlin.backend.api.models.users.defaultUser
import org.example.kotlin.backend.controllers.Controllers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UsersTest : Controllers() {

    @Test
    @DisplayName("Get requested user from all users")
    fun getUserFromAllUsers() {
        val user = users.createUser(defaultUser).getAsObject()
        val allUser = users.getAllUsers().getAsObject()

        allUser shouldContain user
    }

    @Test
    @DisplayName("Create user with valid data")
    fun createUser() {
        val user = users.createUser(defaultUser).getAsObject()
        val expectedUser = users.getUserById(id = user.id)

        expectedUser shouldBeEqualToComparingFields user
    }

    @Test
    @DisplayName("Update full user model with valid data")
    fun updateFullUser() {
        val user = users.createUser(defaultUser).getAsObject()
        val updateRequest = UpdateRequest(
            username = "updatedUsername",
            email = "upd-email@autotest.com",
            password = "updatedPassword",
            phoneNumber = "1234567890"
        )
        val updUser = users.updateUserById(id = user.id, body = updateRequest).getAsObject()
        val login = auth.login(email = updateRequest.email!!, password = updateRequest.password!!).getAsObject()

        login.accessToken.length shouldBeGreaterThan 10
        updUser.phoneNumber shouldBe updateRequest.phoneNumber
        updUser.username shouldBe updateRequest.username
        updUser.email shouldBe updateRequest.email
    }

    @Test
    @DisplayName("Update partial user model with valid data")
    fun updatePartialUser() {
        val user = users.createUser(defaultUser).getAsObject()

        val updateRequest = UpdateRequest(password = "updatedPassword")
        users.updateUserById(id = user.id, body = updateRequest).checkIsSuccessful()

        val login = auth.login(email = user.email, password = updateRequest.password!!).getAsObject()

        login.accessToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("Delete user with valid token should return 200")
    fun testDeleteUserWithValidToken() {
        val user = users.createUser(defaultUser).getAsObject()
        val delete = users.deleteUserById(id = user.id)

        delete.code() shouldBe 200
    }
}