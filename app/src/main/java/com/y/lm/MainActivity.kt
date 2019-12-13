package com.y.lm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.y.lm.pager.PagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnPager.setOnClickListener{ PagerActivity.start(this)}

    }
}
