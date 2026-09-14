package v9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.k0;
import m8.l0;
import m8.r0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final la.b f14748a = new la.b("javax.annotation.meta.TypeQualifierNickname");

    /* renamed from: b, reason: collision with root package name */
    private static final la.b f14749b = new la.b("javax.annotation.meta.TypeQualifier");

    /* renamed from: c, reason: collision with root package name */
    private static final la.b f14750c = new la.b("javax.annotation.meta.TypeQualifierDefault");

    /* renamed from: d, reason: collision with root package name */
    private static final la.b f14751d = new la.b("kotlin.annotations.jvm.UnderMigration");

    /* renamed from: e, reason: collision with root package name */
    private static final List<a> f14752e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<la.b, s> f14753f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<la.b, s> f14754g;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<la.b> f14755h;

    static {
        List<a> g10;
        Map<la.b, s> e10;
        List b10;
        List b11;
        Map k10;
        Map<la.b, s> m10;
        Set<la.b> e11;
        a aVar = a.VALUE_PARAMETER;
        g10 = m8.q.g(a.FIELD, a.METHOD_RETURN_TYPE, aVar, a.TYPE_PARAMETER_BOUNDS, a.TYPE_USE);
        f14752e = g10;
        la.b g11 = z.g();
        da.h hVar = da.h.NOT_NULL;
        e10 = k0.e(l8.t.a(g11, new s(new da.i(hVar, false, 2, null), g10, false)));
        f14753f = e10;
        la.b bVar = new la.b("javax.annotation.ParametersAreNullableByDefault");
        da.i iVar = new da.i(da.h.NULLABLE, false, 2, null);
        b10 = m8.p.b(aVar);
        la.b bVar2 = new la.b("javax.annotation.ParametersAreNonnullByDefault");
        da.i iVar2 = new da.i(hVar, false, 2, null);
        b11 = m8.p.b(aVar);
        k10 = l0.k(l8.t.a(bVar, new s(iVar, b10, false, 4, null)), l8.t.a(bVar2, new s(iVar2, b11, false, 4, null)));
        m10 = l0.m(k10, e10);
        f14754g = m10;
        e11 = r0.e(z.f(), z.e());
        f14755h = e11;
    }

    public static final Map<la.b, s> a() {
        return f14754g;
    }

    public static final Set<la.b> b() {
        return f14755h;
    }

    public static final Map<la.b, s> c() {
        return f14753f;
    }

    public static final la.b d() {
        return f14751d;
    }

    public static final la.b e() {
        return f14750c;
    }

    public static final la.b f() {
        return f14749b;
    }

    public static final la.b g() {
        return f14748a;
    }
}
