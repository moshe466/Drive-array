package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class k5 implements Callable<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ q f6159a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f6160b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ y4 f6161c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(y4 y4Var, q qVar, String str) {
        this.f6161c = y4Var;
        this.f6159a = qVar;
        this.f6160b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6161c.f6633a;
        e9Var.k0();
        e9Var2 = this.f6161c.f6633a;
        return e9Var2.d0().x(this.f6159a, this.f6160b);
    }
}
