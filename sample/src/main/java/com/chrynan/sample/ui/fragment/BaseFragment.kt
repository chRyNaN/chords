package com.chrynan.sample.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.chrynan.sample.coroutine.FragmentCoroutineScope
import com.chrynan.sample.presenter.Presenter
import dagger.android.support.DaggerFragment
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : DaggerFragment(),
        FragmentCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycleScope.coroutineContext

    protected open val presenter: Presenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.bind()
    }

    override fun onResume() {
        super.onResume()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        presenter?.unbind()

        super.onPause()
    }

    override fun onDestroyView() {
        presenter?.unbind()

        super.onDestroyView()
    }
}