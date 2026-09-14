package ka;

import y8.k;

/* loaded from: classes.dex */
public final class f extends ia.a {

    /* renamed from: g, reason: collision with root package name */
    public static final f f11311g;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f11312f;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        new a(null);
        f11311g = new f(1, 4, 2);
        new f(new int[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(int... iArr) {
        this(iArr, false);
        k.e(iArr, "numbers");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(int[] r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "versionArray"
            y8.k.e(r4, r0)
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            r3.f11312f = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.f.<init>(int[], boolean):void");
    }

    public boolean h() {
        boolean z10;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f11312f) {
            z10 = f(f11311g);
        } else {
            int a10 = a();
            f fVar = f11311g;
            z10 = a10 == fVar.a() && b() <= fVar.b() + 1;
        }
        return z10;
    }
}
