package frontend

import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class ParamTest {

    @ParameterizedTest
    @CsvSource(
        delimiter = '|',
        quoteCharacter = '"',
        textBlock = """
        #-----------------------------
        #    FRUIT     |     RANK
        #-----------------------------
             apple     |      1
             banana    |      2
          "lemon lime" |     0xF1
           strawberry  |    700_000
        #-----------------------------
        """
    ) fun testWithCsvSourceWithComment(fruit: String?, rank: String) {
        fruit.shouldNotBeNull()
        rank.toInt() shouldBeGreaterThan 0
    }

    @ParameterizedTest
    @ValueSource(classes = [String::class, Int::class, Double::class])
    fun testWithClassSource(clazz: Class<*>) {
        clazz.shouldNotBeNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["apple", "banana", "lemon lime", "strawberry"])
    fun testWithValueSource(fruit: String) {
        fruit.shouldNotBeNull()
    }
}