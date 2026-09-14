package m;

import java.util.ArrayList;
import m.d;
import m.i;

/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: c, reason: collision with root package name */
    boolean f11919c;

    /* renamed from: e, reason: collision with root package name */
    public a f11921e;

    /* renamed from: a, reason: collision with root package name */
    i f11917a = null;

    /* renamed from: b, reason: collision with root package name */
    float f11918b = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<i> f11920d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    boolean f11922f = false;

    /* loaded from: classes.dex */
    public interface a {
        float a(int i10);

        void b(i iVar, float f10, boolean z10);

        boolean c(i iVar);

        void clear();

        float d(i iVar);

        int e();

        void f(i iVar, float f10);

        i g(int i10);

        void h(float f10);

        float i(b bVar, boolean z10);

        float j(i iVar, boolean z10);

        void k();
    }

    public b() {
    }

    public b(c cVar) {
        this.f11921e = new m.a(this, cVar);
    }

    private boolean u(i iVar, d dVar) {
        return iVar.f11975r <= 1;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int e10 = this.f11921e.e();
        i iVar2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < e10; i10++) {
            float a10 = this.f11921e.a(i10);
            if (a10 < 0.0f) {
                i g10 = this.f11921e.g(i10);
                if ((zArr == null || !zArr[g10.f11965h]) && g10 != iVar && (((aVar = g10.f11972o) == i.a.SLACK || aVar == i.a.ERROR) && a10 < f10)) {
                    f10 = a10;
                    iVar2 = g10;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z10) {
        if (iVar == null || !iVar.f11969l) {
            return;
        }
        this.f11918b += iVar.f11968k * this.f11921e.d(iVar);
        this.f11921e.j(iVar, z10);
        if (z10) {
            iVar.n(this);
        }
        if (d.f11929t && this.f11921e.e() == 0) {
            this.f11922f = true;
            dVar.f11936a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f11918b += bVar.f11918b * this.f11921e.i(bVar, z10);
        if (z10) {
            bVar.f11917a.n(this);
        }
        if (d.f11929t && this.f11917a != null && this.f11921e.e() == 0) {
            this.f11922f = true;
            dVar.f11936a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z10) {
        if (iVar == null || !iVar.f11976s) {
            return;
        }
        float d10 = this.f11921e.d(iVar);
        this.f11918b += iVar.f11978u * d10;
        this.f11921e.j(iVar, z10);
        if (z10) {
            iVar.n(this);
        }
        this.f11921e.b(dVar.f11949n.f11926d[iVar.f11977t], d10, z10);
        if (d.f11929t && this.f11921e.e() == 0) {
            this.f11922f = true;
            dVar.f11936a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f11942g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int e10 = this.f11921e.e();
            for (int i10 = 0; i10 < e10; i10++) {
                i g10 = this.f11921e.g(i10);
                if (g10.f11966i != -1 || g10.f11969l || g10.f11976s) {
                    this.f11920d.add(g10);
                }
            }
            int size = this.f11920d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    i iVar = this.f11920d.get(i11);
                    if (iVar.f11969l) {
                        A(dVar, iVar, true);
                    } else if (iVar.f11976s) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f11942g[iVar.f11966i], true);
                    }
                }
                this.f11920d.clear();
            } else {
                z10 = true;
            }
        }
        if (d.f11929t && this.f11917a != null && this.f11921e.e() == 0) {
            this.f11922f = true;
            dVar.f11936a = true;
        }
    }

    @Override // m.d.a
    public i a(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // m.d.a
    public void b(i iVar) {
        int i10 = iVar.f11967j;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f11921e.f(iVar, f10);
    }

    @Override // m.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f11917a = null;
            this.f11921e.clear();
            for (int i10 = 0; i10 < bVar.f11921e.e(); i10++) {
                this.f11921e.b(bVar.f11921e.g(i10), bVar.f11921e.a(i10), true);
            }
        }
    }

    @Override // m.d.a
    public void clear() {
        this.f11921e.clear();
        this.f11917a = null;
        this.f11918b = 0.0f;
    }

    public b d(d dVar, int i10) {
        this.f11921e.f(dVar.o(i10, "ep"), 1.0f);
        this.f11921e.f(dVar.o(i10, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i10) {
        this.f11921e.f(iVar, i10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z10;
        i g10 = g(dVar);
        if (g10 == null) {
            z10 = true;
        } else {
            x(g10);
            z10 = false;
        }
        if (this.f11921e.e() == 0) {
            this.f11922f = true;
        }
        return z10;
    }

    i g(d dVar) {
        int e10 = this.f11921e.e();
        i iVar = null;
        i iVar2 = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < e10; i10++) {
            float a10 = this.f11921e.a(i10);
            i g10 = this.f11921e.g(i10);
            if (g10.f11972o == i.a.UNRESTRICTED) {
                if (iVar == null || f10 > a10) {
                    z10 = u(g10, dVar);
                    f10 = a10;
                    iVar = g10;
                } else if (!z10 && u(g10, dVar)) {
                    f10 = a10;
                    iVar = g10;
                    z10 = true;
                }
            } else if (iVar == null && a10 < 0.0f) {
                if (iVar2 == null || f11 > a10) {
                    z11 = u(g10, dVar);
                    f11 = a10;
                    iVar2 = g10;
                } else if (!z11 && u(g10, dVar)) {
                    f11 = a10;
                    iVar2 = g10;
                    z11 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // m.d.a
    public i getKey() {
        return this.f11917a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        float f11;
        int i12;
        if (iVar2 == iVar3) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar4, 1.0f);
            this.f11921e.f(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
            this.f11921e.f(iVar3, -1.0f);
            this.f11921e.f(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                i12 = (-i10) + i11;
                f11 = i12;
            }
            return this;
        }
        if (f10 <= 0.0f) {
            this.f11921e.f(iVar, -1.0f);
            this.f11921e.f(iVar2, 1.0f);
            f11 = i10;
        } else {
            if (f10 < 1.0f) {
                float f12 = 1.0f - f10;
                this.f11921e.f(iVar, f12 * 1.0f);
                this.f11921e.f(iVar2, f12 * (-1.0f));
                this.f11921e.f(iVar3, (-1.0f) * f10);
                this.f11921e.f(iVar4, 1.0f * f10);
                if (i10 > 0 || i11 > 0) {
                    f11 = ((-i10) * f12) + (i11 * f10);
                }
                return this;
            }
            this.f11921e.f(iVar4, -1.0f);
            this.f11921e.f(iVar3, 1.0f);
            i12 = -i11;
            f11 = i12;
        }
        this.f11918b = f11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, int i10) {
        this.f11917a = iVar;
        float f10 = i10;
        iVar.f11968k = f10;
        this.f11918b = f10;
        this.f11922f = true;
        return this;
    }

    @Override // m.d.a
    public boolean isEmpty() {
        return this.f11917a == null && this.f11918b == 0.0f && this.f11921e.e() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f10) {
        this.f11921e.f(iVar, -1.0f);
        this.f11921e.f(iVar2, f10);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f11921e.f(iVar, -1.0f);
        this.f11921e.f(iVar2, 1.0f);
        this.f11921e.f(iVar3, f10);
        this.f11921e.f(iVar4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f11918b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
            this.f11921e.f(iVar4, 1.0f);
            this.f11921e.f(iVar3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f11921e.f(iVar3, 1.0f);
            this.f11921e.f(iVar4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
            this.f11921e.f(iVar4, f13);
            this.f11921e.f(iVar3, -f13);
        }
        return this;
    }

    public b m(i iVar, int i10) {
        a aVar;
        float f10;
        if (i10 < 0) {
            this.f11918b = i10 * (-1);
            aVar = this.f11921e;
            f10 = 1.0f;
        } else {
            this.f11918b = i10;
            aVar = this.f11921e;
            f10 = -1.0f;
        }
        aVar.f(iVar, f10);
        return this;
    }

    public b n(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11918b = i10;
        }
        if (z10) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
        } else {
            this.f11921e.f(iVar, -1.0f);
            this.f11921e.f(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11918b = i10;
        }
        if (z10) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
            this.f11921e.f(iVar3, -1.0f);
        } else {
            this.f11921e.f(iVar, -1.0f);
            this.f11921e.f(iVar2, 1.0f);
            this.f11921e.f(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11918b = i10;
        }
        if (z10) {
            this.f11921e.f(iVar, 1.0f);
            this.f11921e.f(iVar2, -1.0f);
            this.f11921e.f(iVar3, 1.0f);
        } else {
            this.f11921e.f(iVar, -1.0f);
            this.f11921e.f(iVar2, 1.0f);
            this.f11921e.f(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f11921e.f(iVar3, 0.5f);
        this.f11921e.f(iVar4, 0.5f);
        this.f11921e.f(iVar, -0.5f);
        this.f11921e.f(iVar2, -0.5f);
        this.f11918b = -f10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f10 = this.f11918b;
        if (f10 < 0.0f) {
            this.f11918b = f10 * (-1.0f);
            this.f11921e.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.f11917a;
        return iVar != null && (iVar.f11972o == i.a.UNRESTRICTED || this.f11918b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f11921e.c(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(i iVar) {
        i iVar2 = this.f11917a;
        if (iVar2 != null) {
            this.f11921e.f(iVar2, -1.0f);
            this.f11917a.f11966i = -1;
            this.f11917a = null;
        }
        float j10 = this.f11921e.j(iVar, true) * (-1.0f);
        this.f11917a = iVar;
        if (j10 == 1.0f) {
            return;
        }
        this.f11918b /= j10;
        this.f11921e.h(j10);
    }

    public void y() {
        this.f11917a = null;
        this.f11921e.clear();
        this.f11918b = 0.0f;
        this.f11922f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String z() {
        /*
            r10 = this;
            m.i r0 = r10.f11917a
            java.lang.String r1 = ""
            if (r0 != 0) goto L14
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            goto L21
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            m.i r1 = r10.f11917a
            r0.append(r1)
        L21:
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f11918b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f11918b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L53
        L52:
            r1 = 0
        L53:
            m.b$a r5 = r10.f11921e
            int r5 = r5.e()
        L59:
            if (r2 >= r5) goto Ld2
            m.b$a r6 = r10.f11921e
            m.i r6 = r6.g(r2)
            if (r6 != 0) goto L64
            goto Lcf
        L64:
            m.b$a r7 = r10.f11921e
            float r7 = r7.a(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L6f
            goto Lcf
        L6f:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L86
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto Lab
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            goto La2
        L86:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            if (r8 <= 0) goto L9a
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto Lab
        L9a:
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
        La2:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r9
        Lab:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto Lb7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto Lc4
        Lb7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        Lc4:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            r1 = 1
        Lcf:
            int r2 = r2 + 1
            goto L59
        Ld2:
            if (r1 != 0) goto Le5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Le5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.b.z():java.lang.String");
    }
}
