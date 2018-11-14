package com.candice.constraintlayoutdemo;

import android.support.test.runner.AndroidJUnit4;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * function:
 * <p>
 *
 * @author:HubertYoung
 * @date:2018/11/14 22:40
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTestTest {
    @Test
    public void useAppContext() {
        String gsonString = "[\n" +
                "  {\n" +
                "    \"title\": \"安全工具设置\",\n" +
                "    \"menus\": [\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000001\",\n" +
                "        \"menusAction\":\"http1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000002\",\n" +
                "        \"menusAction\":\"http2\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000003\",\n" +
                "        \"menusAction\":\"http3\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"账号密码安全\",\n" +
                "    \"menus\": [\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000004\",\n" +
                "        \"menusAction\":\"http4\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000005\",\n" +
                "        \"menusAction\":\"http5\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb000006\",\n" +
                "        \"menusAction\":\"http6\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb0000006\",\n" +
                "        \"menusAction\":\"http06\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"\",\n" +
                "    \"menus\": [\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb0000007\",\n" +
                "        \"menusAction\":\"http7\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb0000008\",\n" +
                "        \"menusAction\":\"http8\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"menusTitle\":\"mb0000009\",\n" +
                "        \"menusAction\":\"http9\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        List<DataBeanNew> lists = new Utils().<DataBeanNew>gsonToList(gsonString, new TypeToken<List<DataBeanNew>>() {
        }.getType());
        assertEquals(lists == null ? 0 : lists.size() ,3);
    }
}