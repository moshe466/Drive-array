package com.google.android.gms.common.api.internal;

import a2.f;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class k3 implements f.b, f.c {

    /* renamed from: a, reason: collision with root package name */
    public final a2.a f4890a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4891b;

    /* renamed from: c, reason: collision with root package name */
    private l3 f4892c;

    public k3(a2.a aVar, boolean z10) {
        this.f4890a = aVar;
        this.f4891b = z10;
    }

    private final l3 b() {
        b2.p.l(this.f4892c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f4892c;
    }

    public final void a(l3 l3Var) {
        this.f4892c = l3Var;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i(int i10) {
        b().i(i10);
    }

    @Override // com.google.android.gms.common.api.internal.o
    public final void n(com.google.android.gms.common.a aVar) {
        b().z(aVar, this.f4890a, this.f4891b);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void p(Bundle bundle) {
        b().p(bundle);
    }
}
