package com.candice.constraintlayoutdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * <br>
 * function:
 * <p>
 * @author:Lyt
 * @date:2018/11/13 上午11:31
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
class MyAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_NO_TITLE: Int = 1
    private val TYPE_CONTENT: Int = 0
    private var menuList =  ArrayList<String>()

    private fun getMenuSize(): Int {
        for (i in list!!.indices) {
            val bean = list!![i]
            Log.e("TAG", "LIST>>>${list!![i]}")
            for (j in bean.menus.indices) {
                menuList.add(bean.menus[j])
            }
        }
        return menuList.size
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return if (p1 == TYPE_NO_TITLE) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_layout2, p0, false)
            MyHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.item_layout, p0, false)
            MyViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        val listSize:Int = if (list == null) 0 else list!!.size
        return listSize + menuList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
//        val viewType = getItemViewType(p1)
//        val menu = menuList[p1]
//        val dataBean = list!![1]
//        when (viewType) {
//            TYPE_NO_TITLE ->
            if (p0 is MyHolder) {
                p0.tvContent1?.text = "11111"
            }
//            TYPE_CONTENT -> if (p0 is MyViewHolder) {
////                p0.tvTitle?.text = dataBean.title
//                p0.tvContent?.text = "aaaaaa"
//            }


//        }
    }

    override fun getItemViewType(position: Int): Int {
//        val dataBean = list!![position]
//        return if (TextUtils.isEmpty(dataBean.title)) {
            return TYPE_NO_TITLE
//        } else {
//            TYPE_CONTENT
//        }
    }

    private var list: List<DataBean>? = null

    fun setList(list: List<DataBean>?) {
        this.list = list
    }
}

class MyHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    val tvContent1 = view?.findViewById<TextView>(R.id.tv_content1)

}

class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    val tvTitle = view?.findViewById<TextView>(R.id.tv_title)
    val tvContent = view?.findViewById<TextView>(R.id.tv_content)


}
