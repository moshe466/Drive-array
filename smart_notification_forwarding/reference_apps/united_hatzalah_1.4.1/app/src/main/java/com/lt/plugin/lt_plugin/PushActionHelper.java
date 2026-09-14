package com.lt.plugin.lt_plugin;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import java.util.Locale;
import java.util.Map;
import w.h;
import w.n;

/* loaded from: classes.dex */
public final class PushActionHelper {
    public static final String ACTION_NAVIGATE = "NAVIGATE";
    public static final String EXTRA_NAV_LAT = "nav_lat";
    public static final String EXTRA_NAV_LNG = "nav_lng";
    public static final String EXTRA_PUSH_NAV = "push_nav";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LNG = "lng";
    private static final String PREFS = "lt_plugin_pending_nav";
    private static final String TAG = "PushActionHelper";
    private static BroadcastReceiver unlockReceiver;

    private PushActionHelper() {
    }

    public static void addTrayNavigateAction(Context context, n nVar, Map<String, String> map, int i) {
        Uri buildGeoUri;
        if (context != null && nVar != null && hasNavigate(map) && (buildGeoUri = buildGeoUri(map.get("nav_lat"), map.get("nav_lng"))) != null) {
            Intent intent = new Intent("android.intent.action.VIEW", buildGeoUri);
            intent.addFlags(268435456);
            nVar.f6648b.add(new h(0, PluginConfig.getLocalized(context, "lt_push_navigate", "ניווט"), PendingIntent.getActivity(context, Math.max(1, i) + 42, intent, 201326592)));
        }
    }

    public static Uri buildGeoUri(String str, String str2) {
        Double parseCoord = parseCoord(str);
        Double parseCoord2 = parseCoord(str2);
        if (parseCoord != null && parseCoord2 != null) {
            Locale locale = Locale.US;
            return Uri.parse("geo:" + trimCoord(parseCoord.doubleValue()) + "," + trimCoord(parseCoord2.doubleValue()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearPending(Context context) {
        if (context == null) {
            return;
        }
        context.getApplicationContext().getSharedPreferences(PREFS, 0).edit().remove(KEY_LAT).remove(KEY_LNG).apply();
    }

    public static synchronized void deferNavigateUntilUnlock(Context context, String str, String str2) {
        synchronized (PushActionHelper.class) {
            if (context != null) {
                if (hasNavigate("true", str, str2)) {
                    Context applicationContext = context.getApplicationContext();
                    applicationContext.getSharedPreferences(PREFS, 0).edit().putString(KEY_LAT, str).putString(KEY_LNG, str2).apply();
                    ensureUnlockReceiver(applicationContext);
                }
            }
        }
    }

    private static synchronized void ensureUnlockReceiver(final Context context) {
        synchronized (PushActionHelper.class) {
            try {
                if (unlockReceiver != null) {
                    return;
                }
                unlockReceiver = new BroadcastReceiver() { // from class: com.lt.plugin.lt_plugin.PushActionHelper.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(PushActionHelper.PREFS, 0);
                        String string = sharedPreferences.getString(PushActionHelper.KEY_LAT, null);
                        String string2 = sharedPreferences.getString(PushActionHelper.KEY_LNG, null);
                        PushActionHelper.clearPending(context);
                        PushActionHelper.unregisterUnlockReceiver(context);
                        if (PushActionHelper.hasNavigate("true", string, string2)) {
                            PushActionHelper.launchNavigateNow(context, string, string2);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        context.registerReceiver(unlockReceiver, intentFilter, 4);
                    } else {
                        context.registerReceiver(unlockReceiver, intentFilter);
                    }
                } catch (Exception e4) {
                    Log.e(TAG, "register USER_PRESENT failed", e4);
                    unlockReceiver = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean hasNavigate(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return hasNavigate(map.get(EXTRA_PUSH_NAV), map.get("nav_lat"), map.get("nav_lng"));
    }

    public static boolean launchNavigate(Context context, String str, String str2) {
        if (context == null || !hasNavigate("true", str, str2)) {
            return false;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            try {
                Intent intent = new Intent(context, (Class<?>) PendingNavigateActivity.class);
                intent.putExtra("nav_lat", str);
                intent.putExtra("nav_lng", str2);
                intent.addFlags(1409286144);
                context.startActivity(intent);
                deferNavigateUntilUnlock(context.getApplicationContext(), str, str2);
                return true;
            } catch (Exception e4) {
                Log.e(TAG, "PendingNavigateActivity failed — defer only", e4);
                deferNavigateUntilUnlock(context.getApplicationContext(), str, str2);
                return true;
            }
        }
        return launchNavigateNow(context, str, str2);
    }

    public static boolean launchNavigateNow(Context context, String str, String str2) {
        Uri buildGeoUri;
        if (context == null || (buildGeoUri = buildGeoUri(str, str2)) == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", buildGeoUri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            clearPending(context);
            return true;
        } catch (Exception e4) {
            Log.e(TAG, "launchNavigateNow failed", e4);
            return false;
        }
    }

    private static Double parseCoord(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            double parseDouble = Double.parseDouble(str.trim());
            if (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble)) {
                return Double.valueOf(parseDouble);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static void putNavExtras(Intent intent, Map<String, String> map) {
        if (intent == null || map == null || !hasNavigate(map)) {
            return;
        }
        intent.putExtra(EXTRA_PUSH_NAV, "true");
        intent.putExtra("nav_lat", map.get("nav_lat"));
        intent.putExtra("nav_lng", map.get("nav_lng"));
    }

    private static String trimCoord(double d2) {
        return String.format(Locale.US, "%.6f", Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void unregisterUnlockReceiver(Context context) {
        synchronized (PushActionHelper.class) {
            BroadcastReceiver broadcastReceiver = unlockReceiver;
            if (broadcastReceiver == null) {
                return;
            }
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
            unlockReceiver = null;
        }
    }

    public static boolean hasNavigate(Intent intent) {
        if (intent == null) {
            return false;
        }
        return hasNavigate(intent.getStringExtra(EXTRA_PUSH_NAV), intent.getStringExtra("nav_lat"), intent.getStringExtra("nav_lng"));
    }

    public static void putNavExtras(Intent intent, String str, String str2, String str3) {
        if (intent == null || !hasNavigate(str, str2, str3)) {
            return;
        }
        intent.putExtra(EXTRA_PUSH_NAV, "true");
        intent.putExtra("nav_lat", str2);
        intent.putExtra("nav_lng", str3);
    }

    public static boolean hasNavigate(String str, String str2, String str3) {
        return (!"true".equalsIgnoreCase(str == null ? "" : str.trim()) || parseCoord(str2) == null || parseCoord(str3) == null) ? false : true;
    }

    public static boolean launchNavigate(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        return launchNavigate(context, intent.getStringExtra("nav_lat"), intent.getStringExtra("nav_lng"));
    }
}
