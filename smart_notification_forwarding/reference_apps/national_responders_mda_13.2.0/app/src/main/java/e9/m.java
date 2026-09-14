package e9;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f9257c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final m f9258d = new m(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final n f9259a;

    /* renamed from: b, reason: collision with root package name */
    private final k f9260b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final m a(k kVar) {
            y8.k.e(kVar, "type");
            return new m(n.IN, kVar);
        }

        public final m b(k kVar) {
            y8.k.e(kVar, "type");
            return new m(n.OUT, kVar);
        }

        public final m c() {
            return m.f9258d;
        }

        public final m d(k kVar) {
            y8.k.e(kVar, "type");
            return new m(n.INVARIANT, kVar);
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9261a;

        static {
            int[] iArr = new int[n.values().length];
            iArr[n.INVARIANT.ordinal()] = 1;
            iArr[n.IN.ordinal()] = 2;
            iArr[n.OUT.ordinal()] = 3;
            f9261a = iArr;
        }
    }

    public m(n nVar, k kVar) {
        String str;
        this.f9259a = nVar;
        this.f9260b = kVar;
        if ((nVar == null) == (kVar == null)) {
            return;
        }
        if (nVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + nVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f9259a == mVar.f9259a && y8.k.a(this.f9260b, mVar.f9260b);
    }

    public int hashCode() {
        n nVar = this.f9259a;
        int hashCode = (nVar == null ? 0 : nVar.hashCode()) * 31;
        k kVar = this.f9260b;
        return hashCode + (kVar != null ? kVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2;
        String str;
        n nVar = this.f9259a;
        int i10 = nVar == null ? -1 : b.f9261a[nVar.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.f9260b);
        }
        if (i10 == 2) {
            sb2 = new StringBuilder();
            str = "in ";
        } else {
            if (i10 != 3) {
                throw new l8.l();
            }
            sb2 = new StringBuilder();
            str = "out ";
        }
        sb2.append(str);
        sb2.append(this.f9260b);
        return sb2.toString();
    }
}
