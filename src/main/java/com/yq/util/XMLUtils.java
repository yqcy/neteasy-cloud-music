package com.yq.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * Created by 晴 on 2017/6/4.
 */
public class XMLUtils {

    public static String getValue(String target, String key) throws DocumentException {
        Document document = DocumentHelper.parseText(target);
        return null;
    }
}
