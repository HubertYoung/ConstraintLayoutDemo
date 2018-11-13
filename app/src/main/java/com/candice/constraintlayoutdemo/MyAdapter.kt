package com.candice.constraintlayoutdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * <br>
 * function:
 * <p>
 * @author:Lyt
 * @date:2018/11/13 上午11:31
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
class MyAdapter(val context: Context, val dataBean: DataBean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_NO_TITLE: Int = 1
    private val TYPE_CONTENT: Int = 0

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        if (p1 == TYPE_NO_TITLE) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_layout2, p0, false)
            return MyHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.item_layout, p0, false)
            return MyViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return dataBean.menus.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        if (TextUtils.isEmpty(dataBean.title)) {
            return TYPE_NO_TITLE
        } else {
            return TYPE_CONTENT
        }
    }
}

class MyHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

}

class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

}
