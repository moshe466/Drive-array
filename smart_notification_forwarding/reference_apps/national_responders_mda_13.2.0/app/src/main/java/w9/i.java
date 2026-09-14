package w9;

import ab.m;
import java.util.Map;
import k9.k;
import kotlin.reflect.KProperty;
import y8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class i extends b {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f15328h = {w.g(new t(w.b(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: g, reason: collision with root package name */
    private final ab.i f15329g;

    /* loaded from: classes.dex */
    static final class a extends l implements x8.a<Map<la.e, ? extends pa.g<? extends Object>>> {
        a() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0044  */
        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Map<la.e, pa.g<java.lang.Object>> b() {
            /*
                r3 = this;
                w9.i r0 = w9.i.this
                ca.b r0 = r0.c()
                boolean r1 = r0 instanceof ca.e
                r2 = 0
                if (r1 == 0) goto L1e
                w9.d r0 = w9.d.f15316a
                w9.i r1 = w9.i.this
                ca.b r1 = r1.c()
                ca.e r1 = (ca.e) r1
                java.util.List r1 = r1.d()
            L19:
                pa.g r0 = r0.c(r1)
                goto L30
            L1e:
                boolean r0 = r0 instanceof ca.m
                if (r0 == 0) goto L2f
                w9.d r0 = w9.d.f15316a
                w9.i r1 = w9.i.this
                ca.b r1 = r1.c()
                java.util.List r1 = m8.o.b(r1)
                goto L19
            L2f:
                r0 = r2
            L30:
                if (r0 != 0) goto L33
                goto L41
            L33:
                w9.c r1 = w9.c.f15310a
                la.e r1 = r1.d()
                l8.n r0 = l8.t.a(r1, r0)
                java.util.Map r2 = m8.i0.e(r0)
            L41:
                if (r2 == 0) goto L44
                goto L48
            L44:
                java.util.Map r2 = m8.i0.h()
            L48:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: w9.i.a.b():java.util.Map");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ca.a aVar, y9.g gVar) {
        super(gVar, aVar, k.a.A);
        y8.k.e(aVar, "annotation");
        y8.k.e(gVar, "c");
        this.f15329g = gVar.e().a(new a());
    }

    @Override // w9.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<Object>> a() {
        return (Map) m.a(this.f15329g, this, f15328h[0]);
    }
}
