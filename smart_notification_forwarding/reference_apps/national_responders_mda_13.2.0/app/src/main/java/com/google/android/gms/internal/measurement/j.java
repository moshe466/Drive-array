package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Bundle f5402j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h f5403k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, Bundle bundle) {
        super(hVar);
        this.f5403k = hVar;
        this.f5402j = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5403k.f5357h;
        qfVar.setConditionalUserProperty(this.f5402j, this.f5358f);
    }
}
