package com.chrynan.sample.di.module.activity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.*
import com.chrynan.sample.di.scope.ActivityScope
import com.chrynan.sample.viewmodel.AdapterItemViewModel
import com.chrynan.sample.ui.activity.MainActivity
import com.chrynan.sample.ui.adapter.ChordAdapter
import com.chrynan.sample.ui.adapter.ChordListAdapter
import com.chrynan.sample.ui.adapter.core.AdapterItemHandler
import com.chrynan.sample.ui.adapter.core.BaseAdapterItemHandler
import com.chrynan.sample.util.ActivityContext
import com.chrynan.sample.view.MainView
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
internal abstract class MainActivityModule {

    @Module
    companion object {

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideDiffUtilCalculator() = DiffUtilCalculator<AdapterItemViewModel>()

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideAndroidDiffDispatcher(listener: ItemListUpdater<AdapterItemViewModel>): DiffDispatcher<AdapterItemViewModel> = AndroidDiffDispatcher(listener)

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideAndroidDiffProcessor(calculator: DiffUtilCalculator<AdapterItemViewModel>): DiffProcessor<AdapterItemViewModel> = AndroidDiffProcessor(calculator)

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideManagerAdapter(chordListAdapter: ChordListAdapter): ManagerRecyclerViewAdapter<AdapterItemViewModel> = anotherAdapterManager(chordListAdapter)

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideLayoutManager(context: MainActivity) = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        @ActivityScope
        @Provides
        @JvmStatic
        @Named("NestedChordListAdapter")
        fun provideChordManagerAdapter(chordAdapter: ChordAdapter): ManagerRecyclerViewAdapter<AdapterItemViewModel> = anotherAdapterManager(chordAdapter)

        @Provides
        @JvmStatic
        @ActivityScope
        fun provideRecycledViewPool() = RecyclerView.RecycledViewPool()
    }

    @Binds
    @ActivityScope
    abstract fun bindAdapterItemHandler(itemHandler: BaseAdapterItemHandler<AdapterItemViewModel>): AdapterItemHandler<AdapterItemViewModel>

    @Binds
    @ActivityScope
    abstract fun bindItemListUpdater(adapter: ManagerRecyclerViewAdapter<AdapterItemViewModel>): ItemListUpdater<AdapterItemViewModel>

    @Binds
    @ActivityScope
    abstract fun bindActivityContext(activity: MainActivity): ActivityContext

    @Binds
    @ActivityScope
    abstract fun bindMainView(activity: MainActivity): MainView

    @Binds
    @ActivityScope
    abstract fun bindChordSelectedListener(activity: MainActivity): ChordAdapter.ChordSelectedListener
}