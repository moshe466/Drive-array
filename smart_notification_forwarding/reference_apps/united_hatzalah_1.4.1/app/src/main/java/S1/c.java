package S1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f2117c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f2118d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f2119e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f2120f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f2121g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f2122h;
    public static final c i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f2123j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f2124k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f2125l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f2126m;

    /* renamed from: n, reason: collision with root package name */
    public static final c f2127n;

    /* renamed from: o, reason: collision with root package name */
    public static final c f2128o;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2129a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2130b;

    static {
        int i3 = 0;
        f2117c = new c("TINK", i3);
        f2118d = new c("CRUNCHY", i3);
        f2119e = new c("LEGACY", i3);
        f2120f = new c("NO_PREFIX", i3);
        int i4 = 1;
        f2121g = new c("SHA1", i4);
        f2122h = new c("SHA224", i4);
        i = new c("SHA256", i4);
        f2123j = new c("SHA384", i4);
        f2124k = new c("SHA512", i4);
        int i5 = 2;
        f2125l = new c("TINK", i5);
        f2126m = new c("CRUNCHY", i5);
        f2127n = new c("LEGACY", i5);
        f2128o = new c("NO_PREFIX", i5);
    }

    public /* synthetic */ c(String str, int i3) {
        this.f2129a = i3;
        this.f2130b = str;
    }

    public final String toString() {
        switch (this.f2129a) {
            case 0:
                return this.f2130b;
            case 1:
                return this.f2130b;
            default:
                return this.f2130b;
        }
    }
}
