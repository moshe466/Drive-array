package androidx.appcompat.widget;

/* loaded from: classes.dex */
class q0 {

    /* renamed from: a, reason: collision with root package name */
    private int f1470a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f1471b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f1472c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f1473d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f1474e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f1475f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1476g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1477h = false;

    public int a() {
        return this.f1476g ? this.f1470a : this.f1471b;
    }

    public int b() {
        return this.f1470a;
    }

    public int c() {
        return this.f1471b;
    }

    public int d() {
        return this.f1476g ? this.f1471b : this.f1470a;
    }

    public void e(int i10, int i11) {
        this.f1477h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1474e = i10;
            this.f1470a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1475f = i11;
            this.f1471b = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if (r2 != Integer.MIN_VALUE) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        if (r2 != Integer.MIN_VALUE) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1476g
            if (r2 != r0) goto L5
            return
        L5:
            r1.f1476g = r2
            boolean r0 = r1.f1477h
            if (r0 == 0) goto L2b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L1d
            int r2 = r1.f1473d
            if (r2 == r0) goto L14
            goto L16
        L14:
            int r2 = r1.f1474e
        L16:
            r1.f1470a = r2
            int r2 = r1.f1472c
            if (r2 == r0) goto L2f
            goto L31
        L1d:
            int r2 = r1.f1472c
            if (r2 == r0) goto L22
            goto L24
        L22:
            int r2 = r1.f1474e
        L24:
            r1.f1470a = r2
            int r2 = r1.f1473d
            if (r2 == r0) goto L2f
            goto L31
        L2b:
            int r2 = r1.f1474e
            r1.f1470a = r2
        L2f:
            int r2 = r1.f1475f
        L31:
            r1.f1471b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q0.f(boolean):void");
    }

    public void g(int i10, int i11) {
        this.f1472c = i10;
        this.f1473d = i11;
        this.f1477h = true;
        if (this.f1476g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1470a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1471b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1470a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1471b = i11;
        }
    }
}
