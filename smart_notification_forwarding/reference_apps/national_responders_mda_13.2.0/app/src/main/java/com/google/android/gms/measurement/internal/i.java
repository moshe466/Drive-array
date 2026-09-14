package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.internal.measurement.mf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: d, reason: collision with root package name */
    private static volatile Handler f6102d;

    /* renamed from: a, reason: collision with root package name */
    private final s5 f6103a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f6104b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f6105c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(s5 s5Var) {
        b2.p.k(s5Var);
        this.f6103a = s5Var;
        this.f6104b = new l(this, s5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(i iVar, long j10) {
        iVar.f6105c = 0L;
        return 0L;
    }

    private final Handler f() {
        Handler handler;
        if (f6102d != null) {
            return f6102d;
        }
        synchronized (i.class) {
            if (f6102d == null) {
                f6102d = new mf(this.f6103a.i().getMainLooper());
            }
            handler = f6102d;
        }
        return handler;
    }

    public abstract void b();

    public final void c(long j10) {
        e();
        if (j10 >= 0) {
            this.f6105c = this.f6103a.f().a();
            if (f().postDelayed(this.f6104b, j10)) {
                return;
            }
            this.f6103a.h().F().b("Failed to schedule delayed post. time", Long.valueOf(j10));
        }
    }

    public final boolean d() {
        return this.f6105c != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.f6105c = 0L;
        f().removeCallbacks(this.f6104b);
    }
}
