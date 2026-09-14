package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class q3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f4968f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4969g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ r3 f4970h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(r3 r3Var, LifecycleCallback lifecycleCallback, String str) {
        this.f4970h = r3Var;
        this.f4968f = lifecycleCallback;
        this.f4969g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        r3 r3Var = this.f4970h;
        i10 = r3Var.f4975g;
        if (i10 > 0) {
            LifecycleCallback lifecycleCallback = this.f4968f;
            bundle = r3Var.f4976h;
            if (bundle != null) {
                bundle3 = r3Var.f4976h;
                bundle2 = bundle3.getBundle(this.f4969g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i11 = this.f4970h.f4975g;
        if (i11 >= 2) {
            this.f4968f.j();
        }
        i12 = this.f4970h.f4975g;
        if (i12 >= 3) {
            this.f4968f.h();
        }
        i13 = this.f4970h.f4975g;
        if (i13 >= 4) {
            this.f4968f.k();
        }
        i14 = this.f4970h.f4975g;
        if (i14 >= 5) {
            this.f4968f.g();
        }
    }
}
