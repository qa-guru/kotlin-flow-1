package backend

import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.models.users.defaultUser
import org.example.kotlin.backend.controllers.Controllers
import org.example.kotlin.backend.helpers.AuthorizationHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UsersTest : Controllers() {
    private val authHelper = AuthorizationHelper()

    @Test
    @DisplayName("Create user with valid data")
    fun createUser() {
        val user = users.createUser(defaultUser).getAsObject()
        val expectedUser = users.getUserById(token = authHelper.getAdminToken(), id = user.id)

        expectedUser shouldBeEqualToComparingFields user
    }

    @Test
    @DisplayName("Delete user with valid token should return 200")
    fun testDeleteUserWithValidToken() {
        val user = users.createUser(defaultUser).getAsObject()
        val delete = users.deleteUserById(authHelper.getAdminToken(), user.id)

        delete.code() shouldBe 200
    }
}