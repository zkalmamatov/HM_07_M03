package kg.example.hm_07_m03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kg.example.hm_07_m03.databinding.FragmentCarBinding


class CarFragment : Fragment() {

    lateinit var binding: FragmentCarBinding
    private val carList = arrayListOf(
        CarModel(
            "https://cdn.kodixauto.ru/media/resized_image/webp/5fd8877796b04a000156e27f/768/0",
            "Характеристики модели Х1",
            "BMW X1"
        ),
        CarModel(
            "https://cdn.kodixauto.ru/media/resized_image/webp/5fd887bf96b04a000156e280/768/0",
            "Характеристики модели Х2",
            "BMW X2"
        ),
        CarModel(
            "https://cdn.kodixauto.ru/media/resized_image/webp/5fd887f596b04a000156e283/768/0",
            "Характеристики модели Х3",
            "BMW X3"
        ),
        CarModel(
            "https://cdn.kodixauto.ru/media/resized_image/webp/5fd8883096b04a000156e28a/768/0",
            "Характеристики модели Х4",
            "BMW X4"
        ),
        CarModel(
            "https://cdn.kodixauto.ru/media/resized_image/webp/5fd8886889995f0001a40cb2/768/0",
            "Характеристики модели Х5",
            "BMW X5"
        )
    )


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentCarBinding.inflate(layoutInflater)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

     fun initAdapter() {
        val adapter = CarAdapter(carList, this::onClick)
        binding.rvCar.adapter = adapter
    }

    private fun onClick(carModel: CarModel) {
        findNavController().navigate(R.id.blankFragment, bundleOf("Car" to carModel))

    }


}