package com.candice.constraintlayoutdemo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



/**
 * <br>
 * function:
 * <p>
 * @author:Lyt
 * @date:2018/11/13 下午4:52
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */

fun <T> GsonToList(gsonString: String, cls: Class<T>): List<T>? {
    var list: List<T>? = null
    val gson = Gson()
    if (gson != null) {
        list = gson.fromJson(gsonString, object : TypeToken<List<T>>() {

        }.type)
    }
    return list
}


fun <T> GsonToArrayList(gsonString: String, cls: Class<T>): ArrayList<T>? {
    var list: ArrayList<T>? = null
    val gson = Gson()
    if (gson != null) {
        list = gson.fromJson(gsonString, object : TypeToken<ArrayList<T>>() {

        }.type)
    }
    return list
}
