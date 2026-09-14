package ea;

import bb.b0;
import ea.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n9.d0;
import n9.d1;
import n9.f0;
import n9.v0;

/* loaded from: classes.dex */
public final class b extends ea.a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, pa.g<?>> {

    /* renamed from: c, reason: collision with root package name */
    private final d0 f9277c;

    /* renamed from: d, reason: collision with root package name */
    private final f0 f9278d;

    /* renamed from: e, reason: collision with root package name */
    private final xa.e f9279e;

    /* loaded from: classes.dex */
    public static final class a implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private final HashMap<la.e, pa.g<?>> f9280a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n9.e f9281b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f9282c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f9283d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ v0 f9284e;

        /* renamed from: ea.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0153a implements o.a {

            /* renamed from: a, reason: collision with root package name */
            private final /* synthetic */ o.a f9285a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ o.a f9286b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f9287c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ la.e f9288d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f9289e;

            C0153a(o.a aVar, a aVar2, la.e eVar, ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> arrayList) {
                this.f9286b = aVar;
                this.f9287c = aVar2;
                this.f9288d = eVar;
                this.f9289e = arrayList;
                this.f9285a = aVar;
            }

            @Override // ea.o.a
            public void a() {
                this.f9286b.a();
                this.f9287c.f9280a.put(this.f9288d, new pa.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) m8.o.d0(this.f9289e)));
            }

            @Override // ea.o.a
            public void b(la.e eVar, la.a aVar, la.e eVar2) {
                y8.k.e(eVar, "name");
                y8.k.e(aVar, "enumClassId");
                y8.k.e(eVar2, "enumEntryName");
                this.f9285a.b(eVar, aVar, eVar2);
            }

            @Override // ea.o.a
            public o.b c(la.e eVar) {
                y8.k.e(eVar, "name");
                return this.f9285a.c(eVar);
            }

            @Override // ea.o.a
            public void d(la.e eVar, pa.f fVar) {
                y8.k.e(eVar, "name");
                y8.k.e(fVar, "value");
                this.f9285a.d(eVar, fVar);
            }

            @Override // ea.o.a
            public o.a e(la.e eVar, la.a aVar) {
                y8.k.e(eVar, "name");
                y8.k.e(aVar, "classId");
                return this.f9285a.e(eVar, aVar);
            }

            @Override // ea.o.a
            public void f(la.e eVar, Object obj) {
                this.f9285a.f(eVar, obj);
            }
        }

        /* renamed from: ea.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0154b implements o.b {

            /* renamed from: a, reason: collision with root package name */
            private final ArrayList<pa.g<?>> f9290a = new ArrayList<>();

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ la.e f9292c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ n9.e f9293d;

            C0154b(la.e eVar, n9.e eVar2) {
                this.f9292c = eVar;
                this.f9293d = eVar2;
            }

            @Override // ea.o.b
            public void a() {
                d1 b10 = w9.a.b(this.f9292c, this.f9293d);
                if (b10 != null) {
                    HashMap hashMap = a.this.f9280a;
                    la.e eVar = this.f9292c;
                    pa.h hVar = pa.h.f13329a;
                    List<? extends pa.g<?>> c10 = jb.a.c(this.f9290a);
                    b0 b11 = b10.b();
                    y8.k.d(b11, "parameter.type");
                    hashMap.put(eVar, hVar.a(c10, b11));
                }
            }

            @Override // ea.o.b
            public void b(pa.f fVar) {
                y8.k.e(fVar, "value");
                this.f9290a.add(new pa.q(fVar));
            }

            @Override // ea.o.b
            public void c(la.a aVar, la.e eVar) {
                y8.k.e(aVar, "enumClassId");
                y8.k.e(eVar, "enumEntryName");
                this.f9290a.add(new pa.j(aVar, eVar));
            }

            @Override // ea.o.b
            public void d(Object obj) {
                this.f9290a.add(a.this.i(this.f9292c, obj));
            }
        }

        a(n9.e eVar, b bVar, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list, v0 v0Var) {
            this.f9281b = eVar;
            this.f9282c = bVar;
            this.f9283d = list;
            this.f9284e = v0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final pa.g<?> i(la.e eVar, Object obj) {
            pa.g<?> c10 = pa.h.f13329a.c(obj);
            return c10 == null ? pa.k.f13334b.a(y8.k.j("Unsupported annotation argument: ", eVar)) : c10;
        }

        @Override // ea.o.a
        public void a() {
            this.f9283d.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(this.f9281b.s(), this.f9280a, this.f9284e));
        }

        @Override // ea.o.a
        public void b(la.e eVar, la.a aVar, la.e eVar2) {
            y8.k.e(eVar, "name");
            y8.k.e(aVar, "enumClassId");
            y8.k.e(eVar2, "enumEntryName");
            this.f9280a.put(eVar, new pa.j(aVar, eVar2));
        }

        @Override // ea.o.a
        public o.b c(la.e eVar) {
            y8.k.e(eVar, "name");
            return new C0154b(eVar, this.f9281b);
        }

        @Override // ea.o.a
        public void d(la.e eVar, pa.f fVar) {
            y8.k.e(eVar, "name");
            y8.k.e(fVar, "value");
            this.f9280a.put(eVar, new pa.q(fVar));
        }

        @Override // ea.o.a
        public o.a e(la.e eVar, la.a aVar) {
            y8.k.e(eVar, "name");
            y8.k.e(aVar, "classId");
            ArrayList arrayList = new ArrayList();
            b bVar = this.f9282c;
            v0 v0Var = v0.f12324a;
            y8.k.d(v0Var, "NO_SOURCE");
            o.a w10 = bVar.w(aVar, v0Var, arrayList);
            y8.k.b(w10);
            return new C0153a(w10, this, eVar, arrayList);
        }

        @Override // ea.o.a
        public void f(la.e eVar, Object obj) {
            if (eVar != null) {
                this.f9280a.put(eVar, i(eVar, obj));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d0 d0Var, f0 f0Var, ab.n nVar, m mVar) {
        super(nVar, mVar);
        y8.k.e(d0Var, "module");
        y8.k.e(f0Var, "notFoundClasses");
        y8.k.e(nVar, "storageManager");
        y8.k.e(mVar, "kotlinClassFinder");
        this.f9277c = d0Var;
        this.f9278d = f0Var;
        this.f9279e = new xa.e(d0Var, f0Var);
    }

    private final n9.e G(la.a aVar) {
        return n9.w.c(this.f9277c, aVar, this.f9278d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ea.a
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public pa.g<?> z(String str, Object obj) {
        boolean A;
        y8.k.e(str, "desc");
        y8.k.e(obj, "initializer");
        A = mb.s.A("ZBCS", str, false, 2, null);
        if (A) {
            int intValue = ((Integer) obj).intValue();
            int hashCode = str.hashCode();
            if (hashCode == 66) {
                if (str.equals("B")) {
                    obj = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(str);
            }
            if (hashCode == 67) {
                if (str.equals("C")) {
                    obj = Character.valueOf((char) intValue);
                }
                throw new AssertionError(str);
            }
            if (hashCode == 83) {
                if (str.equals("S")) {
                    obj = Short.valueOf((short) intValue);
                }
                throw new AssertionError(str);
            }
            if (hashCode == 90 && str.equals("Z")) {
                obj = Boolean.valueOf(intValue != 0);
            }
            throw new AssertionError(str);
        }
        return pa.h.f13329a.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ea.a
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c B(ga.b bVar, ia.c cVar) {
        y8.k.e(bVar, "proto");
        y8.k.e(cVar, "nameResolver");
        return this.f9279e.a(bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ea.a
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public pa.g<?> D(pa.g<?> gVar) {
        pa.g<?> yVar;
        y8.k.e(gVar, "constant");
        if (gVar instanceof pa.d) {
            yVar = new pa.w(((pa.d) gVar).b().byteValue());
        } else if (gVar instanceof pa.u) {
            yVar = new pa.z(((pa.u) gVar).b().shortValue());
        } else if (gVar instanceof pa.m) {
            yVar = new pa.x(((pa.m) gVar).b().intValue());
        } else {
            if (!(gVar instanceof pa.r)) {
                return gVar;
            }
            yVar = new pa.y(((pa.r) gVar).b().longValue());
        }
        return yVar;
    }

    @Override // ea.a
    protected o.a w(la.a aVar, v0 v0Var, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list) {
        y8.k.e(aVar, "annotationClassId");
        y8.k.e(v0Var, "source");
        y8.k.e(list, "result");
        return new a(G(aVar), this, list, v0Var);
    }
}
