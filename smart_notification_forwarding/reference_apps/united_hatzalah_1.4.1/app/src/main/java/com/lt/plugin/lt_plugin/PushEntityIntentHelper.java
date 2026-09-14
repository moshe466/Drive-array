package com.lt.plugin.lt_plugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public final class PushEntityIntentHelper {
    public static final String EXTRA_ENTITY = "lt_push_entity";
    public static final String EXTRA_ENTITY_ID = "lt_push_entity_id";

    private PushEntityIntentHelper() {
    }

    public static void addTapLaunchActivityFlags(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.addFlags(872415232);
    }

    public static boolean consumeIntentToFlutterPrefs(Context context, Intent intent) {
        if (context != null && intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_ENTITY);
            String stringExtra2 = intent.getStringExtra(EXTRA_ENTITY_ID);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("entity");
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = intent.getStringExtra("entityID");
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = intent.getStringExtra("entityId");
            }
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                context.getApplicationContext().getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).edit().putString("flutter.webview.entity", stringExtra + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + stringExtra2).commit();
                intent.removeExtra(EXTRA_ENTITY);
                intent.removeExtra(EXTRA_ENTITY_ID);
                intent.removeExtra("entity");
                intent.removeExtra("entityID");
                intent.removeExtra("entityId");
                return true;
            }
        }
        return false;
    }

    public static void putEntityExtras(Intent intent, String str, String str2) {
        if (intent != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra(EXTRA_ENTITY, str);
            intent.putExtra(EXTRA_ENTITY_ID, str2);
            intent.putExtra("entity", str);
            intent.putExtra("entityID", str2);
        }
    }
}
