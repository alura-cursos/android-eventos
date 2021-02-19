package br.com.alura.eventos.model

import java.time.LocalDate

data class Evento(
    val titulo: String,
    val data: LocalDate = LocalDate.now()
)
