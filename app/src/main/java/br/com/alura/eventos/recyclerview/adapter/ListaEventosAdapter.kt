package br.com.alura.eventos.recyclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.eventos.databinding.ItemEventoBinding
import br.com.alura.eventos.extensions.paraFormatoBrasileiro
import br.com.alura.eventos.model.Evento
import java.util.*

class ListaEventosAdapter(
    private val context: Context,
    eventos: List<Evento> = listOf()
) : RecyclerView.Adapter<ListaEventosAdapter.ViewHolder>() {

    private val dataset = eventos.toMutableList()

    class ViewHolder(private val binding: ItemEventoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(evento: Evento) {
            binding.titulo.text = evento.titulo
            binding.data.text = evento.data.paraFormatoBrasileiro()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(
        ItemEventoBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.bind(dataset[position])

    override fun getItemCount() = dataset.size

    fun atualiza(eventos: List<Evento>) {
        dataset.clear()
        dataset.addAll(eventos)
        notifyDataSetChanged()
    }

}
