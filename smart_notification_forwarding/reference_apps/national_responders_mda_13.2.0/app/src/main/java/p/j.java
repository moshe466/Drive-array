package p;

import p.e;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f13000a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, m.d dVar, e eVar) {
        eVar.f12973q = -1;
        eVar.f12975r = -1;
        e.b bVar = fVar.W[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.W[0] == e.b.MATCH_PARENT) {
            int i10 = eVar.L.f12936g;
            int U = fVar.U() - eVar.N.f12936g;
            d dVar2 = eVar.L;
            dVar2.f12938i = dVar.q(dVar2);
            d dVar3 = eVar.N;
            dVar3.f12938i = dVar.q(dVar3);
            dVar.f(eVar.L.f12938i, i10);
            dVar.f(eVar.N.f12938i, U);
            eVar.f12973q = 2;
            eVar.L0(i10, U);
        }
        if (fVar.W[1] == bVar2 || eVar.W[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i11 = eVar.M.f12936g;
        int v10 = fVar.v() - eVar.O.f12936g;
        d dVar4 = eVar.M;
        dVar4.f12938i = dVar.q(dVar4);
        d dVar5 = eVar.O;
        dVar5.f12938i = dVar.q(dVar5);
        dVar.f(eVar.M.f12938i, i11);
        dVar.f(eVar.O.f12938i, v10);
        if (eVar.f12950e0 > 0 || eVar.T() == 8) {
            d dVar6 = eVar.P;
            dVar6.f12938i = dVar.q(dVar6);
            dVar.f(eVar.P.f12938i, eVar.f12950e0 + i11);
        }
        eVar.f12975r = 2;
        eVar.c1(i11, v10);
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
