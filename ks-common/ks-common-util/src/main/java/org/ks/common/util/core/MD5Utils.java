package org.ks.common.util.core;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @ClassName:org.ks.common.util.core.MD5Utils
 * @Description:
 * @Author: yuzp
 * @Date: 2020/3/20
 */
public class MD5Utils {

    private static final String slat = "&%5123***&&%%$$#@";
    /**
     * 生成md5
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        String result = "";
        try {
            str = str + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(str.getBytes(StandardCharsets.UTF_8));
            byte s[] = m.digest();
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
