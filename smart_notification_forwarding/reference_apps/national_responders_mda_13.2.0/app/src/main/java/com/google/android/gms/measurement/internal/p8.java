package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.mf;

/* loaded from: classes.dex */
public final class p8 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    private Handler f6324c;

    /* renamed from: d, reason: collision with root package name */
    protected final y8 f6325d;

    /* renamed from: e, reason: collision with root package name */
    protected final w8 f6326e;

    /* renamed from: f, reason: collision with root package name */
    private final q8 f6327f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p8(t4 t4Var) {
        super(t4Var);
        this.f6325d = new y8(this);
        this.f6326e = new w8(this);
        this.f6327f = new q8(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        c();
        if (this.f6324c == null) {
            this.f6324c = new mf(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(long j10) {
        c();
        F();
        h().N().b("Activity resumed, time", Long.valueOf(j10));
        if (m().t(s.f6435v0)) {
            if (m().I().booleanValue() || l().f5976w.b()) {
                this.f6326e.b(j10);
            }
            this.f6327f.a();
        } else {
            this.f6327f.a();
            if (m().I().booleanValue()) {
                this.f6326e.b(j10);
            }
        }
        y8 y8Var = this.f6325d;
        y8Var.f6644a.c();
        if (y8Var.f6644a.f6381a.p()) {
            if (!y8Var.f6644a.m().t(s.f6435v0)) {
                y8Var.f6644a.l().f5976w.a(false);
            }
            y8Var.b(y8Var.f6644a.f().a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(long j10) {
        c();
        F();
        h().N().b("Activity paused, time", Long.valueOf(j10));
        this.f6327f.b(j10);
        if (m().I().booleanValue()) {
            this.f6326e.f(j10);
        }
        y8 y8Var = this.f6325d;
        if (y8Var.f6644a.m().t(s.f6435v0)) {
            return;
        }
        y8Var.f6644a.l().f5976w.a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long B(long j10) {
        return this.f6326e.g(j10);
    }

    public final boolean E(boolean z10, boolean z11, long j10) {
        return this.f6326e.d(z10, z11, j10);
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return false;
    }
}
