package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.flutter.plugins.firebase.crashlytics.Constants;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.tika.metadata.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PushRedactionReporter {
    private static final String DEFAULT_SITE = "https://uh-salesforce.herokuapp.com";
    private static final ExecutorService EXEC = Executors.newSingleThreadExecutor();
    private static final String PREFS = "lt_push_redaction_report";
    private static final String TAG = "PushRedactionReporter";
    private static final long THROTTLE_MS = 86400000;

    private PushRedactionReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportAsync$0(Context context, String str, String str2, String str3) {
        try {
            report(context, str, str2, str3);
        } catch (Exception e4) {
            e4.getMessage();
        }
    }

    private static void report(Context context, String str, String str2, String str3) {
        String pairKey = InstallSourceHelper.pairKey(str, str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS, 0);
        long j2 = sharedPreferences.getLong(pairKey, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 > 0 && currentTimeMillis - j2 < THROTTLE_MS) {
            return;
        }
        String string = context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0).getString("flutter.system.site_url", null);
        if (string == null || string.trim().isEmpty()) {
            string = DEFAULT_SITE;
        }
        while (string.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            string = string.substring(0, string.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listenerPackage", str);
        if (str2 != null && !str2.isEmpty()) {
            jSONObject.put("installerPackage", str2);
        } else {
            jSONObject.put("installerPackage", JSONObject.NULL);
        }
        if (str3 == null) {
            str3 = "unknown";
        }
        jSONObject.put(Constants.REASON, str3);
        jSONObject.put("appLabel", InstallSourceHelper.resolveAppLabel(context, str));
        jSONObject.put("appPlatform", "android");
        try {
            String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str4);
        } catch (Exception unused) {
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, "");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string.concat("/security/push-redaction-signal")).openConnection();
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
            httpURLConnection.setDoOutput(true);
            byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bytes);
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    sharedPreferences.edit().putLong(pairKey, currentTimeMillis).apply();
                }
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static void reportAsync(Context context, String str, String str2, String str3) {
        if (context != null && str != null && !str.isEmpty()) {
            EXEC.execute(new com.google.firebase.crashlytics.internal.metadata.a(context.getApplicationContext(), str, str2, str3, 3));
        }
    }
}
