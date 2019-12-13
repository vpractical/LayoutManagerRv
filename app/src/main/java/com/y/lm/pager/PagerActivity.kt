package com.y.lm.pager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.y.lm.R
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : AppCompatActivity() {

    companion object{
        fun start(context: Context){
            val intent = Intent(context, PagerActivity::class.java)
            context.startActivity(intent)
        }
    }

    lateinit var mData: List<Video>
    lateinit var mLayoutManager: PagerLayoutManager
    lateinit var mAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        mData = Video.createData()
        mAdapter = PagerAdapter(this,mData)
        mLayoutManager = PagerLayoutManager(this)
        rvPager.layoutManager = mLayoutManager
        rvPager.adapter = mAdapter

        addListener()
    }

    private fun addListener(){
        mLayoutManager.setOnChildChangedListener(object: PagerLayoutManager.OnChildChangedListener {
            override fun onSelected(view: View) {
                mAdapter.selectItem(view)
            }

            override fun onReleased(view: View) {
                mAdapter.releaseItem(view)
            }
        })
    }

}