package com.candice.constraintlayoutdemo

import com.google.gson.Gson
import java.lang.reflect.Type


/**
 * <br>
 * function:
 * <p>
 * @author:Lyt
 * @date:2018/11/13 下午4:52
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
class Utils{
    private var gson:Gson = Gson()

    fun <T> gsonToList(gsonString: String, type: Type): List<T>? {

        var list: List<T>? = null

        if (gson != null) {
            list = gson.fromJson(gsonString, type )
        }
        return list
    }
//
//
//    fun <T> GsonToArrayList(gsonString: String, cls: Class<T>): ArrayList<T>? {
//        var list: ArrayList<T>? = null
//        val gson = Gson()
//        if (gson != null) {
//            list = gson.fromJson(gsonString, object : TypeToken<ArrayList<T>>() {
//
//            }.type)
//        }
//        return list
//    }
}


