package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7319a;

    /* renamed from: b, reason: collision with root package name */
    private String f7320b;

    /* renamed from: c, reason: collision with root package name */
    private String f7321c;

    /* renamed from: d, reason: collision with root package name */
    private int f7322d;

    /* renamed from: e, reason: collision with root package name */
    private int f7323e = 0;

    public s(Context context) {
        this.f7319a = context;
    }

    public static String c(o3.c cVar) {
        String d10 = cVar.j().d();
        if (d10 != null) {
            return d10;
        }
        String c10 = cVar.j().c();
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

    private PackageInfo f(String str) {
        try {
            return this.f7319a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("Failed to find package ");
            sb2.append(valueOf);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f10 = f(this.f7319a.getPackageName());
        if (f10 != null) {
            this.f7320b = Integer.toString(f10.versionCode);
            this.f7321c = f10.versionName;
        }
    }

    public synchronized String a() {
        if (this.f7320b == null) {
            h();
        }
        return this.f7320b;
    }

    public synchronized String b() {
        if (this.f7321c == null) {
            h();
        }
        return this.f7321c;
    }

    public synchronized int d() {
        PackageInfo f10;
        if (this.f7322d == 0 && (f10 = f("com.google.android.gms")) != null) {
            this.f7322d = f10.versionCode;
        }
        return this.f7322d;
    }

    public synchronized int e() {
        int i10 = this.f7323e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f7319a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        int i11 = 1;
        if (!g2.l.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f7323e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f7323e = 2;
            return 2;
        }
        if (g2.l.h()) {
            this.f7323e = 2;
            i11 = 2;
        } else {
            this.f7323e = 1;
        }
        return i11;
    }

    public boolean g() {
        return e() != 0;
    }
}
