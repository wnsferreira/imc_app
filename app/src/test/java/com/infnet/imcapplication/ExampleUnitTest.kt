package com.infnet.imcapplication

import android.app.Activity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy

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

    @Test
    fun grauImcIsCorrect() {

        val imcObject = Imc(
            "80",
            "1.80"
        )

        val indice: Double = Math.round(imcObject.calcularIMC(imcObject.peso, imcObject.altura)).toDouble()
        val expected: String = "Sobrepeso"
        assertEquals(expected, imcObject.grauIMC(indice))
    }
}