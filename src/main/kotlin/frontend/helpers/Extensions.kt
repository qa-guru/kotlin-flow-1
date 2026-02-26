package org.example.kotlin.frontend.helpers

import com.codeborne.selenide.ElementsCollection
import io.kotest.assertions.fail

// В этом файле можно разместить расширения для классов, которые используются в тестах.
class Extensions {

    companion object {

        fun ElementsCollection.getFirstOrAsserted(text: String) {
            this.firstOrNull { it.text == text } ?: fail("Элемент с текстом '$text' не найден в коллекции")
        }
    }
}