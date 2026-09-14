package com.google.android.gms.common;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x {

    /* renamed from: d, reason: collision with root package name */
    private static final x f5128d = new x(true, 3, 1, null, null);

    /* renamed from: a, reason: collision with root package name */
    final boolean f5129a;

    /* renamed from: b, reason: collision with root package name */
    final String f5130b;

    /* renamed from: c, reason: collision with root package name */
    final Throwable f5131c;

    private x(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f5129a = z10;
        this.f5130b = str;
        this.f5131c = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static x b() {
        return f5128d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x c(String str) {
        return new x(false, 1, 5, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x d(String str, Throwable th) {
        return new x(false, 1, 5, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x f(int i10) {
        return new x(true, i10, 1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x g(int i10, int i11, String str, Throwable th) {
        return new x(false, i10, i11, str, th);
    }

    String a() {
        return this.f5130b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.f5129a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        Throwable th = this.f5131c;
        a();
    }
}
