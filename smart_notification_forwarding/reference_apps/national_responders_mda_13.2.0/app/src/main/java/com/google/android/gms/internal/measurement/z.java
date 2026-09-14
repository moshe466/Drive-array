package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5730j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ of f5731k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ h f5732l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(h hVar, String str, of ofVar) {
        super(hVar);
        this.f5732l = hVar;
        this.f5730j = str;
        this.f5731k = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5732l.f5357h;
        qfVar.getMaxUserProperties(this.f5730j, this.f5731k);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5731k.f(null);
    }
}
