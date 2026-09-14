package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.h;

/* loaded from: classes.dex */
final class i0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f5382j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ of f5383k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ h.b f5384l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(h.b bVar, Activity activity, of ofVar) {
        super(h.this);
        this.f5384l = bVar;
        this.f5382j = activity;
        this.f5383k = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = h.this.f5357h;
        qfVar.onActivitySaveInstanceState(j2.b.z(this.f5382j), this.f5383k, this.f5359g);
    }
}
