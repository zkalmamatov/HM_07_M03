package kg.example.hm_07_m03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kg.example.hm_07_m03.databinding.FragmentCarDetailBinding


class CarDetailFragment : Fragment() {

    lateinit var binding: FragmentCarDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("Car") as CarModel
        binding.apply {
            tvNameFromMain.text = data.name
            tvStatusFromMain.text = data.description
            Glide.with(imgFromMain).load(data.image).into(imgFromMain)
        }
    }

}