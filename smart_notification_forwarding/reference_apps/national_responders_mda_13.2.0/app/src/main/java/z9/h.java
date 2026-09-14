package z9;

import ca.u;
import ea.n;
import ea.o;
import ea.p;
import fa.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import m8.l0;
import m8.q;
import m8.r;
import n9.v0;
import p9.z;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class h extends z {

    /* renamed from: q, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16311q = {w.g(new t(w.b(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), w.g(new t(w.b(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};

    /* renamed from: k, reason: collision with root package name */
    private final u f16312k;

    /* renamed from: l, reason: collision with root package name */
    private final y9.g f16313l;

    /* renamed from: m, reason: collision with root package name */
    private final ab.i f16314m;

    /* renamed from: n, reason: collision with root package name */
    private final d f16315n;

    /* renamed from: o, reason: collision with root package name */
    private final ab.i<List<la.b>> f16316o;

    /* renamed from: p, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f16317p;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<Map<String, ? extends o>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, o> b() {
            Map<String, o> p10;
            ea.u n10 = h.this.f16313l.a().n();
            String b10 = h.this.f().b();
            y8.k.d(b10, "fqName.asString()");
            List<String> a10 = n10.a(b10);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : a10) {
                la.a m10 = la.a.m(sa.c.d(str).e());
                y8.k.d(m10, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                o b11 = n.b(hVar.f16313l.a().i(), m10);
                l8.n a11 = b11 == null ? null : l8.t.a(str, b11);
                if (a11 != null) {
                    arrayList.add(a11);
                }
            }
            p10 = l0.p(arrayList);
            return p10;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<HashMap<sa.c, sa.c>> {

        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f16320a;

            static {
                int[] iArr = new int[a.EnumC0166a.valuesCustom().length];
                iArr[a.EnumC0166a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[a.EnumC0166a.FILE_FACADE.ordinal()] = 2;
                f16320a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HashMap<sa.c, sa.c> b() {
            HashMap<sa.c, sa.c> hashMap = new HashMap<>();
            for (Map.Entry<String, o> entry : h.this.X0().entrySet()) {
                String key = entry.getKey();
                o value = entry.getValue();
                sa.c d10 = sa.c.d(key);
                y8.k.d(d10, "byInternalName(partInternalName)");
                fa.a a10 = value.a();
                int i10 = a.f16320a[a10.c().ordinal()];
                if (i10 == 1) {
                    String e10 = a10.e();
                    if (e10 != null) {
                        sa.c d11 = sa.c.d(e10);
                        y8.k.d(d11, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                        hashMap.put(d10, d11);
                    }
                } else if (i10 == 2) {
                    hashMap.put(d10, d10);
                }
            }
            return hashMap;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<List<? extends la.b>> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<la.b> b() {
            int n10;
            Collection<u> n11 = h.this.f16312k.n();
            n10 = r.n(n11, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = n11.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).f());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(y9.g gVar, u uVar) {
        super(gVar.d(), uVar.f());
        List d10;
        y8.k.e(gVar, "outerContext");
        y8.k.e(uVar, "jPackage");
        this.f16312k = uVar;
        y9.g d11 = y9.a.d(gVar, this, null, 0, 6, null);
        this.f16313l = d11;
        this.f16314m = d11.e().a(new a());
        this.f16315n = new d(d11, uVar, this);
        ab.n e10 = d11.e();
        c cVar = new c();
        d10 = q.d();
        this.f16316o = e10.e(cVar, d10);
        this.f16317p = d11.a().h().a() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b() : y9.e.a(d11, uVar);
        d11.e().a(new b());
    }

    public final n9.e W0(ca.g gVar) {
        y8.k.e(gVar, "jClass");
        return this.f16315n.j().O(gVar);
    }

    public final Map<String, o> X0() {
        return (Map) ab.m.a(this.f16314m, this, f16311q[0]);
    }

    @Override // n9.g0
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public d A() {
        return this.f16315n;
    }

    public final List<la.b> Z0() {
        return this.f16316o.b();
    }

    @Override // p9.z, p9.k, n9.p
    public v0 k() {
        return new p(this);
    }

    @Override // p9.z, p9.j
    public String toString() {
        return y8.k.j("Lazy Java package fragment: ", f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.f16317p;
    }
}
