package br.com.hallisonoliveira.appdev.exercicio2.number

class NumberService {

    private fun stringToList(numbers: String) : List<Int> {
        var processedNumbers = numbers
        if (numbers.startsWith(";")) {
            processedNumbers = processedNumbers.drop(0)
        }

        if (numbers.endsWith(";")) {
            processedNumbers = processedNumbers.drop(processedNumbers.lastIndex)
        }

        val list = processedNumbers.trim()
                .replace("\\s".toRegex(), "")
                .replace("\"".toRegex(), "")
                .split(";")
        return list.filter { it.isNotEmpty() }.map { it.toInt() }
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