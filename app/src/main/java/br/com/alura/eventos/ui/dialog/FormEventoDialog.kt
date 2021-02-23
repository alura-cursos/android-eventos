package br.com.alura.eventos.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import br.com.alura.eventos.databinding.FormEventoBinding
import br.com.alura.eventos.extensions.paraFormatoBrasileiro
import br.com.alura.eventos.extensions.paraLocalDate
import br.com.alura.eventos.model.Evento
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class FormEventoDialog(private val context: Context) {

    fun show(
        supportFragmentManager: FragmentManager,
        quandoEventoCriado: (eventoCriado: Evento) -> Unit
    ) {
        val binding = FormEventoBinding
            .inflate(LayoutInflater.from(context))

        binding.data.setOnClickListener {
            val selecionadorDeData = MaterialDatePicker
                .Builder.datePicker().build()
            selecionadorDeData.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
            selecionadorDeData
                .addOnPositiveButtonClickListener { dataEmMilisegundos ->
                    val data = dataEmMilisegundos.paraLocalDate()
                    binding.data.setText(data.paraFormatoBrasileiro())
                }
        }

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