package com.roynaldi19.dc3_02fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.roynaldi19.dc3_02fragment.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment(), View.OnClickListener {
    private lateinit var binding: FragmentOptionDialogBinding
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChoose.setOnClickListener(this)
        binding.btnClose.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    override fun onClick(view: View) {
        when (view.id) {
            binding.btnChoose.id -> {
                val checkedRadioButtonId = binding.rgOptions.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var player: String? = when (checkedRadioButtonId) {
                        binding.rbCech.id -> binding.rbCech.text.toString().trim()
                        binding.rbTerry.id -> binding.rbTerry.text.toString().trim()
                        binding.rbCole.id -> binding.rbCole.text.toString().trim()
                        binding.rbEssien.id -> binding.rbEssien.text.toString().trim()
                        binding.rbLampard.id -> binding.rbLampard.text.toString().trim()
                        binding.rbHazard.id -> binding.rbHazard.text.toString().trim()
                        binding.rbDrogba.id -> binding.rbDrogba.text.toString().trim()
                        else -> null
                    }
                    optionDialogListener?.onOptionChosen(player)
                    dialog?.dismiss()
                }
            }

            binding.btnClose.id -> {
                dialog?.cancel()
            }
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}

