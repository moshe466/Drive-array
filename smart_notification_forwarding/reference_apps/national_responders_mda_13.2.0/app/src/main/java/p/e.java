package p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p.d;
import q.n;
import q.p;

/* loaded from: classes.dex */
public class e {

    /* renamed from: v0, reason: collision with root package name */
    public static float f12940v0 = 0.5f;
    public int A;
    public float B;
    int C;
    float D;
    private int[] E;
    private float F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    public d L;
    public d M;
    public d N;
    public d O;
    public d P;
    d Q;
    d R;
    public d S;
    public d[] T;
    protected ArrayList<d> U;
    private boolean[] V;
    public b[] W;
    public e X;
    int Y;
    int Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f12942a0;

    /* renamed from: b, reason: collision with root package name */
    public q.c f12943b;

    /* renamed from: b0, reason: collision with root package name */
    protected int f12944b0;

    /* renamed from: c, reason: collision with root package name */
    public q.c f12945c;

    /* renamed from: c0, reason: collision with root package name */
    protected int f12946c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f12948d0;

    /* renamed from: e0, reason: collision with root package name */
    int f12950e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f12952f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f12954g0;

    /* renamed from: h0, reason: collision with root package name */
    float f12956h0;

    /* renamed from: i0, reason: collision with root package name */
    float f12958i0;

    /* renamed from: j0, reason: collision with root package name */
    private Object f12960j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f12962k0;

    /* renamed from: l, reason: collision with root package name */
    public String f12963l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f12964l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f12965m;

    /* renamed from: m0, reason: collision with root package name */
    private String f12966m0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12967n;

    /* renamed from: n0, reason: collision with root package name */
    private String f12968n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12969o;

    /* renamed from: o0, reason: collision with root package name */
    int f12970o0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12971p;

    /* renamed from: p0, reason: collision with root package name */
    int f12972p0;

    /* renamed from: q, reason: collision with root package name */
    public int f12973q;

    /* renamed from: q0, reason: collision with root package name */
    public float[] f12974q0;

    /* renamed from: r, reason: collision with root package name */
    public int f12975r;

    /* renamed from: r0, reason: collision with root package name */
    protected e[] f12976r0;

    /* renamed from: s, reason: collision with root package name */
    private int f12977s;

    /* renamed from: s0, reason: collision with root package name */
    protected e[] f12978s0;

    /* renamed from: t, reason: collision with root package name */
    public int f12979t;

    /* renamed from: t0, reason: collision with root package name */
    public int f12980t0;

    /* renamed from: u, reason: collision with root package name */
    public int f12981u;

    /* renamed from: u0, reason: collision with root package name */
    public int f12982u0;

    /* renamed from: v, reason: collision with root package name */
    public int[] f12983v;

    /* renamed from: w, reason: collision with root package name */
    public int f12984w;

    /* renamed from: x, reason: collision with root package name */
    public int f12985x;

    /* renamed from: y, reason: collision with root package name */
    public float f12986y;

    /* renamed from: z, reason: collision with root package name */
    public int f12987z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12941a = false;

    /* renamed from: d, reason: collision with root package name */
    public q.l f12947d = null;

    /* renamed from: e, reason: collision with root package name */
    public n f12949e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean[] f12951f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    private boolean f12953g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12955h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12957i = true;

    /* renamed from: j, reason: collision with root package name */
    private int f12959j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f12961k = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12988a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12989b;

