package q;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p.e;
import q.b;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private p.f f13369a;

    /* renamed from: d, reason: collision with root package name */
    private p.f f13372d;

    /* renamed from: f, reason: collision with root package name */
    private b.InterfaceC0278b f13374f;

    /* renamed from: g, reason: collision with root package name */
    private b.a f13375g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<m> f13376h;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13370b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13371c = true;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<p> f13373e = new ArrayList<>();

    public e(p.f fVar) {
        new ArrayList();
        this.f13374f = null;
        this.f13375g = new b.a();
        this.f13376h = new ArrayList<>();
        this.f13369a = fVar;
        this.f13372d = fVar;
    }

    private void a(f fVar, int i10, int i11, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f13380d;
        if (pVar.f13409c == null) {
            p.f fVar3 = this.f13369a;
            if (pVar == fVar3.f12947d || pVar == fVar3.f12949e) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i11);
                arrayList.add(mVar);
            }
            pVar.f13409c = mVar;
            mVar.a(pVar);
            for (d dVar : pVar.f13414h.f13387k) {
                if (dVar instanceof f) {
                    a((f) dVar, i10, 0, fVar2, arrayList, mVar);
                }
            }
            for (d dVar2 : pVar.f13415i.f13387k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i10, 1, fVar2, arrayList, mVar);
                }
            }
            if (i10 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f13398k.f13387k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i10, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            Iterator<f> it = pVar.f13414h.f13388l.iterator();
            while (it.hasNext()) {
                a(it.next(), i10, 0, fVar2, arrayList, mVar);
            }
            Iterator<f> it2 = pVar.f13415i.f13388l.iterator();
            while (it2.hasNext()) {
                a(it2.next(), i10, 1, fVar2, arrayList, mVar);
            }
            if (i10 == 1 && (pVar instanceof n)) {
                Iterator<f> it3 = ((n) pVar).f13398k.f13388l.iterator();
                while (it3.hasNext()) {
                    a(it3.next(), i10, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if (r2.f12981u == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(p.f r17) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.b(p.f):boolean");
    }

    private int e(p.f fVar, int i10) {
        int size = this.f13376h.size();
        long j10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j10 = Math.max(j10, this.f13376h.get(i11).b(fVar, i10));
        }
        return (int) j10;
    }

    private void i(p pVar, int i10, ArrayList<m> arrayList) {
        for (d dVar : pVar.f13414h.f13387k) {
            if (dVar instanceof f) {
                a((f) dVar, i10, 0, pVar.f13415i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f13414h, i10, 0, pVar.f13415i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f13415i.f13387k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, 1, pVar.f13414h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f13415i, i10, 1, pVar.f13414h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((n) pVar).f13398k.f13387k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(p.e eVar, e.b bVar, int i10, e.b bVar2, int i11) {
        b.a aVar = this.f13375g;
        aVar.f13357a = bVar;
        aVar.f13358b = bVar2;
        aVar.f13359c = i10;
        aVar.f13360d = i11;
        this.f13374f.b(eVar, aVar);
        eVar.h1(this.f13375g.f13361e);
        eVar.I0(this.f13375g.f13362f);
        eVar.H0(this.f13375g.f13364h);
        eVar.x0(this.f13375g.f13363g);
    }

    public void c() {
        d(this.f13373e);
        this.f13376h.clear();
        m.f13395c = 0;
        i(this.f13369a.f12947d, 0, this.f13376h);
        i(this.f13369a.f12949e, 1, this.f13376h);
        this.f13370b = false;
    }

    public void d(ArrayList<p> arrayList) {
        p jVar;
        arrayList.clear();
        this.f13372d.f12947d.f();
        this.f13372d.f12949e.f();
        arrayList.add(this.f13372d.f12947d);
        arrayList.add(this.f13372d.f12949e);
        Iterator<p.e> it = this.f13372d.f13002w0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            p.e next = it.next();
            if (next instanceof p.g) {
                jVar = new j(next);
            } else {
                if (next.g0()) {
                    if (next.f12943b == null) {
                        next.f12943b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f12943b);
                } else {
                    arrayList.add(next.f12947d);
                }
                if (next.i0()) {
                    if (next.f12945c == null) {
                        next.f12945c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f12945c);
                } else {
                    arrayList.add(next.f12949e);
                }
                if (next instanceof p.i) {
                    jVar = new k(next);
                }
            }
            arrayList.add(jVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f13408b != this.f13372d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f13370b || this.f13371c) {
            Iterator<p.e> it = this.f13369a.f13002w0.iterator();
            while (it.hasNext()) {
                p.e next = it.next();
                next.l();
                next.f12941a = false;
                next.f12947d.r();
                next.f12949e.q();
            }
            this.f13369a.l();
            p.f fVar = this.f13369a;
            fVar.f12941a = false;
            fVar.f12947d.r();
            this.f13369a.f12949e.q();
            this.f13371c = false;
        }
        if (b(this.f13372d)) {
            return false;
        }
        this.f13369a.j1(0);
        this.f13369a.k1(0);
        e.b s10 = this.f13369a.s(0);
        e.b s11 = this.f13369a.s(1);
        if (this.f13370b) {
            c();
        }
        int V = this.f13369a.V();
        int W = this.f13369a.W();
        this.f13369a.f12947d.f13414h.d(V);
        this.f13369a.f12949e.f13414h.d(W);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (s10 == bVar || s11 == bVar) {
            if (z13) {
                Iterator<p> it2 = this.f13373e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().m()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && s10 == e.b.WRAP_CONTENT) {
                this.f13369a.M0(e.b.FIXED);
                p.f fVar2 = this.f13369a;
                fVar2.h1(e(fVar2, 0));
                p.f fVar3 = this.f13369a;
                fVar3.f12947d.f13411e.d(fVar3.U());
            }
            if (z13 && s11 == e.b.WRAP_CONTENT) {
                this.f13369a.d1(e.b.FIXED);
                p.f fVar4 = this.f13369a;
                fVar4.I0(e(fVar4, 1));
                p.f fVar5 = this.f13369a;
                fVar5.f12949e.f13411e.d(fVar5.v());
            }
        }
        p.f fVar6 = this.f13369a;
        e.b[] bVarArr = fVar6.W;
        e.b bVar2 = bVarArr[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == e.b.MATCH_PARENT) {
            int U = fVar6.U() + V;
            this.f13369a.f12947d.f13415i.d(U);
            this.f13369a.f12947d.f13411e.d(U - V);
            m();
            p.f fVar7 = this.f13369a;
            e.b[] bVarArr2 = fVar7.W;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == e.b.MATCH_PARENT) {
                int v10 = fVar7.v() + W;
                this.f13369a.f12949e.f13415i.d(v10);
                this.f13369a.f12949e.f13411e.d(v10 - W);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<p> it3 = this.f13373e.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f13408b != this.f13369a || next2.f13413g) {
                next2.e();
            }
        }
        Iterator<p> it4 = this.f13373e.iterator();
        while (it4.hasNext()) {
            p next3 = it4.next();
            if (z11 || next3.f13408b != this.f13369a) {
                if (!next3.f13414h.f13386j || ((!next3.f13415i.f13386j && !(next3 instanceof j)) || (!next3.f13411e.f13386j && !(next3 instanceof c) && !(next3 instanceof j)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f13369a.M0(s10);
        this.f13369a.d1(s11);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f13370b) {
            Iterator<p.e> it = this.f13369a.f13002w0.iterator();
            while (it.hasNext()) {
                p.e next = it.next();
                next.l();
                next.f12941a = false;
                l lVar = next.f12947d;
                lVar.f13411e.f13386j = false;
                lVar.f13413g = false;
                lVar.r();
                n nVar = next.f12949e;
                nVar.f13411e.f13386j = false;
                nVar.f13413g = false;
                nVar.q();
            }
            this.f13369a.l();
            p.f fVar = this.f13369a;
            fVar.f12941a = false;
            l lVar2 = fVar.f12947d;
            lVar2.f13411e.f13386j = false;
            lVar2.f13413g = false;
            lVar2.r();
            n nVar2 = this.f13369a.f12949e;
            nVar2.f13411e.f13386j = false;
            nVar2.f13413g = false;
            nVar2.q();
            c();
        }
        if (b(this.f13372d)) {
            return false;
        }
        this.f13369a.j1(0);
        this.f13369a.k1(0);
        this.f13369a.f12947d.f13414h.d(0);
        this.f13369a.f12949e.f13414h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        e.b bVar;
        g gVar;
        int v10;
        boolean z12 = true;
        boolean z13 = z10 & true;
        e.b s10 = this.f13369a.s(0);
        e.b s11 = this.f13369a.s(1);
        int V = this.f13369a.V();
        int W = this.f13369a.W();
        if (z13 && (s10 == (bVar = e.b.WRAP_CONTENT) || s11 == bVar)) {
            Iterator<p> it = this.f13373e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f13412f == i10 && !next.m()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && s10 == e.b.WRAP_CONTENT) {
                    this.f13369a.M0(e.b.FIXED);
                    p.f fVar = this.f13369a;
                    fVar.h1(e(fVar, 0));
                    p.f fVar2 = this.f13369a;
                    gVar = fVar2.f12947d.f13411e;
                    v10 = fVar2.U();
                    gVar.d(v10);
                }
            } else if (z13 && s11 == e.b.WRAP_CONTENT) {
                this.f13369a.d1(e.b.FIXED);
                p.f fVar3 = this.f13369a;
                fVar3.I0(e(fVar3, 1));
                p.f fVar4 = this.f13369a;
                gVar = fVar4.f12949e.f13411e;
                v10 = fVar4.v();
                gVar.d(v10);
            }
        }
        p.f fVar5 = this.f13369a;
        if (i10 == 0) {
            e.b[] bVarArr = fVar5.W;
            if (bVarArr[0] == e.b.FIXED || bVarArr[0] == e.b.MATCH_PARENT) {
                int U = fVar5.U() + V;
                this.f13369a.f12947d.f13415i.d(U);
                this.f13369a.f12947d.f13411e.d(U - V);
                z11 = true;
            }
            z11 = false;
        } else {
            e.b[] bVarArr2 = fVar5.W;
            if (bVarArr2[1] == e.b.FIXED || bVarArr2[1] == e.b.MATCH_PARENT) {
                int v11 = fVar5.v() + W;
                this.f13369a.f12949e.f13415i.d(v11);
                this.f13369a.f12949e.f13411e.d(v11 - W);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator<p> it2 = this.f13373e.iterator();
        while (it2.hasNext()) {
            p next2 = it2.next();
            if (next2.f13412f == i10 && (next2.f13408b != this.f13369a || next2.f13413g)) {
                next2.e();
            }
        }
        Iterator<p> it3 = this.f13373e.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.f13412f == i10 && (z11 || next3.f13408b != this.f13369a)) {
                if (!next3.f13414h.f13386j || !next3.f13415i.f13386j || (!(next3 instanceof c) && !next3.f13411e.f13386j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f13369a.M0(s10);
        this.f13369a.d1(s11);
        return z12;
    }

    public void j() {
        this.f13370b = true;
    }

    public void k() {
        this.f13371c = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0008 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m() {
        /*
            r12 = this;
            p.f r0 = r12.f13369a
            java.util.ArrayList<p.e> r0 = r0.f13002w0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lc1
            java.lang.Object r1 = r0.next()
            p.e r1 = (p.e) r1
            boolean r2 = r1.f12941a
            if (r2 == 0) goto L19
            goto L8
        L19:
            p.e$b[] r2 = r1.W
            r3 = 0
            r8 = r2[r3]
            r9 = 1
            r10 = r2[r9]
            int r2 = r1.f12979t
            int r4 = r1.f12981u
            p.e$b r6 = p.e.b.WRAP_CONTENT
            if (r8 == r6) goto L32
            p.e$b r5 = p.e.b.MATCH_CONSTRAINT
            if (r8 != r5) goto L30
            if (r2 != r9) goto L30
            goto L32
        L30:
            r2 = 0
            goto L33
        L32:
            r2 = 1
        L33:
            if (r10 == r6) goto L3b
            p.e$b r5 = p.e.b.MATCH_CONSTRAINT
            if (r10 != r5) goto L3c
            if (r4 != r9) goto L3c
        L3b:
            r3 = 1
        L3c:
            q.l r4 = r1.f12947d
            q.g r4 = r4.f13411e
            boolean r5 = r4.f13386j
            q.n r7 = r1.f12949e
            q.g r7 = r7.f13411e
            boolean r11 = r7.f13386j
            if (r5 == 0) goto L5b
            if (r11 == 0) goto L5b
            p.e$b r6 = p.e.b.FIXED
            int r5 = r4.f13383g
            int r7 = r7.f13383g
            r2 = r12
            r3 = r1
            r4 = r6
            r2.l(r3, r4, r5, r6, r7)
        L58:
            r1.f12941a = r9
            goto Lae
        L5b:
            if (r5 == 0) goto L87
            if (r3 == 0) goto L87
            p.e$b r5 = p.e.b.FIXED
            int r8 = r4.f13383g
            int r7 = r7.f13383g
            r2 = r12
            r3 = r1
            r4 = r5
            r5 = r8
            r2.l(r3, r4, r5, r6, r7)
            p.e$b r2 = p.e.b.MATCH_CONSTRAINT
            if (r10 != r2) goto L7b
            q.n r2 = r1.f12949e
            q.g r2 = r2.f13411e
            int r3 = r1.v()
        L78:
            r2.f13389m = r3
            goto Lae
        L7b:
            q.n r2 = r1.f12949e
            q.g r2 = r2.f13411e
            int r3 = r1.v()
        L83:
            r2.d(r3)
            goto L58
        L87:
            if (r11 == 0) goto Lae
            if (r2 == 0) goto Lae
            int r5 = r4.f13383g
            p.e$b r10 = p.e.b.FIXED
            int r7 = r7.f13383g
            r2 = r12
            r3 = r1
            r4 = r6
            r6 = r10
            r2.l(r3, r4, r5, r6, r7)
            p.e$b r2 = p.e.b.MATCH_CONSTRAINT
            if (r8 != r2) goto La5
            q.l r2 = r1.f12947d
            q.g r2 = r2.f13411e
            int r3 = r1.U()
            goto L78
        La5:
            q.l r2 = r1.f12947d
            q.g r2 = r2.f13411e
            int r3 = r1.U()
            goto L83
        Lae:
            boolean r2 = r1.f12941a
            if (r2 == 0) goto L8
            q.n r2 = r1.f12949e
            q.g r2 = r2.f13399l
            if (r2 == 0) goto L8
            int r1 = r1.n()
            r2.d(r1)
            goto L8
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.m():void");
    }

    public void n(b.InterfaceC0278b interfaceC0278b) {
        this.f13374f = interfaceC0278b;
    }
}
