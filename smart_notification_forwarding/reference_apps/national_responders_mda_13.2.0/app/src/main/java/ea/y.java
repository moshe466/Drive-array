package ea;

import bb.h1;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: k, reason: collision with root package name */
    public static final y f9333k;

    /* renamed from: l, reason: collision with root package name */
    public static final y f9334l;

    /* renamed from: m, reason: collision with root package name */
    public static final y f9335m;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f9336a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9337b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f9338c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9339d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f9340e;

    /* renamed from: f, reason: collision with root package name */
    private final y f9341f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f9342g;

    /* renamed from: h, reason: collision with root package name */
    private final y f9343h;

    /* renamed from: i, reason: collision with root package name */
    private final y f9344i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f9345j;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9346a;

        static {
            int[] iArr = new int[h1.valuesCustom().length];
            iArr[h1.IN_VARIANCE.ordinal()] = 1;
            iArr[h1.INVARIANT.ordinal()] = 2;
            f9346a = iArr;
        }
    }

    static {
        new a(null);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        y yVar = null;
        boolean z14 = false;
        y yVar2 = null;
        y yVar3 = null;
        boolean z15 = false;
        y8.g gVar = null;
        y yVar4 = new y(z10, false, z11, z12, z13, yVar, z14, yVar2, yVar3, z15, 1023, gVar);
        f9333k = yVar4;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z20 = false;
        boolean z21 = false;
        y yVar5 = null;
        y yVar6 = null;
        boolean z22 = true;
        y8.g gVar2 = null;
        y yVar7 = new y(z16, z17, z18, z19, z20, null, z21, yVar5, yVar6, z22, 511, gVar2);
        f9334l = yVar7;
        new y(z10, true, z11, z12, z13, yVar, z14, yVar2, yVar3, z15, 1021, gVar);
        int i10 = 988;
        f9335m = new y(z10, false, z11, z12, z13, yVar4, z14, yVar2, yVar3, z15, i10, gVar);
        new y(z16, z17, z18, z19, z20, yVar7, z21, yVar5, yVar6, z22, 476, gVar2);
        new y(z10, true, z11, z12, z13, yVar4, z14, yVar2, yVar3, z15, i10, gVar);
        boolean z23 = false;
        boolean z24 = true;
        new y(z10, z23, z11, z24, z13, yVar4, z14, yVar2, yVar3, z15, 983, gVar);
        new y(z10, z23, z11, z24, z13, yVar4, z14, yVar2, yVar3, z15, 919, gVar);
        new y(z10, z23, true, false, z13, yVar4, z14, yVar2, yVar3, z15, 984, gVar);
    }

    public y(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, y yVar, boolean z15, y yVar2, y yVar3, boolean z16) {
        this.f9336a = z10;
        this.f9337b = z11;
        this.f9338c = z12;
        this.f9339d = z13;
        this.f9340e = z14;
        this.f9341f = yVar;
        this.f9342g = z15;
        this.f9343h = yVar2;
        this.f9344i = yVar3;
        this.f9345j = z16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ y(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, ea.y r17, boolean r18, ea.y r19, ea.y r20, boolean r21, int r22, y8.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L9
            r1 = 1
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L18
            r4 = 0
            goto L19
        L18:
            r4 = r14
        L19:
            r6 = r0 & 8
            if (r6 == 0) goto L1f
            r6 = 0
            goto L20
        L1f:
            r6 = r15
        L20:
            r7 = r0 & 16
            if (r7 == 0) goto L26
            r7 = 0
            goto L28
        L26:
            r7 = r16
        L28:
            r8 = r0 & 32
            if (r8 == 0) goto L2e
            r8 = 0
            goto L30
        L2e:
            r8 = r17
        L30:
            r9 = r0 & 64
            if (r9 == 0) goto L35
            goto L37
        L35:
            r2 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L3d
            r9 = r8
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L45
            r10 = r8
            goto L47
        L45:
            r10 = r20
        L47:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r5 = r21
        L4e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.y.<init>(boolean, boolean, boolean, boolean, boolean, ea.y, boolean, ea.y, ea.y, boolean, int, y8.g):void");
    }

    public final boolean a() {
        return this.f9342g;
    }

    public final boolean b() {
        return this.f9345j;
    }

    public final boolean c() {
        return this.f9337b;
    }

    public final boolean d() {
        return this.f9336a;
    }

    public final boolean e() {
        return this.f9338c;
    }

    public final y f(h1 h1Var, boolean z10) {
        y8.k.e(h1Var, "effectiveVariance");
        if (!z10 || !this.f9338c) {
            int i10 = b.f9346a[h1Var.ordinal()];
            if (i10 == 1) {
                y yVar = this.f9343h;
                if (yVar != null) {
                    return yVar;
                }
            } else if (i10 != 2) {
                y yVar2 = this.f9341f;
                if (yVar2 != null) {
                    return yVar2;
                }
            } else {
                y yVar3 = this.f9344i;
                if (yVar3 != null) {
                    return yVar3;
                }
            }
        }
        return this;
    }

    public final y g() {
        return new y(this.f9336a, true, this.f9338c, this.f9339d, this.f9340e, this.f9341f, this.f9342g, this.f9343h, this.f9344i, false, 512, null);
    }
}
