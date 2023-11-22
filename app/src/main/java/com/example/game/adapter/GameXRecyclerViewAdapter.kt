package com.example.game.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.game.GameXO
import com.example.game.databinding.RecyclerviewGameBinding

class GameXRecyclerViewAdapter: ListAdapter<GameXO, GameXRecyclerViewAdapter.GameXViewHolder>( object :
    DiffUtil.ItemCallback<GameXO>() {
    override fun areItemsTheSame(oldItem: GameXO, newItem: GameXO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GameXO, newItem: GameXO): Boolean {
        return oldItem == newItem
    }

}
) {

    fun setData(game: MutableList<GameXO>) {
        submitList(game)
    }


    inner class GameXViewHolder(private val binding: RecyclerviewGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvGame.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameXViewHolder {
        return GameXViewHolder(
            RecyclerviewGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameXViewHolder, position: Int) {
        holder.bind()
    }
}