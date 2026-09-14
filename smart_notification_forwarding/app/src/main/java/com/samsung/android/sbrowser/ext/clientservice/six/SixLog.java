package com.samsung.android.sbrowser.ext.clientservice.six;

import android.util.Log;

/* loaded from: classes.dex */
public class SixLog {
    static final boolean DEBUG = false;
    static final String PREFIX = "SIX: ";

    public static void dcheck(boolean z, String str) {
    }

    public static void dlog(String str, String str2) {
    }

    public static boolean isDebug() {
        return false;
    }

    public static void log(String str, String str2) {
        Log.i(PREFIX + str, str2);
    }

    public static void error(String str, String str2) {
        Log.e(PREFIX + str, str2);
    }

    public static void check(boolean z, String str) {
        if (z) {
            return;
        }
        log("SixLog", str);
        throw new RuntimeException(str);
    }
}
