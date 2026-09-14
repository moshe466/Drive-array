package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class e5 implements Callable<List<ha>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v9 f5980a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f5981b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f5982c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ y4 f5983d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(y4 y4Var, v9 v9Var, String str, String str2) {
        this.f5983d = y4Var;
        this.f5980a = v9Var;
        this.f5981b = str;
        this.f5982c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<ha> call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f5983d.f6633a;
        e9Var.k0();
        e9Var2 = this.f5983d.f6633a;
        return e9Var2.a0().n0(this.f5980a.f6560f, this.f5981b, this.f5982c);
    }
}
