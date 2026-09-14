package com.lt.plugin.lt_plugin.utils;

import android.content.Context;

/* loaded from: classes.dex */
public final class LogHelper {
    private static boolean sDebug;

    private LogHelper() {
    }

    public static void d(String str, String str2) {
    }

    public static void i(String str, String str2) {
    }

    public static void init(Context context) {
        boolean z3;
        if ((context.getApplicationInfo().flags & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        sDebug = z3;
    }
}
