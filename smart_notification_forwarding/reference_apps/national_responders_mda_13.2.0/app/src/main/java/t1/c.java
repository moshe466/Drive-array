package t1;

/* loaded from: classes.dex */
public final class c implements m1.b<t1.a> {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f14260a = new c();
    }

    public static c a() {
        return a.f14260a;
    }

    public static t1.a b() {
        return (t1.a) m1.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public t1.a get() {
        return b();
    }
}
