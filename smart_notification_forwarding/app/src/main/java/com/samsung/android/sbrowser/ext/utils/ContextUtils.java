package com.samsung.android.sbrowser.ext.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class ContextUtils {
    private static Context a = null;
    static final /* synthetic */ boolean b = true;

    /* loaded from: classes.dex */
    private static class Holder {
        private static SharedPreferences a = ContextUtils.a();
    }

    static /* synthetic */ SharedPreferences a() {
        return b();
    }

    public static Activity activityFromContext(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static SharedPreferences b() {
        StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
            if (allowDiskWrites != null) {
                allowDiskWrites.close();
            }
            return defaultSharedPreferences;
        } catch (Throwable th) {
            if (allowDiskWrites != null) {
                try {
                    allowDiskWrites.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.a;
    }

    public static AssetManager getApplicationAssets() {
        Context applicationContext = getApplicationContext();
        while (applicationContext instanceof ContextWrapper) {
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        return applicationContext.getAssets();
    }

    public static Context getApplicationContext() {
        return a;
    }

    public static void initApplicationContext(Context context) {
        Context context2;
        if (!b && (context2 = a) != null && context2 != context && ((ContextWrapper) context2).getBaseContext() != context) {
            throw new AssertionError();
        }
        a(context);
    }

    public static void initApplicationContextForTests(Context context) {
        a(context);
        SharedPreferences unused = Holder.a = b();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    private static void a(Context context) {
        if (!b && context == null) {
            throw new AssertionError();
        }
        if (context instanceof Application) {
            context = new ContextWrapper(context);
        }
        a = context;
    }
}
