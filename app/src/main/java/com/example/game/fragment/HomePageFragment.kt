package com.example.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.game.R
import com.example.game.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private var countBtn: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener()

    }

    private fun listener() = with(binding) {
        btnStartGame.setOnClickListener {
            if (!edMatrix.text.isNullOrEmpty() && edMatrix.text.toString().toInt() > 8 && edMatrix.text.toString().toInt() < 25) {
                countBtn = edMatrix.text.toString()

                val bundle = Bundle()
                bundle.putString("requestKey", countBtn)
                val fragment = StartedFragment()
                fragment.arguments = bundle

//                requireActivity().supportFragmentManager.setFragmentResult(
//
//                )


                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack("Info")
                    .commit()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}