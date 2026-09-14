package fc;

/* loaded from: classes.dex */
public final class a<L, M, R> extends b<L, M, R> {

    /* renamed from: f, reason: collision with root package name */
    public final L f9689f;

    /* renamed from: g, reason: collision with root package name */
    public final M f9690g;

    /* renamed from: h, reason: collision with root package name */
    public final R f9691h;

    static {
        r(null, null, null);
    }

    public a(L l10, M m10, R r10) {
        this.f9689f = l10;
        this.f9690g = m10;
        this.f9691h = r10;
    }

    public static <L, M, R> a<L, M, R> r(L l10, M m10, R r10) {
        return new a<>(l10, m10, r10);
    }

    @Override // fc.b
    public L k() {
        return this.f9689f;
    }

    @Override // fc.b
    public M l() {
        return this.f9690g;
    }

    @Override // fc.b
    public R n() {
        return this.f9691h;
    }
}
