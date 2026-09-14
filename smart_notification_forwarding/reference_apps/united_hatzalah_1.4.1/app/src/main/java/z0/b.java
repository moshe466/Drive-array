package z0;

/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final b f6810d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f6811e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f6812f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f6813g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f6814h;
    public static final b i;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6815b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6816c;

    static {
        int i3 = 0;
        f6810d = new b("NONE", i3);
        f6811e = new b("FULL", i3);
        int i4 = 1;
        f6812f = new b("FLAT", i4);
        f6813g = new b("HALF_OPENED", i4);
        int i5 = 2;
        f6814h = new b("FOLD", i5);
        i = new b("HINGE", i5);
    }

    public /* synthetic */ b(String str, int i3) {
        this.f6815b = i3;
        this.f6816c = str;
    }

    public String toString() {
        switch (this.f6815b) {
            case 0:
                return (String) this.f6816c;
            case 1:
                return (String) this.f6816c;
            case 2:
                return (String) this.f6816c;
            default:
                return super.toString();
        }
    }

    public b(A0.a aVar) {
        this.f6815b = 3;
        int i3 = m.f6838b;
        this.f6816c = aVar;
    }
}
