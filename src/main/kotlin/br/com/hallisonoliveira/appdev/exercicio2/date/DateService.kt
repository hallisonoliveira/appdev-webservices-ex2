package br.com.hallisonoliveira.appdev.exercicio2.date

import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Service
class DateService {

    private val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    private fun getDifferenceInDays(start: String, end: String) : Int {
        val startDate = format.parse(start)
        val endDate = format.parse(end)

        val difference = TimeUnit.DAYS.convert(
                endDate.time - startDate.time,
                TimeUnit.MILLISECONDS
        ).toInt()

        return if (difference > 0) difference else 0
    }

    private fun getDifferenceInWeeks(start: String, end: String) : Int {
        val differenceInDays = getDifferenceInDays(start, end)
        return differenceInDays / 7
    }

    private fun getDifferenceInMonths(start: String, end: String) : Int {
        val differenceInDays = getDifferenceInDays(start, end)
        return differenceInDays / 30
    }

    fun getDifferencesBetweenDates(start: String, end: String) : DateResponse {
        return DateResponse(
                differenceInDays = getDifferenceInDays(start, end),
                differenceInWeeks = getDifferenceInWeeks(start, end),
                differenceInMonths = getDifferenceInMonths(start, end)
        )
    }

}