package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ of f5622j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5623k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(h hVar, of ofVar) {
        super(hVar);
        this.f5623k = hVar;
        this.f5622j = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5623k.f5357h;
        qfVar.generateEventId(this.f5622j);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5622j.f(null);
    }
}
