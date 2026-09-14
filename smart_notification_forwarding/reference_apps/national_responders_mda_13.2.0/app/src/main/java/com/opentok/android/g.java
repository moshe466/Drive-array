package com.opentok.android;

import com.opentok.client.SDKVersion;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8586a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f8587b = System.getProperty("native_libs_custom_directory_absolute_path");

    public static synchronized void a() {
        synchronized (g.class) {
            if (f8586a) {
                return;
            }
            String str = f8587b;
            if (str != null) {
                System.load(str);
            } else {
                System.loadLibrary(SDKVersion.LIB_NAME);
            }
            f8586a = true;
        }
    }
}
