package kg.example.hm_07_m03

import android.graphics.ColorSpace
import android.graphics.ColorSpace.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kg.example.hm_07_m03.databinding.FragmentModelDetailBinding
import kg.example.hm_07_m03.databinding.FragmentModelListBinding


class ModelListFragment : Fragment() {



        private lateinit var binding: FragmentModelDetailBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentModelListBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val models = arguments?.getParcelableArrayList<ColorSpace.Model>("models") ?: emptyList()

            binding.rv_models.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewModels.adapter = ModelAdapter(models) { model ->
                // Handle model click
                val fragment = ModelDetailFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable("modelDetail", model)
                    }
                }
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }




}