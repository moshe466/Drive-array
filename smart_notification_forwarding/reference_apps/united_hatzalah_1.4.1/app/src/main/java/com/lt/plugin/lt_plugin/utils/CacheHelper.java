package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import java.io.File;

/* loaded from: classes.dex */
public class CacheHelper {
    private static void clearAppCache(Context context) {
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception unused) {
        }
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.exists()) {
                deleteRecursive(cacheDir);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void clearCache(Context context) {
        if (!PluginConfig.getInstance(context).isCacheManagementEnabled()) {
            return;
        }
        clearWebViewCache(context);
        clearAppCache(context);
    }

    public static void clearWebViewCache(Context context) {
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.lt.plugin.lt_plugin.utils.CacheHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    CookieManager.getInstance().removeAllCookies(null);
                    CookieManager.getInstance().flush();
                    WebStorage.getInstance().deleteAllData();
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }
}
