package w9;

import ab.m;
import java.util.Map;
import k9.k;
import kotlin.reflect.KProperty;
import m8.k0;
import m8.l0;
import y8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f15325h = {w.g(new t(w.b(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: g, reason: collision with root package name */
    private final ab.i f15326g;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.a<Map<la.e, ? extends pa.g<?>>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<la.e, pa.g<?>> b() {
            Map<la.e, pa.g<?>> h10;
            pa.g<?> a10 = d.f15316a.a(h.this.c());
            Map<la.e, pa.g<?>> e10 = a10 == null ? null : k0.e(l8.t.a(c.f15310a.c(), a10));
            if (e10 != null) {
                return e10;
            }
            h10 = l0.h();
            return h10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ca.a aVar, y9.g gVar) {
        super(gVar, aVar, k.a.D);
        y8.k.e(aVar, "annotation");
        y8.k.e(gVar, "c");
        this.f15326g = gVar.e().a(new a());
    }

    @Override // w9.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        return (Map) m.a(this.f15326g, this, f15325h[0]);
    }
}
