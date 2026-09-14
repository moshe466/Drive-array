package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class s3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f4986f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4987g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ t3 f4988h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(t3 t3Var, LifecycleCallback lifecycleCallback, String str) {
        this.f4988h = t3Var;
        this.f4986f = lifecycleCallback;
        this.f4987g = str;
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
        t3 t3Var = this.f4988h;
        i10 = t3Var.f4994f0;
        if (i10 > 0) {
            LifecycleCallback lifecycleCallback = this.f4986f;
            bundle = t3Var.f4995g0;
            if (bundle != null) {
                bundle3 = t3Var.f4995g0;
                bundle2 = bundle3.getBundle(this.f4987g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i11 = this.f4988h.f4994f0;
        if (i11 >= 2) {
            this.f4986f.j();
        }
        i12 = this.f4988h.f4994f0;
        if (i12 >= 3) {
            this.f4986f.h();
        }
        i13 = this.f4988h.f4994f0;
        if (i13 >= 4) {
            this.f4986f.k();
        }
        i14 = this.f4988h.f4994f0;
        if (i14 >= 5) {
            this.f4986f.g();
        }
    }
}
