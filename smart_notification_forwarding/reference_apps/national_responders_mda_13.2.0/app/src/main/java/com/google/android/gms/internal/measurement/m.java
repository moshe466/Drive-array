package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5469j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5470k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ Bundle f5471l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ h f5472m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h hVar, String str, String str2, Bundle bundle) {
        super(hVar);
        this.f5472m = hVar;
        this.f5469j = str;
        this.f5470k = str2;
        this.f5471l = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5472m.f5357h;
        qfVar.clearConditionalUserProperty(this.f5469j, this.f5470k, this.f5471l);
    }
}
