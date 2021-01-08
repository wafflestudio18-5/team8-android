package com.android.example.podomarket.ui.main.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.databinding.ItemProductBinding

class ProductListAdapter(val listener: (ProductDto) -> Unit) : RecyclerView.Adapter<ProductListViewHolder>() {
    private val items = mutableListOf<ProductDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val item = items[position]
        holder.bindProduct(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    fun setItems(products: List<ProductDto>) {
        items.clear()
        items.addAll(products)
        notifyDataSetChanged()
    }
}

class ProductListViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindProduct(product: ProductDto) {
        binding.item = product
    }

}