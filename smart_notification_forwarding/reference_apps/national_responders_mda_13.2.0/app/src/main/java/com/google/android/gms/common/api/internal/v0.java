package com.google.android.gms.common.api.internal;

import a2.a;
import android.os.Bundle;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class v0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1 f5027a;

    public v0(d1 d1Var) {
        this.f5027a = d1Var;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void b(int i10) {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void c() {
        Iterator it = this.f5027a.f4817f.values().iterator();
        while (it.hasNext()) {
            ((a.f) it.next()).p();
        }
        this.f5027a.f4824m.f5078p = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void d(com.google.android.gms.common.a aVar, a2.a aVar2, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final void e() {
        this.f5027a.k();
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.a1
    public final d g(d dVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
