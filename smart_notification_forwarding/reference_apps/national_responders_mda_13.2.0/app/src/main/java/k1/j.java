package k1;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class j implements m1.b<Executor> {

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final j f11171a = new j();
    }

    public static j a() {
        return a.f11171a;
    }

    public static Executor b() {
        return (Executor) m1.d.c(i.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // k8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
