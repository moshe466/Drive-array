package w9;

import ab.m;
import java.util.Map;
import k9.k;
import kotlin.reflect.KProperty;
import m8.k0;
import pa.v;
import y8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f15320h = {w.g(new t(w.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: g, reason: collision with root package name */
    private final ab.i f15321g;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.a<Map<la.e, ? extends v>> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f15322f = new a();

        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<la.e, v> b() {
            Map<la.e, v> e10;
            e10 = k0.e(l8.t.a(c.f15310a.b(), new v("Deprecated in Java")));
            return e10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ca.a aVar, y9.g gVar) {
        super(gVar, aVar, k.a.f11287u);
        y8.k.e(gVar, "c");
        this.f15321g = gVar.e().a(a.f15322f);
    }

    @Override // w9.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        return (Map) m.a(this.f15321g, this, f15320h[0]);
    }
}
