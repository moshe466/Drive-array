package p;

import p.d;
import p.e;

/* loaded from: classes.dex */
public class a extends i {

    /* renamed from: y0, reason: collision with root package name */
    private int f12908y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f12909z0 = true;
    private int A0 = 0;
    boolean B0 = false;

    @Override // p.e
    public void g(m.d dVar, boolean z10) {
        d[] dVarArr;
        boolean z11;
        m.i iVar;
        d dVar2;
        int i10;
        int i11;
        int i12;
        m.i iVar2;
        int i13;
        d[] dVarArr2 = this.T;
        dVarArr2[0] = this.L;
        dVarArr2[2] = this.M;
        dVarArr2[1] = this.N;
        dVarArr2[3] = this.O;
        int i14 = 0;
        while (true) {
            dVarArr = this.T;
            if (i14 >= dVarArr.length) {
                break;
            }
            dVarArr[i14].f12938i = dVar.q(dVarArr[i14]);
            i14++;
        }
        int i15 = this.f12908y0;
        if (i15 < 0 || i15 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i15];
        if (!this.B0) {
            q1();
        }
        if (this.B0) {
            this.B0 = false;
            int i16 = this.f12908y0;
            if (i16 == 0 || i16 == 1) {
                dVar.f(this.L.f12938i, this.f12946c0);
                iVar2 = this.N.f12938i;
                i13 = this.f12946c0;
            } else {
                if (i16 != 2 && i16 != 3) {
                    return;
                }
                dVar.f(this.M.f12938i, this.f12948d0);
                iVar2 = this.O.f12938i;
                i13 = this.f12948d0;
            }
            dVar.f(iVar2, i13);
            return;
        }
        for (int i17 = 0; i17 < this.f12999x0; i17++) {
            e eVar = this.f12998w0[i17];
            if ((this.f12909z0 || eVar.h()) && ((((i11 = this.f12908y0) == 0 || i11 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.L.f12935f != null && eVar.N.f12935f != null) || (((i12 = this.f12908y0) == 2 || i12 == 3) && eVar.R() == e.b.MATCH_CONSTRAINT && eVar.M.f12935f != null && eVar.O.f12935f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.L.k() || this.N.k();
        boolean z13 = this.M.k() || this.O.k();
        int i18 = !z11 && (((i10 = this.f12908y0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13)))) ? 5 : 4;
        for (int i19 = 0; i19 < this.f12999x0; i19++) {
            e eVar2 = this.f12998w0[i19];
            if (this.f12909z0 || eVar2.h()) {
                m.i q10 = dVar.q(eVar2.T[this.f12908y0]);
                d[] dVarArr3 = eVar2.T;
                int i20 = this.f12908y0;
                dVarArr3[i20].f12938i = q10;
                int i21 = (dVarArr3[i20].f12935f == null || dVarArr3[i20].f12935f.f12933d != this) ? 0 : dVarArr3[i20].f12936g + 0;
                if (i20 == 0 || i20 == 2) {
                    dVar.i(dVar3.f12938i, q10, this.A0 - i21, z11);
                } else {
                    dVar.g(dVar3.f12938i, q10, this.A0 + i21, z11);
                }
                dVar.e(dVar3.f12938i, q10, this.A0 + i21, i18);
            }
        }
        int i22 = this.f12908y0;
        if (i22 == 0) {
            dVar.e(this.N.f12938i, this.L.f12938i, 0, 8);
            dVar.e(this.L.f12938i, this.X.N.f12938i, 0, 4);
            iVar = this.L.f12938i;
            dVar2 = this.X.L;
        } else if (i22 == 1) {
            dVar.e(this.L.f12938i, this.N.f12938i, 0, 8);
            dVar.e(this.L.f12938i, this.X.L.f12938i, 0, 4);
            iVar = this.L.f12938i;
            dVar2 = this.X.N;
        } else if (i22 == 2) {
            dVar.e(this.O.f12938i, this.M.f12938i, 0, 8);
            dVar.e(this.M.f12938i, this.X.O.f12938i, 0, 4);
            iVar = this.M.f12938i;
            dVar2 = this.X.M;
        } else {
            if (i22 != 3) {
                return;
            }
            dVar.e(this.M.f12938i, this.O.f12938i, 0, 8);
            dVar.e(this.M.f12938i, this.X.M.f12938i, 0, 4);
            iVar = this.M.f12938i;
            dVar2 = this.X.O;
        }
        dVar.e(iVar, dVar2.f12938i, 0, 0);
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
    public boolean m0() {
        return this.B0;
    }

    public boolean q1() {
        int i10;
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.f12999x0;
            if (i13 >= i10) {
                break;
            }
            e eVar = this.f12998w0[i13];
            if ((this.f12909z0 || eVar.h()) && ((((i11 = this.f12908y0) == 0 || i11 == 1) && !eVar.l0()) || (((i12 = this.f12908y0) == 2 || i12 == 3) && !eVar.m0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.f12999x0; i15++) {
            e eVar2 = this.f12998w0[i15];
            if (this.f12909z0 || eVar2.h()) {
                if (!z11) {
                    int i16 = this.f12908y0;
                    if (i16 == 0) {
                        bVar3 = d.b.LEFT;
                    } else if (i16 == 1) {
                        bVar3 = d.b.RIGHT;
                    } else if (i16 == 2) {
                        bVar3 = d.b.TOP;
                    } else {
                        if (i16 == 3) {
                            bVar3 = d.b.BOTTOM;
                        }
                        z11 = true;
                    }
                    i14 = eVar2.m(bVar3).d();
                    z11 = true;
                }
                int i17 = this.f12908y0;
                if (i17 == 0) {
                    bVar2 = d.b.LEFT;
                } else {
                    if (i17 == 1) {
                        bVar = d.b.RIGHT;
                    } else if (i17 == 2) {
                        bVar2 = d.b.TOP;
                    } else if (i17 == 3) {
                        bVar = d.b.BOTTOM;
                    }
                    i14 = Math.max(i14, eVar2.m(bVar).d());
                }
                i14 = Math.min(i14, eVar2.m(bVar2).d());
            }
        }
        int i18 = i14 + this.A0;
        int i19 = this.f12908y0;
        if (i19 == 0 || i19 == 1) {
            C0(i18, i18);
        } else {
            F0(i18, i18);
        }
        this.B0 = true;
        return true;
    }

    public boolean r1() {
        return this.f12909z0;
    }

    public int s1() {
        return this.f12908y0;
    }

    public int t1() {
        return this.A0;
    }

    @Override // p.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i10 = 0; i10 < this.f12999x0; i10++) {
            e eVar = this.f12998w0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }

    public int u1() {
        int i10 = this.f12908y0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v1() {
        for (int i10 = 0; i10 < this.f12999x0; i10++) {
            e eVar = this.f12998w0[i10];
            if (this.f12909z0 || eVar.h()) {
                int i11 = this.f12908y0;
                if (i11 == 0 || i11 == 1) {
                    eVar.P0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    eVar.P0(1, true);
                }
            }
        }
    }

    public void w1(boolean z10) {
        this.f12909z0 = z10;
    }

    public void x1(int i10) {
        this.f12908y0 = i10;
    }

    public void y1(int i10) {
        this.A0 = i10;
    }
}
