package uz.umarov.poems.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.umarov.poems.R
import uz.umarov.poems.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.yellowCard.setOnClickListener {
            val txt = "Yangi She'rlar"
            findNavController().navigate(R.id.poemsFragment, bundleOf("poem" to txt))
        }
        binding.redCard.setOnClickListener {
            val txt = "Saqlanganlar"
            findNavController().navigate(R.id.poemsFragment, bundleOf("poem" to txt))
        }
        binding.firstCard.setOnClickListener {
            val txt = "Sevgi she'rlari"
            findNavController().navigate(R.id.poemsFragment, bundleOf("poem" to txt))
        }
        binding.secondCard.setOnClickListener {
            val txt = "Krinj she'rlar"
            findNavController().navigate(R.id.poemsFragment, bundleOf("poem" to txt))
        }

        return binding.root
    }
}