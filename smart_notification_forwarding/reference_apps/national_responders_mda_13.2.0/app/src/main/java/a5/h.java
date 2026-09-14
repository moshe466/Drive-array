package a5;

import com.google.gson.q;
import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements y {

    /* renamed from: f, reason: collision with root package name */
    private final z4.c f214f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f215g;

    /* loaded from: classes.dex */
    private final class a<K, V> extends x<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final x<K> f216a;

        /* renamed from: b, reason: collision with root package name */
        private final x<V> f217b;

        /* renamed from: c, reason: collision with root package name */
        private final z4.i<? extends Map<K, V>> f218c;

        public a(com.google.gson.e eVar, Type type, x<K> xVar, Type type2, x<V> xVar2, z4.i<? extends Map<K, V>> iVar) {
            this.f216a = new m(eVar, xVar, type);
            this.f217b = new m(eVar, xVar2, type2);
            this.f218c = iVar;
        }

        private String e(com.google.gson.k kVar) {
            if (!kVar.w()) {
                if (kVar.u()) {
                    return "null";
                }
                throw new AssertionError();
            }
            q j10 = kVar.j();
            if (j10.C()) {
                return String.valueOf(j10.z());
            }
            if (j10.A()) {
                return Boolean.toString(j10.x());
            }
            if (j10.D()) {
                return j10.s();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(f5.a aVar) {
            f5.b m02 = aVar.m0();
            if (m02 == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            Map<K, V> a10 = this.f218c.a();
            if (m02 == f5.b.BEGIN_ARRAY) {
                aVar.c();
                while (aVar.N()) {
                    aVar.c();
                    K b10 = this.f216a.b(aVar);
                    if (a10.put(b10, this.f217b.b(aVar)) != null) {
                        throw new t("duplicate key: " + b10);
                    }
                    aVar.v();
                }
                aVar.v();
            } else {
                aVar.d();
                while (aVar.N()) {
                    z4.f.f16191a.a(aVar);
                    K b11 = this.f216a.b(aVar);
                    if (a10.put(b11, this.f217b.b(aVar)) != null) {
                        throw new t("duplicate key: " + b11);
                    }
                }
                aVar.D();
            }
            return a10;
        }

        @Override // com.google.gson.x
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Map<K, V> map) {
            if (map == null) {
                cVar.b0();
                return;
            }
            if (!h.this.f215g) {
                cVar.g();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.O(String.valueOf(entry.getKey()));
                    this.f217b.d(cVar, entry.getValue());
                }
                cVar.D();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.k c10 = this.f216a.c(entry2.getKey());
                arrayList.add(c10);
                arrayList2.add(entry2.getValue());
                z10 |= c10.t() || c10.v();
            }
            if (!z10) {
                cVar.g();
                int size = arrayList.size();
                while (i10 < size) {
                    cVar.O(e((com.google.gson.k) arrayList.get(i10)));
                    this.f217b.d(cVar, arrayList2.get(i10));
                    i10++;
                }
                cVar.D();
                return;
            }
            cVar.f();
            int size2 = arrayList.size();
            while (i10 < size2) {
                cVar.f();
                z4.l.b((com.google.gson.k) arrayList.get(i10), cVar);
                this.f217b.d(cVar, arrayList2.get(i10));
                cVar.v();
                i10++;
            }
            cVar.v();
        }
    }

    public h(z4.c cVar, boolean z10) {
        this.f214f = cVar;
        this.f215g = z10;
    }

    private x<?> b(com.google.gson.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f265f : eVar.k(e5.a.b(type));
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
        Type e10 = aVar.e();
        if (!Map.class.isAssignableFrom(aVar.c())) {
            return null;
        }
        Type[] j10 = z4.b.j(e10, z4.b.k(e10));
        return new a(eVar, j10[0], b(eVar, j10[0]), j10[1], eVar.k(e5.a.b(j10[1])), this.f214f.a(aVar));
    }
}
