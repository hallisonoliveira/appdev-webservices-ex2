package br.com.hallisonoliveira.appdev.exercicio2.number

class NumberService {

    private fun stringToList(numbers: String) : List<Int> {
        val list = numbers.trim().replace("\\s".toRegex(), "").split(";")
        return list.map { it.toInt() }
    }

    fun getClassifiedNumbers(numbers: String) : NumberResponse {
        val numbersList = stringToList(numbers)
        return NumberResponse(
            increasingOrder = numbersList.sorted(),
            decreasingOrder = numbersList.sortedDescending(),
            pairList = numbersList.filter { it % 2 == 0 }
        )
    }

}