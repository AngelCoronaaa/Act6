package com.example.act6.data

import com.example.act6.R
import com.example.act6.models.Curso
import com.example.act6.models.Usuario

object MockData {
    val usuarios = listOf(
        Usuario("Juan Pérez", "juan", "1234", "juan@test.com"),
        Usuario("Ana Gómez", "ana", "1234", "ana@test.com"),
        Usuario("Angel Corona", "angel", "1234", "angel@test.com")
    )

    val cursos = listOf(
        Curso(
            titulo = "Desarrollo Web Fullstack",
            descripcion = "Aprende a crear aplicaciones web completas desde cero con React y Node.js.",
            categoria = "Principiante",
            duracion = "12 hrs",
            imagenUrl = R.drawable.ic_course_web
        ),
        Curso(
            titulo = "Mobile App con Kotlin",
            descripcion = "Desarrolla aplicaciones nativas para Android utilizando Kotlin y las últimas tecnologías de Jetpack.",
            categoria = "Intermedio",
            duracion = "20 hrs",
            imagenUrl = R.drawable.ic_course_mobile
        ),
        Curso(
            titulo = "Diseño UX/UI",
            descripcion = "Domina Figma y aprende los principios del diseño de experiencia de usuario e interfaces.",
            categoria = "Principiante",
            duracion = "10 hrs",
            imagenUrl = R.drawable.ic_course_ux
        )
    )
}