package com.lt.plugin.lt_plugin;

import F0.RunnableC0064o;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.provider.Settings;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.tasks.Task;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.utils.LogHelper;
import com.lt.plugin.lt_plugin.utils.SessionPreferencesHelper;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public class LtPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    private Activity activity;
    private Context applicationContext;
    private MethodChannel channel;
    private PluginConfig pluginConfig;

    /* renamed from: com.lt.plugin.lt_plugin.LtPlugin$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends WebViewClient {
        final /* synthetic */ WebView val$webView;

        public AnonymousClass1(WebView webView) {
            r2 = webView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            PrintDocumentAdapter createPrintDocumentAdapter = r2.createPrintDocumentAdapter("Document");
            PrintManager printManager = (PrintManager) LtPlugin.this.applicationContext.getSystemService("print");
            if (printManager != null) {
                printManager.print("Document", createPrintDocumentAdapter, null);
            }
        }
    }

    private String getPermissionStatusNative(String str) {
        boolean z3;
        if (str == null) {
            return "denied";
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("notifications")) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            if (notificationManager == null || !notificationManager.areNotificationsEnabled()) {
                return "denied";
            }
            return "granted";
        }
        if (lowerCase.equals("camera")) {
            if (AbstractC0773d.a(this.applicationContext, "android.permission.CAMERA") != 0) {
                return "denied";
            }
            return "granted";
        }
        if (lowerCase.equals("photos")) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                if (AbstractC0773d.a(this.applicationContext, "android.permission.READ_MEDIA_IMAGES") == 0) {
                    return "granted";
                }
                if (i < 34 || AbstractC0773d.a(this.applicationContext, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") != 0) {
                    return "denied";
                }
                return "limited";
            }
            if (i >= 29) {
                if (AbstractC0773d.a(this.applicationContext, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    return "denied";
                }
                return "granted";
            }
            if (AbstractC0773d.a(this.applicationContext, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                return "denied";
            }
            return "granted";
        }
        if (lowerCase.equals("microphone")) {
            if (AbstractC0773d.a(this.applicationContext, "android.permission.RECORD_AUDIO") != 0) {
                return "denied";
            }
            return "granted";
        }
        if (lowerCase.equals("location")) {
            boolean z4 = false;
            if (AbstractC0773d.a(this.applicationContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (AbstractC0773d.a(this.applicationContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                z4 = true;
            }
            if (!z3 && !z4) {
                return "denied";
            }
            return "granted";
        }
        if (lowerCase.equals("locationalways")) {
            if (AbstractC0773d.a(this.applicationContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && AbstractC0773d.a(this.applicationContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return "denied";
            }
            if (Build.VERSION.SDK_INT < 29 || AbstractC0773d.a(this.applicationContext, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
                return "granted";
            }
            return "limited";
        }
        if (!lowerCase.equals("overlay") || !Settings.canDrawOverlays(this.applicationContext)) {
            return "denied";
        }
        return "granted";
    }

    public /* synthetic */ void lambda$onMethodCall$0(String str, String str2, MethodChannel.Result result, Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            String str3 = (String) task.getResult();
            LogHelper.i("LtPlugin", "Sending token to server (fetchTokenAndSendIfNeeded), fbUserID=" + str + ", url=" + str2);
            FCMNotificationIntentService.sendTokenToServer(this.applicationContext, str3, str, str2, "android");
        } else {
            Log.e("LtPlugin", "Failed to get token", task.getException());
        }
        result.success(null);
    }

    public static /* synthetic */ void lambda$onMethodCall$1(Location location, MethodChannel.Result result) {
        try {
            if (location != null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", location.getLatitude());
                jSONObject2.put("longitude", location.getLongitude());
                jSONObject2.put("accuracy", location.getAccuracy());
                if (location.hasAltitude()) {
                    jSONObject2.put("altitude", location.getAltitude());
                }
                if (location.hasSpeed()) {
                    jSONObject2.put("speed", location.getSpeed());
                }
                if (location.hasBearing()) {
                    jSONObject2.put("heading", location.getBearing());
                }
                jSONObject.put("coords", jSONObject2);
                result.success(jSONObject.toString());
                return;
            }
            result.success("{}");
        } catch (Exception e4) {
            result.error("LOCATION_ERROR", "Error getting current position: " + e4.getMessage(), null);
        }
    }

    public static /* synthetic */ void lambda$onMethodCall$2(Handler handler, MethodChannel.Result result, Location location) {
        handler.post(new RunnableC0064o(7, location, result));
    }

    public static /* synthetic */ void lambda$onMethodCall$3(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
            return;
        }
        if (task.getException() != null) {
            task.getException().getMessage();
        }
        result.success(null);
    }

    public static /* synthetic */ void lambda$onMethodCall$4(MethodChannel.Result result, Task task) {
        result.success(Boolean.valueOf(task.isSuccessful()));
    }

    public /* synthetic */ void lambda$onMethodCall$5(String str, String str2, MethodChannel.Result result) {
        try {
            Context context = this.activity;
            if (context == null) {
                context = this.applicationContext;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str2);
            intent.addFlags(268435456);
            context.startActivity(Intent.createChooser(intent, "פתח באמצעות"));
            result.success(null);
        } catch (Exception e4) {
            result.error("OPEN_FILE_ERROR", "Error opening file: " + e4.getMessage(), null);
        }
    }

    public /* synthetic */ void lambda$onMethodCall$6(String str, String str2, Handler handler, MethodChannel.Result result) {
        if (str == null || str.isEmpty()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty("User-Agent", "MedAssist/1.0");
                httpURLConnection.connect();
                str = httpURLConnection.getContentType();
                if (str != null && str.contains(";")) {
                    str = str.split(";")[0].trim();
                }
                httpURLConnection.disconnect();
            } catch (Exception e4) {
                e4.getMessage();
            }
        }
        if (str == null || str.isEmpty()) {
            str = "*/*";
        }
        handler.post(new com.google.firebase.crashlytics.internal.metadata.a(this, str2, str, result, 2));
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "lt_plugin");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        this.applicationContext = applicationContext;
        LogHelper.init(applicationContext);
        this.pluginConfig = PluginConfig.getInstance(this.applicationContext);
        SessionPreferencesHelper.setFlutterChannelForWebViewReload(this.channel);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        SessionPreferencesHelper.setFlutterChannelForWebViewReload(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:657:0x09fd, code lost:
    
        r0 = r0.get(0).topActivity;
     */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r30, final io.flutter.plugin.common.MethodChannel.Result r31) {
        /*
            Method dump skipped, instructions count: 3682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.LtPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }
}
