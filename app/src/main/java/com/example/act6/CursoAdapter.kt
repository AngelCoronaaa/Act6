package com.example.act6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.act6.databinding.ItemCursoBinding
import com.example.act6.models.Curso

class CursoAdapter(
    private val cursos: List<Curso>,
    private val onCursoClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(private val binding: ItemCursoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(curso: Curso) {
            binding.tvTituloCurso.text = curso.titulo
            binding.tvInfoCurso.text = "${curso.categoria} | Duración: ${curso.duracion}"
            binding.imgCurso.setImageResource(curso.imagenUrl)
            
            binding.btnVerDetalles.setOnClickListener {
                onCursoClick(curso)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val binding = ItemCursoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CursoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        holder.bind(cursos[position])
    }

    override fun getItemCount(): Int = cursos.size
}