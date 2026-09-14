package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class h5 implements Callable<List<ha>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f6082a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f6083b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f6084c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ y4 f6085d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(y4 y4Var, String str, String str2, String str3) {
        this.f6085d = y4Var;
        this.f6082a = str;
        this.f6083b = str2;
        this.f6084c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<ha> call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6085d.f6633a;
        e9Var.k0();
        e9Var2 = this.f6085d.f6633a;
        return e9Var2.a0().n0(this.f6082a, this.f6083b, this.f6084c);
    }
}
