package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6194f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6195g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6196h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f6197i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ w5 f6198j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l6(w5 w5Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f6198j = w5Var;
        this.f6194f = atomicReference;
        this.f6195g = str2;
        this.f6196h = str3;
        this.f6197i = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6198j.f6381a.P().R(this.f6194f, null, this.f6195g, this.f6196h, this.f6197i);
    }
}
