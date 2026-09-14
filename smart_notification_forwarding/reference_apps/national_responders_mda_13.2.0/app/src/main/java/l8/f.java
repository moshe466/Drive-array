package l8;

/* loaded from: classes.dex */
public final class f implements Comparable<f> {

    /* renamed from: j, reason: collision with root package name */
    public static final f f11804j;

    /* renamed from: f, reason: collision with root package name */
    private final int f11805f;

    /* renamed from: g, reason: collision with root package name */
    private final int f11806g;

    /* renamed from: h, reason: collision with root package name */
    private final int f11807h;

    /* renamed from: i, reason: collision with root package name */
    private final int f11808i;

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
        f11804j = g.a();
    }

    public f(int i10, int i11, int i12) {
        this.f11805f = i10;
        this.f11806g = i11;
        this.f11807h = i12;
        this.f11808i = k(i10, i11, i12);
    }

    private final int k(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new d9.c(0, 255).t(i10) && new d9.c(0, 255).t(i11) && new d9.c(0, 255).t(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        f fVar = obj instanceof f ? (f) obj : null;
        return fVar != null && this.f11808i == fVar.f11808i;
    }

    public int hashCode() {
        return this.f11808i;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        y8.k.e(fVar, "other");
        return this.f11808i - fVar.f11808i;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11805f);
        sb2.append('.');
        sb2.append(this.f11806g);
        sb2.append('.');
        sb2.append(this.f11807h);
        return sb2.toString();
    }
}
