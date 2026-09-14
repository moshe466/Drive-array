package q;

import java.util.ArrayList;
import p.e;

/* loaded from: classes.dex */
public class i {
    public static o a(p.e eVar, int i10, ArrayList<o> arrayList, o oVar) {
        p.d dVar;
        int p12;
        int i11 = i10 == 0 ? eVar.f12980t0 : eVar.f12982u0;
        if (i11 != -1 && (oVar == null || i11 != oVar.f13403b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i12);
                if (oVar2.c() == i11) {
                    if (oVar != null) {
                        oVar.g(i10, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof p.i) && (p12 = ((p.i) eVar).p1(i10)) != -1) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i13);
                    if (oVar3.c() == p12) {
                        oVar = oVar3;
                        break;
                    }
                    i13++;
                }
            }
            if (oVar == null) {
                oVar = new o(i10);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof p.g) {
                p.g gVar = (p.g) eVar;
                gVar.o1().b(gVar.p1() == 0 ? 1 : 0, arrayList, oVar);
            }
            int c10 = oVar.c();
            if (i10 == 0) {
                eVar.f12980t0 = c10;
                eVar.L.b(i10, arrayList, oVar);
                dVar = eVar.N;
            } else {
                eVar.f12982u0 = c10;
                eVar.M.b(i10, arrayList, oVar);
                eVar.P.b(i10, arrayList, oVar);
                dVar = eVar.O;
            }
            dVar.b(i10, arrayList, oVar);
            eVar.S.b(i10, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            o oVar = arrayList.get(i11);
            if (i10 == oVar.f13403b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x038d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0388  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(p.f r16, q.b.InterfaceC0278b r17) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.i.c(p.f, q.b$b):boolean");
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
