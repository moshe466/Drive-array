package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.q;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final l4.a f7475a = new n4.d().a(q.b.class, new q.c()).a(q.class, new q.a()).f();

    public static boolean A(Intent intent) {
        if (intent == null || s(intent)) {
            return false;
        }
        return a();
    }

    public static boolean B(Intent intent) {
        if (intent == null || s(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    static boolean a() {
        Context g10;
        SharedPreferences sharedPreferences;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            o3.c.h();
            g10 = o3.c.h().g();
            sharedPreferences = g10.getSharedPreferences("com.google.firebase.messaging", 0);
        } catch (PackageManager.NameNotFoundException | IllegalStateException unused) {
        }
        if (sharedPreferences.contains("export_to_big_query")) {
            return sharedPreferences.getBoolean("export_to_big_query", false);
        }
        PackageManager packageManager = g10.getPackageManager();
        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(g10.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
            return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    static String c(Intent intent) {
        return intent.getStringExtra("google.c.a.c_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        return FirebaseInstanceId.getInstance(o3.c.h()).g();
    }

    static String f(Intent intent) {
        return intent.getStringExtra("google.c.a.m_c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    private static int i(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    static String j(Intent intent) {
        return intent.getStringExtra("google.c.a.ts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(Intent intent) {
        return (intent.getExtras() == null || !v.t(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION";
    }

    static String l(Intent intent) {
        return (intent.getExtras() == null || !v.t(intent.getExtras())) ? "data" : "display";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return o3.c.h().g().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        return i(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o() {
        o3.c h10 = o3.c.h();
        String d10 = h10.j().d();
        if (d10 != null) {
            return d10;
        }
        String c10 = h10.j().c();
        if (!c10.startsWith("1:")) {
            return c10;
        }
        String[] split = c10.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
            sb2.append("Invalid TTL: ");
            sb2.append(valueOf);
            return 0;
        }
    }

    static String r(Intent intent) {
        if (intent.hasExtra("google.c.a.udt")) {
            return intent.getStringExtra("google.c.a.udt");
        }
        return null;
    }

    private static boolean s(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void t(Intent intent) {
        y("_nd", intent);
    }

    public static void u(Intent intent) {
        y("_nf", intent);
    }

    public static void v(Intent intent) {
        z(intent);
        y("_no", intent);
    }

    public static void w(Intent intent) {
        i1.g f10;
        if (B(intent)) {
            y("_nr", intent);
        }
        if (!A(intent) || (f10 = FirebaseMessaging.f()) == null) {
            return;
        }
        x("MESSAGE_DELIVERED", intent, f10.a("FCM_CLIENT_EVENT_LOGGING", String.class, i1.b.b("json"), t.f7474a));
    }

    private static void x(String str, Intent intent, i1.f<String> fVar) {
        try {
            fVar.a(i1.c.d(f7475a.a(new q.b(new q("MESSAGE_DELIVERED", intent)))));
        } catch (l4.b unused) {
        }
    }

    static void y(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String c10 = c(intent);
        if (c10 != null) {
            bundle.putString("_nmid", c10);
        }
        String d10 = d(intent);
        if (d10 != null) {
            bundle.putString("_nmn", d10);
        }
        String h10 = h(intent);
        if (!TextUtils.isEmpty(h10)) {
            bundle.putString("label", h10);
        }
        String f10 = f(intent);
        if (!TextUtils.isEmpty(f10)) {
            bundle.putString("message_channel", f10);
        }
        String p10 = p(intent);
        if (p10 != null) {
            bundle.putString("_nt", p10);
        }
        String j10 = j(intent);
        if (j10 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(j10));
            } catch (NumberFormatException unused) {
            }
        }
        String r10 = r(intent);
        if (r10 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(r10));
            } catch (NumberFormatException unused2) {
            }
        }
        String l10 = l(intent);
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", l10);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb2 = new StringBuilder(str.length() + 37 + valueOf.length());
            sb2.append("Logging to scion event=");
            sb2.append(str);
            sb2.append(" scionPayload=");
            sb2.append(valueOf);
        }
        p3.a aVar = (p3.a) o3.c.h().f(p3.a.class);
        if (aVar != null) {
            aVar.c("fcm", str, bundle);
        }
    }

    private static void z(Intent intent) {
        p3.a aVar;
        if (intent == null || !"1".equals(intent.getStringExtra("google.c.a.tc")) || (aVar = (p3.a) o3.c.h().f(p3.a.class)) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        aVar.b("fcm", "_ln", stringExtra);
        Bundle bundle = new Bundle();
        bundle.putString("source", "Firebase");
        bundle.putString("medium", "notification");
        bundle.putString("campaign", stringExtra);
        aVar.c("fcm", "_cmp", bundle);
    }
}
