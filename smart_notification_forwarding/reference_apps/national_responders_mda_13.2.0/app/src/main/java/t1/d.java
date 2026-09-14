package t1;

/* loaded from: classes.dex */
public final class d implements m1.b<t1.a> {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f14261a = new d();
    }

    public static d a() {
        return a.f14261a;
    }

    public static t1.a c() {
        return (t1.a) m1.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t1.a get() {
        return c();
    }
}
