package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class f5 implements Callable<List<p9>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f6047a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f6048b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f6049c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ y4 f6050d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f5(y4 y4Var, String str, String str2, String str3) {
        this.f6050d = y4Var;
        this.f6047a = str;
        this.f6048b = str2;
        this.f6049c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<p9> call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6050d.f6633a;
        e9Var.k0();
        e9Var2 = this.f6050d.f6633a;
        return e9Var2.a0().N(this.f6047a, this.f6048b, this.f6049c);
    }
}
