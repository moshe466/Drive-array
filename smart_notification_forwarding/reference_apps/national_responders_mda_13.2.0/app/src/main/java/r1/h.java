package r1;

/* loaded from: classes.dex */
public final class h implements m1.b<d> {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f13677a = new h();
    }

    public static h a() {
        return a.f13677a;
    }

    public static d c() {
        return (d) m1.d.c(e.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get() {
        return c();
    }
}
