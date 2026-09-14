package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f5153j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5154k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(h hVar, boolean z10) {
        super(hVar);
        this.f5154k = hVar;
        this.f5153j = z10;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5154k.f5357h;
        qfVar.setDataCollectionEnabled(this.f5153j);
    }
}
