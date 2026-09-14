package com.groboot.mdaemergency;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import w6.m;
import w6.z;

/* loaded from: classes.dex */
public class PirateHttpsRequest implements Runnable {

    /* renamed from: aa, reason: collision with root package name */
    static ArrayList<String> f7537aa = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    Boolean f7538a;
    String key;
    String key2;
    String serverUrl = "https://api.motoconnect.co.il/push";
    String value;
    String value2;

    public PirateHttpsRequest(String str, String str2, String str3, String str4, Boolean bool) {
        this.key = str;
        this.value = str2;
        this.key2 = str3;
        this.value2 = str4;
        this.f7538a = bool;
        Log.d("PirateHttpsRequest", "key: " + this.key + " value:" + this.value);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f7538a.booleanValue() && this.key != null && !this.key.isEmpty() && this.value != null && !this.value.isEmpty()) {
                Log.d("PirateHttpsRequest", "inside run key: " + this.key + " value:" + this.value);
                trustAllHosts();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.serverUrl).openConnection();
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, "UTF-8"));
                HashMap hashMap = new HashMap();
                hashMap.put(this.key, this.value);
                hashMap.put(this.key2, this.value2);
                hashMap.put("p", m.k().getPhone());
                hashMap.put("id", m.k().getID());
                if (z.b().c() != null) {
                    hashMap.put("token", z.b().c());
                }
                hashMap.put("v", "13.2.0");
                hashMap.put("v2", "1.1.6");
                bufferedWriter.write(getPostDataString(hashMap));
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedOutputStream.close();
                Log.d("PirateHttpsRequest", "Code: " + httpsURLConnection.getResponseCode());
            }
        } catch (Exception e10) {
            Log.e("PirateHttpsRequest", e10.getMessage());
        }
    }

    private String getPostDataString(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        Integer num;
        StringBuilder sb2 = new StringBuilder();
        Integer num2 = 1;
        for (Map.Entry next : hashMap.entrySet()) {
            if (num2 != null) {
                num = null;
            } else {
                sb2.append("&");
                num = num2;
            }
            sb2.append(URLEncoder.encode(next.getKey(), "UTF-8"));
            sb2.append("=");
            sb2.append(URLEncoder.encode(next.getValue(), "UTF-8"));
            num2 = num;
        }
        return sb2.toString();
    }

    private void trustAllHosts() {
        try {
            TrustManager[] trustManagerArr = {new PirateX509ExtendedTrustManager()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new PirateHostnameVerifier());
        } catch (Exception e10) {
        }
    }
}
