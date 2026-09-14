package m;

import java.util.Arrays;
import java.util.Comparator;
import m.b;

/* loaded from: classes.dex */
public class h extends m.b {

    /* renamed from: g, reason: collision with root package name */
    private int f11955g;

    /* renamed from: h, reason: collision with root package name */
    private i[] f11956h;

    /* renamed from: i, reason: collision with root package name */
    private i[] f11957i;

    /* renamed from: j, reason: collision with root package name */
    private int f11958j;

    /* renamed from: k, reason: collision with root package name */
    b f11959k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator<i> {
        a(h hVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f11965h - iVar2.f11965h;
        }
    }

    /* loaded from: classes.dex */
    class b {

        /* renamed from: a, reason: collision with root package name */
        i f11960a;

        public b(h hVar) {
        }

        public boolean a(i iVar, float f10) {
            boolean z10 = true;
            if (!this.f11960a.f11963f) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = iVar.f11971n[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f11960a.f11971n[i10] = f12;
                    } else {
                        this.f11960a.f11971n[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f11960a.f11971n;
                fArr[i11] = fArr[i11] + (iVar.f11971n[i11] * f10);
                if (Math.abs(fArr[i11]) < 1.0E-4f) {
                    this.f11960a.f11971n[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                h.this.G(this.f11960a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f11960a = iVar;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f11960a.f11971n[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = iVar.f11971n[i10];
                float f11 = this.f11960a.f11971n[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f11960a.f11971n, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f11960a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f11960a.f11971n[i10] + " ";
                }
            }
            return str + "] " + this.f11960a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f11955g = 128;
        this.f11956h = new i[128];
        this.f11957i = new i[128];
        this.f11958j = 0;
        this.f11959k = new b(this);
    }

    private final void F(i iVar) {
        int i10;
        int i11 = this.f11958j + 1;
        i[] iVarArr = this.f11956h;
        if (i11 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f11956h = iVarArr2;
            this.f11957i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f11956h;
        int i12 = this.f11958j;
        iVarArr3[i12] = iVar;
        int i13 = i12 + 1;
        this.f11958j = i13;
        if (i13 > 1 && iVarArr3[i13 - 1].f11965h > iVar.f11965h) {
            int i14 = 0;
            while (true) {
                i10 = this.f11958j;
                if (i14 >= i10) {
                    break;
                }
                this.f11957i[i14] = this.f11956h[i14];
                i14++;
            }
            Arrays.sort(this.f11957i, 0, i10, new a(this));
            for (int i15 = 0; i15 < this.f11958j; i15++) {
                this.f11956h[i15] = this.f11957i[i15];
            }
        }
        iVar.f11963f = true;
        iVar.j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i10 = 0;
        while (i10 < this.f11958j) {
            if (this.f11956h[i10] == iVar) {
                while (true) {
                    int i11 = this.f11958j;
                    if (i10 >= i11 - 1) {
                        this.f11958j = i11 - 1;
                        iVar.f11963f = false;
                        return;
                    } else {
                        i[] iVarArr = this.f11956h;
                        int i12 = i10 + 1;
                        iVarArr[i10] = iVarArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // m.b
    public void B(d dVar, m.b bVar, boolean z10) {
        i iVar = bVar.f11917a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f11921e;
        int e10 = aVar.e();
        for (int i10 = 0; i10 < e10; i10++) {
            i g10 = aVar.g(i10);
            float a10 = aVar.a(i10);
            this.f11959k.b(g10);
            if (this.f11959k.a(iVar, a10)) {
                F(g10);
            }
            this.f11918b += bVar.f11918b * a10;
        }
        G(iVar);
    }

    @Override // m.b, m.d.a
    public i a(d dVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f11958j; i11++) {
            i iVar = this.f11956h[i11];
            if (!zArr[iVar.f11965h]) {
                this.f11959k.b(iVar);
                b bVar = this.f11959k;
                if (i10 == -1) {
                    if (!bVar.c()) {
                    }
                    i10 = i11;
                } else {
                    if (!bVar.d(this.f11956h[i10])) {
                    }
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f11956h[i10];
    }

    @Override // m.b, m.d.a
    public void b(i iVar) {
        this.f11959k.b(iVar);
        this.f11959k.e();
        iVar.f11971n[iVar.f11967j] = 1.0f;
        F(iVar);
    }

    @Override // m.b, m.d.a
    public void clear() {
        this.f11958j = 0;
        this.f11918b = 0.0f;
    }

    @Override // m.b, m.d.a
    public boolean isEmpty() {
        return this.f11958j == 0;
    }

    @Override // m.b
    public String toString() {
        String str = " goal -> (" + this.f11918b + ") : ";
        for (int i10 = 0; i10 < this.f11958j; i10++) {
            this.f11959k.b(this.f11956h[i10]);
            str = str + this.f11959k + " ";
        }
        return str;
    }
}
