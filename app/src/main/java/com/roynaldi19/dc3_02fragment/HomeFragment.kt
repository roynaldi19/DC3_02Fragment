package com.roynaldi19.dc3_02fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.roynaldi19.dc3_02fragment.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCategory.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == binding.btnCategory.id) {
            val categoryFragment = CategoryFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    categoryFragment,
                    CategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}