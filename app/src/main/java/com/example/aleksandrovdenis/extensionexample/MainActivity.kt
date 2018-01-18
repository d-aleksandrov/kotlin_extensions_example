package com.example.aleksandrovdenis.extensionexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testData.getOrNull(0)?.let { data -> bindCell1(main_cell1, data) }
        testData.getOrNull(1)?.apply { bindMethod_cell_2.invoke(main_cell2) }

        main_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter = FunctionalAdapter()

        testData.forEach {
            val vh = if (Math.random() > 0.5)
                it.VH_cell_1
            else
                it.VH_cell_2()

            adapter.add(vh)
        }

        main_recycler.adapter = adapter
    }
}
