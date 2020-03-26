package com.example.cleanarcdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarcdemo.data.Plant
import com.example.cleanarcdemo.databinding.LayoutPlantItemBinding

class PlantAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listPlant : ArrayList<Plant> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PlantViewHolder(
            LayoutPlantItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listPlant.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlantViewHolder).bind(listPlant[position])
    }

    fun setPlantList(list: List<Plant>) {
        listPlant.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class PlantViewHolder(
        private val binding: LayoutPlantItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Plant) {
            binding.apply {
                plant = item
                executePendingBindings()
            }
        }
    }
}