package com.isetr.tp5app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isetr.tp5app.model.Etudiant

class EtudiantViewModel : ViewModel() {

    private val _etudiants = MutableLiveData<MutableList<Etudiant>>()
    private val _selectedEtudiant = MutableLiveData<Etudiant?>()

    val etudiants: LiveData<MutableList<Etudiant>> = _etudiants
    val selectedEtudiant: LiveData<Etudiant?> = _selectedEtudiant
    init {
        _etudiants.value = mutableListOf(
            Etudiant("101", "ali@isetr.tn", "M1 Info"),
            Etudiant("102", "nadia@isetr.tn", "M2 Info"),
            Etudiant("103", "amel@isetr.tn", "L1 Info")
        )
    }

    fun addEtudiant(etudiant: Etudiant) {
        val currentList = _etudiants.value ?: mutableListOf()
        currentList.add(etudiant)
        _etudiants.value = currentList
    }
    fun selectEtudiant(etudiant: Etudiant) {
        _selectedEtudiant.value = etudiant
    }
}