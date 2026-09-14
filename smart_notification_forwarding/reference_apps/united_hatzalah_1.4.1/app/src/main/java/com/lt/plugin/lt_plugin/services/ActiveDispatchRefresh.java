package com.lt.plugin.lt_plugin.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tika.metadata.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ActiveDispatchRefresh {
    private static final String KEY_HEADER = "flutter.webview.flutterShellHeader";
    private static final String KEY_PAYLOAD = "flutter.webview.activeDispatch";
    private static final String KEY_PROFILE = "flutter.webview.profile";
    private static final String KEY_SECRET = "flutter.webview.flutterShellSecret";
    private static final String KEY_SF_ID = "flutter.webview.activeDispatchSfId";
    private static final String KEY_WEB_URL = "flutter.webview.activeDispatchWebUrl";
    private static final String PREFS = "FlutterSharedPreferences";
    private static final String TAG = "ActiveDispatchRefresh";
    private static final int TIMEOUT_MS = 12000;
    private static final AtomicBoolean inFlight = new AtomicBoolean(false);

    private ActiveDispatchRefresh() {
    }

    private static void apply(Context context, String str) {
        if (str == null) {
            ActiveDispatchAppWidget.refresh(context, null);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSharedPreferences", 0);
        if (ActiveDispatchOverlayService.parseItems(str).isEmpty()) {
            sharedPreferences.edit().remove(KEY_PAYLOAD).apply();
            ActiveDispatchAppWidget.refresh(context, "");
            ActiveDispatchOverlayService.hide(context);
        } else {
            sharedPreferences.edit().putString(KEY_PAYLOAD, str).apply();
            ActiveDispatchAppWidget.refresh(context, str);
            ActiveDispatchOverlayService.show(context, str, true);
        }
    }

    private static String fetch(Context context) {
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSharedPreferences", 0);
        HttpURLConnection httpURLConnection2 = null;
        String string = sharedPreferences.getString(KEY_WEB_URL, null);
        String string2 = sharedPreferences.getString(KEY_SF_ID, null);
        if (TextUtils.isEmpty(string2)) {
            string2 = sfIdFromProfile(sharedPreferences.getString(KEY_PROFILE, null));
        }
        String string3 = sharedPreferences.getString(KEY_SECRET, null);
        String string4 = sharedPreferences.getString(KEY_HEADER, "X-UH-Flutter-Shell");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(trimSlash(string) + "/auth/activeDispatch").openConnection();
                try {
                    httpURLConnection.setConnectTimeout(TIMEOUT_MS);
                    httpURLConnection.setReadTimeout(TIMEOUT_MS);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                    httpURLConnection.setRequestProperty(string4, proof(string3));
                    byte[] bytes = new JSONObject().put("sfId", string2).toString().getBytes(StandardCharsets.UTF_8);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(bytes);
                        outputStream.close();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode >= 200 && responseCode < 300) {
                            errorStream = httpURLConnection.getInputStream();
                        } else {
                            errorStream = httpURLConnection.getErrorStream();
                        }
                        String readAll = readAll(errorStream);
                        if (responseCode != 200) {
                            httpURLConnection.disconnect();
                            return null;
                        }
                        httpURLConnection.disconnect();
                        return readAll;
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                httpURLConnection = null;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return null;
    }

    public static boolean isRefreshing() {
        return inFlight.get();
    }

    public static /* synthetic */ void lambda$start$0(Context context, String str) {
        inFlight.set(false);
        apply(context, str);
    }

    public static /* synthetic */ void lambda$start$1(Context context) {
        new Handler(Looper.getMainLooper()).post(new h(context, fetch(context)));
    }

    private static String proof(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = StandardCharsets.UTF_8;
        mac.init(new SecretKeySpec(str.getBytes(charset), "HmacSHA256"));
        byte[] doFinal = mac.doFinal(Long.toString(currentTimeMillis).getBytes(charset));
        StringBuilder sb = new StringBuilder(doFinal.length * 2);
        for (byte b4 : doFinal) {
            sb.append(String.format("%02x", Byte.valueOf(b4)));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", currentTimeMillis);
        jSONObject.put("h", sb.toString());
        return Base64.encodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 2);
    }

    private static String readAll(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toString("UTF-8");
            }
        }
    }

    public static void remember(Context context, String str, String str2, String str3, String str4) {
        SharedPreferences.Editor edit = context.getSharedPreferences("FlutterSharedPreferences", 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(KEY_WEB_URL, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(KEY_SF_ID, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            edit.putString(KEY_SECRET, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            edit.putString(KEY_HEADER, str4);
        }
        edit.apply();
    }

    private static String sfIdFromProfile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String trim = jSONObject.optString("Id", jSONObject.optString("id", "")).trim();
            if (TextUtils.isEmpty(trim)) {
                return null;
            }
            return trim;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void start(Context context) {
        if (!inFlight.compareAndSet(false, true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        ActiveDispatchAppWidget.refresh(applicationContext, null);
        new Thread(new c(applicationContext, 0), "ad-refresh").start();
    }

    private static String trimSlash(String str) {
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) == '/') {
            length--;
        }
        return str.substring(0, length);
    }
}
