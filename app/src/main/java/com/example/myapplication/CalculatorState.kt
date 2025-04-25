package com.example.composetest.com.example.myapplication

data class CalculatorState(
    val number1:String="",
    val number2:String="",
    val operation: CalculatorOperation? = null
)
