package da;

import ea.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l8.w;
import m8.d0;
import m8.k0;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, k> f8836a = new LinkedHashMap();

    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f8837a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f8838b;

        /* renamed from: da.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0148a {

            /* renamed from: a, reason: collision with root package name */
            private final String f8839a;

            /* renamed from: b, reason: collision with root package name */
            private final List<l8.n<String, s>> f8840b;

            /* renamed from: c, reason: collision with root package name */
            private l8.n<String, s> f8841c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f8842d;

            public C0148a(a aVar, String str) {
                y8.k.e(aVar, "this$0");
                y8.k.e(str, "functionName");
                this.f8842d = aVar;
                this.f8839a = str;
                this.f8840b = new ArrayList();
                this.f8841c = l8.t.a("V", null);
            }

            public final l8.n<String, k> a() {
                int n10;
                int n11;
                v vVar = v.f9330a;
                String b10 = this.f8842d.b();
                String b11 = b();
                List<l8.n<String, s>> list = this.f8840b;
                n10 = m8.r.n(list, 10);
                ArrayList arrayList = new ArrayList(n10);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((l8.n) it.next()).c());
                }
                String k10 = vVar.k(b10, vVar.j(b11, arrayList, this.f8841c.c()));
                s d10 = this.f8841c.d();
                List<l8.n<String, s>> list2 = this.f8840b;
                n11 = m8.r.n(list2, 10);
                ArrayList arrayList2 = new ArrayList(n11);
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((s) ((l8.n) it2.next()).d());
                }
                return l8.t.a(k10, new k(d10, arrayList2));
            }

            public final String b() {
                return this.f8839a;
            }

            public final void c(String str, e... eVarArr) {
                Iterable<d0> b02;
                int n10;
                int d10;
                int a10;
                s sVar;
                y8.k.e(str, "type");
                y8.k.e(eVarArr, "qualifiers");
                List<l8.n<String, s>> list = this.f8840b;
                if (eVarArr.length == 0) {
                    sVar = null;
                } else {
                    b02 = m8.k.b0(eVarArr);
                    n10 = m8.r.n(b02, 10);
                    d10 = k0.d(n10);
                    a10 = d9.f.a(d10, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
                    for (d0 d0Var : b02) {
                        linkedHashMap.put(Integer.valueOf(d0Var.c()), (e) d0Var.d());
                    }
                    sVar = new s(linkedHashMap);
                }
                list.add(l8.t.a(str, sVar));
            }

            public final void d(String str, e... eVarArr) {
                Iterable<d0> b02;
                int n10;
                int d10;
                int a10;
                y8.k.e(str, "type");
                y8.k.e(eVarArr, "qualifiers");
                b02 = m8.k.b0(eVarArr);
                n10 = m8.r.n(b02, 10);
                d10 = k0.d(n10);
                a10 = d9.f.a(d10, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
                for (d0 d0Var : b02) {
                    linkedHashMap.put(Integer.valueOf(d0Var.c()), (e) d0Var.d());
                }
                this.f8841c = l8.t.a(str, new s(linkedHashMap));
            }

            public final void e(sa.d dVar) {
                y8.k.e(dVar, "type");
                String desc = dVar.getDesc();
                y8.k.d(desc, "type.desc");
                this.f8841c = l8.t.a(desc, null);
            }
        }

        public a(m mVar, String str) {
            y8.k.e(mVar, "this$0");
            y8.k.e(str, "className");
            this.f8838b = mVar;
            this.f8837a = str;
        }

        public final void a(String str, x8.l<? super C0148a, w> lVar) {
            y8.k.e(str, "name");
            y8.k.e(lVar, "block");
            Map map = this.f8838b.f8836a;
            C0148a c0148a = new C0148a(this, str);
            lVar.h(c0148a);
            l8.n<String, k> a10 = c0148a.a();
            map.put(a10.c(), a10.d());
        }

        public final String b() {
            return this.f8837a;
        }
    }

    public final Map<String, k> b() {
        return this.f8836a;
    }
}
