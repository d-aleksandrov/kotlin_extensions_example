package com.example.aleksandrovdenis.extensionexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by aleksandrovdenis on 17.01.2018.
 */
class FunctionalAdapter : RecyclerView.Adapter<AbstractViewHolder>() {

    fun add(item: Pair<Int, View.() -> Unit>) {
        items.add(item)
    }

    val items = mutableListOf<Pair<Int, View.() -> Unit>>()
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AbstractViewHolder?, position: Int) {
        holder?.itemView?.let { view ->
            items.getOrNull(position)?.let { pair ->
                pair.second.invoke(view)
            }
        }

    }

    override fun getItemViewType(position: Int): Int
            = items.getOrNull(position)?.first ?: throw Exception("bounds of list")

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(viewType, parent, false)
        return AbstractViewHolder(viewType, view)
    }

}

class AbstractViewHolder(val type: Int, view: View) : RecyclerView.ViewHolder(view)