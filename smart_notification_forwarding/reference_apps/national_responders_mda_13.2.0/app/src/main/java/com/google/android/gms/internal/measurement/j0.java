package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.h;

/* loaded from: classes.dex */
final class j0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f5404j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h.b f5405k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(h.b bVar, Activity activity) {
        super(h.this);
        this.f5405k = bVar;
        this.f5404j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = h.this.f5357h;
        qfVar.onActivityStopped(j2.b.z(this.f5404j), this.f5359g);
    }
}
