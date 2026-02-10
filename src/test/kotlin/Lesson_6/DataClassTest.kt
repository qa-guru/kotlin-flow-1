package Lesson_6

import Lesson_5.ExtensionFunctions
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import lesson_4.Person
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import java.time.Duration

class DataClassTest {

    @Test
    fun random() {
        println("Class: ${ExtensionFunctions()}") // ExtensionFunctions@6d311334
        println("Data class: ${Person("Vasya", 15)}") // Person(name=Vasya, age=15)

        val newDefaultStudent = defaultStudent.copy(role = true)
    }

    @Test
    fun objectTest() {

    }
}

data class Student(
    val studentId: Int,
    val firstName: String?,
    val lastName: String?,
    val role:Boolean,
    val age: Int,
)

val defaultStudent = Student(
    studentId = 0,
    firstName = null,
    lastName = null,
    role = false,
    age = 0,
)

//public class Student {
//    private int studentId;
//    private String firstName;
//    private String lastName;
//    private int age;
//
//    public Student() {}
//
//    public Student(int studentId, String firstName, String lastName, int age) {
//        this.studentId = studentId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    // Getters and Setters
//    public int getStudentId() { return studentId; }
//    public void setStudentId(int studentId) { this.studentId = studentId; }
//
//    public String getFirstName() { return firstName; }
//    public void setFirstName(String firstName) { this.firstName = firstName; }
//
//    public String getLastName() { return lastName; }
//    public void setLastName(String lastName) { this.lastName = lastName; }
//
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId=" + studentId +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}