package org.sopt.doSopkathon.presentation.write

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.sopt.doSopkathon.databinding.DialogWriteBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class WriteDialog(
    private val click: () -> Unit = { -> },
    private val click2: () -> Unit = { -> }
) : DialogFragment() {

    private var _binding: DialogWriteBinding? = null
    private val binding: DialogWriteBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DialogWriteBinding.inflate(inflater, container, false)

        // 다이얼로그 뜰 때 배경색 dialog?.window?.setBackgroundDrawableResource(배경색)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        binding.btnWriteDialogHome.setOnSingleClickListener {
            click()
        }

        binding.btnWriteDialogWorry.setOnSingleClickListener {
            click2()
        }

        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
