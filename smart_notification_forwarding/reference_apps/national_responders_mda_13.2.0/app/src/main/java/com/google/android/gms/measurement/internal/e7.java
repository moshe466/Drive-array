package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f5993f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ c7 f5994g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ c7 f5995h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f5996i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ b7 f5997j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e7(b7 b7Var, Bundle bundle, c7 c7Var, c7 c7Var2, long j10) {
        this.f5997j = b7Var;
        this.f5993f = bundle;
        this.f5994g = c7Var;
        this.f5995h = c7Var2;
        this.f5996i = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5997j.K(this.f5993f, this.f5994g, this.f5995h, this.f5996i);
    }
}
