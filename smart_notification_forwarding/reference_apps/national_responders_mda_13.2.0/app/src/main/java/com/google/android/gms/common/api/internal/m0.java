package com.google.android.gms.common.api.internal;

import a2.a;
import android.content.Context;
import b2.c;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m0 extends t0 {

    /* renamed from: g, reason: collision with root package name */
    private final Map f4913g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ u0 f4914h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(u0 u0Var, Map map) {
        super(u0Var, null);
        this.f4914h = u0Var;
        this.f4913g = map;
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void a() {
        com.google.android.gms.common.c cVar;
        Context context;
        boolean z10;
        Context context2;
        d1 d1Var;
        w2.f fVar;
        w2.f fVar2;
        d1 d1Var2;
        Context context3;
        boolean z11;
        cVar = this.f4914h.f4999d;
        b2.j0 j0Var = new b2.j0(cVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f fVar3 : this.f4913g.keySet()) {
            if (fVar3.g()) {
                z11 = ((j0) this.f4913g.get(fVar3)).f4881c;
                if (!z11) {
                    arrayList.add(fVar3);
                }
            }
            arrayList2.add(fVar3);
        }
        int i10 = -1;
        int i11 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i11 < size) {
                a.f fVar4 = (a.f) arrayList.get(i11);
                context = this.f4914h.f4998c;
                i10 = j0Var.b(context, fVar4);
                i11++;
                if (i10 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i11 < size2) {
                a.f fVar5 = (a.f) arrayList2.get(i11);
                context3 = this.f4914h.f4998c;
                i10 = j0Var.b(context3, fVar5);
                i11++;
                if (i10 == 0) {
                    break;
                }
            }
        }
        if (i10 != 0) {
            com.google.android.gms.common.a aVar = new com.google.android.gms.common.a(i10, null);
            u0 u0Var = this.f4914h;
            d1Var2 = u0Var.f4996a;
            d1Var2.m(new k0(this, u0Var, aVar));
            return;
        }
        u0 u0Var2 = this.f4914h;
        z10 = u0Var2.f5008m;
        if (z10) {
            fVar = u0Var2.f5006k;
            if (fVar != null) {
                fVar2 = u0Var2.f5006k;
                fVar2.s();
            }
        }
        for (a.f fVar6 : this.f4913g.keySet()) {
            c.InterfaceC0067c interfaceC0067c = (c.InterfaceC0067c) this.f4913g.get(fVar6);
            if (fVar6.g()) {
                context2 = this.f4914h.f4998c;
                if (j0Var.b(context2, fVar6) != 0) {
                    u0 u0Var3 = this.f4914h;
                    d1Var = u0Var3.f4996a;
                    d1Var.m(new l0(this, u0Var3, interfaceC0067c));
                }
            }
            fVar6.t(interfaceC0067c);
        }
    }
}
