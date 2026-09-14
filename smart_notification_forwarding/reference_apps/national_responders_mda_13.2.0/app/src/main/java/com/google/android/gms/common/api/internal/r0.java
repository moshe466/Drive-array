package com.google.android.gms.common.api.internal;

import a2.f;
import android.os.Bundle;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class r0 implements f.b, f.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u0 f4971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r0(u0 u0Var, q0 q0Var) {
        this.f4971a = u0Var;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i(int i10) {
    }

    @Override // com.google.android.gms.common.api.internal.o
    public final void n(com.google.android.gms.common.a aVar) {
        Lock lock;
        Lock lock2;
        boolean p10;
        lock = this.f4971a.f4997b;
        lock.lock();
        try {
            p10 = this.f4971a.p(aVar);
            if (p10) {
                this.f4971a.h();
                this.f4971a.m();
            } else {
                this.f4971a.k(aVar);
            }
        } finally {
            lock2 = this.f4971a.f4997b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void p(Bundle bundle) {
        b2.e eVar;
        w2.f fVar;
        eVar = this.f4971a.f5013r;
        fVar = this.f4971a.f5006k;
        ((w2.f) b2.p.k(fVar)).u(new p0(this.f4971a));
    }
}
