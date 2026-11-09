package com.isetr.tp5app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Etudiant(
    val identifiant: String,
    val email: String,
    val classe: String
) : Parcelable