package org.sopt.doSopkathon.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.sopt.doSopkathon.databinding.DialogMainBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class MainDialog(
    private val click: () -> Unit = { -> }
) : DialogFragment() {

    private var _binding: DialogMainBinding? = null
    private val binding: DialogMainBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DialogMainBinding.inflate(inflater, container, false)

        // 다이얼로그 뜰 때 배경색 dialog?.window?.setBackgroundDrawableResource(배경색)

        binding.ivMainDialogClose.setOnSingleClickListener {
            dismiss()
        }

        binding.btnMainDialogShowWorry.setOnSingleClickListener {
            click
        }

        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
