package r1;

/* loaded from: classes.dex */
public final class f implements m1.b<String> {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f13673a = new f();
    }

    public static f a() {
        return a.f13673a;
    }

    public static String b() {
        return (String) m1.d.c(e.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
