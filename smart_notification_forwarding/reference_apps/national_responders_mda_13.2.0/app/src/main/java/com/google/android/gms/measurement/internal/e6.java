package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f5984f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f5985g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f5986h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Bundle f5987i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f5988j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ boolean f5989k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ boolean f5990l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ String f5991m;

    /* renamed from: n, reason: collision with root package name */
    private final /* synthetic */ w5 f5992n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e6(w5 w5Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f5992n = w5Var;
        this.f5984f = str;
        this.f5985g = str2;
        this.f5986h = j10;
        this.f5987i = bundle;
        this.f5988j = z10;
        this.f5989k = z11;
        this.f5990l = z12;
        this.f5991m = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5992n.P(this.f5984f, this.f5985g, this.f5986h, this.f5987i, this.f5988j, this.f5989k, this.f5990l, this.f5991m);
    }
}