        static {
            int[] iArr = new int[b.values().length];
            f12989b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12989b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12989b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12989b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f12988a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12988a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12988a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12988a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12988a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12988a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12988a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12988a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12988a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        new o.a(this);
        this.f12965m = false;
        this.f12967n = false;
        this.f12969o = false;
        this.f12971p = false;
        this.f12973q = -1;
        this.f12975r = -1;
        this.f12977s = 0;
        this.f12979t = 0;
        this.f12981u = 0;
        this.f12983v = new int[2];
        this.f12984w = 0;
        this.f12985x = 0;
        this.f12986y = 1.0f;
        this.f12987z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = -1;
        this.D = 1.0f;
        this.E = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.F = 0.0f;
        this.G = false;
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.L = new d(this, d.b.LEFT);
        this.M = new d(this, d.b.TOP);
        this.N = new d(this, d.b.RIGHT);
        this.O = new d(this, d.b.BOTTOM);
        this.P = new d(this, d.b.BASELINE);
        this.Q = new d(this, d.b.CENTER_X);
        this.R = new d(this, d.b.CENTER_Y);
        d dVar = new d(this, d.b.CENTER);
        this.S = dVar;
        this.T = new d[]{this.L, this.N, this.M, this.O, this.P, dVar};
        this.U = new ArrayList<>();
        this.V = new boolean[2];
        b bVar = b.FIXED;
        this.W = new b[]{bVar, bVar};
        this.X = null;
        this.Y = 0;
        this.Z = 0;
        this.f12942a0 = 0.0f;
        this.f12944b0 = -1;
        this.f12946c0 = 0;
        this.f12948d0 = 0;
        this.f12950e0 = 0;
        float f10 = f12940v0;
        this.f12956h0 = f10;
        this.f12958i0 = f10;
        this.f12962k0 = 0;
        this.f12964l0 = false;
        this.f12966m0 = null;
        this.f12968n0 = null;
        this.f12970o0 = 0;
        this.f12972p0 = 0;
        this.f12974q0 = new float[]{-1.0f, -1.0f};
        this.f12976r0 = new e[]{null, null};
        this.f12978s0 = new e[]{null, null};
        this.f12980t0 = -1;
        this.f12982u0 = -1;
        d();
    }

