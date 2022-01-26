package org.ks.common.util.core;

import java.util.Objects;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || "".equals(str);
    }
}
