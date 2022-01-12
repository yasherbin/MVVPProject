package com.example.mvvpproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvpproject.databinding.ItemLayoutBinding
import com.example.mvvpproject.data.model.Frog
import com.example.mvvpproject.ui.main.view.FrogListFragmentDirections


class MainAdapter(
    private val frogs: ArrayList<Frog>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(private val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder (itemBinding.root) {


        fun bind(frog: Frog) {
            itemBinding.textViewName.text = frog.name
            itemBinding.textViewType.text = frog.type
            Glide.with(itemBinding.imageViewAvatar.context)
                .load("https://st.depositphotos.com/1005549/1734/i/600/depositphotos_17349957-stock-photo-green-frog.jpg")
                .into(itemBinding.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DataViewHolder {
            val itemBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DataViewHolder(itemBinding)
        }

    override fun getItemCount(): Int = frogs.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(frogs[position])
        holder.itemView.setOnClickListener { mView ->

            val direction = FrogListFragmentDirections.actionUserListFragmentToDetailFragment(frogs[position].name, frogs[position].description)
            mView.findNavController().navigate(direction)
        }
    }

    fun addData(list: List<Frog>) {
        frogs.addAll(list)
    }

}
