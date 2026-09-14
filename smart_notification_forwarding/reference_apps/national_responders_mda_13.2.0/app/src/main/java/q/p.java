package q;

import p.d;
import p.e;

/* loaded from: classes.dex */
public abstract class p implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f13407a;

    /* renamed from: b, reason: collision with root package name */
    p.e f13408b;

    /* renamed from: c, reason: collision with root package name */
    m f13409c;

    /* renamed from: d, reason: collision with root package name */
    protected e.b f13410d;

    /* renamed from: e, reason: collision with root package name */
    g f13411e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f13412f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f13413g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f13414h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f13415i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    protected b f13416j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13417a;

        static {
            int[] iArr = new int[d.b.values().length];
            f13417a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13417a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13417a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13417a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13417a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(p.e eVar) {
        this.f13408b = eVar;
    }

    private void l(int i10, int i11) {
        g gVar;
        int g10;
        int i12 = this.f13407a;
        if (i12 != 0) {
            if (i12 == 1) {
                int g11 = g(this.f13411e.f13389m, i10);
                gVar = this.f13411e;
                g10 = Math.min(g11, i11);
                gVar.d(g10);
            }
            if (i12 != 2) {
                if (i12 != 3) {
                    return;
                }
                p.e eVar = this.f13408b;
                p pVar = eVar.f12947d;
                e.b bVar = pVar.f13410d;
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && pVar.f13407a == 3) {
                    n nVar = eVar.f12949e;
                    if (nVar.f13410d == bVar2 && nVar.f13407a == 3) {
                        return;
                    }
                }
                if (i10 == 0) {
                    pVar = eVar.f12949e;
                }
                if (pVar.f13411e.f13386j) {
                    float t10 = eVar.t();
                    this.f13411e.d(i10 == 1 ? (int) ((pVar.f13411e.f13383g / t10) + 0.5f) : (int) ((t10 * pVar.f13411e.f13383g) + 0.5f));
                    return;
                }
                return;
            }
            p.e I = this.f13408b.I();
            if (I == null) {
                return;
            }
            if (!(i10 == 0 ? I.f12947d : I.f12949e).f13411e.f13386j) {
                return;
            }
            p.e eVar2 = this.f13408b;
            i11 = (int) ((r9.f13383g * (i10 == 0 ? eVar2.f12986y : eVar2.B)) + 0.5f);
        }
        gVar = this.f13411e;
        g10 = g(i11, i10);
        gVar.d(g10);
    }

    @Override // q.d
    public void a(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i10) {
        fVar.f13388l.add(fVar2);
        fVar.f13382f = i10;
        fVar2.f13387k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f13388l.add(fVar2);
        fVar.f13388l.add(this.f13411e);
        fVar.f13384h = i10;
        fVar.f13385i = gVar;
        fVar2.f13387k.add(fVar);
        gVar.f13387k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i10, int i11) {
        int max;
        if (i11 == 0) {
            p.e eVar = this.f13408b;
            int i12 = eVar.f12985x;
            max = Math.max(eVar.f12984w, i10);
            if (i12 > 0) {
                max = Math.min(i12, i10);
            }
            if (max == i10) {
                return i10;
            }
        } else {
            p.e eVar2 = this.f13408b;
            int i13 = eVar2.A;
            max = Math.max(eVar2.f12987z, i10);
            if (i13 > 0) {
                max = Math.min(i13, i10);
            }
            if (max == i10) {
                return i10;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(p.d dVar) {
        p pVar;
        p pVar2;
        p.d dVar2 = dVar.f12935f;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f12933d;
        int i10 = a.f13417a[dVar2.f12934e.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                pVar2 = eVar.f12947d;
            } else if (i10 == 3) {
                pVar = eVar.f12949e;
            } else {
                if (i10 == 4) {
                    return eVar.f12949e.f13398k;
                }
                if (i10 != 5) {
                    return null;
                }
                pVar2 = eVar.f12949e;
            }
            return pVar2.f13415i;
        }
        pVar = eVar.f12947d;
        return pVar.f13414h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(p.d dVar, int i10) {
        p.d dVar2 = dVar.f12935f;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f12933d;
        p pVar = i10 == 0 ? eVar.f12947d : eVar.f12949e;
        int i11 = a.f13417a[dVar2.f12934e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f13415i;
        }
        return pVar.f13414h;
    }

    public long j() {
        if (this.f13411e.f13386j) {
            return r0.f13383g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f13413g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, p.d dVar2, p.d dVar3, int i10) {
        f fVar;
        f h10 = h(dVar2);
        f h11 = h(dVar3);
        if (h10.f13386j && h11.f13386j) {
            int e10 = h10.f13383g + dVar2.e();
            int e11 = h11.f13383g - dVar3.e();
            int i11 = e11 - e10;
            if (!this.f13411e.f13386j && this.f13410d == e.b.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            g gVar = this.f13411e;
            if (gVar.f13386j) {
                if (gVar.f13383g == i11) {
                    this.f13414h.d(e10);
                    fVar = this.f13415i;
                } else {
                    p.e eVar = this.f13408b;
                    float w10 = i10 == 0 ? eVar.w() : eVar.P();
                    if (h10 == h11) {
                        e10 = h10.f13383g;
                        e11 = h11.f13383g;
                        w10 = 0.5f;
                    }
                    this.f13414h.d((int) (e10 + 0.5f + (((e11 - e10) - this.f13411e.f13383g) * w10)));
                    fVar = this.f13415i;
                    e11 = this.f13414h.f13383g + this.f13411e.f13383g;
                }
                fVar.d(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
