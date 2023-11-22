package com.example.game.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.game.GAME_X_OR_O
import com.example.game.GameXO
import com.example.game.databinding.RecyclerviewGameBinding
import kotlin.math.sqrt

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

    private var number = 0
    fun setData(game: MutableList<GameXO>) {
        submitList(game)
    }



    inner class GameXViewHolder(private val binding: RecyclerviewGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val game = currentList[adapterPosition]
            binding.tvGame.text = " "
            binding.root.setOnClickListener {
                if (!game.isXOrO) {
                    if (number == 0) {
                        binding.tvGame.text = "0"
                        number++
                        game.isXOrO = true
                    }else {
                        binding.tvGame.text = "X"
                        number--
                        game.isXOrO = true
                    }
                }
            }
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