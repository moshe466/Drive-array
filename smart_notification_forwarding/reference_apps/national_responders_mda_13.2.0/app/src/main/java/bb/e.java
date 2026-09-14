package bb;

import bb.f;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static final e f4186a = new e();

    /* renamed from: b */
    public static boolean f4187b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4188a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f4189b;

        static {
            int[] iArr = new int[db.r.valuesCustom().length];
            iArr[db.r.INV.ordinal()] = 1;
            iArr[db.r.OUT.ordinal()] = 2;
            iArr[db.r.IN.ordinal()] = 3;
            f4188a = iArr;
            int[] iArr2 = new int[f.a.valuesCustom().length];
            iArr2[f.a.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[f.a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[f.a.SKIP_LOWER.ordinal()] = 3;
            f4189b = iArr2;
        }
    }

    private e() {
    }

    private final Boolean a(f fVar, db.i iVar, db.i iVar2) {
        if (!fVar.A0(iVar) && !fVar.A0(iVar2)) {
            return null;
        }
        if (fVar.A0(iVar) && fVar.A0(iVar2)) {
            return Boolean.TRUE;
        }
        if (fVar.A0(iVar)) {
            if (c(fVar, this, iVar, iVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (fVar.A0(iVar2) && (b(fVar, iVar) || c(fVar, this, iVar2, iVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean b(f fVar, db.i iVar) {
        boolean z10;
        db.l a10 = fVar.a(iVar);
        if (a10 instanceof db.g) {
            Collection<db.h> T = fVar.T(a10);
            if (!(T instanceof Collection) || !T.isEmpty()) {
                Iterator<T> it = T.iterator();
                while (it.hasNext()) {
                    db.i b10 = fVar.b((db.h) it.next());
                    if (y8.k.a(b10 == null ? null : Boolean.valueOf(fVar.A0(b10)), Boolean.TRUE)) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            if (z10) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c(f fVar, e eVar, db.i iVar, db.i iVar2, boolean z10) {
        Collection<db.h> B = fVar.B(iVar);
        if (!(B instanceof Collection) || !B.isEmpty()) {
            for (db.h hVar : B) {
                if (y8.k.a(fVar.J(hVar), fVar.a(iVar2)) || (z10 && o(eVar, fVar, iVar2, hVar, false, 8, null))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Boolean d(f fVar, db.i iVar, db.i iVar2) {
        boolean b10;
        boolean z10 = false;
        if (fVar.k(iVar) || fVar.k(iVar2)) {
            if (fVar.z0()) {
                return Boolean.TRUE;
            }
            if (fVar.m(iVar) && !fVar.m(iVar2)) {
                return Boolean.FALSE;
            }
            b10 = d.f4185a.b(fVar, fVar.d(iVar, false), fVar.d(iVar2, false));
        } else {
            if (!fVar.H(iVar) && !fVar.H(iVar2)) {
                db.d L = fVar.L(iVar2);
                db.c j10 = fVar.j(L == null ? iVar2 : fVar.F(L));
                db.h G = j10 == null ? null : fVar.G(j10);
                if (j10 != null && G != null) {
                    if (fVar.m(iVar2)) {
                        G = fVar.z(G, true);
                    } else if (fVar.x0(iVar2)) {
                        G = fVar.q(G);
                    }
                    db.h hVar = G;
                    int i10 = a.f4189b[fVar.q0(iVar, j10).ordinal()];
                    if (i10 == 1) {
                        b10 = o(this, fVar, iVar, hVar, false, 8, null);
                    } else if (i10 == 2 && o(this, fVar, iVar, hVar, false, 8, null)) {
                        return Boolean.TRUE;
                    }
                }
                db.l a10 = fVar.a(iVar2);
                if (!fVar.u(a10)) {
                    return null;
                }
                fVar.m(iVar2);
                Collection<db.h> T = fVar.T(a10);
                if (!(T instanceof Collection) || !T.isEmpty()) {
                    Iterator<T> it = T.iterator();
                    while (it.hasNext()) {
                        if (!o(this, fVar, iVar, (db.h) it.next(), false, 8, null)) {
                            break;
                        }
                    }
                }
                z10 = true;
                return Boolean.valueOf(z10);
            }
            b10 = fVar.C0();
        }
        return Boolean.valueOf(b10);
    }

    private final List<db.i> e(f fVar, db.i iVar, db.l lVar) {
        String Q;
        f.b F0;
        List<db.i> d10;
        List<db.i> b10;
        List<db.i> d11;
        List<db.i> o02 = fVar.o0(iVar, lVar);
        if (o02 == null) {
            if (!fVar.h(lVar) && fVar.w0(iVar)) {
                d11 = m8.q.d();
                return d11;
            }
            if (fVar.Y(lVar)) {
                if (!fVar.W(fVar.a(iVar), lVar)) {
                    d10 = m8.q.d();
                    return d10;
                }
                db.i S = fVar.S(iVar, db.b.FOR_SUBTYPING);
                if (S != null) {
                    iVar = S;
                }
                b10 = m8.p.b(iVar);
                return b10;
            }
            o02 = new jb.i<>();
            fVar.u0();
            ArrayDeque<db.i> r02 = fVar.r0();
            y8.k.b(r02);
            Set<db.i> s02 = fVar.s0();
            y8.k.b(s02);
            r02.push(iVar);
            while (!r02.isEmpty()) {
                if (s02.size() > 1000) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Too many supertypes for type: ");
                    sb2.append(iVar);
                    sb2.append(". Supertypes = ");
                    Q = m8.y.Q(s02, null, null, null, 0, null, null, 63, null);
                    sb2.append(Q);
                    throw new IllegalStateException(sb2.toString().toString());
                }
                db.i pop = r02.pop();
                y8.k.d(pop, "current");
                if (s02.add(pop)) {
                    db.i S2 = fVar.S(pop, db.b.FOR_SUBTYPING);
                    if (S2 == null) {
                        S2 = pop;
                    }
                    if (fVar.W(fVar.a(S2), lVar)) {
                        o02.add(S2);
                        F0 = f.b.c.f4200a;
                    } else {
                        F0 = fVar.y(S2) == 0 ? f.b.C0071b.f4199a : fVar.F0(S2);
                    }
                    if (!(!y8.k.a(F0, f.b.c.f4200a))) {
                        F0 = null;
                    }
                    if (F0 != null) {
                        Iterator<db.h> it = fVar.T(fVar.a(pop)).iterator();
                        while (it.hasNext()) {
                            r02.add(F0.a(fVar, it.next()));
                        }
                    }
                }
            }
            fVar.m0();
        }
        return o02;
    }

    private final List<db.i> f(f fVar, db.i iVar, db.l lVar) {
        return q(fVar, e(fVar, iVar, lVar));
    }

    private final boolean g(f fVar, db.h hVar, db.h hVar2, boolean z10) {
        Boolean d10 = d(fVar, fVar.C(hVar), fVar.i(hVar2));
        if (d10 == null) {
            Boolean k02 = fVar.k0(hVar, hVar2, z10);
            return k02 == null ? p(fVar, fVar.C(hVar), fVar.i(hVar2)) : k02.booleanValue();
        }
        boolean booleanValue = d10.booleanValue();
        fVar.k0(hVar, hVar2, z10);
        return booleanValue;
    }

    private final boolean k(f fVar, db.i iVar) {
        String Q;
        db.l a10 = fVar.a(iVar);
        if (fVar.h(a10)) {
            return fVar.I(a10);
        }
        if (fVar.I(fVar.a(iVar))) {
            return true;
        }
        fVar.u0();
        ArrayDeque<db.i> r02 = fVar.r0();
        y8.k.b(r02);
        Set<db.i> s02 = fVar.s0();
        y8.k.b(s02);
        r02.push(iVar);
        while (!r02.isEmpty()) {
            if (s02.size() > 1000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Too many supertypes for type: ");
                sb2.append(iVar);
                sb2.append(". Supertypes = ");
                Q = m8.y.Q(s02, null, null, null, 0, null, null, 63, null);
                sb2.append(Q);
                throw new IllegalStateException(sb2.toString().toString());
            }
            db.i pop = r02.pop();
            y8.k.d(pop, "current");
            if (s02.add(pop)) {
                f.b bVar = fVar.w0(pop) ? f.b.c.f4200a : f.b.C0071b.f4199a;
                if (!(!y8.k.a(bVar, f.b.c.f4200a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator<db.h> it = fVar.T(fVar.a(pop)).iterator();
                    while (it.hasNext()) {
                        db.i a11 = bVar.a(fVar, it.next());
                        if (fVar.I(fVar.a(a11))) {
                            fVar.m0();
                            return true;
                        }
                        r02.add(a11);
                    }
                }
            }
        }
        fVar.m0();
        return false;
    }

    private final boolean l(f fVar, db.h hVar) {
        return fVar.g0(fVar.J(hVar)) && !fVar.y0(hVar) && !fVar.x0(hVar) && y8.k.a(fVar.a(fVar.C(hVar)), fVar.a(fVar.i(hVar)));
    }

    public static /* synthetic */ boolean o(e eVar, f fVar, db.h hVar, db.h hVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return eVar.n(fVar, hVar, hVar2, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00cf, code lost:
    
        if ((r19.o(r5) == db.r.INV) != false) goto L141;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean p(bb.f r19, db.i r20, db.i r21) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.e.p(bb.f, db.i, db.i):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<db.i> q(f fVar, List<? extends db.i> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z10 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            db.j A = fVar.A((db.i) next);
            int l10 = fVar.l(A);
            int i10 = 0;
            while (true) {
                if (i10 >= l10) {
                    break;
                }
                if (!(fVar.R(fVar.g(fVar.c0(A, i10))) == null)) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final db.r h(db.r rVar, db.r rVar2) {
        y8.k.e(rVar, "declared");
        y8.k.e(rVar2, "useSite");
        db.r rVar3 = db.r.INV;
        if (rVar == rVar3) {
            return rVar2;
        }
        if (rVar2 == rVar3 || rVar == rVar2) {
            return rVar;
        }
        return null;
    }

    public final boolean i(f fVar, db.h hVar, db.h hVar2) {
        y8.k.e(fVar, "context");
        y8.k.e(hVar, "a");
        y8.k.e(hVar2, "b");
        if (hVar == hVar2) {
            return true;
        }
        if (l(fVar, hVar) && l(fVar, hVar2)) {
            db.h E0 = fVar.E0(hVar);
            db.h E02 = fVar.E0(hVar2);
            db.i C = fVar.C(E0);
            if (!fVar.W(fVar.J(E0), fVar.J(E02))) {
                return false;
            }
            if (fVar.y(C) == 0) {
                return fVar.t0(E0) || fVar.t0(E02) || fVar.m(C) == fVar.m(fVar.C(E02));
            }
        }
        return o(this, fVar, hVar, hVar2, false, 8, null) && o(this, fVar, hVar2, hVar, false, 8, null);
    }

    public final List<db.i> j(f fVar, db.i iVar, db.l lVar) {
        String Q;
        f.b bVar;
        y8.k.e(fVar, "<this>");
        y8.k.e(iVar, "subType");
        y8.k.e(lVar, "superConstructor");
        if (fVar.w0(iVar)) {
            return f(fVar, iVar, lVar);
        }
        if (!fVar.h(lVar) && !fVar.E(lVar)) {
            return e(fVar, iVar, lVar);
        }
        jb.i<db.i> iVar2 = new jb.i();
        fVar.u0();
        ArrayDeque<db.i> r02 = fVar.r0();
        y8.k.b(r02);
        Set<db.i> s02 = fVar.s0();
        y8.k.b(s02);
        r02.push(iVar);
        while (!r02.isEmpty()) {
            if (s02.size() > 1000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Too many supertypes for type: ");
                sb2.append(iVar);
                sb2.append(". Supertypes = ");
                Q = m8.y.Q(s02, null, null, null, 0, null, null, 63, null);
                sb2.append(Q);
                throw new IllegalStateException(sb2.toString().toString());
            }
            db.i pop = r02.pop();
            y8.k.d(pop, "current");
            if (s02.add(pop)) {
                if (fVar.w0(pop)) {
                    iVar2.add(pop);
                    bVar = f.b.c.f4200a;
                } else {
                    bVar = f.b.C0071b.f4199a;
                }
                if (!(!y8.k.a(bVar, f.b.c.f4200a))) {
                    bVar = null;
                }
                if (bVar != null) {
                    Iterator<db.h> it = fVar.T(fVar.a(pop)).iterator();
                    while (it.hasNext()) {
                        r02.add(bVar.a(fVar, it.next()));
                    }
                }
            }
        }
        fVar.m0();
        ArrayList arrayList = new ArrayList();
        for (db.i iVar3 : iVar2) {
            y8.k.d(iVar3, "it");
            m8.v.r(arrayList, f(fVar, iVar3, lVar));
        }
        return arrayList;
    }

    public final boolean m(f fVar, db.j jVar, db.i iVar) {
        int i10;
        int i11;
        boolean i12;
        int i13;
        boolean z10;
        int i14;
        Object obj;
        e eVar;
        f fVar2;
        db.h hVar;
        y8.k.e(fVar, "<this>");
        y8.k.e(jVar, "capturedSubArguments");
        y8.k.e(iVar, "superType");
        db.l a10 = fVar.a(iVar);
        int D = fVar.D(a10);
        if (D > 0) {
            int i15 = 0;
            while (true) {
                int i16 = i15 + 1;
                db.k f10 = fVar.f(iVar, i15);
                if (!fVar.x(f10)) {
                    db.h g10 = fVar.g(f10);
                    db.k c02 = fVar.c0(jVar, i15);
                    fVar.o(c02);
                    db.r rVar = db.r.INV;
                    db.h g11 = fVar.g(c02);
                    db.r h10 = h(fVar.Q(fVar.r(a10, i15)), fVar.o(f10));
                    if (h10 == null) {
                        return fVar.z0();
                    }
                    i10 = fVar.f4195a;
                    if (i10 > 100) {
                        throw new IllegalStateException(y8.k.j("Arguments depth is too high. Some related argument: ", g11).toString());
                    }
                    i11 = fVar.f4195a;
                    fVar.f4195a = i11 + 1;
                    int i17 = a.f4188a[h10.ordinal()];
                    if (i17 != 1) {
                        if (i17 == 2) {
                            z10 = false;
                            i14 = 8;
                            obj = null;
                            eVar = this;
                            fVar2 = fVar;
                            hVar = g11;
                        } else {
                            if (i17 != 3) {
                                throw new l8.l();
                            }
                            z10 = false;
                            i14 = 8;
                            obj = null;
                            eVar = this;
                            fVar2 = fVar;
                            hVar = g10;
                            g10 = g11;
                        }
                        i12 = o(eVar, fVar2, hVar, g10, z10, i14, obj);
                    } else {
                        i12 = i(fVar, g11, g10);
                    }
                    i13 = fVar.f4195a;
                    fVar.f4195a = i13 - 1;
                    if (!i12) {
                        return false;
                    }
                }
                if (i16 >= D) {
                    break;
                }
                i15 = i16;
            }
        }
        return true;
    }

    public final boolean n(f fVar, db.h hVar, db.h hVar2, boolean z10) {
        y8.k.e(fVar, "context");
        y8.k.e(hVar, "subType");
        y8.k.e(hVar2, "superType");
        if (hVar == hVar2) {
            return true;
        }
        if (fVar.n0(hVar, hVar2)) {
            return g(fVar, fVar.D0(fVar.E0(hVar)), fVar.D0(fVar.E0(hVar2)), z10);
        }
        return false;
    }
}
