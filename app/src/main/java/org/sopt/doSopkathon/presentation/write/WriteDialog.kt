package org.sopt.doSopkathon.presentation.write

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.DialogWriteBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class WriteDialog(
    private val click: () -> Unit = { -> },
    private val click2: () -> Unit = { -> }
) : DialogFragment() {

    private var _binding: DialogWriteBinding? = null
    private val binding: DialogWriteBinding
        get() = requireNotNull(_binding) { getString(R.string.binding_not_initialized_error_msg) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogWriteBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnWriteDialogHome.setOnSingleClickListener {
            click()
        }

        binding.btnWriteDialogWorry.setOnSingleClickListener {
            click2()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
