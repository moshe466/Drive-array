package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ of f5600j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5601k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(h hVar, of ofVar) {
        super(hVar);
        this.f5601k = hVar;
        this.f5600j = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5601k.f5357h;
        qfVar.getCurrentScreenName(this.f5600j);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5600j.f(null);
    }
}
