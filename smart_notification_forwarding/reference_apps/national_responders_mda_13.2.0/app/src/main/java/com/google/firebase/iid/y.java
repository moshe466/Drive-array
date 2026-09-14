package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    final SharedPreferences f7335a;

    /* renamed from: b, reason: collision with root package name */
    final Context f7336b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Long> f7337c = new l.a();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: d, reason: collision with root package name */
        private static final long f7338d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a, reason: collision with root package name */
        final String f7339a;

        /* renamed from: b, reason: collision with root package name */
        final String f7340b;

        /* renamed from: c, reason: collision with root package name */
        final long f7341c;

        private a(String str, String str2, long j10) {
            this.f7339a = str;
            this.f7340b = str2;
            this.f7341c = j10;
        }

        static String a(String str, String str2, long j10) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j10);
                return jSONObject.toString();
            } catch (JSONException e10) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
                sb2.append("Failed to encode token: ");
                sb2.append(valueOf);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String b(a aVar) {
            if (aVar == null) {
                return null;
            }
            return aVar.f7339a;
        }

        static a d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e10) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                sb2.append("Failed to parse token: ");
                sb2.append(valueOf);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(String str) {
            return System.currentTimeMillis() > this.f7341c + f7338d || !str.equals(this.f7340b);
        }
    }

    public y(Context context) {
        this.f7336b = context;
        this.f7335a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    private void a(String str) {
        File file = new File(androidx.core.content.a.g(this.f7336b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || g()) {
                return;
            }
            d();
        } catch (IOException e10) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e10.getMessage());
                if (valueOf.length() != 0) {
                    "Error creating file in no backup dir: ".concat(valueOf);
                }
            }
        }
    }

    static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 6);
        sb2.append(str);
        sb2.append("|S|");
        sb2.append("cre");
        return sb2.toString();
    }

    private String c(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append("|T|");
        sb2.append(str2);
        sb2.append("|");
        sb2.append(str3);
        return sb2.toString();
    }

    private long e(String str) {
        String string = this.f7335a.getString(b(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private long j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f7335a.contains(b(str, "cre"))) {
            return e(str);
        }
        SharedPreferences.Editor edit = this.f7335a.edit();
        edit.putString(b(str, "cre"), String.valueOf(currentTimeMillis));
        edit.commit();
        return currentTimeMillis;
    }

    public synchronized void d() {
        this.f7337c.clear();
        this.f7335a.edit().clear().commit();
    }

    public synchronized a f(String str, String str2, String str3) {
        return a.d(this.f7335a.getString(c(str, str2, str3), null));
    }

    public synchronized boolean g() {
        return this.f7335a.getAll().isEmpty();
    }

    public synchronized void h(String str, String str2, String str3, String str4, String str5) {
        String a10 = a.a(str4, str5, System.currentTimeMillis());
        if (a10 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f7335a.edit();
        edit.putString(c(str, str2, str3), a10);
        edit.commit();
    }

    public synchronized long i(String str) {
        long j10;
        j10 = j(str);
        this.f7337c.put(str, Long.valueOf(j10));
        return j10;
    }
}
