package com.roynaldi19.dc3_02fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
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

    override fun onClick(view: View) {
        if (view.id == binding.btnDetailCategory.id) {
            val detailCategoryFragment = DetailCategoryFragment()

            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "LifeStyle")
            val description = "Kategori ini akan berisi produk produk lifestyle"

            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.description = description

            val fragmentManager = parentFragmentManager
            fragmentManager.commit {
                addToBackStack(null)
                replace(
                    R.id.frame_container,
                    detailCategoryFragment,
                    DetailCategoryFragment::class.java.simpleName
                )
            }
        }
    }
}