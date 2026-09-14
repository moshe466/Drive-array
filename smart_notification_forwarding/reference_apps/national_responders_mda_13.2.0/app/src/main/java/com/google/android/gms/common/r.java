package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import b2.t0;
import b2.u0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    static final p f5113a;

    /* renamed from: b, reason: collision with root package name */
    static final p f5114b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile u0 f5115c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f5116d;

    /* renamed from: e, reason: collision with root package name */
    private static Context f5117e;

    static {
        new j(n.p("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new k(n.p("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f5113a = new l(n.p("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f5114b = new m(n.p("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f5116d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x a(String str, n nVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, nVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x b(String str, boolean z10, boolean z11, boolean z12) {
        return g(str, z10, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String c(boolean z10, String str, n nVar) {
        String str2 = true != (!z10 && f(str, nVar, true, false).f5129a) ? "not allowed" : "debug cert rejected";
        MessageDigest b10 = g2.a.b("SHA-256");
        b2.p.k(b10);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, g2.j.a(b10.digest(nVar.z())), Boolean.valueOf(z10), "12451000.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d(Context context) {
        synchronized (r.class) {
            if (f5117e == null) {
                if (context != null) {
                    f5117e = context.getApplicationContext();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            h();
            boolean k10 = f5115c.k();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return k10;
        } catch (RemoteException | DynamiteModule.a unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static x f(final String str, final n nVar, final boolean z10, boolean z11) {
        try {
            h();
            b2.p.k(f5117e);
            try {
                return f5115c.B(new u(str, nVar, z10, z11), j2.b.z(f5117e.getPackageManager())) ? x.b() : new w(new Callable() { // from class: com.google.android.gms.common.i
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return r.c(z10, str, nVar);
                    }
                }, null);
            } catch (RemoteException e10) {
                return x.d("module call", e10);
            }
        } catch (DynamiteModule.a e11) {
            return x.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [j2.a, android.os.IBinder] */
    private static x g(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        String concat;
        x d10;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            b2.p.k(f5117e);
            try {
                h();
                s sVar = new s(str, z10, false, j2.b.z(f5117e), false);
                try {
                    z1.i h02 = z13 ? f5115c.h0(sVar) : f5115c.u(sVar);
                    if (h02.j()) {
                        d10 = x.f(h02.l());
                    } else {
                        String g10 = h02.g();
                        PackageManager.NameNotFoundException nameNotFoundException = h02.s() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (g10 == null) {
                            g10 = "error checking package certificate";
                        }
                        d10 = x.g(h02.l(), h02.s(), g10, nameNotFoundException);
                    }
                } catch (RemoteException e10) {
                    e = e10;
                    concat = "module call";
                    d10 = x.d(concat, e);
                    return d10;
                }
            } catch (DynamiteModule.a e11) {
                e = e11;
                concat = "module init: ".concat(String.valueOf(e.getMessage()));
            }
            return d10;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void h() {
        if (f5115c != null) {
            return;
        }
        b2.p.k(f5117e);
        synchronized (f5116d) {
            if (f5115c == null) {
                f5115c = t0.n(DynamiteModule.d(f5117e, DynamiteModule.f5133c, "com.google.android.gms.googlecertificates").c("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
