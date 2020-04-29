package br.com.hallisonoliveira.appdev.exercicio2.mimic

class MimicService {

    fun getMimicText(text: String) : MimicResponse {
        return MimicResponse(
            text.replace(VOWELS.toRegex(), "i")
        )
    }

    companion object {
        private const val VOWELS = "[AEIOUÃÂÁÀÊÉÈÎÍÌÔÓÒÛÚÙaeiouãâáàêéèîíìôóòûúù]"
    }
}