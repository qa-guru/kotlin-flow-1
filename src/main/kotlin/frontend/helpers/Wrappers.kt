package org.example.kotlin.frontend.helpers

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By

class Wrappers {

    companion object {
        fun byTestGroup(target: String): By {
            return Selectors.by("data-test-group", target) // Multiple elements with the same value, used for lists
        }

        fun byTestId(target: String) = Selectors.by("data-test-id", target) // Single UNIQ element
    }
}