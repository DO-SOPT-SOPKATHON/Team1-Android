package org.sopt.doSopkathon.presentation.mock

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.doSopkathon.R
import org.sopt.doSopkathon.databinding.ActivityMockBinding
import org.sopt.doSopkathon.util.ViewModelFactory
import org.sopt.doSopkathon.util.base.BindingActivity

class MockActivity : BindingActivity<ActivityMockBinding>(R.layout.activity_mock) {

   private val viewModel: MockViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.test()
    }
}