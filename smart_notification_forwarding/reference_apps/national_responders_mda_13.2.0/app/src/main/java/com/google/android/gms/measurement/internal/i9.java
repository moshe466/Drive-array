package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.bc;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i9 implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v9 f6126a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e9 f6127b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i9(e9 e9Var, v9 v9Var) {
        this.f6127b = e9Var;
        this.f6126a = v9Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        t3 I;
        String str;
        if (bc.a() && this.f6127b.L().t(s.J0) && (!this.f6127b.j(this.f6126a.f6560f).q() || !v2.a.f(this.f6126a.B).q())) {
            I = this.f6127b.h().N();
            str = "Analytics storage consent denied. Returning null app instance id";
        } else {
            b4 V = this.f6127b.V(this.f6126a);
            if (V != null) {
                return V.x();
            }
            I = this.f6127b.h().I();
            str = "App info was null when attempting to get app instance id";
        }
        I.a(str);
        return null;
    }
}
