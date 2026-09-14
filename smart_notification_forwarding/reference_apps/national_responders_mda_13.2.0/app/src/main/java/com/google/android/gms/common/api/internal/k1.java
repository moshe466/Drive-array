package com.google.android.gms.common.api.internal;

import android.os.Handler;
import b2.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k1 implements c.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l1 f4887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(l1 l1Var) {
        this.f4887a = l1Var;
    }

    @Override // b2.c.e
    public final void a() {
        Handler handler;
        handler = this.f4887a.f4911m.f4858p;
        handler.post(new j1(this));
    }
}
