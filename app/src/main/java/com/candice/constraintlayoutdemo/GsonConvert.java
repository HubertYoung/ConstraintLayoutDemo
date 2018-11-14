package com.candice.constraintlayoutdemo;

import java.util.List;

/**
 * <br>
 * function:
 * <p>
 *
 * @author:HubertYoung
 * @date:2018/11/14 22:54
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
public class GsonConvert {
    public static List<DataBeanNew> method(String gsonString){
        List<DataBeanNew> list = GsonUtil.gsonToList(gsonString, DataBeanNew.class);
        return list;
    }
}
