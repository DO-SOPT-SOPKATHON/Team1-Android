package org.sopt.doSopkathon.presentation.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.DialogMainBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class MainDialog(
    private val click: () -> Unit = { -> },
) : DialogFragment() {

    private var _binding: DialogMainBinding? = null
    private val binding: DialogMainBinding
        get() = requireNotNull(_binding) { getString(R.string.binding_not_initialized_error_msg) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogMainBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCloseBtnListener()
        initMainBtnListener()
    }

    private fun initCloseBtnListener() {
        binding.ivMainDialogClose.setOnSingleClickListener {
            dismiss()
        }
    }

    private fun initMainBtnListener() {
        binding.btnMainDialogShowWorry.setOnSingleClickListener {
            click()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
