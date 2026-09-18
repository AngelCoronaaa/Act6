package com.example.act6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.act6.data.MockData
import com.example.act6.databinding.ActivityCursosBinding
import com.example.act6.models.Curso

class CursosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCursosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCursosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreUsuario = intent.getStringExtra("nombreUsuario") ?: ""
        if (nombreUsuario.isNotEmpty()) {
            binding.tvHeader.text = "Hola, $nombreUsuario\nCursos disponibles"
        }

        binding.imgClose.setOnClickListener {
            finish()
        }

        val adapter = CursoAdapter(MockData.cursos) { cursoSeleccionado ->
            val intent = Intent(this, DetalleCursoActivity::class.java).apply {
                putExtra("curso", cursoSeleccionado)
            }
            startActivity(intent)
        }
        
        binding.rvCursos.layoutManager = LinearLayoutManager(this)
        binding.rvCursos.adapter = adapter
    }
}