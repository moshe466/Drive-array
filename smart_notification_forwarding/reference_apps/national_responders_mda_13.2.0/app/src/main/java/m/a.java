package m;

import java.util.Arrays;
import m.b;

/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    private static float f11905l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final b f11907b;

    /* renamed from: c, reason: collision with root package name */
    protected final c f11908c;

    /* renamed from: a, reason: collision with root package name */
    int f11906a = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f11909d = 8;

    /* renamed from: e, reason: collision with root package name */
    private i f11910e = null;

    /* renamed from: f, reason: collision with root package name */
    private int[] f11911f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    private int[] f11912g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    private float[] f11913h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private int f11914i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f11915j = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11916k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f11907b = bVar;
        this.f11908c = cVar;
    }

    @Override // m.b.a
    public float a(int i10) {
        int i11 = this.f11914i;
        for (int i12 = 0; i11 != -1 && i12 < this.f11906a; i12++) {
            if (i12 == i10) {
                return this.f11913h[i11];
            }
            i11 = this.f11912g[i11];
        }
        return 0.0f;
    }

    @Override // m.b.a
    public void b(i iVar, float f10, boolean z10) {
        float f11 = f11905l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f11914i;
            if (i10 == -1) {
                this.f11914i = 0;
                this.f11913h[0] = f10;
                this.f11911f[0] = iVar.f11965h;
                this.f11912g[0] = -1;
                iVar.f11975r++;
                iVar.j(this.f11907b);
                this.f11906a++;
                if (this.f11916k) {
                    return;
                }
                int i11 = this.f11915j + 1;
                this.f11915j = i11;
                int[] iArr = this.f11911f;
                if (i11 >= iArr.length) {
                    this.f11916k = true;
                    this.f11915j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f11906a; i13++) {
                int[] iArr2 = this.f11911f;
                int i14 = iArr2[i10];
                int i15 = iVar.f11965h;
                if (i14 == i15) {
                    float[] fArr = this.f11913h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f11905l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f11914i) {
                            this.f11914i = this.f11912g[i10];
                        } else {
                            int[] iArr3 = this.f11912g;
                            iArr3[i12] = iArr3[i10];
                        }
                        if (z10) {
                            iVar.n(this.f11907b);
                        }
                        if (this.f11916k) {
                            this.f11915j = i10;
                        }
                        iVar.f11975r--;
                        this.f11906a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i10] < i15) {
                    i12 = i10;
                }
                i10 = this.f11912g[i10];
            }
            int i16 = this.f11915j;
            int i17 = i16 + 1;
            if (this.f11916k) {
                int[] iArr4 = this.f11911f;
                if (iArr4[i16] != -1) {
                    i16 = iArr4.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr5 = this.f11911f;
            if (i16 >= iArr5.length && this.f11906a < iArr5.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr6 = this.f11911f;
                    if (i18 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i18] == -1) {
                        i16 = i18;
                        break;
                    }
                    i18++;
                }
            }
            int[] iArr7 = this.f11911f;
            if (i16 >= iArr7.length) {
                i16 = iArr7.length;
                int i19 = this.f11909d * 2;
                this.f11909d = i19;
                this.f11916k = false;
                this.f11915j = i16 - 1;
                this.f11913h = Arrays.copyOf(this.f11913h, i19);
                this.f11911f = Arrays.copyOf(this.f11911f, this.f11909d);
                this.f11912g = Arrays.copyOf(this.f11912g, this.f11909d);
            }
            this.f11911f[i16] = iVar.f11965h;
            this.f11913h[i16] = f10;
            int[] iArr8 = this.f11912g;
            if (i12 != -1) {
                iArr8[i16] = iArr8[i12];
                iArr8[i12] = i16;
            } else {
                iArr8[i16] = this.f11914i;
                this.f11914i = i16;
            }
            iVar.f11975r++;
            iVar.j(this.f11907b);
            this.f11906a++;
            if (!this.f11916k) {
                this.f11915j++;
            }
            int i20 = this.f11915j;
            int[] iArr9 = this.f11911f;
            if (i20 >= iArr9.length) {
                this.f11916k = true;
                this.f11915j = iArr9.length - 1;
            }
        }
    }

    @Override // m.b.a
    public boolean c(i iVar) {
        int i10 = this.f11914i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            if (this.f11911f[i10] == iVar.f11965h) {
                return true;
            }
            i10 = this.f11912g[i10];
        }
        return false;
    }

    @Override // m.b.a
    public final void clear() {
        int i10 = this.f11914i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            i iVar = this.f11908c.f11926d[this.f11911f[i10]];
            if (iVar != null) {
                iVar.n(this.f11907b);
            }
            i10 = this.f11912g[i10];
        }
        this.f11914i = -1;
        this.f11915j = -1;
        this.f11916k = false;
        this.f11906a = 0;
    }

    @Override // m.b.a
    public final float d(i iVar) {
        int i10 = this.f11914i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            if (this.f11911f[i10] == iVar.f11965h) {
                return this.f11913h[i10];
            }
            i10 = this.f11912g[i10];
        }
        return 0.0f;
    }

    @Override // m.b.a
    public int e() {
        return this.f11906a;
    }

    @Override // m.b.a
    public final void f(i iVar, float f10) {
        if (f10 == 0.0f) {
            j(iVar, true);
            return;
        }
        int i10 = this.f11914i;
        if (i10 == -1) {
            this.f11914i = 0;
            this.f11913h[0] = f10;
            this.f11911f[0] = iVar.f11965h;
            this.f11912g[0] = -1;
            iVar.f11975r++;
            iVar.j(this.f11907b);
            this.f11906a++;
            if (this.f11916k) {
                return;
            }
            int i11 = this.f11915j + 1;
            this.f11915j = i11;
            int[] iArr = this.f11911f;
            if (i11 >= iArr.length) {
                this.f11916k = true;
                this.f11915j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f11906a; i13++) {
            int[] iArr2 = this.f11911f;
            int i14 = iArr2[i10];
            int i15 = iVar.f11965h;
            if (i14 == i15) {
                this.f11913h[i10] = f10;
                return;
            }
            if (iArr2[i10] < i15) {
                i12 = i10;
            }
            i10 = this.f11912g[i10];
        }
        int i16 = this.f11915j;
        int i17 = i16 + 1;
        if (this.f11916k) {
            int[] iArr3 = this.f11911f;
            if (iArr3[i16] != -1) {
                i16 = iArr3.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr4 = this.f11911f;
        if (i16 >= iArr4.length && this.f11906a < iArr4.length) {
            int i18 = 0;
            while (true) {
                int[] iArr5 = this.f11911f;
                if (i18 >= iArr5.length) {
                    break;
                }
                if (iArr5[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr6 = this.f11911f;
        if (i16 >= iArr6.length) {
            i16 = iArr6.length;
            int i19 = this.f11909d * 2;
            this.f11909d = i19;
            this.f11916k = false;
            this.f11915j = i16 - 1;
            this.f11913h = Arrays.copyOf(this.f11913h, i19);
            this.f11911f = Arrays.copyOf(this.f11911f, this.f11909d);
            this.f11912g = Arrays.copyOf(this.f11912g, this.f11909d);
        }
        this.f11911f[i16] = iVar.f11965h;
        this.f11913h[i16] = f10;
        int[] iArr7 = this.f11912g;
        if (i12 != -1) {
            iArr7[i16] = iArr7[i12];
            iArr7[i12] = i16;
        } else {
            iArr7[i16] = this.f11914i;
            this.f11914i = i16;
        }
        iVar.f11975r++;
        iVar.j(this.f11907b);
        int i20 = this.f11906a + 1;
        this.f11906a = i20;
        if (!this.f11916k) {
            this.f11915j++;
        }
        int[] iArr8 = this.f11911f;
        if (i20 >= iArr8.length) {
            this.f11916k = true;
        }
        if (this.f11915j >= iArr8.length) {
            this.f11916k = true;
            this.f11915j = iArr8.length - 1;
        }
    }

    @Override // m.b.a
    public i g(int i10) {
        int i11 = this.f11914i;
        for (int i12 = 0; i11 != -1 && i12 < this.f11906a; i12++) {
            if (i12 == i10) {
                return this.f11908c.f11926d[this.f11911f[i11]];
            }
            i11 = this.f11912g[i11];
        }
        return null;
    }

    @Override // m.b.a
    public void h(float f10) {
        int i10 = this.f11914i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            float[] fArr = this.f11913h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f11912g[i10];
        }
    }

    @Override // m.b.a
    public float i(b bVar, boolean z10) {
        float d10 = d(bVar.f11917a);
        j(bVar.f11917a, z10);
        b.a aVar = bVar.f11921e;
        int e10 = aVar.e();
        for (int i10 = 0; i10 < e10; i10++) {
            i g10 = aVar.g(i10);
            b(g10, aVar.d(g10) * d10, z10);
        }
        return d10;
    }

    @Override // m.b.a
    public final float j(i iVar, boolean z10) {
        if (this.f11910e == iVar) {
            this.f11910e = null;
        }
        int i10 = this.f11914i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f11906a) {
            if (this.f11911f[i10] == iVar.f11965h) {
                if (i10 == this.f11914i) {
                    this.f11914i = this.f11912g[i10];
                } else {
                    int[] iArr = this.f11912g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.n(this.f11907b);
                }
                iVar.f11975r--;
                this.f11906a--;
                this.f11911f[i10] = -1;
                if (this.f11916k) {
                    this.f11915j = i10;
                }
                return this.f11913h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f11912g[i10];
        }
        return 0.0f;
    }

    @Override // m.b.a
    public void k() {
        int i10 = this.f11914i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            float[] fArr = this.f11913h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f11912g[i10];
        }
    }

    public String toString() {
        int i10 = this.f11914i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f11906a; i11++) {
            str = ((str + " -> ") + this.f11913h[i10] + " : ") + this.f11908c.f11926d[this.f11911f[i10]];
            i10 = this.f11912g[i10];
        }
        return str;
    }
}
