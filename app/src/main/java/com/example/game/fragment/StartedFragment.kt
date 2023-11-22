package com.example.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.game.GAME_X_OR_O
import com.example.game.GameXO
import com.example.game.adapter.GameXRecyclerViewAdapter
import com.example.game.databinding.FragmentStartedBinding

class StartedFragment : Fragment() {


    private lateinit var adapter: GameXRecyclerViewAdapter
    private var countBtn: MutableList<GameXO> = mutableListOf()
    private var _binding: FragmentStartedBinding? = null
    private val binding get() = _binding!!
    private var count : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartedBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { getCounter(it) }
    }

    private fun recyclerViewInit() {
        adapter = GameXRecyclerViewAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(context, count)
        binding.recyclerView.adapter = adapter
        adapter.setData(countBtn)
    }

    private fun getCounter(bundle: Bundle) {

            val result = bundle.getString("requestKey", "1")


            result?.let {
                val list = ArrayList<GameXO>()

                while (count < it.toString().toInt() * it.toInt()) {
                    list.add(
                        GameXO(
                            game = GAME_X_OR_O.X
                        )
                    )
                    count++
                    if (list.size == it.toInt()) {
                        recyclerViewInit()
                        adapter.setData(countBtn)
                    }
                }
                countBtn.addAll(list)
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}