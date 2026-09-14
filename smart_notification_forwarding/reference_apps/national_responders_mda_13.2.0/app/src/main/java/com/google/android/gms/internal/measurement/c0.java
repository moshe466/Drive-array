package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5221j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5222k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ Object f5223l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ boolean f5224m;

    /* renamed from: n, reason: collision with root package name */
    private final /* synthetic */ h f5225n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(h hVar, String str, String str2, Object obj, boolean z10) {
        super(hVar);
        this.f5225n = hVar;
        this.f5221j = str;
        this.f5222k = str2;
        this.f5223l = obj;
        this.f5224m = z10;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5225n.f5357h;
        qfVar.setUserProperty(this.f5221j, this.f5222k, j2.b.z(this.f5223l), this.f5224m, this.f5358f);
    }
}
