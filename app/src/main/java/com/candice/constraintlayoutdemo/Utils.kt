package com.candice.constraintlayoutdemo

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonParser
import java.lang.reflect.Type
import java.util.*


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
        gson.serializeNulls()
        var result = ArrayList<T>()
        if (TextUtils.isEmpty(gsonString)) return result
        return try {
            if (null != gson) {
                val array = JsonParser().parse(gsonString)
                    .asJsonArray
                for (elem in array) {
                    result.add(gson.fromJson<T>(elem, type))
                }
            }
            result
        } catch (e: Exception) {
            ArrayList()
        }

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


