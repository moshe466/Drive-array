package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ h.c f5184j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5185k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(h hVar, h.c cVar) {
        super(hVar);
        this.f5185k = hVar;
        this.f5184j = cVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5185k.f5357h;
        qfVar.registerOnMeasurementEventListener(this.f5184j);
    }
}
