package com.isetr.tp5app.ui.liste

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isetr.tp5app.databinding.ItemBinding
import com.isetr.tp5app.model.Etudiant

class EtudiantAdapter(
    private var etudiants: MutableList<Etudiant>,
    private val onItemClicked: (Etudiant) -> Unit
) : RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder>() {

    inner class EtudiantViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EtudiantViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EtudiantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EtudiantViewHolder, position: Int) {
        val etudiant = etudiants[position]
        holder.binding.tvId.text = etudiant.identifiant
        holder.binding.tvClasse.text = etudiant.classe
        holder.binding.tvMail.text = etudiant.email
        holder.itemView.setOnClickListener { onItemClicked(etudiant) }
    }
    fun updateList(newList: List<Etudiant>) {
        etudiants.clear()
        etudiants.addAll(newList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = etudiants.size
}