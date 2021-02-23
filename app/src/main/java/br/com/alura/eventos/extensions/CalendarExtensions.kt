package br.com.alura.eventos.extensions

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

private val formatador = DateTimeFormatter
    .ofPattern("dd/MM/yyyy", Locale("UTC"))

fun LocalDate.paraFormatoBrasileiro(): String = this.format(formatador)

fun String.paraLocalDate(): LocalDate = LocalDate.parse(this, formatador)

fun Long.paraLocalDate(): LocalDate = Instant.ofEpochMilli(this)
    .atZone(ZoneId.of("America/Sao_Paulo"))
    .withZoneSameInstant(ZoneId.ofOffset("UTC", ZoneOffset.UTC))
    .toLocalDate()