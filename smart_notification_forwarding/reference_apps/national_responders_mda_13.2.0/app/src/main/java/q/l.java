package q;

import java.util.List;
import p.d;
import p.e;
import q.f;
import q.p;

/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: k, reason: collision with root package name */
    private static int[] f13393k = new int[2];

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13394a;

        static {
            int[] iArr = new int[p.b.values().length];
            f13394a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13394a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13394a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(p.e eVar) {
        super(eVar);
        this.f13414h.f13381e = f.a.LEFT;
        this.f13415i.f13381e = f.a.RIGHT;
        this.f13412f = 0;
    }

    private void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0299, code lost:
    
        if (r14 != 1) goto L134;
     */
    @Override // q.p, q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(q.d r17) {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.l.a(q.d):void");
    }

    @Override // q.p
    void d() {
        p.e I;
        f fVar;
        f fVar2;
        int V;
        f fVar3;
        p.d dVar;
        List<d> list;
        d dVar2;
        f fVar4;
        f fVar5;
        f fVar6;
        int V2;
        f fVar7;
        f fVar8;
        int i10;
        p.e I2;
        p.e eVar = this.f13408b;
        if (eVar.f12941a) {
            this.f13411e.d(eVar.U());
        }
        if (this.f13411e.f13386j) {
            e.b bVar = this.f13410d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (I = this.f13408b.I()) != null && (I.y() == e.b.FIXED || I.y() == bVar2)) {
                b(this.f13414h, I.f12947d.f13414h, this.f13408b.L.e());
                b(this.f13415i, I.f12947d.f13415i, -this.f13408b.N.e());
                return;
            }
        } else {
            e.b y10 = this.f13408b.y();
            this.f13410d = y10;
            if (y10 != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (y10 == bVar3 && (I2 = this.f13408b.I()) != null && (I2.y() == e.b.FIXED || I2.y() == bVar3)) {
                    int U = (I2.U() - this.f13408b.L.e()) - this.f13408b.N.e();
                    b(this.f13414h, I2.f12947d.f13414h, this.f13408b.L.e());
                    b(this.f13415i, I2.f12947d.f13415i, -this.f13408b.N.e());
                    this.f13411e.d(U);
                    return;
                }
                if (this.f13410d == e.b.FIXED) {
                    this.f13411e.d(this.f13408b.U());
                }
            }
        }
        g gVar = this.f13411e;
        if (gVar.f13386j) {
            p.e eVar2 = this.f13408b;
            if (eVar2.f12941a) {
                p.d[] dVarArr = eVar2.T;
                if (dVarArr[0].f12935f != null && dVarArr[1].f12935f != null) {
                    if (eVar2.g0()) {
                        this.f13414h.f13382f = this.f13408b.T[0].e();
                        fVar3 = this.f13415i;
                        dVar = this.f13408b.T[1];
                        fVar3.f13382f = -dVar.e();
                        return;
                    }
                    f h10 = h(this.f13408b.T[0]);
                    if (h10 != null) {
                        b(this.f13414h, h10, this.f13408b.T[0].e());
                    }
                    f h11 = h(this.f13408b.T[1]);
                    if (h11 != null) {
                        b(this.f13415i, h11, -this.f13408b.T[1].e());
                    }
                    this.f13414h.f13378b = true;
                    this.f13415i.f13378b = true;
                    return;
                }
                if (dVarArr[0].f12935f != null) {
                    fVar5 = h(dVarArr[0]);
                    if (fVar5 == null) {
                        return;
                    }
                    fVar6 = this.f13414h;
                    V2 = this.f13408b.T[0].e();
                } else {
                    if (dVarArr[1].f12935f != null) {
                        f h12 = h(dVarArr[1]);
                        if (h12 != null) {
                            b(this.f13415i, h12, -this.f13408b.T[1].e());
                            fVar7 = this.f13414h;
                            fVar8 = this.f13415i;
                            i10 = -this.f13411e.f13383g;
                            b(fVar7, fVar8, i10);
                            return;
                        }
                        return;
                    }
                    if ((eVar2 instanceof p.h) || eVar2.I() == null || this.f13408b.m(d.b.CENTER).f12935f != null) {
                        return;
                    }
                    fVar5 = this.f13408b.I().f12947d.f13414h;
                    fVar6 = this.f13414h;
                    V2 = this.f13408b.V();
                }
                b(fVar6, fVar5, V2);
                fVar7 = this.f13415i;
                fVar8 = this.f13414h;
                i10 = this.f13411e.f13383g;
                b(fVar7, fVar8, i10);
                return;
            }
        }
        if (this.f13410d == e.b.MATCH_CONSTRAINT) {
            p.e eVar3 = this.f13408b;
            int i11 = eVar3.f12979t;
            if (i11 == 2) {
                p.e I3 = eVar3.I();
                if (I3 != null) {
                    g gVar2 = I3.f12949e.f13411e;
                    this.f13411e.f13388l.add(gVar2);
                    gVar2.f13387k.add(this.f13411e);
                    g gVar3 = this.f13411e;
                    gVar3.f13378b = true;
                    gVar3.f13387k.add(this.f13414h);
                    list = this.f13411e.f13387k;
                    dVar2 = this.f13415i;
                    list.add(dVar2);
                }
            } else if (i11 == 3) {
                if (eVar3.f12981u == 3) {
                    this.f13414h.f13377a = this;
                    this.f13415i.f13377a = this;
                    n nVar = eVar3.f12949e;
                    nVar.f13414h.f13377a = this;
                    nVar.f13415i.f13377a = this;
                    gVar.f13377a = this;
                    if (eVar3.i0()) {
                        this.f13411e.f13388l.add(this.f13408b.f12949e.f13411e);
                        this.f13408b.f12949e.f13411e.f13387k.add(this.f13411e);
                        n nVar2 = this.f13408b.f12949e;
                        nVar2.f13411e.f13377a = this;
                        this.f13411e.f13388l.add(nVar2.f13414h);
                        this.f13411e.f13388l.add(this.f13408b.f12949e.f13415i);
                        this.f13408b.f12949e.f13414h.f13387k.add(this.f13411e);
                        list = this.f13408b.f12949e.f13415i.f13387k;
                        dVar2 = this.f13411e;
                        list.add(dVar2);
                    } else if (this.f13408b.g0()) {
                        this.f13408b.f12949e.f13411e.f13388l.add(this.f13411e);
                        list = this.f13411e.f13387k;
                        dVar2 = this.f13408b.f12949e.f13411e;
                        list.add(dVar2);
                    } else {
                        fVar4 = this.f13408b.f12949e.f13411e;
                    }
                } else {
                    g gVar4 = eVar3.f12949e.f13411e;
                    gVar.f13388l.add(gVar4);
                    gVar4.f13387k.add(this.f13411e);
                    this.f13408b.f12949e.f13414h.f13387k.add(this.f13411e);
                    this.f13408b.f12949e.f13415i.f13387k.add(this.f13411e);
                    g gVar5 = this.f13411e;
                    gVar5.f13378b = true;
                    gVar5.f13387k.add(this.f13414h);
                    this.f13411e.f13387k.add(this.f13415i);
                    this.f13414h.f13388l.add(this.f13411e);
                    fVar4 = this.f13415i;
                }
                list = fVar4.f13388l;
                dVar2 = this.f13411e;
                list.add(dVar2);
            }
            fVar3.f13382f = -dVar.e();
            return;
        }
        p.e eVar4 = this.f13408b;
        p.d[] dVarArr2 = eVar4.T;
        if (dVarArr2[0].f12935f != null && dVarArr2[1].f12935f != null) {
            if (eVar4.g0()) {
                this.f13414h.f13382f = this.f13408b.T[0].e();
                fVar3 = this.f13415i;
                dVar = this.f13408b.T[1];
                fVar3.f13382f = -dVar.e();
                return;
            }
            f h13 = h(this.f13408b.T[0]);
            f h14 = h(this.f13408b.T[1]);
            if (h13 != null) {
                h13.b(this);
            }
            if (h14 != null) {
                h14.b(this);
            }
            this.f13416j = p.b.CENTER;
            return;
        }
        if (dVarArr2[0].f12935f != null) {
            fVar = h(dVarArr2[0]);
            if (fVar == null) {
                return;
            }
            fVar2 = this.f13414h;
            V = this.f13408b.T[0].e();
        } else {
            if (dVarArr2[1].f12935f != null) {
                f h15 = h(dVarArr2[1]);
                if (h15 != null) {
                    b(this.f13415i, h15, -this.f13408b.T[1].e());
                    c(this.f13414h, this.f13415i, -1, this.f13411e);
                    return;
                }
                return;
            }
            if ((eVar4 instanceof p.h) || eVar4.I() == null) {
                return;
            }
            fVar = this.f13408b.I().f12947d.f13414h;
            fVar2 = this.f13414h;
            V = this.f13408b.V();
        }
        b(fVar2, fVar, V);
        c(this.f13415i, this.f13414h, 1, this.f13411e);
    }

    @Override // q.p
    public void e() {
        f fVar = this.f13414h;
        if (fVar.f13386j) {
            this.f13408b.j1(fVar.f13383g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void f() {
        this.f13409c = null;
        this.f13414h.c();
        this.f13415i.c();
        this.f13411e.c();
        this.f13413g = false;
    }

    @Override // q.p
    boolean m() {
        return this.f13410d != e.b.MATCH_CONSTRAINT || this.f13408b.f12979t == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f13413g = false;
        this.f13414h.c();
        this.f13414h.f13386j = false;
        this.f13415i.c();
        this.f13415i.f13386j = false;
        this.f13411e.f13386j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f13408b.r();
    }
}
