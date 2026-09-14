package kotlinx.coroutines.internal;

import java.util.Objects;
import nb.n1;
import p8.f;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f11611a = new b0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final x8.p<Object, f.b, Object> f11612b = a.f11615f;

    /* renamed from: c, reason: collision with root package name */
    private static final x8.p<n1<?>, f.b, n1<?>> f11613c = b.f11616f;

    /* renamed from: d, reason: collision with root package name */
    private static final x8.p<i0, f.b, i0> f11614d = c.f11617f;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.p<Object, f.b, Object> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f11615f = new a();

        a() {
            super(2);
        }

        @Override // x8.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object g(Object obj, f.b bVar) {
            if (!(bVar instanceof n1)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.p<n1<?>, f.b, n1<?>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11616f = new b();

        b() {
            super(2);
        }

        @Override // x8.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n1<?> g(n1<?> n1Var, f.b bVar) {
            if (n1Var != null) {
                return n1Var;
            }
            if (bVar instanceof n1) {
                return (n1) bVar;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.p<i0, f.b, i0> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f11617f = new c();

        c() {
            super(2);
        }

        @Override // x8.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 g(i0 i0Var, f.b bVar) {
            if (bVar instanceof n1) {
                n1<?> n1Var = (n1) bVar;
                i0Var.a(n1Var, n1Var.M(i0Var.f11629a));
            }
            return i0Var;
        }
    }

    public static final void a(p8.f fVar, Object obj) {
        if (obj == f11611a) {
            return;
        }
        if (obj instanceof i0) {
            ((i0) obj).b(fVar);
            return;
        }
        Object fold = fVar.fold(null, f11613c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((n1) fold).f(fVar, obj);
    }

    public static final Object b(p8.f fVar) {
        Object fold = fVar.fold(0, f11612b);
        y8.k.b(fold);
        return fold;
    }

    public static final Object c(p8.f fVar, Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        return obj == 0 ? f11611a : obj instanceof Integer ? fVar.fold(new i0(fVar, ((Number) obj).intValue()), f11614d) : ((n1) obj).M(fVar);
    }
}
