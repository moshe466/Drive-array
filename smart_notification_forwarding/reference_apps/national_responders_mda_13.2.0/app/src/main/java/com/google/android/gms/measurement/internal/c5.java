package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class c5 implements Callable<List<p9>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v9 f5895a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f5896b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f5897c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ y4 f5898d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c5(y4 y4Var, v9 v9Var, String str, String str2) {
        this.f5898d = y4Var;
        this.f5895a = v9Var;
        this.f5896b = str;
        this.f5897c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<p9> call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f5898d.f6633a;
        e9Var.k0();
        e9Var2 = this.f5898d.f6633a;
        return e9Var2.a0().N(this.f5895a.f6560f, this.f5896b, this.f5897c);
    }
}
