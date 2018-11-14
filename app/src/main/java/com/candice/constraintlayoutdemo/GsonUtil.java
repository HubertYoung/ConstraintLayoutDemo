package com.candice.constraintlayoutdemo;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 作者：JIUU on 2016/12/13 15:37
 * QQ号：1344393464
 * 作用：Gson帮助类
 */
public class GsonUtil {
    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
            gson.serializeNulls();
        }
    }

    private GsonUtil() {
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }
    /**
     * 转成arrayList
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> ArrayList<T> GsonToArrayList(String gsonString, Class<T> cls) {
        ArrayList<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<ArrayList<T>>() {
            }.getType());
        }
        return list;
    }
    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
    /**
     * Json 转成 Map<>
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> getMapForJson(String jsonStr){
        JSONObject jsonObject ;
        try {
            jsonObject = new JSONObject(jsonStr);

            Iterator<String> keyIter= jsonObject.keys();
            String key;
            Object value ;
            Map<String, Object> valueMap = new HashMap<String, Object>();
            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = jsonObject.get(key);
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {
        }
        return null;
    }
    /**
     * @author:Yang
     * @date:2017-8-2 14:12:48
     * @since:v1.0
     * @param: 用来将JSON串转为对象，但此方法不可用来转带泛型的集合
     */
//    public static < T > List< T > gsonToList( String json, Class< T > cls ) {
//        if ( TextUtils.isEmpty( json ) ) return null;
//        try {
//            List< T > list = new ArrayList< T >();
//            if ( json.startsWith( "[" ) && json.endsWith( "]" ) ) {//当字符串以“[”开始，以“]”结束时，表示该字符串解析出来为集合
//                //截取字符串，去除中括号
//                json = json.substring( 1, json.length() - 1 );
//                //将字符串以"},"分解成数组
////                json = json.replace( " ", "" );
//                if ( TextUtils.isEmpty( json ) )return null;
//                String[] strArr = json.split( "\\}," );
//                //分解后的字符串数组的长度
//                int strArrLength = strArr.length;
//                //遍历数组，进行解析，将字符串解析成对象
//                for (int i = 0; i < strArrLength; i++) {
//                    String newJsonString = null;
//                    if ( i == strArrLength - 1 ) {
//                        newJsonString = strArr[ i ];
//                    } else {
//                        newJsonString = strArr[ i ] + "}";
//                    }
//                    T bean = GsonToBean( newJsonString, cls );
//                    list.add( bean );
//                }
//            }
//            if ( list == null || list.size() == 0 ) {
//                return null;
//            }
//            return list;
//        } catch ( Exception e ) {
//            LogUtil.e( e.getMessage().toString() );
//            return null;
//        }
//    }

    /**
     * @author:Yang
     * @date:2017-8-2 14:12:48
     * @since:v1.0
     * @desc:ddframework.gent.common.commonutils
     * @param: 用来将JSON串转为对象，但此方法不可用来转带泛型的集合
     */
    public static < T > List< T > gsonToList( String json, Class< T > cls ) {
        List< T > result = new ArrayList<>();
        if ( TextUtils.isEmpty( json ) ) return result;
        try {
            if ( null != gson ) {
                JsonArray array = new JsonParser().parse( json )
                        .getAsJsonArray();
                for (final JsonElement elem : array) {
                    result.add( gson.fromJson( elem, cls ) );
                }
            }
            return result;
        } catch ( Exception e ) {
            return new ArrayList< T >();
        }
    }
}
