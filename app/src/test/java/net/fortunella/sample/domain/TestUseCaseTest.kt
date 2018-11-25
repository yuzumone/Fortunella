package net.fortunella.sample.domain

import net.fortunella.Failure
import net.fortunella.Success
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class TestUseCaseTest {

    private lateinit var useCase: TestUseCase

    @Before
    fun setUp() {
        useCase = TestUseCase()
    }

    @Test
    fun testSuccess() {
        useCase(true) {
            assertThat(it, org.hamcrest.core.IsInstanceOf(Success::class.java))
            when (it) {
                is Success -> assertEquals("ok", it.value)
            }
        }
    }

    @Test
    fun testFailure() {
        useCase(false) {
            assertThat(it, org.hamcrest.core.IsInstanceOf(Failure::class.java))
            when (it) {
                is Failure -> assertEquals(IllegalArgumentException(), it.reason)
            }
        }
    }
}