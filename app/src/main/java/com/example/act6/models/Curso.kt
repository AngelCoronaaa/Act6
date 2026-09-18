package com.example.act6.models

import android.os.Parcel
import android.os.Parcelable

data class Curso(
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val duracion: String,
    val imagenUrl: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        titulo = parcel.readString() ?: "",
        descripcion = parcel.readString() ?: "",
        categoria = parcel.readString() ?: "",
        duracion = parcel.readString() ?: "",
        imagenUrl = parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(descripcion)
        parcel.writeString(categoria)
        parcel.writeString(duracion)
        parcel.writeInt(imagenUrl)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Curso> {
        override fun createFromParcel(parcel: Parcel): Curso = Curso(parcel)
        override fun newArray(size: Int): Array<Curso?> = arrayOfNulls(size)
    }
}