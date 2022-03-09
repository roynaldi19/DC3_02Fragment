package com.roynaldi19.bfaa01_04fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class OptionDialogFragment : DialogFragment() {
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbCech: RadioButton
    private lateinit var rbTerry: RadioButton
    private lateinit var rbCole: RadioButton
    private lateinit var rbEssien: RadioButton
    private lateinit var rbLampard: RadioButton
    private lateinit var rbHazard: RadioButton
    private lateinit var rbDrogba: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbCech = view.findViewById(R.id.rb_cech)
        rbTerry = view.findViewById(R.id.rb_terry)
        rbCole = view.findViewById(R.id.rb_cole)
        rbEssien = view.findViewById(R.id.rb_essien)
        rbLampard = view.findViewById(R.id.rb_lampard)
        rbHazard = view.findViewById(R.id.rb_hazard)
        rbDrogba = view.findViewById(R.id.rb_drogba)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var player: String? = when (checkedRadioButtonId) {
                    R.id.rb_cech -> rbCech.text.toString().trim()
                    R.id.rb_terry -> rbTerry.text.toString().trim()
                    R.id.rb_cole -> rbCole.text.toString().trim()
                    R.id.rb_essien -> rbEssien.text.toString().trim()
                    R.id.rb_lampard -> rbLampard.text.toString().trim()
                    R.id.rb_hazard -> rbHazard.text.toString().trim()
                    R.id.rb_drogba -> rbDrogba.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(player)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener {
            dialog?.cancel()
        }

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

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}

