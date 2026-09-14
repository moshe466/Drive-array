package da;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final a f8764e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final e f8765f = new e(null, null, false, false, 8, null);

    /* renamed from: a, reason: collision with root package name */
    private final h f8766a;

    /* renamed from: b, reason: collision with root package name */
    private final f f8767b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f8768c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f8769d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final e a() {
            return e.f8765f;
        }
    }

    public e(h hVar, f fVar, boolean z10, boolean z11) {
        this.f8766a = hVar;
        this.f8767b = fVar;
        this.f8768c = z10;
        this.f8769d = z11;
    }

    public /* synthetic */ e(h hVar, f fVar, boolean z10, boolean z11, int i10, y8.g gVar) {
        this(hVar, fVar, z10, (i10 & 8) != 0 ? false : z11);
    }

    public final f b() {
        return this.f8767b;
    }

    public final h c() {
        return this.f8766a;
    }

    public final boolean d() {
        return this.f8768c;
    }

    public final boolean e() {
        return this.f8769d;
    }
}
