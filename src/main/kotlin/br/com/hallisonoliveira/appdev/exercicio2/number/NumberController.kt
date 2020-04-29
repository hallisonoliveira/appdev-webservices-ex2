package br.com.hallisonoliveira.appdev.exercicio2.number

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception

@RestController
@RequestMapping("/number")
class NumberController {

    @PostMapping(produces = ["application/json"])
    fun getClassifiedNumbers(
        @RequestBody numberRequest: String
    ) : ResponseEntity<NumberResponse> {
        val service = NumberService()
        try {
            val numberResponse = service.getClassifiedNumbers(numberRequest)
            return ResponseEntity.ok(numberResponse)
        } catch (exception: Exception) {
            print(exception.message)
            throw ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Falha ao processar requisição"
            )
        }
    }

}