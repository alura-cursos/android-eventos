package br.com.alura.eventos.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.eventos.databinding.FormEventoBinding
import br.com.alura.eventos.extensions.paraLocalDate
import br.com.alura.eventos.model.Evento

class FormEventoDialog(private val context: Context) {

    fun show(quandoEventoCriado: (eventoCriado: Evento) -> Unit) {
        val binding = FormEventoBinding
            .inflate(LayoutInflater.from(context))

        val dialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .show()

        binding.botaoSalvar.setOnClickListener {
            val titulo = binding.titulo.text.toString()
            val dataEmTexto = binding.data.text.toString()
            val data = dataEmTexto.paraLocalDate()
            val evento = Evento(titulo, data)
            dialog.dismiss()
            quandoEventoCriado(evento)
        }
    }

}