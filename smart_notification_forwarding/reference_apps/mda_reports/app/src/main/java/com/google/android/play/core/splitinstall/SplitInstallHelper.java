package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SplitInstallHelper {
    private static final com.google.android.play.core.splitcompat.a a = new com.google.android.play.core.splitcompat.a("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            boolean z = false;
            try {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                String mapLibraryName = System.mapLibraryName(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(mapLibraryName).length());
                sb.append(str2);
                sb.append("/");
                sb.append(mapLibraryName);
                String sb2 = sb.toString();
                if (new File(sb2).exists()) {
                    System.load(sb2);
                    z = true;
                }
                if (!z) {
                    throw e;
                }
            } catch (UnsatisfiedLinkError e2) {
                throw e2;
            }
        }
    }

    public static void updateAppInfo(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i <= 25 || i >= 28) {
            return;
        }
        a.a("Calling dispatchPackageBroadcast", new Object[0]);
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mAppThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            obj.getClass().getMethod("dispatchPackageBroadcast", Integer.TYPE, String[].class).invoke(obj, 3, new String[]{context.getPackageName()});
            a.a("Called dispatchPackageBroadcast", new Object[0]);
        } catch (Exception e) {
            a.a(e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
        }
    }
}
