package br.com.hallisonoliveira.appdev.exercicio2.mimic

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception

@RestController
@RequestMapping("/mimic")
class MimicController {

    @PostMapping(produces = ["application/json"])
    fun getMimicText(
            @RequestBody text: String
    ) : ResponseEntity<MimicResponse> {
        val service = MimicService()
        try {
            val mimicResponse = service.getMimicText(text)
            return ResponseEntity.ok(mimicResponse)
        } catch (exception: Exception) {
            print(exception.message)
            throw ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Falha ao processar requisição"
            )
        }
    }

}