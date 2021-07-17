package com.chrynan.sample.ui.adapter

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class HorizontalDividerListDecorator : RecyclerView.ItemDecoration() {

    companion object {

        private const val FIRST_POSITION = 0
    }

    abstract val dividerColorInt: Int
    abstract val dividerHeightDimen: Int

    private val paint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = dividerColorInt
        }
    }

    abstract fun shouldDrawTopDividerForViewType(viewType: ViewType?): Boolean

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.apply {
            canvas.save()

            for (i in 0 until childCount) {
                val child = getChildAt(i)
                val adapterPosition = getChildAdapterPosition(child)
                val adapterViewType = try {
                    adapter?.getItemViewType(adapterPosition)
                } catch (throwable: Throwable) {
                    null
                }
                val isAdapterPositionValid =
                    adapterPosition != RecyclerView.NO_POSITION && adapterPosition != FIRST_POSITION
                val shouldDrawTopDivider =
                    isAdapterPositionValid && shouldDrawTopDividerForViewType(adapterViewType)

                if (shouldDrawTopDivider) {
                    val left = paddingLeft.toFloat()
                    val right = width - paddingRight.toFloat()
                    val top = child.top + child.translationY
                    val bottom = top + dividerHeightDimen

                    canvas.drawLine(left, top, right, bottom, paint)
                }
            }

            canvas.restore()
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) = outRect.set(0, dividerHeightDimen, 0, 0)
}
