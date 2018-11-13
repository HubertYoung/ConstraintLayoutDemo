package com.candice.constraintlayoutdemo;

import java.util.List;

/**
 * <br>
 * function:
 * <p>
 *
 * @author:Lyt
 * @date:2018/11/13 下午5:38
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
public class Bean {

    /**
     * title : 安全工具设置
     * menus : ["mb0001","mb000002","mb00003"]
     */

    private String title;
    private List<String> menus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }


}
