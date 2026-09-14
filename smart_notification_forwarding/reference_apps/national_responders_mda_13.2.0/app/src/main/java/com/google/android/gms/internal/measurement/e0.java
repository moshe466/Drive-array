package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.h;

/* loaded from: classes.dex */
final class e0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f5273j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ h.b f5274k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(h.b bVar, Activity activity) {
        super(h.this);
        this.f5274k = bVar;
        this.f5273j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = h.this.f5357h;
        qfVar.onActivityStarted(j2.b.z(this.f5273j), this.f5359g);
    }
}
