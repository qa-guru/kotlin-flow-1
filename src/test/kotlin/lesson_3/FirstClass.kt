package lesson_3

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Tags

@Tags
class FirstClass {
    val email: String = "random@email.com"
    val password: String = "randomPassword"

    var name: String = "Name"

    fun getStudentInfo(name: String, age: Int, cls: Int): String {

//        email = ""
//        this.name = ""

        val list: List<String> = listOf("one", "two", "three")
        val arr: ArrayList<String> = arrayListOf("one", "two", "three")

        return ""
    }

    fun auth(email: String = this.email, password: String = this.password): String {
        return "$email : $password"
    }

    fun allInfo() {
        getStudentInfo(name = "Name", cls = 4, age = 1)
    }
}
