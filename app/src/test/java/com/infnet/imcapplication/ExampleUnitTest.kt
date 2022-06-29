package com.infnet.imcapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun imcCalcIsCorrect() {

        val peso: String = "80"
        val altura: String = "1.80"

        val expected = 25.0
        val actual = Math.round(peso.toDouble() / (altura.toDouble() * altura.toDouble()))

        assertEquals(expected, actual.toDouble(), .1)
    }
}