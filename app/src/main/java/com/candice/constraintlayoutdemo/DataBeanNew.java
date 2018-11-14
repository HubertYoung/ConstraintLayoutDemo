package com.candice.constraintlayoutdemo;

import java.util.List;

/**
 * <br>
 * function:
 * <p>
 *
 * @author:HubertYoung
 * @date:2018/11/14 22:36
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
public class DataBeanNew {

    /**
     * title : 安全工具设置
     * menus : [{"menusTitle":"mb000001","menusAction":"http1"},{"menusTitle":"mb000002","menusAction":"http2"},{"menusTitle":"mb000003","menusAction":"http3"}]
     */

    public String title;
    public List<MenusBean> menus;

    public static class MenusBean {
        public MenusBean(String menusTitle, String menusAction, String parentTitle) {
            this.menusTitle = menusTitle;
            this.menusAction = menusAction;
            this.parentTitle = parentTitle;
        }

        /**
         * menusTitle : mb000001
         * menusAction : http1
         */

        public String menusTitle;
        public String menusAction;
        public String parentTitle;
    }
}
