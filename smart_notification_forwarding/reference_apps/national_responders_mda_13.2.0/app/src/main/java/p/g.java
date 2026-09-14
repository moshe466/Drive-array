package p;

import p.d;
import p.e;

/* loaded from: classes.dex */
public class g extends e {
    private boolean B0;

    /* renamed from: w0, reason: collision with root package name */
    protected float f12993w0 = -1.0f;

    /* renamed from: x0, reason: collision with root package name */
    protected int f12994x0 = -1;

    /* renamed from: y0, reason: collision with root package name */
    protected int f12995y0 = -1;

    /* renamed from: z0, reason: collision with root package name */
    private d f12996z0 = this.M;
    private int A0 = 0;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12997a;

        static {
            int[] iArr = new int[d.b.values().length];
            f12997a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12997a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12997a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12997a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12997a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12997a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12997a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12997a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12997a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.U.clear();
        this.U.add(this.f12996z0);
        int length = this.T.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.T[i10] = this.f12996z0;
        }
    }

    @Override // p.e
    public void g(m.d dVar, boolean z10) {
        f fVar = (f) I();
        if (fVar == null) {
            return;
        }
        d m10 = fVar.m(d.b.LEFT);
        d m11 = fVar.m(d.b.RIGHT);
        e eVar = this.X;
        boolean z11 = eVar != null && eVar.W[0] == e.b.WRAP_CONTENT;
        if (this.A0 == 0) {
            m10 = fVar.m(d.b.TOP);
            m11 = fVar.m(d.b.BOTTOM);
            e eVar2 = this.X;
            z11 = eVar2 != null && eVar2.W[1] == e.b.WRAP_CONTENT;
        }
        if (this.B0 && this.f12996z0.m()) {
            m.i q10 = dVar.q(this.f12996z0);
            dVar.f(q10, this.f12996z0.d());
            if (this.f12994x0 != -1) {
                if (z11) {
                    dVar.h(dVar.q(m11), q10, 0, 5);
                }
            } else if (this.f12995y0 != -1 && z11) {
                m.i q11 = dVar.q(m11);
                dVar.h(q10, dVar.q(m10), 0, 5);
                dVar.h(q11, q10, 0, 5);
            }
            this.B0 = false;
            return;
        }
        if (this.f12994x0 != -1) {
            m.i q12 = dVar.q(this.f12996z0);
            dVar.e(q12, dVar.q(m10), this.f12994x0, 8);
            if (z11) {
                dVar.h(dVar.q(m11), q12, 0, 5);
                return;
            }
            return;
        }
        if (this.f12995y0 == -1) {
            if (this.f12993w0 != -1.0f) {
                dVar.d(m.d.s(dVar, dVar.q(this.f12996z0), dVar.q(m11), this.f12993w0));
                return;
            }
            return;
        }
        m.i q13 = dVar.q(this.f12996z0);
        m.i q14 = dVar.q(m11);
        dVar.e(q13, q14, -this.f12995y0, 8);
        if (z11) {
            dVar.h(q13, dVar.q(m10), 0, 5);
            dVar.h(q14, q13, 0, 5);
        }
    }

    @Override // p.e
    public boolean h() {
        return true;
    }

    @Override // p.e
    public boolean l0() {
        return this.B0;
    }

    @Override // p.e
    public d m(d.b bVar) {
        int i10 = a.f12997a[bVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.A0 == 1) {
                return this.f12996z0;
            }
            return null;
        }
        if ((i10 == 3 || i10 == 4) && this.A0 == 0) {
            return this.f12996z0;
        }
        return null;
    }

    @Override // p.e
    public boolean m0() {
        return this.B0;
    }

    @Override // p.e
    public void n1(m.d dVar, boolean z10) {
        if (I() == null) {
            return;
        }
        int x10 = dVar.x(this.f12996z0);
        if (this.A0 == 1) {
            j1(x10);
            k1(0);
            I0(I().v());
            h1(0);
            return;
        }
        j1(0);
        k1(x10);
        h1(I().U());
        I0(0);
    }

    public d o1() {
        return this.f12996z0;
    }

    public int p1() {
        return this.A0;
    }

    public int q1() {
        return this.f12994x0;
    }

    public int r1() {
        return this.f12995y0;
    }

    public float s1() {
        return this.f12993w0;
    }

    public void t1(int i10) {
        this.f12996z0.s(i10);
        this.B0 = true;
    }

    public void u1(int i10) {
        if (i10 > -1) {
            this.f12993w0 = -1.0f;
            this.f12994x0 = i10;
            this.f12995y0 = -1;
        }
    }

    public void v1(int i10) {
        if (i10 > -1) {
            this.f12993w0 = -1.0f;
            this.f12994x0 = -1;
            this.f12995y0 = i10;
        }
    }

    public void w1(float f10) {
        if (f10 > -1.0f) {
            this.f12993w0 = f10;
            this.f12994x0 = -1;
            this.f12995y0 = -1;
        }
    }

    public void x1(int i10) {
        if (this.A0 == i10) {
            return;
        }
        this.A0 = i10;
        this.U.clear();
        this.f12996z0 = this.A0 == 1 ? this.L : this.M;
        this.U.add(this.f12996z0);
        int length = this.T.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.T[i11] = this.f12996z0;
        }
    }
}
