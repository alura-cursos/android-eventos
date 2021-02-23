package br.com.alura.eventos.ui.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.alura.eventos.R
import br.com.alura.eventos.dao.EventoDao
import br.com.alura.eventos.databinding.ListaEventosBinding
import br.com.alura.eventos.model.Evento
import br.com.alura.eventos.recyclerview.adapter.ListaEventosAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDate.ofEpochDay
import java.time.ZoneId
import java.util.*

class ListaEventosActivity : AppCompatActivity() {

    private val binding by lazy {
        ListaEventosBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
    }
    private val dao = EventoDao()
    private val adapter by lazy {
        ListaEventosAdapter(
            context = this,
            dao.eventos
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerview.adapter = adapter
        configuraFAB()
    }

    private fun configuraFAB() {
        binding.floatingActionButton.setOnClickListener {
            FormEventoDialog(this)
                .show(supportFragmentManager) { eventoCriado ->
                    dao.salva(eventoCriado)
                    adapter.atualiza(dao.eventos)
                }
        }
    }

}