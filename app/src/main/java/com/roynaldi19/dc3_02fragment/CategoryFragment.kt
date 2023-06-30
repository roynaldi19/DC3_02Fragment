package com.roynaldi19.dc3_02fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roynaldi19.dc3_02fragment.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

    }

}