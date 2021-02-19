package br.com.alura.eventos.dao

import br.com.alura.eventos.model.Evento

class EventoDao {

    companion object {
        private val eventos = mutableListOf<Evento>()
    }

    val eventos get() = Companion.eventos.toList()

    fun salva(evento: Evento) {
        Companion.eventos.add(evento)
    }

}