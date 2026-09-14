package com.google.android.gms.common.api.internal;

import a2.a;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 extends t0 {

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList f4933g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ u0 f4934h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(u0 u0Var, ArrayList arrayList) {
        super(u0Var, null);
        this.f4934h = u0Var;
        this.f4933g = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void a() {
        d1 d1Var;
        b2.j jVar;
        d1 d1Var2;
        u0 u0Var = this.f4934h;
        d1Var = u0Var.f4996a;
        d1Var.f4824m.f5078p = u0.x(u0Var);
        ArrayList arrayList = this.f4933g;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            a.f fVar = (a.f) arrayList.get(i10);
            u0 u0Var2 = this.f4934h;
            jVar = u0Var2.f5010o;
            d1Var2 = u0Var2.f4996a;
            fVar.n(jVar, d1Var2.f4824m.f5078p);
        }
    }
}
