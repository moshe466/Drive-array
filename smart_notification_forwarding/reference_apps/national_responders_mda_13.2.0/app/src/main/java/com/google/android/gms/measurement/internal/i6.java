package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6118f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6119g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6120h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ w5 f6121i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i6(w5 w5Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f6121i = w5Var;
        this.f6118f = atomicReference;
        this.f6119g = str2;
        this.f6120h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6121i.f6381a.P().Q(this.f6118f, null, this.f6119g, this.f6120h);
    }
}
