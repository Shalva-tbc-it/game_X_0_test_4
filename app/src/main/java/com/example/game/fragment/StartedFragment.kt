package com.example.game.fragment

import android.os.Build
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
    private lateinit var countBtn: MutableList<GameXO>
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
        getCounter()

    }

    private fun recyclerViewInit() {
        adapter = GameXRecyclerViewAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(context, count)
        binding.recyclerView.adapter = adapter
        adapter.setData(countBtn)
    }

    private fun getCounter() {
        parentFragmentManager.setFragmentResultListener(
            "requestKey",
            viewLifecycleOwner
        ) { _, bundle ->

            val result =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable("bundleKey", GameXO::class.java)
                } else {
                    bundle.getParcelable("bundleKey")
                }

            result?.let {
                count = it.toString().toInt()
                while (countBtn.size < it.toString().toInt()) {
                    countBtn.add(
                        GameXO(
                            game = GAME_X_OR_O.X
                        )
                    )
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}