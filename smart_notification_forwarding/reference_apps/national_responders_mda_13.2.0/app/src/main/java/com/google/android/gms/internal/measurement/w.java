package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f5652j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5653k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ boolean f5654l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ of f5655m;

    /* renamed from: n, reason: collision with root package name */
    private final /* synthetic */ h f5656n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(h hVar, String str, String str2, boolean z10, of ofVar) {
        super(hVar);
        this.f5656n = hVar;
        this.f5652j = str;
        this.f5653k = str2;
        this.f5654l = z10;
        this.f5655m = ofVar;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5656n.f5357h;
        qfVar.getUserProperties(this.f5652j, this.f5653k, this.f5654l, this.f5655m);
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    protected final void b() {
        this.f5655m.f(null);
    }
}
