package org.ks.common.util.core;

import java.util.UUID;

/**
 * UUIDUtils工具类
 */
public class UUIDUtils {

    public static String buildUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Boolean checkUUID(String val1, String val2) {
        return !StringUtils.isEmpty(val1) && !StringUtils.isEmpty(val2) && val1.equals(val2);
    }
}
