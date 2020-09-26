import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class fibonacciTest {
    @Test
    fun `check first elements`() {
        assertEquals(1, fibonacci(1))
        assertEquals(1, fibonacci(2))
    }

    @Test
    fun `check small numbers`() {
        assertEquals(2, fibonacci(3))
        assertEquals(3, fibonacci(4))
        assertEquals(8, fibonacci(6))
        assertEquals(13, fibonacci(7))
    }

    @Test
    fun `check big numbers`() {
        assertEquals(6765, fibonacci(20))
        assertEquals(832040, fibonacci((30)))
        assertEquals(14930352, fibonacci(36))
    }
}