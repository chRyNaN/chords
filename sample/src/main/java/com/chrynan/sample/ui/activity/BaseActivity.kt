package com.chrynan.sample.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chrynan.sample.coroutine.ActivityCoroutineScope
import com.chrynan.sample.coroutine.AndroidCoroutineDispatchers
import com.chrynan.sample.presenter.Presenter
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(),
        ActivityCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    protected val dispatchers = AndroidCoroutineDispatchers()

    private lateinit var job: Job

    protected open val presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        job = SupervisorJob()

        bindToPresenter()
    }

    override fun onRestart() {
        super.onRestart()

        bindToPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        unbindFromPresenter()

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        job.cancel()

        unbindFromPresenter()

        super.onDestroy()
    }

    private fun bindToPresenter() {
        if (presenter?.isBound == false) {
            presenter?.bind()
        }
    }

    private fun unbindFromPresenter() {
        if (presenter?.isBound == true) {
            presenter?.unbind()
        }
    }
}