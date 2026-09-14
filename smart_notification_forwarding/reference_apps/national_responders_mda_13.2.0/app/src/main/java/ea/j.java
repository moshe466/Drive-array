package ea;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final b f9309a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final d f9310b = new d(sa.d.BOOLEAN);

    /* renamed from: c, reason: collision with root package name */
    private static final d f9311c = new d(sa.d.CHAR);

    /* renamed from: d, reason: collision with root package name */
    private static final d f9312d = new d(sa.d.BYTE);

    /* renamed from: e, reason: collision with root package name */
    private static final d f9313e = new d(sa.d.SHORT);

    /* renamed from: f, reason: collision with root package name */
    private static final d f9314f = new d(sa.d.INT);

    /* renamed from: g, reason: collision with root package name */
    private static final d f9315g = new d(sa.d.FLOAT);

    /* renamed from: h, reason: collision with root package name */
    private static final d f9316h = new d(sa.d.LONG);

    /* renamed from: i, reason: collision with root package name */
    private static final d f9317i = new d(sa.d.DOUBLE);

    /* loaded from: classes.dex */
    public static final class a extends j {

        /* renamed from: j, reason: collision with root package name */
        private final j f9318j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar) {
            super(null);
            y8.k.e(jVar, "elementType");
            this.f9318j = jVar;
        }

        public final j i() {
            return this.f9318j;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public final d a() {
            return j.f9310b;
        }

        public final d b() {
            return j.f9312d;
        }

        public final d c() {
            return j.f9311c;
        }

        public final d d() {
            return j.f9317i;
        }

        public final d e() {
            return j.f9315g;
        }

        public final d f() {
            return j.f9314f;
        }

        public final d g() {
            return j.f9316h;
        }

        public final d h() {
            return j.f9313e;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends j {

        /* renamed from: j, reason: collision with root package name */
        private final String f9319j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            y8.k.e(str, "internalName");
            this.f9319j = str;
        }

        public final String i() {
            return this.f9319j;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends j {

        /* renamed from: j, reason: collision with root package name */
        private final sa.d f9320j;

        public d(sa.d dVar) {
            super(null);
            this.f9320j = dVar;
        }

        public final sa.d i() {
            return this.f9320j;
        }
    }

    private j() {
    }

    public /* synthetic */ j(y8.g gVar) {
        this();
    }

    public String toString() {
        return l.f9321a.d(this);
    }
}
