package com.lt.plugin.lt_plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;

/* loaded from: classes.dex */
public final class AppLinkIntentHelper {
    private static final String PREFS_KEY_APP_LINK = "flutter.webview.appLinkData";

    private AppLinkIntentHelper() {
    }

    public static boolean consumeIntentToFlutterPrefs(Context context, Intent intent, String... strArr) {
        Uri data;
        if (context == null || intent == null || strArr == null || strArr.length == 0 || (data = intent.getData()) == null || !"https".equalsIgnoreCase(data.getScheme())) {
            return false;
        }
        String host = data.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        for (String str : strArr) {
            if (str != null && host.equalsIgnoreCase(str)) {
                String queryParameter = data.getQueryParameter("entity");
                String queryParameter2 = data.getQueryParameter("entityID");
                if (TextUtils.isEmpty(queryParameter2)) {
                    queryParameter2 = data.getQueryParameter("entityId");
                }
                if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
                    return false;
                }
                context.getApplicationContext().getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString(PREFS_KEY_APP_LINK, data.toString()).commit();
                intent.setData(null);
                return true;
            }
        }
        return false;
    }
}
