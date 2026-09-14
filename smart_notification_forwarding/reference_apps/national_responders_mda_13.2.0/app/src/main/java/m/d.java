package m;

import java.util.Arrays;
import java.util.HashMap;
import m.i;
import p.d;

/* loaded from: classes.dex */
public class d {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f11927r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f11928s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f11929t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f11930u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f11931v = false;

    /* renamed from: w, reason: collision with root package name */
    private static int f11932w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static e f11933x;

    /* renamed from: y, reason: collision with root package name */
    public static long f11934y;

    /* renamed from: z, reason: collision with root package name */
    public static long f11935z;

    /* renamed from: d, reason: collision with root package name */
    private a f11939d;

    /* renamed from: g, reason: collision with root package name */
    m.b[] f11942g;

    /* renamed from: n, reason: collision with root package name */
    final c f11949n;

    /* renamed from: q, reason: collision with root package name */
    private a f11952q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11936a = false;

    /* renamed from: b, reason: collision with root package name */
    int f11937b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, i> f11938c = null;

    /* renamed from: e, reason: collision with root package name */
    private int f11940e = 32;

    /* renamed from: f, reason: collision with root package name */
    private int f11941f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11943h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11944i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean[] f11945j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    int f11946k = 1;

    /* renamed from: l, reason: collision with root package name */
    int f11947l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f11948m = 32;

    /* renamed from: o, reason: collision with root package name */
    private i[] f11950o = new i[f11932w];

    /* renamed from: p, reason: collision with root package name */
    private int f11951p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        i a(d dVar, boolean[] zArr);

        void b(i iVar);

