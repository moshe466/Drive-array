package ea;

import bb.b0;
import ea.o;
import ea.r;
import ga.c;
import ja.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import ka.e;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import n9.v0;
import xa.x;

/* loaded from: classes.dex */
public abstract class a<A, C> implements xa.c<A, C> {

    /* renamed from: a, reason: collision with root package name */
    private final m f9262a;

    /* renamed from: b, reason: collision with root package name */
    private final ab.g<o, b<A, C>> f9263b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ea.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0151a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0151a[] valuesCustom() {
            EnumC0151a[] valuesCustom = values();
            EnumC0151a[] enumC0151aArr = new EnumC0151a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, enumC0151aArr, 0, valuesCustom.length);
            return enumC0151aArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<A, C> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<r, List<A>> f9264a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<r, C> f9265b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<r, ? extends List<? extends A>> map, Map<r, ? extends C> map2) {
            y8.k.e(map, "memberAnnotations");
            y8.k.e(map2, "propertyConstants");
            this.f9264a = map;
            this.f9265b = map2;
        }

        public final Map<r, List<A>> a() {
            return this.f9264a;
        }

        public final Map<r, C> b() {
            return this.f9265b;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9266a;

        static {
            int[] iArr = new int[xa.b.values().length];
            iArr[xa.b.PROPERTY_GETTER.ordinal()] = 1;
            iArr[xa.b.PROPERTY_SETTER.ordinal()] = 2;
            iArr[xa.b.PROPERTY.ordinal()] = 3;
            f9266a = iArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements o.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<A, C> f9267a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<r, List<A>> f9268b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HashMap<r, C> f9269c;

        /* renamed from: ea.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0152a extends b implements o.e {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f9270d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0152a(d dVar, r rVar) {
                super(dVar, rVar);
                y8.k.e(dVar, "this$0");
                y8.k.e(rVar, "signature");
                this.f9270d = dVar;
            }

            @Override // ea.o.e
            public o.a b(int i10, la.a aVar, v0 v0Var) {
                y8.k.e(aVar, "classId");
                y8.k.e(v0Var, "source");
                r e10 = r.f9327b.e(d(), i10);
                List<A> list = this.f9270d.f9268b.get(e10);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f9270d.f9268b.put(e10, list);
                }
                return this.f9270d.f9267a.x(aVar, v0Var, list);
            }
        }

        /* loaded from: classes.dex */
        public class b implements o.c {

            /* renamed from: a, reason: collision with root package name */
            private final r f9271a;

            /* renamed from: b, reason: collision with root package name */
            private final ArrayList<A> f9272b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f9273c;

            public b(d dVar, r rVar) {
                y8.k.e(dVar, "this$0");
                y8.k.e(rVar, "signature");
                this.f9273c = dVar;
                this.f9271a = rVar;
                this.f9272b = new ArrayList<>();
            }

            @Override // ea.o.c
            public void a() {
                if (!this.f9272b.isEmpty()) {
                    this.f9273c.f9268b.put(this.f9271a, this.f9272b);
                }
            }

            @Override // ea.o.c
            public o.a c(la.a aVar, v0 v0Var) {
                y8.k.e(aVar, "classId");
                y8.k.e(v0Var, "source");
                return this.f9273c.f9267a.x(aVar, v0Var, this.f9272b);
            }

            protected final r d() {
                return this.f9271a;
            }
        }

        d(a<A, C> aVar, HashMap<r, List<A>> hashMap, HashMap<r, C> hashMap2) {
            this.f9267a = aVar;
            this.f9268b = hashMap;
            this.f9269c = hashMap2;
        }

        @Override // ea.o.d
        public o.c a(la.e eVar, String str, Object obj) {
            C z10;
            y8.k.e(eVar, "name");
            y8.k.e(str, "desc");
            r.a aVar = r.f9327b;
            String k10 = eVar.k();
            y8.k.d(k10, "name.asString()");
            r a10 = aVar.a(k10, str);
            if (obj != null && (z10 = this.f9267a.z(str, obj)) != null) {
                this.f9269c.put(a10, z10);
            }
            return new b(this, a10);
        }

        @Override // ea.o.d
        public o.e b(la.e eVar, String str) {
            y8.k.e(eVar, "name");
            y8.k.e(str, "desc");
            r.a aVar = r.f9327b;
            String k10 = eVar.k();
            y8.k.d(k10, "name.asString()");
            return new C0152a(this, aVar.d(k10, str));
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements o.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<A, C> f9274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f9275b;

        e(a<A, C> aVar, ArrayList<A> arrayList) {
            this.f9274a = aVar;
            this.f9275b = arrayList;
        }

        @Override // ea.o.c
        public void a() {
        }

        @Override // ea.o.c
        public o.a c(la.a aVar, v0 v0Var) {
            y8.k.e(aVar, "classId");
            y8.k.e(v0Var, "source");
            return this.f9274a.x(aVar, v0Var, this.f9275b);
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements x8.l<o, b<? extends A, ? extends C>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<A, C> f9276f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(a<A, C> aVar) {
            super(1);
            this.f9276f = aVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b<A, C> h(o oVar) {
            y8.k.e(oVar, "kotlinClass");
            return this.f9276f.y(oVar);
        }
    }

    public a(ab.n nVar, m mVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(mVar, "kotlinClassFinder");
        this.f9262a = mVar;
        this.f9263b = nVar.i(new f(this));
    }

    private final List<A> A(xa.x xVar, ga.n nVar, EnumC0151a enumC0151a) {
        boolean A;
        List<A> d10;
        List<A> d11;
        List<A> d12;
        Boolean d13 = ia.b.f10820z.d(nVar.U());
        y8.k.d(d13, "IS_CONST.get(proto.flags)");
        boolean booleanValue = d13.booleanValue();
        ka.h hVar = ka.h.f11321a;
        boolean f10 = ka.h.f(nVar);
        EnumC0151a enumC0151a2 = EnumC0151a.PROPERTY;
        ia.c b10 = xVar.b();
        ia.g d14 = xVar.d();
        if (enumC0151a == enumC0151a2) {
            r u10 = u(this, nVar, b10, d14, false, true, false, 40, null);
            if (u10 != null) {
                return o(this, xVar, u10, true, false, Boolean.valueOf(booleanValue), f10, 8, null);
            }
            d12 = m8.q.d();
            return d12;
        }
        r u11 = u(this, nVar, b10, d14, true, false, false, 48, null);
        if (u11 == null) {
            d11 = m8.q.d();
            return d11;
        }
        A = mb.s.A(u11.a(), "$delegate", false, 2, null);
        if (A == (enumC0151a == EnumC0151a.DELEGATE_FIELD)) {
            return n(xVar, u11, true, true, Boolean.valueOf(booleanValue), f10);
        }
        d10 = m8.q.d();
        return d10;
    }

    private final o C(x.a aVar) {
        v0 c10 = aVar.c();
        q qVar = c10 instanceof q ? (q) c10 : null;
        if (qVar == null) {
            return null;
        }
        return qVar.d();
    }

    private final int m(xa.x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar) {
        if (qVar instanceof ga.i) {
            if (ia.f.d((ga.i) qVar)) {
                return 1;
            }
        } else if (qVar instanceof ga.n) {
            if (ia.f.e((ga.n) qVar)) {
                return 1;
            }
        } else {
            if (!(qVar instanceof ga.d)) {
                throw new UnsupportedOperationException(y8.k.j("Unsupported message: ", qVar.getClass()));
            }
            x.a aVar = (x.a) xVar;
            if (aVar.g() == c.EnumC0180c.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        }
        return 0;
    }

    private final List<A> n(xa.x xVar, r rVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        List<A> d10;
        List<A> d11;
        o p10 = p(xVar, v(xVar, z10, z11, bool, z12));
        if (p10 == null) {
            d11 = m8.q.d();
            return d11;
        }
        List<A> list = this.f9263b.h(p10).a().get(rVar);
        if (list != null) {
            return list;
        }
        d10 = m8.q.d();
        return d10;
    }

    static /* synthetic */ List o(a aVar, xa.x xVar, r rVar, boolean z10, boolean z11, Boolean bool, boolean z12, int i10, Object obj) {
        if (obj == null) {
            return aVar.n(xVar, rVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? null : bool, (i10 & 32) != 0 ? false : z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final o p(xa.x xVar, o oVar) {
        if (oVar != null) {
            return oVar;
        }
        if (xVar instanceof x.a) {
            return C((x.a) xVar);
        }
        return null;
    }

    private final r r(kotlin.reflect.jvm.internal.impl.protobuf.q qVar, ia.c cVar, ia.g gVar, xa.b bVar, boolean z10) {
        r.a aVar;
        a.c A;
        String str;
        r.a aVar2;
        e.b e10;
        if (qVar instanceof ga.d) {
            aVar2 = r.f9327b;
            e10 = ka.h.f11321a.b((ga.d) qVar, cVar, gVar);
            if (e10 == null) {
                return null;
            }
        } else {
            if (!(qVar instanceof ga.i)) {
                if (!(qVar instanceof ga.n)) {
                    return null;
                }
                i.f<ga.n, a.d> fVar = ja.a.f10976d;
                y8.k.d(fVar, "propertySignature");
                a.d dVar = (a.d) ia.e.a((i.d) qVar, fVar);
                if (dVar == null) {
                    return null;
                }
                int i10 = c.f9266a[bVar.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return t((ga.n) qVar, cVar, gVar, true, true, z10);
                    }
                    if (!dVar.G()) {
                        return null;
                    }
                    aVar = r.f9327b;
                    A = dVar.B();
                    str = "signature.setter";
                } else {
                    if (!dVar.F()) {
                        return null;
                    }
                    aVar = r.f9327b;
                    A = dVar.A();
                    str = "signature.getter";
                }
                y8.k.d(A, str);
                return aVar.c(cVar, A);
            }
            aVar2 = r.f9327b;
            e10 = ka.h.f11321a.e((ga.i) qVar, cVar, gVar);
            if (e10 == null) {
                return null;
            }
        }
        return aVar2.b(e10);
    }

    static /* synthetic */ r s(a aVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, ia.c cVar, ia.g gVar, xa.b bVar, boolean z10, int i10, Object obj) {
        if (obj == null) {
            return aVar.r(qVar, cVar, gVar, bVar, (i10 & 16) != 0 ? false : z10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final r t(ga.n nVar, ia.c cVar, ia.g gVar, boolean z10, boolean z11, boolean z12) {
        i.f<ga.n, a.d> fVar = ja.a.f10976d;
        y8.k.d(fVar, "propertySignature");
        a.d dVar = (a.d) ia.e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        if (z10) {
            e.a c10 = ka.h.f11321a.c(nVar, cVar, gVar, z12);
            if (c10 == null) {
                return null;
            }
            return r.f9327b.b(c10);
        }
        if (!z11 || !dVar.H()) {
            return null;
        }
        r.a aVar = r.f9327b;
        a.c C = dVar.C();
        y8.k.d(C, "signature.syntheticMethod");
        return aVar.c(cVar, C);
    }

    static /* synthetic */ r u(a aVar, ga.n nVar, ia.c cVar, ia.g gVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if (obj == null) {
            return aVar.t(nVar, cVar, gVar, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? true : z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final o v(xa.x xVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        x.a h10;
        m mVar;
        String t10;
        la.a m10;
        String str;
        if (z10) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + xVar + ')').toString());
            }
            if (xVar instanceof x.a) {
                x.a aVar = (x.a) xVar;
                if (aVar.g() == c.EnumC0180c.INTERFACE) {
                    mVar = this.f9262a;
                    m10 = aVar.e().d(la.e.r("DefaultImpls"));
                    str = "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))";
                    y8.k.d(m10, str);
                    return n.b(mVar, m10);
                }
            }
            if (bool.booleanValue() && (xVar instanceof x.b)) {
                v0 c10 = xVar.c();
                i iVar = c10 instanceof i ? (i) c10 : null;
                sa.c e10 = iVar == null ? null : iVar.e();
                if (e10 != null) {
                    mVar = this.f9262a;
                    String f10 = e10.f();
                    y8.k.d(f10, "facadeClassName.internalName");
                    t10 = mb.r.t(f10, '/', '.', false, 4, null);
                    m10 = la.a.m(new la.b(t10));
                    str = "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))";
                    y8.k.d(m10, str);
                    return n.b(mVar, m10);
                }
            }
        }
        if (z11 && (xVar instanceof x.a)) {
            x.a aVar2 = (x.a) xVar;
            if (aVar2.g() == c.EnumC0180c.COMPANION_OBJECT && (h10 = aVar2.h()) != null && (h10.g() == c.EnumC0180c.CLASS || h10.g() == c.EnumC0180c.ENUM_CLASS || (z12 && (h10.g() == c.EnumC0180c.INTERFACE || h10.g() == c.EnumC0180c.ANNOTATION_CLASS)))) {
                return C(h10);
            }
        }
        if (!(xVar instanceof x.b) || !(xVar.c() instanceof i)) {
            return null;
        }
        v0 c11 = xVar.c();
        Objects.requireNonNull(c11, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        i iVar2 = (i) c11;
        o f11 = iVar2.f();
        return f11 == null ? n.b(this.f9262a, iVar2.d()) : f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o.a x(la.a aVar, v0 v0Var, List<A> list) {
        if (j9.a.f10971a.a().contains(aVar)) {
            return null;
        }
        return w(aVar, v0Var, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b<A, C> y(o oVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        oVar.c(new d(this, hashMap, hashMap2), q(oVar));
        return new b<>(hashMap, hashMap2);
    }

    protected abstract A B(ga.b bVar, ia.c cVar);

    protected abstract C D(C c10);

    @Override // xa.c
    public List<A> a(ga.s sVar, ia.c cVar) {
        int n10;
        y8.k.e(sVar, "proto");
        y8.k.e(cVar, "nameResolver");
        Object v10 = sVar.v(ja.a.f10980h);
        y8.k.d(v10, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<ga.b> iterable = (Iterable) v10;
        n10 = m8.r.n(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (ga.b bVar : iterable) {
            y8.k.d(bVar, "it");
            arrayList.add(B(bVar, cVar));
        }
        return arrayList;
    }

    @Override // xa.c
    public C b(xa.x xVar, ga.n nVar, b0 b0Var) {
        C c10;
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        y8.k.e(b0Var, "expectedType");
        Boolean d10 = ia.b.f10820z.d(nVar.U());
        ka.h hVar = ka.h.f11321a;
        o p10 = p(xVar, v(xVar, true, true, d10, ka.h.f(nVar)));
        if (p10 == null) {
            return null;
        }
        r r10 = r(nVar, xVar.b(), xVar.d(), xa.b.PROPERTY, p10.a().d().d(ea.e.f9295b.a()));
        if (r10 == null || (c10 = this.f9263b.h(p10).b().get(r10)) == null) {
            return null;
        }
        k9.o oVar = k9.o.f11295a;
        return k9.o.d(b0Var) ? D(c10) : c10;
    }

    @Override // xa.c
    public List<A> c(xa.x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar) {
        List<A> d10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "proto");
        y8.k.e(bVar, "kind");
        if (bVar == xa.b.PROPERTY) {
            return A(xVar, (ga.n) qVar, EnumC0151a.PROPERTY);
        }
        r s10 = s(this, qVar, xVar.b(), xVar.d(), bVar, false, 16, null);
        if (s10 != null) {
            return o(this, xVar, s10, false, false, null, false, 60, null);
        }
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<A> d(xa.x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar, int i10, ga.u uVar) {
        List<A> d10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "callableProto");
        y8.k.e(bVar, "kind");
        y8.k.e(uVar, "proto");
        r s10 = s(this, qVar, xVar.b(), xVar.d(), bVar, false, 16, null);
        if (s10 != null) {
            return o(this, xVar, r.f9327b.e(s10, i10 + m(xVar, qVar)), false, false, null, false, 60, null);
        }
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<A> e(xa.x xVar, ga.n nVar) {
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        return A(xVar, nVar, EnumC0151a.DELEGATE_FIELD);
    }

    @Override // xa.c
    public List<A> f(xa.x xVar, ga.g gVar) {
        y8.k.e(xVar, "container");
        y8.k.e(gVar, "proto");
        r.a aVar = r.f9327b;
        String a10 = xVar.b().a(gVar.H());
        ka.b bVar = ka.b.f11300a;
        String c10 = ((x.a) xVar).e().c();
        y8.k.d(c10, "container as ProtoContainer.Class).classId.asString()");
        return o(this, xVar, aVar.a(a10, ka.b.b(c10)), false, false, null, false, 60, null);
    }

    @Override // xa.c
    public List<A> g(xa.x xVar, kotlin.reflect.jvm.internal.impl.protobuf.q qVar, xa.b bVar) {
        List<A> d10;
        y8.k.e(xVar, "container");
        y8.k.e(qVar, "proto");
        y8.k.e(bVar, "kind");
        r s10 = s(this, qVar, xVar.b(), xVar.d(), bVar, false, 16, null);
        if (s10 != null) {
            return o(this, xVar, r.f9327b.e(s10, 0), false, false, null, false, 60, null);
        }
        d10 = m8.q.d();
        return d10;
    }

    @Override // xa.c
    public List<A> h(x.a aVar) {
        y8.k.e(aVar, "container");
        o C = C(aVar);
        if (C == null) {
            throw new IllegalStateException(y8.k.j("Class for loading annotations is not found: ", aVar.a()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        C.b(new e(this, arrayList), q(C));
        return arrayList;
    }

    @Override // xa.c
    public List<A> i(xa.x xVar, ga.n nVar) {
        y8.k.e(xVar, "container");
        y8.k.e(nVar, "proto");
        return A(xVar, nVar, EnumC0151a.BACKING_FIELD);
    }

    @Override // xa.c
    public List<A> j(ga.q qVar, ia.c cVar) {
        int n10;
        y8.k.e(qVar, "proto");
        y8.k.e(cVar, "nameResolver");
        Object v10 = qVar.v(ja.a.f10978f);
        y8.k.d(v10, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ga.b> iterable = (Iterable) v10;
        n10 = m8.r.n(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (ga.b bVar : iterable) {
            y8.k.d(bVar, "it");
            arrayList.add(B(bVar, cVar));
        }
        return arrayList;
    }

    protected byte[] q(o oVar) {
        y8.k.e(oVar, "kotlinClass");
        return null;
    }

    protected abstract o.a w(la.a aVar, v0 v0Var, List<A> list);

    protected abstract C z(String str, Object obj);
}
