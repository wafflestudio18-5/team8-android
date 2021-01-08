package com.android.example.podomarket.ui.product.create

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.podomarket.data.network.dto.CityDto
import com.android.example.podomarket.databinding.ItemCityBinding

class SelectCityAdapter(val listener: (CityDto) -> Unit) : RecyclerView.Adapter<SelectCityViewHolder>() {
    private val items = mutableListOf<CityDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectCityViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SelectCityViewHolder, position: Int) {
        val item = items[position]
        holder.bindCity(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    fun setItems(cities: List<CityDto>) {
        items.clear()
        items.addAll(cities)
        notifyDataSetChanged()
    }
}

class SelectCityViewHolder(private val binding: ItemCityBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindCity(city: CityDto) {
        binding.item = city
    }

}