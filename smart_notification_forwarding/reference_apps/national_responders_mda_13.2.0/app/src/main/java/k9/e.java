package k9;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: f, reason: collision with root package name */
    public static final a f11211f;

    /* renamed from: g, reason: collision with root package name */
    private static final e f11212g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final e a() {
            return e.f11212g;
        }
    }

    static {
        y8.g gVar = null;
        f11211f = new a(gVar);
        f11212g = new e(false, 1, gVar);
    }

    public e(boolean z10) {
        super(new ab.f("DefaultBuiltIns"));
        if (z10) {
            f(false);
        }
    }

    public /* synthetic */ e(boolean z10, int i10, y8.g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }

    public static final e N0() {
        return f11211f.a();
    }
}
