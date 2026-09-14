package com.google.android.gms.common.api.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ u0 f4874f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(u0 u0Var) {
        this.f4874f = u0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.common.c cVar;
        Context context;
        u0 u0Var = this.f4874f;
        cVar = u0Var.f4999d;
        context = u0Var.f4998c;
        cVar.a(context);
    }
}
