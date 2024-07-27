package kg.example.hm_07_m03

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.hm_07_m03.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<String>,
    private val onItemClick: (Product) -> Unit
    ) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

        inner class ProductViewHolder(private val binding: ItemProductBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(product: Product) {
                binding.product = product
                binding.root.setOnClickListener { onItemClick(product) }
                binding.executePendingBindings()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            holder.bind(products[position])
        }

        override fun getItemCount(): Int = products.size
    }