        void c(a aVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends m.b {
        public b(d dVar, c cVar) {
            this.f11921e = new j(this, cVar);
        }
    }

    public d() {
        this.f11942g = null;
        this.f11942g = new m.b[32];
        C();
        c cVar = new c();
        this.f11949n = cVar;
        this.f11939d = new h(cVar);
        this.f11952q = f11931v ? new b(this, cVar) : new m.b(cVar);
    }

    private final int B(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f11946k; i10++) {
            this.f11945j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f11946k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f11945j[aVar.getKey().f11965h] = true;
            }
            i a10 = aVar.a(this, this.f11945j);
            if (a10 != null) {
                boolean[] zArr = this.f11945j;
                int i12 = a10.f11965h;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (a10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f11947l; i14++) {
                    m.b bVar = this.f11942g[i14];
                    if (bVar.f11917a.f11972o != i.a.UNRESTRICTED && !bVar.f11922f && bVar.t(a10)) {
                        float d10 = bVar.f11921e.d(a10);
                        if (d10 < 0.0f) {
                            float f11 = (-bVar.f11918b) / d10;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    m.b bVar2 = this.f11942g[i13];
                    bVar2.f11917a.f11966i = -1;
                    bVar2.x(a10);
                    i iVar = bVar2.f11917a;
                    iVar.f11966i = i13;
                    iVar.t(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    private void C() {
        int i10 = 0;
        if (f11931v) {
            while (i10 < this.f11947l) {
                m.b bVar = this.f11942g[i10];
                if (bVar != null) {
                    this.f11949n.f11923a.a(bVar);
                }
                this.f11942g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f11947l) {
            m.b bVar2 = this.f11942g[i10];
            if (bVar2 != null) {
                this.f11949n.f11924b.a(bVar2);
            }
            this.f11942g[i10] = null;
            i10++;
        }
    }

    private i a(i.a aVar, String str) {
        i b10 = this.f11949n.f11925c.b();
        if (b10 == null) {
            b10 = new i(aVar, str);
        } else {
            b10.o();
        }
        b10.s(aVar, str);
        int i10 = this.f11951p;
        int i11 = f11932w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f11932w = i12;
            this.f11950o = (i[]) Arrays.copyOf(this.f11950o, i12);
        }
        i[] iVarArr = this.f11950o;
        int i13 = this.f11951p;
        this.f11951p = i13 + 1;
        iVarArr[i13] = b10;
        return b10;
    }

    private final void l(m.b bVar) {
        int i10;
        if (f11929t && bVar.f11922f) {
            bVar.f11917a.r(this, bVar.f11918b);
        } else {
            m.b[] bVarArr = this.f11942g;
            int i11 = this.f11947l;
            bVarArr[i11] = bVar;
            i iVar = bVar.f11917a;
            iVar.f11966i = i11;
            this.f11947l = i11 + 1;
            iVar.t(this, bVar);
        }
        if (f11929t && this.f11936a) {
            int i12 = 0;
            while (i12 < this.f11947l) {
                if (this.f11942g[i12] == null) {
                    System.out.println("WTF");
                }
                m.b[] bVarArr2 = this.f11942g;
                if (bVarArr2[i12] != null && bVarArr2[i12].f11922f) {
                    m.b bVar2 = bVarArr2[i12];
                    bVar2.f11917a.r(this, bVar2.f11918b);
                    (f11931v ? this.f11949n.f11923a : this.f11949n.f11924b).a(bVar2);
                    this.f11942g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f11947l;
                        if (i13 >= i10) {
                            break;
                        }
                        m.b[] bVarArr3 = this.f11942g;
                        int i15 = i13 - 1;
                        bVarArr3[i15] = bVarArr3[i13];
                        if (bVarArr3[i15].f11917a.f11966i == i13) {
                            bVarArr3[i15].f11917a.f11966i = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f11942g[i14] = null;
                    }
                    this.f11947l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f11936a = false;
        }
    }

    private void n() {
        for (int i10 = 0; i10 < this.f11947l; i10++) {
            m.b bVar = this.f11942g[i10];
            bVar.f11917a.f11968k = bVar.f11918b;
        }
    }

    public static m.b s(d dVar, i iVar, i iVar2, float f10) {
        return dVar.r().j(iVar, iVar2, f10);
    }

    private int u(a aVar) {
        boolean z10;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f11947l) {
                z10 = false;
                break;
            }
            m.b[] bVarArr = this.f11942g;
            if (bVarArr[i10].f11917a.f11972o != i.a.UNRESTRICTED && bVarArr[i10].f11918b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            float f10 = Float.MAX_VALUE;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < this.f11947l; i15++) {
                m.b bVar = this.f11942g[i15];
                if (bVar.f11917a.f11972o != i.a.UNRESTRICTED && !bVar.f11922f && bVar.f11918b < 0.0f) {
                    int i16 = 9;
                    if (f11930u) {
                        int e10 = bVar.f11921e.e();
                        int i17 = 0;
                        while (i17 < e10) {
                            i g10 = bVar.f11921e.g(i17);
                            float d10 = bVar.f11921e.d(g10);
                            if (d10 > 0.0f) {
                                int i18 = 0;
                                while (i18 < i16) {
                                    float f11 = g10.f11970m[i18] / d10;
                                    if ((f11 < f10 && i18 == i14) || i18 > i14) {
                                        i13 = g10.f11965h;
                                        i14 = i18;
                                        i12 = i15;
                                        f10 = f11;
                                    }
                                    i18++;
                                    i16 = 9;
                                }
                            }
                            i17++;
                            i16 = 9;
                        }
                    } else {
                        for (int i19 = 1; i19 < this.f11946k; i19++) {
                            i iVar = this.f11949n.f11926d[i19];
                            float d11 = bVar.f11921e.d(iVar);
                            if (d11 > 0.0f) {
                                for (int i20 = 0; i20 < 9; i20++) {
                                    float f12 = iVar.f11970m[i20] / d11;
                                    if ((f12 < f10 && i20 == i14) || i20 > i14) {
                                        i13 = i19;
                                        i12 = i15;
                                        i14 = i20;
                                        f10 = f12;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i12 != -1) {
                m.b bVar2 = this.f11942g[i12];
                bVar2.f11917a.f11966i = -1;
                bVar2.x(this.f11949n.f11926d[i13]);
                i iVar2 = bVar2.f11917a;
                iVar2.f11966i = i12;
                iVar2.t(this, bVar2);
            } else {
                z11 = true;
            }
            if (i11 > this.f11946k / 2) {
                z11 = true;
            }
        }
        return i11;
    }

    public static e w() {
        return f11933x;
    }

    private void y() {
        int i10 = this.f11940e * 2;
        this.f11940e = i10;
        this.f11942g = (m.b[]) Arrays.copyOf(this.f11942g, i10);
        c cVar = this.f11949n;
        cVar.f11926d = (i[]) Arrays.copyOf(cVar.f11926d, this.f11940e);
        int i11 = this.f11940e;
        this.f11945j = new boolean[i11];
        this.f11941f = i11;
        this.f11948m = i11;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f11949n;
            i[] iVarArr = cVar.f11926d;
            if (i10 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i10];
            if (iVar != null) {
                iVar.o();
            }
            i10++;
        }
        cVar.f11925c.c(this.f11950o, this.f11951p);
        this.f11951p = 0;
        Arrays.fill(this.f11949n.f11926d, (Object) null);
        HashMap<String, i> hashMap = this.f11938c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f11937b = 0;
        this.f11939d.clear();
        this.f11946k = 1;
        for (int i11 = 0; i11 < this.f11947l; i11++) {
            m.b[] bVarArr = this.f11942g;
            if (bVarArr[i11] != null) {
                bVarArr[i11].f11919c = false;
            }
        }
        C();
        this.f11947l = 0;
        this.f11952q = f11931v ? new b(this, this.f11949n) : new m.b(this.f11949n);
    }

    public void b(p.e eVar, p.e eVar2, float f10, int i10) {
        d.b bVar = d.b.LEFT;
        i q10 = q(eVar.m(bVar));
        d.b bVar2 = d.b.TOP;
        i q11 = q(eVar.m(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q12 = q(eVar.m(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q13 = q(eVar.m(bVar4));
        i q14 = q(eVar2.m(bVar));
        i q15 = q(eVar2.m(bVar2));
        i q16 = q(eVar2.m(bVar3));
        i q17 = q(eVar2.m(bVar4));
        m.b r10 = r();
        double d10 = f10;
        double d11 = i10;
        r10.q(q11, q13, q15, q17, (float) (Math.sin(d10) * d11));
        d(r10);
        m.b r11 = r();
        r11.q(q10, q12, q14, q16, (float) (Math.cos(d10) * d11));
        d(r11);
    }

    public void c(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11, int i12) {
        m.b r10 = r();
        r10.h(iVar, iVar2, i10, f10, iVar3, iVar4, i11);
        if (i12 != 8) {
            r10.d(this, i12);
        }
        d(r10);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(m.b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.f11947l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f11948m
            if (r0 >= r2) goto L12
            int r0 = r5.f11946k
            int r0 = r0 + r1
            int r2 = r5.f11941f
            if (r0 < r2) goto L15
        L12:
            r5.y()
        L15:
            r0 = 0
            boolean r2 = r6.f11922f
            if (r2 != 0) goto L81
            r6.D(r5)
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L24
            return
        L24:
            r6.r()
            boolean r2 = r6.f(r5)
            if (r2 == 0) goto L78
            m.i r2 = r5.p()
            r6.f11917a = r2
            int r3 = r5.f11947l
            r5.l(r6)
            int r4 = r5.f11947l
            int r3 = r3 + r1
            if (r4 != r3) goto L78
            m.d$a r0 = r5.f11952q
            r0.c(r6)
            m.d$a r0 = r5.f11952q
            r5.B(r0, r1)
            int r0 = r2.f11966i
            r3 = -1
            if (r0 != r3) goto L79
            m.i r0 = r6.f11917a
            if (r0 != r2) goto L59
            m.i r0 = r6.v(r2)
            if (r0 == 0) goto L59
            r6.x(r0)
        L59:
            boolean r0 = r6.f11922f
            if (r0 != 0) goto L62
            m.i r0 = r6.f11917a
            r0.t(r5, r6)
        L62:
            boolean r0 = m.d.f11931v
            if (r0 == 0) goto L6b
            m.c r0 = r5.f11949n
            m.f<m.b> r0 = r0.f11923a
            goto L6f
        L6b:
            m.c r0 = r5.f11949n
            m.f<m.b> r0 = r0.f11924b
        L6f:
            r0.a(r6)
            int r0 = r5.f11947l
            int r0 = r0 - r1
            r5.f11947l = r0
            goto L79
        L78:
            r1 = 0
        L79:
            boolean r0 = r6.s()
            if (r0 != 0) goto L80
            return
        L80:
            r0 = r1
        L81:
            if (r0 != 0) goto L86
            r5.l(r6)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.d(m.b):void");
    }

    public m.b e(i iVar, i iVar2, int i10, int i11) {
        if (f11928s && i11 == 8 && iVar2.f11969l && iVar.f11966i == -1) {
            iVar.r(this, iVar2.f11968k + i10);
            return null;
        }
        m.b r10 = r();
        r10.n(iVar, iVar2, i10);
        if (i11 != 8) {
            r10.d(this, i11);
        }
        d(r10);
        return r10;
    }

    public void f(i iVar, int i10) {
        m.b r10;
        if (f11928s && iVar.f11966i == -1) {
            float f10 = i10;
            iVar.r(this, f10);
            for (int i11 = 0; i11 < this.f11937b + 1; i11++) {
                i iVar2 = this.f11949n.f11926d[i11];
                if (iVar2 != null && iVar2.f11976s && iVar2.f11977t == iVar.f11965h) {
                    iVar2.r(this, iVar2.f11978u + f10);
                }
            }
            return;
        }
        int i12 = iVar.f11966i;
        if (i12 != -1) {
            m.b bVar = this.f11942g[i12];
            if (!bVar.f11922f) {
                if (bVar.f11921e.e() == 0) {
                    bVar.f11922f = true;
                } else {
                    r10 = r();
                    r10.m(iVar, i10);
                }
            }
            bVar.f11918b = i10;
            return;
        }
        r10 = r();
        r10.i(iVar, i10);
        d(r10);
    }

    public void g(i iVar, i iVar2, int i10, boolean z10) {
        m.b r10 = r();
        i t10 = t();
        t10.f11967j = 0;
        r10.o(iVar, iVar2, t10, i10);
        d(r10);
    }

    public void h(i iVar, i iVar2, int i10, int i11) {
        m.b r10 = r();
        i t10 = t();
        t10.f11967j = 0;
        r10.o(iVar, iVar2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f11921e.d(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void i(i iVar, i iVar2, int i10, boolean z10) {
        m.b r10 = r();
        i t10 = t();
        t10.f11967j = 0;
        r10.p(iVar, iVar2, t10, i10);
        d(r10);
    }

    public void j(i iVar, i iVar2, int i10, int i11) {
        m.b r10 = r();
        i t10 = t();
        t10.f11967j = 0;
        r10.p(iVar, iVar2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f11921e.d(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f10, int i10) {
        m.b r10 = r();
        r10.k(iVar, iVar2, iVar3, iVar4, f10);
        if (i10 != 8) {
            r10.d(this, i10);
        }
        d(r10);
    }

    void m(m.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public i o(int i10, String str) {
        if (this.f11946k + 1 >= this.f11941f) {
            y();
        }
        i a10 = a(i.a.ERROR, str);
        int i11 = this.f11937b + 1;
        this.f11937b = i11;
        this.f11946k++;
        a10.f11965h = i11;
        a10.f11967j = i10;
        this.f11949n.f11926d[i11] = a10;
        this.f11939d.b(a10);
        return a10;
    }

    public i p() {
        if (this.f11946k + 1 >= this.f11941f) {
            y();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f11937b + 1;
        this.f11937b = i10;
        this.f11946k++;
        a10.f11965h = i10;
        this.f11949n.f11926d[i10] = a10;
        return a10;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f11946k + 1 >= this.f11941f) {
            y();
        }
        if (obj instanceof p.d) {
            p.d dVar = (p.d) obj;
            iVar = dVar.h();
            if (iVar == null) {
                dVar.r(this.f11949n);
                iVar = dVar.h();
            }
            int i10 = iVar.f11965h;
            if (i10 == -1 || i10 > this.f11937b || this.f11949n.f11926d[i10] == null) {
                if (i10 != -1) {
                    iVar.o();
                }
                int i11 = this.f11937b + 1;
                this.f11937b = i11;
                this.f11946k++;
                iVar.f11965h = i11;
                iVar.f11972o = i.a.UNRESTRICTED;
                this.f11949n.f11926d[i11] = iVar;
            }
        }
        return iVar;
    }

    public m.b r() {
        m.b b10;
        if (f11931v) {
            b10 = this.f11949n.f11923a.b();
            if (b10 == null) {
                b10 = new b(this, this.f11949n);
                f11935z++;
            }
            b10.y();
        } else {
            b10 = this.f11949n.f11924b.b();
            if (b10 == null) {
                b10 = new m.b(this.f11949n);
                f11934y++;
            }
            b10.y();
        }
        i.l();
        return b10;
    }

    public i t() {
        if (this.f11946k + 1 >= this.f11941f) {
            y();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f11937b + 1;
        this.f11937b = i10;
        this.f11946k++;
        a10.f11965h = i10;
        this.f11949n.f11926d[i10] = a10;
        return a10;
    }

    public c v() {
        return this.f11949n;
    }

    public int x(Object obj) {
        i h10 = ((p.d) obj).h();
        if (h10 != null) {
            return (int) (h10.f11968k + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.f11939d.isEmpty()) {
            n();
            return;
        }
        if (this.f11943h || this.f11944i) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.f11947l) {
                    z10 = true;
                    break;
                } else if (!this.f11942g[i10].f11922f) {
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                n();
                return;
            }
        }
        A(this.f11939d);
    }
}
