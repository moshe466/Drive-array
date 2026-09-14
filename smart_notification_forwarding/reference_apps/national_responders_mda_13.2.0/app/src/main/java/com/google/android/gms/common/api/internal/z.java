package com.google.android.gms.common.api.internal;

import a2.g;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements g.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BasePendingResult f5062a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f5063b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(b0 b0Var, BasePendingResult basePendingResult) {
        this.f5063b = b0Var;
        this.f5062a = basePendingResult;
    }

    @Override // a2.g.a
    public final void a(Status status) {
        Map map;
        map = this.f5063b.f4785a;
        map.remove(this.f5062a);
    }
}
