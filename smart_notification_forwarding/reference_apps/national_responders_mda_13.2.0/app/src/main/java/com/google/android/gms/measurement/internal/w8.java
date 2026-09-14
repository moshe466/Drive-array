package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.ad;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w8 {

    /* renamed from: a, reason: collision with root package name */
    private long f6605a;

    /* renamed from: b, reason: collision with root package name */
    private long f6606b;

    /* renamed from: c, reason: collision with root package name */
    private final i f6607c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ p8 f6608d;

    public w8(p8 p8Var) {
        this.f6608d = p8Var;
        this.f6607c = new v8(this, p8Var.f6381a);
        long b10 = p8Var.f().b();
        this.f6605a = b10;
        this.f6606b = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.f6608d.c();
        d(false, false, this.f6608d.f().b());
        this.f6608d.o().v(this.f6608d.f().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f6607c.e();
        this.f6605a = 0L;
        this.f6606b = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j10) {
        this.f6608d.c();
        this.f6607c.e();
        this.f6605a = j10;
        this.f6606b = j10;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f6608d.c();
        this.f6608d.w();
        if (!ad.a() || !this.f6608d.m().t(s.f6425q0) || this.f6608d.f6381a.p()) {
            this.f6608d.l().f5974u.b(this.f6608d.f().a());
        }
        long j11 = j10 - this.f6605a;
        if (!z10 && j11 < 1000) {
            this.f6608d.h().N().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
            return false;
        }
        if (this.f6608d.m().t(s.T) && !z11) {
            j11 = (bd.a() && this.f6608d.m().t(s.V)) ? g(j10) : e();
        }
        this.f6608d.h().N().b("Recording user engagement, ms", Long.valueOf(j11));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        b7.O(this.f6608d.s().D(!this.f6608d.m().I().booleanValue()), bundle, true);
        if (this.f6608d.m().t(s.T) && !this.f6608d.m().t(s.U) && z11) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f6608d.m().t(s.U) || !z11) {
            this.f6608d.p().R("auto", "_e", bundle);
        }
        this.f6605a = j10;
        this.f6607c.e();
        this.f6607c.c(3600000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e() {
        long b10 = this.f6608d.f().b();
        long j10 = b10 - this.f6606b;
        this.f6606b = b10;
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(long j10) {
        this.f6607c.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long g(long j10) {
        long j11 = j10 - this.f6606b;
        this.f6606b = j10;
        return j11;
    }
}
