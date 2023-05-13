package com.example.agriapp

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun whenInputIsValid(){

        val name = "viduth"
        val cropName = "Carrot"
        val location = "malabe"
        val amount = 10

        val result = Validator.validateInput(name,cropName,location, amount)

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInValid1(){

        val name = "viduth"
        val cropName = "Carrot"
        val location = "malabe"
        val amount = -10

        val result = Validator.validateInput(name,cropName,location, amount)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun whenInputIsInValid3(){

        val name = ""
        val cropName = "Carrot"
        val location = "malabe"
        val amount = 10

        val result = Validator.validateInput(name,cropName,location, amount)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun whenInputIsInValid2(){

        val name = "viduth"
        val cropName = ""
        val location = "malabe"
        val amount = 10

        val result = Validator.validateInput1(name,cropName,location, amount)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun whenInputIsInValid4(){

        val name = "viduth"
        val cropName = "carrot"
        val location = ""
        val amount = 10

        val result = Validator.validateInput1(name,cropName,location, amount)

        assertThat(result).isEqualTo(false)
    }



}

