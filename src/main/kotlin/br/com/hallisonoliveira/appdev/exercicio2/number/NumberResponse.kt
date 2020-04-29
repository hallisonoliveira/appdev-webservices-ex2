package br.com.hallisonoliveira.appdev.exercicio2.number

data class NumberResponse(
    val increasingOrder: List<Int>,
    val decreasingOrder: List<Int>,
    val pairList: List<Int>
)