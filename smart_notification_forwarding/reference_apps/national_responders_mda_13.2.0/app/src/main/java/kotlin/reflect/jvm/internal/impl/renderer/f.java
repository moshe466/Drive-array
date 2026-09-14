package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;

/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public static final class a {
        public static boolean a(f fVar) {
            y8.k.e(fVar, "this");
            return fVar.n().getIncludeAnnotationArguments();
        }

        public static boolean b(f fVar) {
            y8.k.e(fVar, "this");
            return fVar.n().getIncludeEmptyAnnotationArguments();
        }
    }

    void a(boolean z10);

    void b(boolean z10);

    void c(boolean z10);

    void d(m mVar);

    void e(Set<la.b> set);

    void f(boolean z10);

    void g(Set<? extends e> set);

    void h(k kVar);

    void i(kotlin.reflect.jvm.internal.impl.renderer.a aVar);

    void j(boolean z10);

    boolean k();

    Set<la.b> l();

    boolean m();

    kotlin.reflect.jvm.internal.impl.renderer.a n();

    void o(b bVar);

    void p(boolean z10);

    void q(boolean z10);
}
