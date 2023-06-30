package com.roynaldi19.dc3_02fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roynaldi19.dc3_02fragment.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentDetailCategoryBinding

    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnProfile.setOnClickListener(this)
        binding.btnShowDialog.setOnClickListener(this)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            binding.tvCategoryName.text = categoryName
            binding.tvCategoryDescription.text = description
        }
    }

    override fun onClick(view: View) {

    }

}