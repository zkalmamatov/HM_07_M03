package kg.example.hm_07_m03

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import kg.example.hm_07_m03.databinding.ItemListCarBinding

class CarAdapter(
    private var carList: ArrayList<CarModel>,
    val onClick: (model: CarModel) -> Unit
) : Adapter<CarAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding: ItemListCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(carModel: CarModel) {
            binding.apply {
                carModel.apply {
                    tvDescription.text = description
                    tvName.text = name
                    Glide.with(imgCar).load(image).into(imgCar)

                    itemView.setOnClickListener {
                        onClick.invoke(carModel)
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListCarBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return carList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(carList[position])
    }
}