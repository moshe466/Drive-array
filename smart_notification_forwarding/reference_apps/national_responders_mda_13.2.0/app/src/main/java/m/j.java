package m;

import java.util.Arrays;
import m.b;

/* loaded from: classes.dex */
public class j implements b.a {

    /* renamed from: m, reason: collision with root package name */
    private static float f11979m = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    private int f11980a = 16;

    /* renamed from: b, reason: collision with root package name */
    private int f11981b = 16;

    /* renamed from: c, reason: collision with root package name */
    int[] f11982c = new int[16];

    /* renamed from: d, reason: collision with root package name */
    int[] f11983d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    int[] f11984e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    float[] f11985f = new float[16];

    /* renamed from: g, reason: collision with root package name */
    int[] f11986g = new int[16];

    /* renamed from: h, reason: collision with root package name */
    int[] f11987h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    int f11988i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f11989j = -1;

    /* renamed from: k, reason: collision with root package name */
    private final b f11990k;

    /* renamed from: l, reason: collision with root package name */
    protected final c f11991l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, c cVar) {
        this.f11990k = bVar;
        this.f11991l = cVar;
        clear();
    }

    private void l(i iVar, int i10) {
        int[] iArr;
        int i11 = iVar.f11965h % this.f11981b;
        int[] iArr2 = this.f11982c;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f11983d;
                if (iArr[i12] == -1) {
                    break;
                } else {
                    i12 = iArr[i12];
                }
            }
            iArr[i12] = i10;
        }
        this.f11983d[i10] = -1;
    }

    private void m(int i10, i iVar, float f10) {
        this.f11984e[i10] = iVar.f11965h;
        this.f11985f[i10] = f10;
        this.f11986g[i10] = -1;
        this.f11987h[i10] = -1;
        iVar.j(this.f11990k);
        iVar.f11975r++;
        this.f11988i++;
    }

    private int n() {
        for (int i10 = 0; i10 < this.f11980a; i10++) {
            if (this.f11984e[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void o() {
        int i10 = this.f11980a * 2;
        this.f11984e = Arrays.copyOf(this.f11984e, i10);
        this.f11985f = Arrays.copyOf(this.f11985f, i10);
        this.f11986g = Arrays.copyOf(this.f11986g, i10);
        this.f11987h = Arrays.copyOf(this.f11987h, i10);
        this.f11983d = Arrays.copyOf(this.f11983d, i10);
        for (int i11 = this.f11980a; i11 < i10; i11++) {
            this.f11984e[i11] = -1;
            this.f11983d[i11] = -1;
        }
        this.f11980a = i10;
    }

    private void q(int i10, i iVar, float f10) {
        int n10 = n();
        m(n10, iVar, f10);
        if (i10 != -1) {
            this.f11986g[n10] = i10;
            int[] iArr = this.f11987h;
            iArr[n10] = iArr[i10];
            iArr[i10] = n10;
        } else {
            this.f11986g[n10] = -1;
            if (this.f11988i > 0) {
                this.f11987h[n10] = this.f11989j;
                this.f11989j = n10;
            } else {
                this.f11987h[n10] = -1;
            }
        }
        int[] iArr2 = this.f11987h;
        if (iArr2[n10] != -1) {
            this.f11986g[iArr2[n10]] = n10;
        }
        l(iVar, n10);
    }

    private void r(i iVar) {
        int[] iArr;
        int i10 = iVar.f11965h;
        int i11 = i10 % this.f11981b;
        int[] iArr2 = this.f11982c;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            return;
        }
        if (this.f11984e[i12] == i10) {
            int[] iArr3 = this.f11983d;
            iArr2[i11] = iArr3[i12];
            iArr3[i12] = -1;
            return;
        }
        while (true) {
            iArr = this.f11983d;
            if (iArr[i12] == -1 || this.f11984e[iArr[i12]] == i10) {
                break;
            } else {
                i12 = iArr[i12];
            }
        }
        int i13 = iArr[i12];
        if (i13 == -1 || this.f11984e[i13] != i10) {
            return;
        }
        iArr[i12] = iArr[i13];
        iArr[i13] = -1;
    }

    @Override // m.b.a
    public float a(int i10) {
        int i11 = this.f11988i;
        int i12 = this.f11989j;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f11985f[i12];
            }
            i12 = this.f11987h[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // m.b.a
    public void b(i iVar, float f10, boolean z10) {
        float f11 = f11979m;
        if (f10 <= (-f11) || f10 >= f11) {
            int p10 = p(iVar);
            if (p10 == -1) {
                f(iVar, f10);
                return;
            }
            float[] fArr = this.f11985f;
            fArr[p10] = fArr[p10] + f10;
            float f12 = fArr[p10];
            float f13 = f11979m;
            if (f12 <= (-f13) || fArr[p10] >= f13) {
                return;
            }
            fArr[p10] = 0.0f;
            j(iVar, z10);
        }
    }

    @Override // m.b.a
    public boolean c(i iVar) {
        return p(iVar) != -1;
    }

    @Override // m.b.a
    public void clear() {
        int i10 = this.f11988i;
        for (int i11 = 0; i11 < i10; i11++) {
            i g10 = g(i11);
            if (g10 != null) {
                g10.n(this.f11990k);
            }
        }
        for (int i12 = 0; i12 < this.f11980a; i12++) {
            this.f11984e[i12] = -1;
            this.f11983d[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f11981b; i13++) {
            this.f11982c[i13] = -1;
        }
        this.f11988i = 0;
        this.f11989j = -1;
    }

    @Override // m.b.a
    public float d(i iVar) {
        int p10 = p(iVar);
        if (p10 != -1) {
            return this.f11985f[p10];
        }
        return 0.0f;
    }

    @Override // m.b.a
    public int e() {
        return this.f11988i;
    }

    @Override // m.b.a
    public void f(i iVar, float f10) {
        float f11 = f11979m;
        if (f10 > (-f11) && f10 < f11) {
            j(iVar, true);
            return;
        }
        if (this.f11988i == 0) {
            m(0, iVar, f10);
            l(iVar, 0);
            this.f11989j = 0;
            return;
        }
        int p10 = p(iVar);
        if (p10 != -1) {
            this.f11985f[p10] = f10;
            return;
        }
        if (this.f11988i + 1 >= this.f11980a) {
            o();
        }
        int i10 = this.f11988i;
        int i11 = this.f11989j;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int[] iArr = this.f11984e;
            int i14 = iArr[i11];
            int i15 = iVar.f11965h;
            if (i14 == i15) {
                this.f11985f[i11] = f10;
                return;
            }
            if (iArr[i11] < i15) {
                i12 = i11;
            }
            i11 = this.f11987h[i11];
            if (i11 == -1) {
                break;
            }
        }
        q(i12, iVar, f10);
    }

    @Override // m.b.a
    public i g(int i10) {
        int i11 = this.f11988i;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f11989j;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f11991l.f11926d[this.f11984e[i12]];
            }
            i12 = this.f11987h[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // m.b.a
    public void h(float f10) {
        int i10 = this.f11988i;
        int i11 = this.f11989j;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f11985f;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f11987h[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // m.b.a
    public float i(b bVar, boolean z10) {
        float d10 = d(bVar.f11917a);
        j(bVar.f11917a, z10);
        j jVar = (j) bVar.f11921e;
        int e10 = jVar.e();
        int i10 = 0;
        int i11 = 0;
        while (i10 < e10) {
            int[] iArr = jVar.f11984e;
            if (iArr[i11] != -1) {
                b(this.f11991l.f11926d[iArr[i11]], jVar.f11985f[i11] * d10, z10);
                i10++;
            }
            i11++;
        }
        return d10;
    }

    @Override // m.b.a
    public float j(i iVar, boolean z10) {
        int p10 = p(iVar);
        if (p10 == -1) {
            return 0.0f;
        }
        r(iVar);
        float f10 = this.f11985f[p10];
        if (this.f11989j == p10) {
            this.f11989j = this.f11987h[p10];
        }
        this.f11984e[p10] = -1;
        int[] iArr = this.f11986g;
        if (iArr[p10] != -1) {
            int[] iArr2 = this.f11987h;
            iArr2[iArr[p10]] = iArr2[p10];
        }
        int[] iArr3 = this.f11987h;
        if (iArr3[p10] != -1) {
            iArr[iArr3[p10]] = iArr[p10];
        }
        this.f11988i--;
        iVar.f11975r--;
        if (z10) {
            iVar.n(this.f11990k);
        }
        return f10;
    }

    @Override // m.b.a
    public void k() {
        int i10 = this.f11988i;
        int i11 = this.f11989j;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f11985f;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f11987h[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public int p(i iVar) {
        int[] iArr;
        if (this.f11988i != 0 && iVar != null) {
            int i10 = iVar.f11965h;
            int i11 = this.f11982c[i10 % this.f11981b];
            if (i11 == -1) {
                return -1;
            }
            if (this.f11984e[i11] == i10) {
                return i11;
            }
            while (true) {
                iArr = this.f11983d;
                if (iArr[i11] == -1 || this.f11984e[iArr[i11]] == i10) {
                    break;
                }
                i11 = iArr[i11];
            }
            if (iArr[i11] != -1 && this.f11984e[iArr[i11]] == i10) {
                return iArr[i11];
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb2;
        String str = hashCode() + " { ";
        int i10 = this.f11988i;
        for (int i11 = 0; i11 < i10; i11++) {
            i g10 = g(i11);
            if (g10 != null) {
                String str2 = str + g10 + " = " + a(i11) + " ";
                int p10 = p(g10);
                String str3 = str2 + "[p: ";
                if (this.f11986g[p10] != -1) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(this.f11991l.f11926d[this.f11984e[this.f11986g[p10]]]);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append("none");
                }
                String str4 = sb2.toString() + ", n: ";
                str = (this.f11987h[p10] != -1 ? str4 + this.f11991l.f11926d[this.f11984e[this.f11987h[p10]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
