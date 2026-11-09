package com.isetr.tp5app.ui.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.isetr.tp5app.databinding.FragmentListeBinding
import com.isetr.tp5app.model.Etudiant
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.activityViewModels
import com.isetr.tp5app.viewModel.EtudiantViewModel
class ListeFragment : Fragment() {

    private var _binding: FragmentListeBinding? = null
    private val etudiantViewModel: EtudiantViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var etudiantAdapter: EtudiantAdapter
    private lateinit var etudiantList: MutableList<Etudiant>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListeBinding.inflate(inflater, container, false)
        val root: View = binding.root
         return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillRecyclerView()
        etudiantViewModel.etudiants.observe(viewLifecycleOwner) { nouvelleListe ->
            etudiantAdapter.updateList(nouvelleListe)
        }
    }
    private fun fillRecyclerView() {
        etudiantList = mutableListOf()
        etudiantAdapter = EtudiantAdapter(etudiantList) { etudiant ->
            Toast.makeText(
                requireContext(),
                "Étudiant sélectionné : ${etudiant.email}",
                Toast.LENGTH_SHORT
            ).show()
        }
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = etudiantAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}