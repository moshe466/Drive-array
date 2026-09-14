package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.b;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.l;

/* loaded from: classes.dex */
public abstract class p<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    private final l f4943a;

    /* renamed from: b, reason: collision with root package name */
    private final z1.c[] f4944b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4945c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4946d;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(l<L> lVar, Feature[] featureArr, boolean z10, int i10) {
        this.f4943a = lVar;
        this.f4944b = featureArr;
        this.f4945c = z10;
        this.f4946d = i10;
    }

    public void a() {
        this.f4943a.a();
    }

    public l.a<L> b() {
        return this.f4943a.b();
    }

    public z1.c[] c() {
        return this.f4944b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(A a10, z2.m<Void> mVar);

    public final int e() {
        return this.f4946d;
    }

    public final boolean f() {
        return this.f4945c;
    }
}
