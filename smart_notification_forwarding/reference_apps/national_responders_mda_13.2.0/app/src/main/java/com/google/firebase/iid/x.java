package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public class x {

    /* renamed from: e, reason: collision with root package name */
    private static x f7330e;

    /* renamed from: a, reason: collision with root package name */
    private String f7331a = null;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f7332b = null;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f7333c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Queue<Intent> f7334d = new ArrayDeque();

    private x() {
    }

    private int a(Context context, Intent intent) {
        String f10 = f(context, intent);
        if (f10 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3) && f10.length() != 0) {
                "Restricting intent to a specific service: ".concat(f10);
            }
            intent.setClassName(context.getPackageName(), f10);
        }
        try {
            return (e(context) ? a0.e(context, intent) : context.startService(intent)) == null ? 404 : -1;
        } catch (IllegalStateException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 45);
            sb2.append("Failed to start service while in background: ");
            sb2.append(valueOf);
            return 402;
        } catch (SecurityException unused) {
            return 401;
        }
    }

    public static synchronized x b() {
        x xVar;
        synchronized (x.class) {
            if (f7330e == null) {
                f7330e = new x();
            }
            xVar = f7330e;
        }
        return xVar;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2;
        String str3 = this.f7331a;
        if (str3 != null) {
            return str3;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                } else {
                    str2 = serviceInfo.name;
                }
                this.f7331a = str2;
                return this.f7331a;
            }
            String str4 = serviceInfo.packageName;
            String str5 = serviceInfo.name;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 94 + String.valueOf(str5).length());
            sb2.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb2.append(str4);
            sb2.append("/");
            sb2.append(str5);
            return null;
        }
        return null;
    }

    public Intent c() {
        return this.f7334d.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Context context) {
        if (this.f7333c == null) {
            this.f7333c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        this.f7332b.booleanValue();
        return this.f7333c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context) {
        if (this.f7332b == null) {
            this.f7332b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        this.f7332b.booleanValue();
        return this.f7332b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        this.f7334d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
