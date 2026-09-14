package com.google.android.gms.common.api.internal;

import a2.a;
import android.os.Looper;

/* loaded from: classes.dex */
public final class q1 extends e0 {

    /* renamed from: c, reason: collision with root package name */
    private final a2.e f4967c;

    public q1(a2.e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f4967c = eVar;
    }

    @Override // a2.f
    public final <A extends a.b, T extends d<? extends a2.j, A>> T g(T t10) {
        return (T) this.f4967c.n(t10);
    }

    @Override // a2.f
    public final Looper h() {
        return this.f4967c.r();
    }

    @Override // a2.f
    public final void k(s2 s2Var) {
    }
}
