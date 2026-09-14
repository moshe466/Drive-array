package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5542j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5543k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(h hVar, String str) {
        super(hVar);
        this.f5543k = hVar;
        this.f5542j = str;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5543k.f5357h;
        qfVar.beginAdUnitExposure(this.f5542j, this.f5359g);
    }
}
