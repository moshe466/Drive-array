package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ of f5562j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5563k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(h hVar, of ofVar) {
        super(hVar);
        this.f5563k = hVar;
        this.f5562j = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5563k.f5357h;
        qfVar.getCachedAppInstanceId(this.f5562j);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5562j.f(null);
    }
}
