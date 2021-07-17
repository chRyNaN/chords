package com.chrynan.sample.ui.activity

import android.os.Bundle
import androidx.lifecycle.coroutineScope
import com.chrynan.sample.coroutine.ActivityCoroutineScope
import com.chrynan.sample.presenter.Presenter
import dagger.android.support.DaggerAppCompatActivity
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : DaggerAppCompatActivity(),
        ActivityCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycle.coroutineScope.coroutineContext

    protected open val presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter?.bind()
    }

    override fun onRestart() {
        super.onRestart()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        presenter?.unbind()

        super.onDestroy()
    }
}