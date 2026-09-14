package ya;

import ab.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import m8.r;
import n9.d0;
import n9.f0;
import n9.h0;
import n9.i0;
import u9.c;
import x8.l;
import xa.j;
import xa.k;
import xa.m;
import xa.p;
import xa.q;
import xa.t;
import y8.i;
import y8.k;
import y8.w;

/* loaded from: classes.dex */
public final class b implements k9.a {

    /* renamed from: b, reason: collision with root package name */
    private final d f16004b = new d();

    /* loaded from: classes.dex */
    /* synthetic */ class a extends i implements l<String, InputStream> {
        a(d dVar) {
            super(1, dVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "loadResource";
        }

        @Override // y8.c
        public final e9.d k() {
            return w.b(d.class);
        }

        @Override // y8.c
        public final String m() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final InputStream h(String str) {
            k.e(str, "p0");
            return ((d) this.f15934g).a(str);
        }
    }

    @Override // k9.a
    public h0 a(n nVar, d0 d0Var, Iterable<? extends o9.b> iterable, o9.c cVar, o9.a aVar, boolean z10) {
        k.e(nVar, "storageManager");
        k.e(d0Var, "builtInsModule");
        k.e(iterable, "classDescriptorFactories");
        k.e(cVar, "platformDependentDeclarationFilter");
        k.e(aVar, "additionalClassPartsProvider");
        return b(nVar, d0Var, k9.k.f11250p, iterable, cVar, aVar, z10, new a(this.f16004b));
    }

    public final h0 b(n nVar, d0 d0Var, Set<la.b> set, Iterable<? extends o9.b> iterable, o9.c cVar, o9.a aVar, boolean z10, l<? super String, ? extends InputStream> lVar) {
        int n10;
        List d10;
        k.e(nVar, "storageManager");
        k.e(d0Var, "module");
        k.e(set, "packageFqNames");
        k.e(iterable, "classDescriptorFactories");
        k.e(cVar, "platformDependentDeclarationFilter");
        k.e(aVar, "additionalClassPartsProvider");
        k.e(lVar, "loadResource");
        n10 = r.n(set, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (la.b bVar : set) {
            String n11 = ya.a.f16003m.n(bVar);
            InputStream h10 = lVar.h(n11);
            if (h10 == null) {
                throw new IllegalStateException(k.j("Resource not found in classpath: ", n11));
            }
            arrayList.add(c.f16005r.a(bVar, nVar, d0Var, h10, z10));
        }
        i0 i0Var = new i0(arrayList);
        f0 f0Var = new f0(nVar, d0Var);
        k.a aVar2 = k.a.f15605a;
        m mVar = new m(i0Var);
        ya.a aVar3 = ya.a.f16003m;
        xa.d dVar = new xa.d(d0Var, f0Var, aVar3);
        t.a aVar4 = t.a.f15631a;
        p pVar = p.f15625a;
        y8.k.d(pVar, "DO_NOTHING");
        c.a aVar5 = c.a.f14494a;
        q.a aVar6 = q.a.f15626a;
        xa.i a10 = xa.i.f15582a.a();
        g e10 = aVar3.e();
        d10 = m8.q.d();
        j jVar = new j(nVar, d0Var, aVar2, mVar, dVar, i0Var, aVar4, pVar, aVar5, aVar6, iterable, f0Var, a10, aVar, cVar, e10, null, new ta.b(nVar, d10), null, 327680, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).W0(jVar);
        }
        return i0Var;
    }
}
