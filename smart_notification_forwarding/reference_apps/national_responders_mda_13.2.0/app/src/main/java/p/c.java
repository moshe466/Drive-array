package p;

import java.util.ArrayList;
import p.e;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected e f12910a;

    /* renamed from: b, reason: collision with root package name */
    protected e f12911b;

    /* renamed from: c, reason: collision with root package name */
    protected e f12912c;

    /* renamed from: d, reason: collision with root package name */
    protected e f12913d;

    /* renamed from: e, reason: collision with root package name */
    protected e f12914e;

    /* renamed from: f, reason: collision with root package name */
    protected e f12915f;

    /* renamed from: g, reason: collision with root package name */
    protected e f12916g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f12917h;

    /* renamed from: i, reason: collision with root package name */
    protected int f12918i;

    /* renamed from: j, reason: collision with root package name */
    protected int f12919j;

    /* renamed from: k, reason: collision with root package name */
    protected float f12920k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f12921l;

    /* renamed from: m, reason: collision with root package name */
    int f12922m;

    /* renamed from: n, reason: collision with root package name */
    int f12923n;

    /* renamed from: o, reason: collision with root package name */
    private int f12924o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12925p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f12926q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f12927r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f12928s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12929t;

    public c(e eVar, int i10, boolean z10) {
        this.f12925p = false;
        this.f12910a = eVar;
        this.f12924o = i10;
        this.f12925p = z10;
    }

    private void b() {
        int i10 = this.f12924o * 2;
        e eVar = this.f12910a;
        boolean z10 = false;
        e eVar2 = eVar;
        boolean z11 = false;
        while (!z11) {
            this.f12918i++;
            e[] eVarArr = eVar.f12978s0;
            int i11 = this.f12924o;
            e eVar3 = null;
            eVarArr[i11] = null;
            eVar.f12976r0[i11] = null;
            if (eVar.T() != 8) {
                this.f12921l++;
                e.b s10 = eVar.s(this.f12924o);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (s10 != bVar) {
                    this.f12922m += eVar.C(this.f12924o);
                }
                int e10 = this.f12922m + eVar.T[i10].e();
                this.f12922m = e10;
                int i12 = i10 + 1;
                this.f12922m = e10 + eVar.T[i12].e();
                int e11 = this.f12923n + eVar.T[i10].e();
                this.f12923n = e11;
                this.f12923n = e11 + eVar.T[i12].e();
                if (this.f12911b == null) {
                    this.f12911b = eVar;
                }
                this.f12913d = eVar;
                e.b[] bVarArr = eVar.W;
                int i13 = this.f12924o;
                if (bVarArr[i13] == bVar) {
                    int[] iArr = eVar.f12983v;
                    if (iArr[i13] == 0 || iArr[i13] == 3 || iArr[i13] == 2) {
                        this.f12919j++;
                        float[] fArr = eVar.f12974q0;
                        float f10 = fArr[i13];
                        if (f10 > 0.0f) {
                            this.f12920k += fArr[i13];
                        }
                        if (c(eVar, i13)) {
                            if (f10 < 0.0f) {
                                this.f12926q = true;
                            } else {
                                this.f12927r = true;
                            }
                            if (this.f12917h == null) {
                                this.f12917h = new ArrayList<>();
                            }
                            this.f12917h.add(eVar);
                        }
                        if (this.f12915f == null) {
                            this.f12915f = eVar;
                        }
                        e eVar4 = this.f12916g;
                        if (eVar4 != null) {
                            eVar4.f12976r0[this.f12924o] = eVar;
                        }
                        this.f12916g = eVar;
                    }
                    if (this.f12924o == 0) {
                        if (eVar.f12979t == 0 && eVar.f12984w == 0) {
                            int i14 = eVar.f12985x;
                        }
                    } else if (eVar.f12981u == 0 && eVar.f12987z == 0) {
                        int i15 = eVar.A;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f12978s0[this.f12924o] = eVar;
            }
            d dVar = eVar.T[i10 + 1].f12935f;
            if (dVar != null) {
                e eVar5 = dVar.f12933d;
                d[] dVarArr = eVar5.T;
                if (dVarArr[i10].f12935f != null && dVarArr[i10].f12935f.f12933d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z11 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f12911b;
        if (eVar6 != null) {
            this.f12922m -= eVar6.T[i10].e();
        }
        e eVar7 = this.f12913d;
        if (eVar7 != null) {
            this.f12922m -= eVar7.T[i10 + 1].e();
        }
        this.f12912c = eVar;
        if (this.f12924o == 0 && this.f12925p) {
            this.f12914e = eVar;
        } else {
            this.f12914e = this.f12910a;
        }
        if (this.f12927r && this.f12926q) {
            z10 = true;
        }
        this.f12928s = z10;
    }

    private static boolean c(e eVar, int i10) {
        if (eVar.T() != 8 && eVar.W[i10] == e.b.MATCH_CONSTRAINT) {
            int[] iArr = eVar.f12983v;
            if (iArr[i10] == 0 || iArr[i10] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.f12929t) {
            b();
        }
        this.f12929t = true;
    }
}
