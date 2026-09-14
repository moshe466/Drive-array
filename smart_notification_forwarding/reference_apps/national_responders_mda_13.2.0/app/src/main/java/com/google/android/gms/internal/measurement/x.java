package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ of f5665j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5666k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(h hVar, of ofVar) {
        super(hVar);
        this.f5666k = hVar;
        this.f5665j = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5666k.f5357h;
        qfVar.getCurrentScreenClass(this.f5665j);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5665j.f(null);
    }
}
