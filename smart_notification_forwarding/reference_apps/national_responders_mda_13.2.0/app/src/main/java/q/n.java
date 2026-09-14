package q;

import p.e;
import q.f;
import q.p;

/* loaded from: classes.dex */
public class n extends p {

    /* renamed from: k, reason: collision with root package name */
    public f f13398k;

    /* renamed from: l, reason: collision with root package name */
    g f13399l;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13400a;

        static {
            int[] iArr = new int[p.b.values().length];
            f13400a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13400a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13400a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(p.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f13398k = fVar;
        this.f13399l = null;
        this.f13414h.f13381e = f.a.TOP;
        this.f13415i.f13381e = f.a.BOTTOM;
        fVar.f13381e = f.a.BASELINE;
        this.f13412f = 1;
    }

    @Override // q.p, q.d
    public void a(d dVar) {
        int i10;
        float t10;
        int i11 = a.f13400a[this.f13416j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            p.e eVar = this.f13408b;
            n(dVar, eVar.M, eVar.O, 1);
            return;
        }
        g gVar = this.f13411e;
        if (gVar.f13379c && !gVar.f13386j && this.f13410d == e.b.MATCH_CONSTRAINT) {
            p.e eVar2 = this.f13408b;
            int i12 = eVar2.f12981u;
            if (i12 == 2) {
                p.e I = eVar2.I();
                if (I != null) {
                    if (I.f12949e.f13411e.f13386j) {
                        i10 = (int) ((r7.f13383g * this.f13408b.B) + 0.5f);
                        this.f13411e.d(i10);
                    }
                }
            } else if (i12 == 3 && eVar2.f12947d.f13411e.f13386j) {
                int u10 = eVar2.u();
                if (u10 != -1) {
                    if (u10 == 0) {
                        t10 = r7.f12947d.f13411e.f13383g * this.f13408b.t();
                        i10 = (int) (t10 + 0.5f);
                        this.f13411e.d(i10);
                    } else if (u10 != 1) {
                        i10 = 0;
                        this.f13411e.d(i10);
                    }
                }
                t10 = r7.f12947d.f13411e.f13383g / this.f13408b.t();
                i10 = (int) (t10 + 0.5f);
                this.f13411e.d(i10);
            }
        }
        f fVar = this.f13414h;
        if (fVar.f13379c) {
            f fVar2 = this.f13415i;
            if (fVar2.f13379c) {
                if (fVar.f13386j && fVar2.f13386j && this.f13411e.f13386j) {
                    return;
                }
                if (!this.f13411e.f13386j && this.f13410d == e.b.MATCH_CONSTRAINT) {
                    p.e eVar3 = this.f13408b;
                    if (eVar3.f12979t == 0 && !eVar3.i0()) {
                        f fVar3 = this.f13414h.f13388l.get(0);
                        f fVar4 = this.f13415i.f13388l.get(0);
                        int i13 = fVar3.f13383g;
                        f fVar5 = this.f13414h;
                        int i14 = i13 + fVar5.f13382f;
                        int i15 = fVar4.f13383g + this.f13415i.f13382f;
                        fVar5.d(i14);
                        this.f13415i.d(i15);
                        this.f13411e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f13411e.f13386j && this.f13410d == e.b.MATCH_CONSTRAINT && this.f13407a == 1 && this.f13414h.f13388l.size() > 0 && this.f13415i.f13388l.size() > 0) {
                    f fVar6 = this.f13414h.f13388l.get(0);
                    int i16 = (this.f13415i.f13388l.get(0).f13383g + this.f13415i.f13382f) - (fVar6.f13383g + this.f13414h.f13382f);
                    g gVar2 = this.f13411e;
                    int i17 = gVar2.f13389m;
                    if (i16 < i17) {
                        gVar2.d(i16);
                    } else {
                        gVar2.d(i17);
                    }
                }
                if (this.f13411e.f13386j && this.f13414h.f13388l.size() > 0 && this.f13415i.f13388l.size() > 0) {
                    f fVar7 = this.f13414h.f13388l.get(0);
                    f fVar8 = this.f13415i.f13388l.get(0);
                    int i18 = fVar7.f13383g + this.f13414h.f13382f;
                    int i19 = fVar8.f13383g + this.f13415i.f13382f;
                    float P = this.f13408b.P();
                    if (fVar7 == fVar8) {
                        i18 = fVar7.f13383g;
                        i19 = fVar8.f13383g;
                        P = 0.5f;
                    }
                    this.f13414h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f13411e.f13383g) * P)));
                    this.f13415i.d(this.f13414h.f13383g + this.f13411e.f13383g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02e7, code lost:
    
        if (r9.f13408b.X() != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02e9, code lost:
    
        r0 = r9.f13398k;
        r1 = r9.f13414h;
        r2 = r9.f13399l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0342, code lost:
    
        if (r0.f13410d == r1) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03ed, code lost:
    
        r0.f13411e.f13387k.add(r9.f13411e);
        r9.f13411e.f13388l.add(r9.f13408b.f12947d.f13411e);
        r9.f13411e.f13377a = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0374, code lost:
    
        if (r9.f13408b.X() != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03eb, code lost:
    
        if (r0.f13410d == r1) goto L157;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    @Override // q.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.n.d():void");
    }

    @Override // q.p
    public void e() {
        f fVar = this.f13414h;
        if (fVar.f13386j) {
            this.f13408b.k1(fVar.f13383g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void f() {
        this.f13409c = null;
        this.f13414h.c();
        this.f13415i.c();
        this.f13398k.c();
        this.f13411e.c();
        this.f13413g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public boolean m() {
        return this.f13410d != e.b.MATCH_CONSTRAINT || this.f13408b.f12981u == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f13413g = false;
        this.f13414h.c();
        this.f13414h.f13386j = false;
        this.f13415i.c();
        this.f13415i.f13386j = false;
        this.f13398k.c();
        this.f13398k.f13386j = false;
        this.f13411e.f13386j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f13408b.r();
    }
}
