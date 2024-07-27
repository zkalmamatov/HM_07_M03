package kg.example.hm_07_m03

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.hm_07_m03.databinding.ItemModelBinding

class ModelAdapter(
        private val models: List<Model>,
        private val onItemClick: (Model) -> Unit
    ) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

        inner class ModelViewHolder(private val binding: ItemModelBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(model: Model) {
                binding.model = model
                binding.root.setOnClickListener { onItemClick(model) }
                binding.executePendingBindings()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
            val binding = ItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ModelViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
            holder.bind(models[position])
        }

        override fun getItemCount(): Int = models.size
    }



