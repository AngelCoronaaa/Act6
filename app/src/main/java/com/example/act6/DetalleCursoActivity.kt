package com.example.act6

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.act6.databinding.ActivityDetalleCursoBinding
import com.example.act6.models.Curso

class DetalleCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalleCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val curso = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("curso", Curso::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Curso>("curso")
        }

        curso?.let {
            binding.imgDetalleCurso.setImageResource(it.imagenUrl)
            binding.tvDetalleTitulo.text = it.titulo
            binding.tvCategoriaPill.text = it.categoria
            binding.tvDetalleNivelDuracion.text = "${it.categoria} – ${it.duracion}"
            binding.tvDetalleDescripcion.text = it.descripcion
        }

        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }
}