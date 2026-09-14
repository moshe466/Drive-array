package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ int f5697j = 5;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5698k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ Object f5699l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ h f5700m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(h hVar, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f5700m = hVar;
        this.f5698k = str;
        this.f5699l = obj;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5700m.f5357h;
        qfVar.logHealthData(this.f5697j, this.f5698k, j2.b.z(this.f5699l), j2.b.z(null), j2.b.z(null));
    }
}
