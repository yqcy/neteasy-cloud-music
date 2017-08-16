package com.yq.test.util;

import com.yq.util.HttpUtils;
import com.yq.util.XMLUtils;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestHttpUtils {

    @Test
    public void testGetRequest() throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "66842");
        String result = HttpUtils.get("http://music.163.ong", map);
        String title = XMLUtils.getValue(result, "title");
        System.out.println(title);
        System.out.println(result);
    }
}
