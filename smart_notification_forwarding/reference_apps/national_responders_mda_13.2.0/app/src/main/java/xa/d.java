package xa;

import ga.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.d0;
import n9.f0;
import xa.x;

/* loaded from: classes.dex */
public final class d implements c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, pa.g<?>> {

    /* renamed from: a, reason: collision with root package name */
    private final wa.a f15565a;

    /* renamed from: b, reason: collision with root package name */
    private final e f15566b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15567a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.PROPERTY.ordinal()] = 1;
            iArr[b.PROPERTY_GETTER.ordinal()] = 2;
            iArr[b.PROPERTY_SETTER.ordinal()] = 3;
            f15567a = iArr;
        }
    }

    public d(d0 d0Var, f0 f0Var, wa.a aVar) {
        y8.k.e(d0Var, "module");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(aVar, "protocol");
        this.f15565a = aVar;
        this.f15566b = new e(d0Var, f0Var);
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> a(ga.s sVar, ia.c cVar) {
        int n10;
        y8.k.e(sVar, "proto");
        y8.k.e(cVar, "nameResolver");
        List list = (List) sVar.v(this.f15565a.l());
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> c(x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, b bVar) {
        i.d dVar;
        Object h10;
        int n10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "proto");
        y8.k.e(bVar, "kind");
        if (qVar instanceof ga.d) {
            dVar = (ga.d) qVar;
            h10 = this.f15565a.c();
        } else if (qVar instanceof ga.i) {
            dVar = (ga.i) qVar;
            h10 = this.f15565a.f();
        } else {
            if (!(qVar instanceof ga.n)) {
                throw new IllegalStateException(y8.k.j("Unknown message: ", qVar).toString());
            }
            int i10 = a.f15567a[bVar.ordinal()];
            if (i10 == 1) {
                dVar = (ga.n) qVar;
                h10 = this.f15565a.h();
            } else if (i10 == 2) {
                dVar = (ga.n) qVar;
                h10 = this.f15565a.i();
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                dVar = (ga.n) qVar;
                h10 = this.f15565a.j();
            }
        }
        List list = (List) dVar.v(h10);
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), xVar.b()));
        }
        return arrayList;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d(x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, b bVar, int i10, ga.u uVar) {
        int n10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "callableProto");
        y8.k.e(bVar, "kind");
        y8.k.e(uVar, "proto");
        List list = (List) uVar.v(this.f15565a.g());
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), xVar.b()));
        }
        return arrayList;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> e(x xVar, ga.n nVar) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f(x xVar, ga.g gVar) {
        int n10;
        y8.k.e(xVar, "container");
        y8.k.e(gVar, "proto");
        List list = (List) gVar.v(this.f15565a.d());
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), xVar.b()));
        }
        return arrayList;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> g(x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, b bVar) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "proto");
        y8.k.e(bVar, "kind");
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> h(x.a aVar) {
        int n10;
        y8.k.e(aVar, "container");
        List list = (List) aVar.f().v(this.f15565a.a());
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), aVar.b()));
        }
        return arrayList;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> i(x xVar, ga.n nVar) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d10;
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> j(ga.q qVar, ia.c cVar) {
        int n10;
        y8.k.e(qVar, "proto");
        y8.k.e(cVar, "nameResolver");
        List list = (List) qVar.v(this.f15565a.k());
        if (list == null) {
            list = m8.q.d();
        }
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f15566b.a((ga.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // xa.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public pa.g<?> b(x xVar, ga.n nVar, bb.b0 b0Var) {
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        y8.k.e(b0Var, "expectedType");
        b.C0176b.c cVar = (b.C0176b.c) ia.e.a(nVar, this.f15565a.b());
        if (cVar == null) {
            return null;
        }
        return this.f15566b.f(b0Var, cVar, xVar.b());
    }
}
