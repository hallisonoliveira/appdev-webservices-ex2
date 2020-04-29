package br.com.hallisonoliveira.appdev.exercicio2.date

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception
import java.text.ParseException

@RestController
@RequestMapping("/date")
class DateController {

    @GetMapping("/{startDate}/{endDate}")
    fun differenceBetweenDates(
        @PathVariable startDate: String,
        @PathVariable endDate: String
    ) : ResponseEntity<DateResponse> {
        val service = DateService()
        try {
            val dateResponse = service.getDifferencesBetweenDates(startDate, endDate)
            return ResponseEntity.ok(dateResponse)
        } catch (parseException: ParseException) {
            print(parseException.message)
            throw ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED, parseException.message
            )
        } catch (exception: Exception) {
            print(exception.message)
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Falha ao processar requisição"
            )
        }
    }
}