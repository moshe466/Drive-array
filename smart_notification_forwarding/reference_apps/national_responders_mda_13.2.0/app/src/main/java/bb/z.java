package bb;

/* loaded from: classes.dex */
public final class z extends y0 {

    /* renamed from: b, reason: collision with root package name */
    private final n9.a1[] f4282b;

    /* renamed from: c, reason: collision with root package name */
    private final v0[] f4283c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4284d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z(java.util.List<? extends n9.a1> r9, java.util.List<? extends bb.v0> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "parameters"
            y8.k.e(r9, r0)
            java.lang.String r0 = "argumentsList"
            y8.k.e(r10, r0)
            r0 = 0
            n9.a1[] r1 = new n9.a1[r0]
            java.lang.Object[] r9 = r9.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r9, r1)
            r3 = r9
            n9.a1[] r3 = (n9.a1[]) r3
            bb.v0[] r9 = new bb.v0[r0]
            java.lang.Object[] r9 = r10.toArray(r9)
            java.util.Objects.requireNonNull(r9, r1)
            r4 = r9
            bb.v0[] r4 = (bb.v0[]) r4
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.z.<init>(java.util.List, java.util.List):void");
    }

    public z(n9.a1[] a1VarArr, v0[] v0VarArr, boolean z10) {
        y8.k.e(a1VarArr, "parameters");
        y8.k.e(v0VarArr, "arguments");
        this.f4282b = a1VarArr;
        this.f4283c = v0VarArr;
        this.f4284d = z10;
        int length = a1VarArr.length;
        int length2 = v0VarArr.length;
    }

    public /* synthetic */ z(n9.a1[] a1VarArr, v0[] v0VarArr, boolean z10, int i10, y8.g gVar) {
        this(a1VarArr, v0VarArr, (i10 & 4) != 0 ? false : z10);
    }

    @Override // bb.y0
    public boolean b() {
        return this.f4284d;
    }

    @Override // bb.y0
    public v0 e(b0 b0Var) {
        y8.k.e(b0Var, "key");
        n9.h A = b0Var.W0().A();
        n9.a1 a1Var = A instanceof n9.a1 ? (n9.a1) A : null;
        if (a1Var == null) {
            return null;
        }
        int j10 = a1Var.j();
        n9.a1[] a1VarArr = this.f4282b;
        if (j10 >= a1VarArr.length || !y8.k.a(a1VarArr[j10].o(), a1Var.o())) {
            return null;
        }
        return this.f4283c[j10];
    }

    @Override // bb.y0
    public boolean f() {
        return this.f4283c.length == 0;
    }

    public final v0[] h() {
        return this.f4283c;
    }

    public final n9.a1[] i() {
        return this.f4282b;
    }
}
