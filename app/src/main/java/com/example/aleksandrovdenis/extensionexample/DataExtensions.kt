package com.example.aleksandrovdenis.extensionexample

import android.view.View
import kotlinx.android.synthetic.main.layout_cell_1.view.*
import kotlinx.android.synthetic.main.layout_cell_2.view.*

/**
 * Created by aleksandrovdenis on 17.01.2018.
 */

fun bindCell1(view: View, data: Data) {
    view.cell1_text.setText(data.titleId)
    view.cell1_icon.setImageResource(data.icon)
}

fun bindCell2(view: View, data: Data) {
    view.cell2_text.setText(data.titleId)
    view.cell2_icon.setImageResource(data.icon)
}

fun Data.bindCell1(view: View) {
    view.cell1_icon.setImageResource(icon)
    view.cell2_text.setText(titleId)
}

val Data.bindMethod_cell_2: View.() -> Unit
    get() = {
        cell2_icon.setImageResource(icon)
        cell2_text.setText(titleId)
    }

val Data.bindMethod_cell_1: View.() -> Unit
    get() = {
        this.cell1_icon.setImageResource(this@bindMethod_cell_1.icon)
        this.cell1_text.setText(this@bindMethod_cell_1.titleId)
    }

val Data.VH_cell_1: Pair<Int, View.() -> Unit>
    get() = R.layout.layout_cell_1 to bindMethod_cell_1

fun Data.VH_cell_2() = Pair<Int, View.() -> Unit>(R.layout.layout_cell_2, {
    cell2_icon.setImageResource(icon)
    cell2_text.setText(titleId)
})
