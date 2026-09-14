package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import m8.r0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f11555a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<la.b> f11556b;

    static {
        Set<la.b> e10;
        e10 = r0.e(new la.b("kotlin.internal.NoInfer"), new la.b("kotlin.internal.Exact"));
        f11556b = e10;
    }

    private h() {
    }

    public final Set<la.b> a() {
        return f11556b;
    }
}
