package lesson_4

import org.junit.jupiter.api.Test

class ScopeFunctions {

    @Test
    fun randomTest() {
        val person = Person("John Doe", 30)

        var str: String = "Hello"
        str = "World"

        println(str)

        person.name?.let { println("Person name: $it") }

        // Using 'let' to print person's details
        person.let {
            println("Name: ${it.name}, Age: ${it.age}")
        }

        // Using 'apply' to modify person's age
        val updatedPerson = person.apply {
            age += 5
        }

        println("Updated Age: ${updatedPerson.age}")

        // Using 'also' to log person's name
        person.also {
            println("Logging Name: ${it.name}")
        }

        // Using 'with' to access person's properties
        with(person) {
            println("Accessing with 'with': Name is $name and Age is $age")
        }

        // Using 'run' to create a summary string
        val summary = person.run {
            "Person Summary: Name is $name, Age is $age"
        }
        println(summary)
    }
}

data class Person(var name: String?, var age: Int)