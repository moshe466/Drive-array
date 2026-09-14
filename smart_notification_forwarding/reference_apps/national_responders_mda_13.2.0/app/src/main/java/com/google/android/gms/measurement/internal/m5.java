package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class m5 implements Callable<List<p9>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v9 f6223a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ y4 f6224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m5(y4 y4Var, v9 v9Var) {
        this.f6224b = y4Var;
        this.f6223a = v9Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<p9> call() {
        e9 e9Var;
        e9 e9Var2;
        e9Var = this.f6224b.f6633a;
        e9Var.k0();
        e9Var2 = this.f6224b.f6633a;
        return e9Var2.a0().L(this.f6223a.f6560f);
    }
}
