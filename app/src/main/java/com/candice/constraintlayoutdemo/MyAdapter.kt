package com.candice.constraintlayoutdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
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
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataBean.menus.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

}
