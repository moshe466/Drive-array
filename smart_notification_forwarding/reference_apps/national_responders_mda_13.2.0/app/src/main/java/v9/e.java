package v9;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import n9.u0;

/* loaded from: classes.dex */
public final class e extends c0 {

    /* renamed from: m, reason: collision with root package name */
    public static final e f14779m = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<n9.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ u0 f14780f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u0 u0Var) {
            super(1);
            this.f14780f = u0Var;
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            Map<String, la.e> i10 = c0.f14765a.i();
            String d10 = ea.t.d(this.f14780f);
            Objects.requireNonNull(i10, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            return i10.containsKey(d10);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    private e() {
    }

    public final List<la.e> i(la.e eVar) {
        List<la.e> d10;
        y8.k.e(eVar, "name");
        List<la.e> list = c0.f14765a.e().get(eVar);
        if (list != null) {
            return list;
        }
        d10 = m8.q.d();
        return d10;
    }

    public final la.e j(u0 u0Var) {
        y8.k.e(u0Var, "functionDescriptor");
        Map<String, la.e> i10 = c0.f14765a.i();
        String d10 = ea.t.d(u0Var);
        if (d10 == null) {
            return null;
        }
        return i10.get(d10);
    }

    public final boolean k(la.e eVar) {
        y8.k.e(eVar, "<this>");
        return c0.f14765a.f().contains(eVar);
    }

    public final boolean l(u0 u0Var) {
        y8.k.e(u0Var, "functionDescriptor");
        return k9.h.e0(u0Var) && ra.a.d(u0Var, false, new a(u0Var), 1, null) != null;
    }

    public final boolean m(u0 u0Var) {
        y8.k.e(u0Var, "<this>");
        return y8.k.a(u0Var.c().k(), "removeAt") && y8.k.a(ea.t.d(u0Var), c0.f14765a.g().b());
    }
}
