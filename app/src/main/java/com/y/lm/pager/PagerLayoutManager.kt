package com.y.lm.pager

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.y.lm.log

class PagerLayoutManager(context: Context) : LinearLayoutManager(context) ,RecyclerView.OnChildAttachStateChangeListener{


    private val mSnapHelper: PagerSnapHelper = PagerSnapHelper()

    override fun onAttachedToWindow(view: RecyclerView?) {
        super.onAttachedToWindow(view)
        view?.clearOnChildAttachStateChangeListeners()
        view?.addOnChildAttachStateChangeListener(this)
        mSnapHelper.attachToRecyclerView(view)
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
        log("IDLE : $state")
        when (state){
            RecyclerView.SCROLL_STATE_IDLE -> {
            }
        }
    }

    override fun onChildViewDetachedFromWindow(view: View) {
        log("detach")
        onChildChangedListener?.onReleased(view)
    }

    override fun onChildViewAttachedToWindow(view: View) {
        log("attach")
        onChildChangedListener?.onSelected(view)
    }

    /**
     * child变化后的监听
     */
    interface OnChildChangedListener{
        fun onSelected(view: View)
        fun onReleased(view: View)
    }
    private var onChildChangedListener: OnChildChangedListener? = null
    fun setOnChildChangedListener(listener: OnChildChangedListener){
        this.onChildChangedListener = listener
    }

}