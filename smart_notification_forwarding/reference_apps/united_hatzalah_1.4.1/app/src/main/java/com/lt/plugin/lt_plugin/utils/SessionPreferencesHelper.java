package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;

/* loaded from: classes.dex */
public final class SessionPreferencesHelper {
    private static final long RELOAD_RETRY_BACKOFF_MS = 400;
    private static final int RELOAD_RETRY_MAX = 20;
    private static MethodChannel sFlutterChannel;

    /* renamed from: com.lt.plugin.lt_plugin.utils.SessionPreferencesHelper$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements MethodChannel.Result {
        final /* synthetic */ int val$attempt;
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ String val$method;

        public AnonymousClass1(int i, Handler handler, String str) {
            this.val$attempt = i;
            this.val$handler = handler;
            this.val$method = str;
        }

        public static /* synthetic */ void lambda$notImplemented$0(String str, int i) {
            SessionPreferencesHelper.invokeOnFlutterWithRetry(str, i + 1);
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(String str, String str2, Object obj) {
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            int i = this.val$attempt;
            if (i < 20) {
                this.val$handler.postDelayed(new e(this.val$method, i, 0), SessionPreferencesHelper.RELOAD_RETRY_BACKOFF_MS);
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(Object obj) {
        }
    }

    private SessionPreferencesHelper() {
    }

    public static void clearAllSessionData(Context context) {
        boolean z3;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
        String string = sharedPreferences.getString("flutter.webview.fbUserID", null);
        if (string != null && !string.isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        PluginServicesHelper.stopAllSessionRelatedServices(applicationContext);
        sharedPreferences.edit().clear().apply();
        applicationContext.getSharedPreferences("async", 0).edit().clear().apply();
        CacheHelper.clearWebViewCache(applicationContext);
        if (z3) {
            notifyReloadWebView();
        }
    }

    private static void invokeOnFlutter(String str) {
        invokeOnFlutterWithRetry(str, 0);
    }

    public static void invokeOnFlutterWithRetry(String str, int i) {
        MethodChannel methodChannel = sFlutterChannel;
        Handler handler = new Handler(Looper.getMainLooper());
        if (methodChannel == null) {
            if (i < 20) {
                handler.postDelayed(new e(str, i, 1), RELOAD_RETRY_BACKOFF_MS);
                return;
            }
            return;
        }
        handler.post(new d(methodChannel, str, i, handler, 0));
    }

    public static /* synthetic */ void lambda$invokeOnFlutterWithRetry$0(String str, int i) {
        invokeOnFlutterWithRetry(str, i + 1);
    }

    public static /* synthetic */ void lambda$invokeOnFlutterWithRetry$1(MethodChannel methodChannel, String str, int i, Handler handler) {
        try {
            methodChannel.invokeMethod(str, null, new AnonymousClass1(i, handler, str));
        } catch (Exception unused) {
        }
    }

    public static void notifyReloadSharedPreferences() {
        invokeOnFlutter("reloadSharedPreferences");
    }

    private static void notifyReloadWebView() {
        invokeOnFlutter("reloadWebView");
    }

    public static void notifyReloadWebViewForPendingAppLink() {
        invokeOnFlutter("reloadWebViewForPendingAppLink");
    }

    public static void notifyReloadWebViewForPendingEntity() {
        invokeOnFlutter("reloadWebViewForPendingEntity");
    }

    public static void setFlutterChannelForWebViewReload(MethodChannel methodChannel) {
        sFlutterChannel = methodChannel;
    }
}
