package com.isetr.tp5app.ui.ajout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.isetr.tp5app.R
import com.isetr.tp5app.databinding.FragmentAjoutBinding
import androidx.fragment.app.activityViewModels
import com.isetr.tp5app.model.Etudiant
import com.isetr.tp5app.viewModel.EtudiantViewModel
class AjoutFragment : Fragment() {

    private var _binding: FragmentAjoutBinding? = null
    private val etudiantViewModel: EtudiantViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAjoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.boutonAjouter.setOnClickListener {
            ajouterEtudiant()
        }
    }

    private fun ajouterEtudiant() {
        val identifiant = binding.editIdentifiant.text.toString().trim()
        val email = binding.editEmail.text.toString().trim()
        val classe = binding.editClasse.text.toString().trim()

        if (identifiant.isEmpty() || email.isEmpty() || classe.isEmpty()) {
            Toast.makeText(requireContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            return
        }

        val nouvelEtudiant = Etudiant(identifiant, email, classe)

            etudiantViewModel.addEtudiant(nouvelEtudiant)

        Toast.makeText(requireContext(), "Étudiant ajouté", Toast.LENGTH_SHORT).show()


        binding.editIdentifiant.text.clear()
        binding.editEmail.text.clear()
        binding.editClasse.text.clear()


        findNavController().navigate(R.id.action_ajout_to_liste)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}