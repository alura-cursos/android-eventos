package br.com.alura.eventos.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

private val formatador = DateTimeFormatter
    .ofPattern("dd/MM/yyyy", Locale("UTC"))

fun LocalDate.paraFormatoBrasileiro(): String = this.format(formatador)

fun String.paraLocalDate(): LocalDate = LocalDate.parse(this, formatador)