    private void N(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        v0(sb2, "      size", i10, 0);
        v0(sb2, "      min", i11, 0);
        v0(sb2, "      max", i12, Integer.MAX_VALUE);
        v0(sb2, "      matchMin", i14, 0);
        v0(sb2, "      matchDef", i15, 0);
        u0(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    private void O(StringBuilder sb2, String str, d dVar) {
        if (dVar.f12935f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(dVar.f12935f);
        sb2.append("'");
        if (dVar.f12937h != Integer.MIN_VALUE || dVar.f12936g != 0) {
            sb2.append(",");
            sb2.append(dVar.f12936g);
            if (dVar.f12937h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(dVar.f12937h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    private void d() {
        this.U.add(this.L);
        this.U.add(this.M);
        this.U.add(this.N);
        this.U.add(this.O);
        this.U.add(this.Q);
        this.U.add(this.R);
        this.U.add(this.S);
        this.U.add(this.P);
    }

    private boolean d0(int i10) {
        int i11 = i10 * 2;
        d[] dVarArr = this.T;
        if (dVarArr[i11].f12935f != null && dVarArr[i11].f12935f.f12935f != dVarArr[i11]) {
            int i12 = i11 + 1;
            if (dVarArr[i12].f12935f != null && dVarArr[i12].f12935f.f12935f == dVarArr[i12]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x0455, code lost:
    
        if ((r4 instanceof p.a) != false) goto L271;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0546 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x050f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(m.d r37, boolean r38, boolean r39, boolean r40, boolean r41, m.i r42, m.i r43, p.e.b r44, boolean r45, p.d r46, p.d r47, int r48, int r49, int r50, int r51, float r52, boolean r53, boolean r54, boolean r55, boolean r56, boolean r57, int r58, int r59, int r60, int r61, float r62, boolean r63) {
        /*
            Method dump skipped, instructions count: 1407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.i(m.d, boolean, boolean, boolean, boolean, m.i, m.i, p.e$b, boolean, p.d, p.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void u0(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    private void v0(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    private void w0(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f10);
        sb2.append(",");
        sb2.append(i10);
        sb2.append("");
        sb2.append("],\n");
    }

    public int A() {
        return this.J;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please report as a decompilation issue!!! */
    public void A0(String str) {
        float f10;
        int i10 = 0;
        if (str == null || str.length() == 0) {
            this.f12942a0 = 0.0f;
            return;
        }
        int i11 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i12 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i11 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i11 = 1;
            }
            i12 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i12);
            if (substring2.length() > 0) {
                f10 = Float.parseFloat(substring2);
            }
            f10 = 0.0f;
        } else {
            String substring3 = str.substring(i12, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f10 = i11 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f10 = 0.0f;
        }
        i10 = (f10 > i10 ? 1 : (f10 == i10 ? 0 : -1));
        if (i10 > 0) {
            this.f12942a0 = f10;
            this.f12944b0 = i11;
        }
    }

    public int B() {
        return this.K;
    }

    public void B0(int i10) {
        if (this.G) {
            int i11 = i10 - this.f12950e0;
            int i12 = this.Z + i11;
            this.f12948d0 = i11;
            this.M.s(i11);
            this.O.s(i12);
            this.P.s(i10);
            this.f12967n = true;
        }
    }

    public int C(int i10) {
        if (i10 == 0) {
            return U();
        }
        if (i10 == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i10, int i11) {
        if (this.f12965m) {
            return;
        }
        this.L.s(i10);
        this.N.s(i11);
        this.f12946c0 = i10;
        this.Y = i11 - i10;
        this.f12965m = true;
    }

    public int D() {
        return this.E[1];
    }

    public void D0(int i10) {
        this.L.s(i10);
        this.f12946c0 = i10;
    }

    public int E() {
        return this.E[0];
    }

    public void E0(int i10) {
        this.M.s(i10);
        this.f12948d0 = i10;
    }

    public int F() {
        return this.f12954g0;
    }

    public void F0(int i10, int i11) {
        if (this.f12967n) {
            return;
        }
        this.M.s(i10);
        this.O.s(i11);
        this.f12948d0 = i10;
        this.Z = i11 - i10;
        if (this.G) {
            this.P.s(i10 + this.f12950e0);
        }
        this.f12967n = true;
    }

    public int G() {
        return this.f12952f0;
    }

    public void G0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f12946c0 = i10;
        this.f12948d0 = i11;
        if (this.f12962k0 == 8) {
            this.Y = 0;
            this.Z = 0;
            return;
        }
        b[] bVarArr = this.W;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.Y)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.Z)) {
            i17 = i14;
        }
        this.Y = i16;
        this.Z = i17;
        int i18 = this.f12954g0;
        if (i17 < i18) {
            this.Z = i18;
        }
        int i19 = this.f12952f0;
        if (i16 < i19) {
            this.Y = i19;
        }
        int i20 = this.f12985x;
        if (i20 > 0 && bVarArr[0] == b.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, i20);
        }
        int i21 = this.A;
        if (i21 > 0 && this.W[1] == b.MATCH_CONSTRAINT) {
            this.Z = Math.min(this.Z, i21);
        }
        int i22 = this.Y;
        if (i16 != i22) {
            this.f12959j = i22;
        }
        int i23 = this.Z;
        if (i17 != i23) {
            this.f12961k = i23;
        }
    }

    public e H(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.O).f12935f) != null && dVar2.f12935f == dVar) {
                return dVar2.f12933d;
            }
            return null;
        }
        d dVar3 = this.N;
        d dVar4 = dVar3.f12935f;
        if (dVar4 == null || dVar4.f12935f != dVar3) {
            return null;
        }
        return dVar4.f12933d;
    }

    public void H0(boolean z10) {
        this.G = z10;
    }

    public e I() {
        return this.X;
    }

    public void I0(int i10) {
        this.Z = i10;
        int i11 = this.f12954g0;
        if (i10 < i11) {
            this.Z = i11;
        }
    }

    public e J(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.M).f12935f) != null && dVar2.f12935f == dVar) {
                return dVar2.f12933d;
            }
            return null;
        }
        d dVar3 = this.L;
        d dVar4 = dVar3.f12935f;
        if (dVar4 == null || dVar4.f12935f != dVar3) {
            return null;
        }
        return dVar4.f12933d;
    }

    public void J0(float f10) {
        this.f12956h0 = f10;
    }

    public int K() {
        return V() + this.Y;
    }

    public void K0(int i10) {
        this.f12970o0 = i10;
    }

    public p L(int i10) {
        if (i10 == 0) {
            return this.f12947d;
        }
        if (i10 == 1) {
            return this.f12949e;
        }
        return null;
    }

    public void L0(int i10, int i11) {
        this.f12946c0 = i10;
        int i12 = i11 - i10;
        this.Y = i12;
        int i13 = this.f12952f0;
        if (i12 < i13) {
            this.Y = i13;
        }
    }

    public void M(StringBuilder sb2) {
        sb2.append("  " + this.f12963l + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.Y);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.Z);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f12946c0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f12948d0);
        sb2.append("\n");
        O(sb2, "left", this.L);
        O(sb2, "top", this.M);
        O(sb2, "right", this.N);
        O(sb2, "bottom", this.O);
        O(sb2, "baseline", this.P);
        O(sb2, "centerX", this.Q);
        O(sb2, "centerY", this.R);
        N(sb2, "    width", this.Y, this.f12952f0, this.E[0], this.f12959j, this.f12984w, this.f12979t, this.f12986y, this.f12974q0[0]);
        N(sb2, "    height", this.Z, this.f12954g0, this.E[1], this.f12961k, this.f12987z, this.f12981u, this.B, this.f12974q0[1]);
        w0(sb2, "    dimensionRatio", this.f12942a0, this.f12944b0);
        u0(sb2, "    horizontalBias", this.f12956h0, f12940v0);
        u0(sb2, "    verticalBias", this.f12958i0, f12940v0);
        v0(sb2, "    horizontalChainStyle", this.f12970o0, 0);
        v0(sb2, "    verticalChainStyle", this.f12972p0, 0);
        sb2.append("  }");
    }

    public void M0(b bVar) {
        this.W[0] = bVar;
    }

    public void N0(int i10, int i11, int i12, float f10) {
        this.f12979t = i10;
        this.f12984w = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f12985x = i12;
        this.f12986y = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f12979t = 2;
    }

    public void O0(float f10) {
        this.f12974q0[0] = f10;
    }

    public float P() {
        return this.f12958i0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P0(int i10, boolean z10) {
        this.V[i10] = z10;
    }

    public int Q() {
        return this.f12972p0;
    }

    public void Q0(boolean z10) {
        this.H = z10;
    }

    public b R() {
        return this.W[1];
    }

    public void R0(boolean z10) {
        this.I = z10;
    }

    public int S() {
        int i10 = this.L != null ? 0 + this.M.f12936g : 0;
        return this.N != null ? i10 + this.O.f12936g : i10;
    }

    public void S0(int i10, int i11) {
        this.J = i10;
        this.K = i11;
        V0(false);
    }

    public int T() {
        return this.f12962k0;
    }

    public void T0(int i10) {
        this.E[1] = i10;
    }

    public int U() {
        if (this.f12962k0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public void U0(int i10) {
        this.E[0] = i10;
    }

    public int V() {
        e eVar = this.X;
        return (eVar == null || !(eVar instanceof f)) ? this.f12946c0 : ((f) eVar).D0 + this.f12946c0;
    }

    public void V0(boolean z10) {
        this.f12953g = z10;
    }

    public int W() {
        e eVar = this.X;
        return (eVar == null || !(eVar instanceof f)) ? this.f12948d0 : ((f) eVar).E0 + this.f12948d0;
    }

    public void W0(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f12954g0 = i10;
    }

    public boolean X() {
        return this.G;
    }

    public void X0(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f12952f0 = i10;
    }

    public boolean Y(int i10) {
        if (i10 == 0) {
            return (this.L.f12935f != null ? 1 : 0) + (this.N.f12935f != null ? 1 : 0) < 2;
        }
        return ((this.M.f12935f != null ? 1 : 0) + (this.O.f12935f != null ? 1 : 0)) + (this.P.f12935f != null ? 1 : 0) < 2;
    }

    public void Y0(int i10, int i11) {
        this.f12946c0 = i10;
        this.f12948d0 = i11;
    }

    public boolean Z() {
        int size = this.U.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.U.get(i10).l()) {
                return true;
            }
        }
        return false;
    }

    public void Z0(e eVar) {
        this.X = eVar;
    }

    public boolean a0() {
        return (this.f12959j == -1 && this.f12961k == -1) ? false : true;
    }

    public void a1(float f10) {
        this.f12958i0 = f10;
    }

    public boolean b0(int i10, int i11) {
        d dVar;
        d dVar2;
        if (i10 == 0) {
            d dVar3 = this.L.f12935f;
            return dVar3 != null && dVar3.m() && (dVar2 = this.N.f12935f) != null && dVar2.m() && (this.N.f12935f.d() - this.N.e()) - (this.L.f12935f.d() + this.L.e()) >= i11;
        }
        d dVar4 = this.M.f12935f;
        return dVar4 != null && dVar4.m() && (dVar = this.O.f12935f) != null && dVar.m() && (this.O.f12935f.d() - this.O.e()) - (this.M.f12935f.d() + this.M.e()) >= i11;
        return false;
    }

    public void b1(int i10) {
        this.f12972p0 = i10;
    }

    public void c0(d.b bVar, e eVar, d.b bVar2, int i10, int i11) {
        m(bVar).a(eVar.m(bVar2), i10, i11, true);
    }

    public void c1(int i10, int i11) {
        this.f12948d0 = i10;
        int i12 = i11 - i10;
        this.Z = i12;
        int i13 = this.f12954g0;
        if (i12 < i13) {
            this.Z = i13;
        }
    }

    public void d1(b bVar) {
        this.W[1] = bVar;
    }

    public void e(f fVar, m.d dVar, HashSet<e> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.P1(64));
        }
        if (i10 == 0) {
            HashSet<d> c10 = this.L.c();
            if (c10 != null) {
                Iterator<d> it = c10.iterator();
                while (it.hasNext()) {
                    it.next().f12933d.e(fVar, dVar, hashSet, i10, true);
                }
            }
            HashSet<d> c11 = this.N.c();
            if (c11 != null) {
                Iterator<d> it2 = c11.iterator();
                while (it2.hasNext()) {
                    it2.next().f12933d.e(fVar, dVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<d> c12 = this.M.c();
        if (c12 != null) {
            Iterator<d> it3 = c12.iterator();
            while (it3.hasNext()) {
                it3.next().f12933d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet<d> c13 = this.O.c();
        if (c13 != null) {
            Iterator<d> it4 = c13.iterator();
            while (it4.hasNext()) {
                it4.next().f12933d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet<d> c14 = this.P.c();
        if (c14 != null) {
            Iterator<d> it5 = c14.iterator();
            while (it5.hasNext()) {
                it5.next().f12933d.e(fVar, dVar, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        return this.f12969o;
    }

    public void e1(int i10, int i11, int i12, float f10) {
        this.f12981u = i10;
        this.f12987z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.A = i12;
        this.B = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f12981u = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof k) || (this instanceof g);
    }

    public boolean f0(int i10) {
        return this.V[i10];
    }

    public void f1(float f10) {
        this.f12974q0[1] = f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(m.d r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.g(m.d, boolean):void");
    }

    public boolean g0() {
        d dVar = this.L;
        d dVar2 = dVar.f12935f;
        if (dVar2 != null && dVar2.f12935f == dVar) {
            return true;
        }
        d dVar3 = this.N;
        d dVar4 = dVar3.f12935f;
        return dVar4 != null && dVar4.f12935f == dVar3;
    }

    public void g1(int i10) {
        this.f12962k0 = i10;
    }

    public boolean h() {
        return this.f12962k0 != 8;
    }

    public boolean h0() {
        return this.H;
    }

    public void h1(int i10) {
        this.Y = i10;
        int i11 = this.f12952f0;
        if (i10 < i11) {
            this.Y = i11;
        }
    }

    public boolean i0() {
        d dVar = this.M;
        d dVar2 = dVar.f12935f;
        if (dVar2 != null && dVar2.f12935f == dVar) {
            return true;
        }
        d dVar3 = this.O;
        d dVar4 = dVar3.f12935f;
        return dVar4 != null && dVar4.f12935f == dVar3;
    }

    public void i1(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.f12977s = i10;
    }

    public void j(e eVar, float f10, int i10) {
        d.b bVar = d.b.CENTER;
        c0(bVar, eVar, bVar, i10, 0);
        this.F = f10;
    }

    public boolean j0() {
        return this.I;
    }

    public void j1(int i10) {
        this.f12946c0 = i10;
    }

    public void k(m.d dVar) {
        dVar.q(this.L);
        dVar.q(this.M);
        dVar.q(this.N);
        dVar.q(this.O);
        if (this.f12950e0 > 0) {
            dVar.q(this.P);
        }
    }

    public boolean k0() {
        return this.f12953g && this.f12962k0 != 8;
    }

    public void k1(int i10) {
        this.f12948d0 = i10;
    }

    public void l() {
        if (this.f12947d == null) {
            this.f12947d = new q.l(this);
        }
        if (this.f12949e == null) {
            this.f12949e = new n(this);
        }
    }

    public boolean l0() {
        return this.f12965m || (this.L.m() && this.N.m());
    }

    public void l1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.C == -1) {
            if (z12 && !z13) {
                this.C = 0;
            } else if (!z12 && z13) {
                this.C = 1;
                if (this.f12944b0 == -1) {
                    this.D = 1.0f / this.D;
                }
            }
        }
        if (this.C == 0 && (!this.M.n() || !this.O.n())) {
            this.C = 1;
        } else if (this.C == 1 && (!this.L.n() || !this.N.n())) {
            this.C = 0;
        }
        if (this.C == -1 && (!this.M.n() || !this.O.n() || !this.L.n() || !this.N.n())) {
            if (this.M.n() && this.O.n()) {
                this.C = 0;
            } else if (this.L.n() && this.N.n()) {
                this.D = 1.0f / this.D;
                this.C = 1;
            }
        }
        if (this.C == -1) {
            int i10 = this.f12984w;
            if (i10 > 0 && this.f12987z == 0) {
                this.C = 0;
            } else {
                if (i10 != 0 || this.f12987z <= 0) {
                    return;
                }
                this.D = 1.0f / this.D;
                this.C = 1;
            }
        }
    }

    public d m(d.b bVar) {
        switch (a.f12988a[bVar.ordinal()]) {
            case 1:
                return this.L;
            case 2:
                return this.M;
            case 3:
                return this.N;
            case 4:
                return this.O;
            case 5:
                return this.P;
            case 6:
                return this.S;
            case 7:
                return this.Q;
            case 8:
                return this.R;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean m0() {
        return this.f12967n || (this.M.m() && this.O.m());
    }

    public void m1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean k10 = z10 & this.f12947d.k();
        boolean k11 = z11 & this.f12949e.k();
        q.l lVar = this.f12947d;
        int i12 = lVar.f13414h.f13383g;
        n nVar = this.f12949e;
        int i13 = nVar.f13414h.f13383g;
        int i14 = lVar.f13415i.f13383g;
        int i15 = nVar.f13415i.f13383g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (k10) {
            this.f12946c0 = i12;
        }
        if (k11) {
            this.f12948d0 = i13;
        }
        if (this.f12962k0 == 8) {
            this.Y = 0;
            this.Z = 0;
            return;
        }
        if (k10) {
            if (this.W[0] == b.FIXED && i17 < (i11 = this.Y)) {
                i17 = i11;
            }
            this.Y = i17;
            int i19 = this.f12952f0;
            if (i17 < i19) {
                this.Y = i19;
            }
        }
        if (k11) {
            if (this.W[1] == b.FIXED && i18 < (i10 = this.Z)) {
                i18 = i10;
            }
            this.Z = i18;
            int i20 = this.f12954g0;
            if (i18 < i20) {
                this.Z = i20;
            }
        }
    }

    public int n() {
        return this.f12950e0;
    }

    public boolean n0() {
        return this.f12971p;
    }

    public void n1(m.d dVar, boolean z10) {
        n nVar;
        q.l lVar;
        int x10 = dVar.x(this.L);
        int x11 = dVar.x(this.M);
        int x12 = dVar.x(this.N);
        int x13 = dVar.x(this.O);
        if (z10 && (lVar = this.f12947d) != null) {
            q.f fVar = lVar.f13414h;
            if (fVar.f13386j) {
                q.f fVar2 = lVar.f13415i;
                if (fVar2.f13386j) {
                    x10 = fVar.f13383g;
                    x12 = fVar2.f13383g;
                }
            }
        }
        if (z10 && (nVar = this.f12949e) != null) {
            q.f fVar3 = nVar.f13414h;
            if (fVar3.f13386j) {
                q.f fVar4 = nVar.f13415i;
                if (fVar4.f13386j) {
                    x11 = fVar3.f13383g;
                    x13 = fVar4.f13383g;
                }
            }
        }
        int i10 = x13 - x11;
        if (x12 - x10 < 0 || i10 < 0 || x10 == Integer.MIN_VALUE || x10 == Integer.MAX_VALUE || x11 == Integer.MIN_VALUE || x11 == Integer.MAX_VALUE || x12 == Integer.MIN_VALUE || x12 == Integer.MAX_VALUE || x13 == Integer.MIN_VALUE || x13 == Integer.MAX_VALUE) {
            x13 = 0;
            x10 = 0;
            x11 = 0;
            x12 = 0;
        }
        G0(x10, x11, x12, x13);
    }

    public float o(int i10) {
        if (i10 == 0) {
            return this.f12956h0;
        }
        if (i10 == 1) {
            return this.f12958i0;
        }
        return -1.0f;
    }

    public void o0() {
        this.f12969o = true;
    }

    public int p() {
        return W() + this.Z;
    }

    public void p0() {
        this.f12971p = true;
    }

    public Object q() {
        return this.f12960j0;
    }

    public boolean q0() {
        b[] bVarArr = this.W;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String r() {
        return this.f12966m0;
    }

    public void r0() {
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        this.S.p();
        this.X = null;
        this.F = 0.0f;
        this.Y = 0;
        this.Z = 0;
        this.f12942a0 = 0.0f;
        this.f12944b0 = -1;
        this.f12946c0 = 0;
        this.f12948d0 = 0;
        this.f12950e0 = 0;
        this.f12952f0 = 0;
        this.f12954g0 = 0;
        float f10 = f12940v0;
        this.f12956h0 = f10;
        this.f12958i0 = f10;
        b[] bVarArr = this.W;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f12960j0 = null;
        this.f12962k0 = 0;
        this.f12968n0 = null;
        this.f12970o0 = 0;
        this.f12972p0 = 0;
        float[] fArr = this.f12974q0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f12973q = -1;
        this.f12975r = -1;
        int[] iArr = this.E;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f12979t = 0;
        this.f12981u = 0;
        this.f12986y = 1.0f;
        this.B = 1.0f;
        this.f12985x = Integer.MAX_VALUE;
        this.A = Integer.MAX_VALUE;
        this.f12984w = 0;
        this.f12987z = 0;
        this.C = -1;
        this.D = 1.0f;
        boolean[] zArr = this.f12951f;
        zArr[0] = true;
        zArr[1] = true;
        this.I = false;
        boolean[] zArr2 = this.V;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f12953g = true;
        int[] iArr2 = this.f12983v;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f12959j = -1;
        this.f12961k = -1;
    }

    public b s(int i10) {
        if (i10 == 0) {
            return y();
        }
        if (i10 == 1) {
            return R();
        }
        return null;
    }

    public void s0() {
        this.f12965m = false;
        this.f12967n = false;
        this.f12969o = false;
        this.f12971p = false;
        int size = this.U.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.U.get(i10).q();
        }
    }

    public float t() {
        return this.f12942a0;
    }

    public void t0(m.c cVar) {
        this.L.r(cVar);
        this.M.r(cVar);
        this.N.r(cVar);
        this.O.r(cVar);
        this.P.r(cVar);
        this.S.r(cVar);
        this.Q.r(cVar);
        this.R.r(cVar);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f12968n0 != null) {
            str = "type: " + this.f12968n0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f12966m0 != null) {
            str2 = "id: " + this.f12966m0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f12946c0);
        sb2.append(", ");
        sb2.append(this.f12948d0);
        sb2.append(") - (");
        sb2.append(this.Y);
        sb2.append(" x ");
        sb2.append(this.Z);
        sb2.append(")");
        return sb2.toString();
    }

    public int u() {
        return this.f12944b0;
    }

    public int v() {
        if (this.f12962k0 == 8) {
            return 0;
        }
        return this.Z;
    }

    public float w() {
        return this.f12956h0;
    }

    public int x() {
        return this.f12970o0;
    }

    public void x0(int i10) {
        this.f12950e0 = i10;
        this.G = i10 > 0;
    }

    public b y() {
        return this.W[0];
    }

    public void y0(Object obj) {
        this.f12960j0 = obj;
    }

    public int z() {
        d dVar = this.L;
        int i10 = dVar != null ? 0 + dVar.f12936g : 0;
        d dVar2 = this.N;
        return dVar2 != null ? i10 + dVar2.f12936g : i10;
    }

    public void z0(String str) {
        this.f12966m0 = str;
    }
}
