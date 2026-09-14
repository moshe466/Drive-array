package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5439j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5440k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ of f5441l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ h f5442m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h hVar, String str, String str2, of ofVar) {
        super(hVar);
        this.f5442m = hVar;
        this.f5439j = str;
        this.f5440k = str2;
        this.f5441l = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5442m.f5357h;
        qfVar.getConditionalUserProperties(this.f5439j, this.f5440k, this.f5441l);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5441l.f(null);
    }
}
