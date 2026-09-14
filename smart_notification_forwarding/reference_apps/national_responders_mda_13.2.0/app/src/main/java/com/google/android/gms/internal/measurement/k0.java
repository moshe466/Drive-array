package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.h;

/* loaded from: classes.dex */
final class k0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f5421j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h.b f5422k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(h.b bVar, Activity activity) {
        super(h.this);
        this.f5422k = bVar;
        this.f5421j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = h.this.f5357h;
        qfVar.onActivityDestroyed(j2.b.z(this.f5421j), this.f5359g);
    }
}
