package org.apache.tika.utils;

/* loaded from: classes.dex */
public class CompareUtils {
    public static int compareClassName(Object obj, Object obj2) {
        String name = obj.getClass().getName();
        String name2 = obj2.getClass().getName();
        boolean startsWith = name.startsWith("org.apache.tika.");
        if (startsWith == name2.startsWith("org.apache.tika.")) {
            return name.compareTo(name2);
        }
        if (startsWith) {
            return 1;
        }
        return -1;
    }
}
