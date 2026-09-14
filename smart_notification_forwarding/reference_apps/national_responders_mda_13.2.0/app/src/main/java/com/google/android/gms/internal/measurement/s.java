package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ of f5579j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5580k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(h hVar, of ofVar) {
        super(hVar);
        this.f5580k = hVar;
        this.f5579j = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5580k.f5357h;
        qfVar.getGmpAppId(this.f5579j);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5579j.f(null);
    }
}
