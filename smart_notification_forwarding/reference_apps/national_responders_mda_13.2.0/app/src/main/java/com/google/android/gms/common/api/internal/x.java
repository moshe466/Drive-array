package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.b;
import com.google.android.gms.common.api.internal.l;

/* loaded from: classes.dex */
public abstract class x<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f5033a;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(l.a<L> aVar) {
        this.f5033a = aVar;
    }

    public l.a<L> a() {
        return this.f5033a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(A a10, z2.m<Boolean> mVar);
}
