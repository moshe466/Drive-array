package com.google.gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: n, reason: collision with root package name */
    private static final e5.a<?> f7480n = e5.a.a(Object.class);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<e5.a<?>, f<?>>> f7481a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<e5.a<?>, x<?>> f7482b;

    /* renamed from: c, reason: collision with root package name */
    private final z4.c f7483c;

    /* renamed from: d, reason: collision with root package name */
    private final a5.e f7484d;

    /* renamed from: e, reason: collision with root package name */
    final List<y> f7485e;

    /* renamed from: f, reason: collision with root package name */
    final Map<Type, g<?>> f7486f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f7487g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f7488h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f7489i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f7490j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f7491k;

    /* renamed from: l, reason: collision with root package name */
    final List<y> f7492l;

    /* renamed from: m, reason: collision with root package name */
    final List<y> f7493m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x<Number> {
        a(e eVar) {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Double.valueOf(aVar.d0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            if (number == null) {
                cVar.b0();
            } else {
                e.d(number.doubleValue());
                cVar.n0(number);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends x<Number> {
        b(e eVar) {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Float.valueOf((float) aVar.d0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            if (number == null) {
                cVar.b0();
            } else {
                e.d(number.floatValue());
                cVar.n0(number);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends x<Number> {
        c() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Long.valueOf(aVar.f0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            if (number == null) {
                cVar.b0();
            } else {
                cVar.o0(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends x<AtomicLong> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f7494a;

        d(x xVar) {
            this.f7494a = xVar;
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(f5.a aVar) {
            return new AtomicLong(((Number) this.f7494a.b(aVar)).longValue());
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, AtomicLong atomicLong) {
            this.f7494a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0095e extends x<AtomicLongArray> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f7495a;

        C0095e(x xVar) {
            this.f7495a = xVar;
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(f5.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.N()) {
                arrayList.add(Long.valueOf(((Number) this.f7495a.b(aVar)).longValue()));
            }
            aVar.v();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, AtomicLongArray atomicLongArray) {
            cVar.f();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f7495a.d(cVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            cVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f<T> extends x<T> {

        /* renamed from: a, reason: collision with root package name */
        private x<T> f7496a;

        f() {
        }

        @Override // com.google.gson.x
        public T b(f5.a aVar) {
            x<T> xVar = this.f7496a;
            if (xVar != null) {
                return xVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.x
        public void d(f5.c cVar, T t10) {
            x<T> xVar = this.f7496a;
            if (xVar == null) {
                throw new IllegalStateException();
            }
            xVar.d(cVar, t10);
        }

        public void e(x<T> xVar) {
            if (this.f7496a != null) {
                throw new AssertionError();
            }
            this.f7496a = xVar;
        }
    }

    public e() {
        this(z4.d.f16177l, com.google.gson.c.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, u.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), v.DOUBLE, v.LAZILY_PARSED_NUMBER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(z4.d dVar, com.google.gson.d dVar2, Map<Type, g<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, u uVar, String str, int i10, int i11, List<y> list, List<y> list2, List<y> list3, w wVar, w wVar2) {
        this.f7481a = new ThreadLocal<>();
        this.f7482b = new ConcurrentHashMap();
        this.f7486f = map;
        z4.c cVar = new z4.c(map);
        this.f7483c = cVar;
        this.f7487g = z10;
        this.f7488h = z12;
        this.f7489i = z13;
        this.f7490j = z14;
        this.f7491k = z15;
        this.f7492l = list;
        this.f7493m = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a5.n.V);
        arrayList.add(a5.j.e(wVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(a5.n.B);
        arrayList.add(a5.n.f272m);
        arrayList.add(a5.n.f266g);
        arrayList.add(a5.n.f268i);
        arrayList.add(a5.n.f270k);
        x<Number> n10 = n(uVar);
        arrayList.add(a5.n.c(Long.TYPE, Long.class, n10));
        arrayList.add(a5.n.c(Double.TYPE, Double.class, e(z16)));
        arrayList.add(a5.n.c(Float.TYPE, Float.class, f(z16)));
        arrayList.add(a5.i.e(wVar2));
        arrayList.add(a5.n.f274o);
        arrayList.add(a5.n.f276q);
        arrayList.add(a5.n.b(AtomicLong.class, b(n10)));
        arrayList.add(a5.n.b(AtomicLongArray.class, c(n10)));
        arrayList.add(a5.n.f278s);
        arrayList.add(a5.n.f283x);
        arrayList.add(a5.n.D);
        arrayList.add(a5.n.F);
        arrayList.add(a5.n.b(BigDecimal.class, a5.n.f285z));
        arrayList.add(a5.n.b(BigInteger.class, a5.n.A));
        arrayList.add(a5.n.H);
        arrayList.add(a5.n.J);
        arrayList.add(a5.n.N);
        arrayList.add(a5.n.P);
        arrayList.add(a5.n.T);
        arrayList.add(a5.n.L);
        arrayList.add(a5.n.f263d);
        arrayList.add(a5.c.f197b);
        arrayList.add(a5.n.R);
        if (d5.d.f8664a) {
            arrayList.add(d5.d.f8668e);
            arrayList.add(d5.d.f8667d);
            arrayList.add(d5.d.f8669f);
        }
        arrayList.add(a5.a.f191c);
        arrayList.add(a5.n.f261b);
        arrayList.add(new a5.b(cVar));
        arrayList.add(new a5.h(cVar, z11));
        a5.e eVar = new a5.e(cVar);
        this.f7484d = eVar;
        arrayList.add(eVar);
        arrayList.add(a5.n.W);
        arrayList.add(new a5.k(cVar, dVar2, dVar, eVar));
        this.f7485e = Collections.unmodifiableList(arrayList);
    }

    private static void a(Object obj, f5.a aVar) {
        if (obj != null) {
            try {
                if (aVar.m0() == f5.b.END_DOCUMENT) {
                } else {
                    throw new l("JSON document was not fully consumed.");
                }
            } catch (f5.d e10) {
                throw new t(e10);
            } catch (IOException e11) {
                throw new l(e11);
            }
        }
    }

    private static x<AtomicLong> b(x<Number> xVar) {
        return new d(xVar).a();
    }

    private static x<AtomicLongArray> c(x<Number> xVar) {
        return new C0095e(xVar).a();
    }

    static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private x<Number> e(boolean z10) {
        return z10 ? a5.n.f281v : new a(this);
    }

    private x<Number> f(boolean z10) {
        return z10 ? a5.n.f280u : new b(this);
    }

    private static x<Number> n(u uVar) {
        return uVar == u.DEFAULT ? a5.n.f279t : new c();
    }

    public <T> T g(f5.a aVar, Type type) {
        boolean O = aVar.O();
        boolean z10 = true;
        aVar.r0(true);
        try {
            try {
                try {
                    aVar.m0();
                    z10 = false;
                    T b10 = k(e5.a.b(type)).b(aVar);
                    aVar.r0(O);
                    return b10;
                } catch (AssertionError e10) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e10.getMessage());
                    assertionError.initCause(e10);
                    throw assertionError;
                } catch (IllegalStateException e11) {
                    throw new t(e11);
                }
            } catch (EOFException e12) {
                if (!z10) {
                    throw new t(e12);
                }
                aVar.r0(O);
                return null;
            } catch (IOException e13) {
                throw new t(e13);
            }
        } catch (Throwable th) {
            aVar.r0(O);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) {
        f5.a o10 = o(reader);
        T t10 = (T) g(o10, type);
        a(t10, o10);
        return t10;
    }

    public <T> T i(String str, Class<T> cls) {
        return (T) z4.k.b(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public <T> x<T> k(e5.a<T> aVar) {
        x<T> xVar = (x) this.f7482b.get(aVar == null ? f7480n : aVar);
        if (xVar != null) {
            return xVar;
        }
        Map<e5.a<?>, f<?>> map = this.f7481a.get();
        boolean z10 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f7481a.set(map);
            z10 = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<y> it = this.f7485e.iterator();
            while (it.hasNext()) {
                x<T> a10 = it.next().a(this, aVar);
                if (a10 != null) {
                    fVar2.e(a10);
                    this.f7482b.put(aVar, a10);
                    return a10;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z10) {
                this.f7481a.remove();
            }
        }
    }

    public <T> x<T> l(Class<T> cls) {
        return k(e5.a.a(cls));
    }

    public <T> x<T> m(y yVar, e5.a<T> aVar) {
        if (!this.f7485e.contains(yVar)) {
            yVar = this.f7484d;
        }
        boolean z10 = false;
        for (y yVar2 : this.f7485e) {
            if (z10) {
                x<T> a10 = yVar2.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            } else if (yVar2 == yVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public f5.a o(Reader reader) {
        f5.a aVar = new f5.a(reader);
        aVar.r0(this.f7491k);
        return aVar;
    }

    public f5.c p(Writer writer) {
        if (this.f7488h) {
            writer.write(")]}'\n");
        }
        f5.c cVar = new f5.c(writer);
        if (this.f7490j) {
            cVar.h0("  ");
        }
        cVar.j0(this.f7487g);
        return cVar;
    }

    public String q(k kVar) {
        StringWriter stringWriter = new StringWriter();
        u(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(m.f7516a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(k kVar, f5.c cVar) {
        boolean N = cVar.N();
        cVar.i0(true);
        boolean M = cVar.M();
        cVar.g0(this.f7489i);
        boolean H = cVar.H();
        cVar.j0(this.f7487g);
        try {
            try {
                z4.l.b(kVar, cVar);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e11.getMessage());
                assertionError.initCause(e11);
                throw assertionError;
            }
        } finally {
            cVar.i0(N);
            cVar.g0(M);
            cVar.j0(H);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f7487g + ",factories:" + this.f7485e + ",instanceCreators:" + this.f7483c + "}";
    }

    public void u(k kVar, Appendable appendable) {
        try {
            t(kVar, p(z4.l.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public void v(Object obj, Type type, f5.c cVar) {
        x k10 = k(e5.a.b(type));
        boolean N = cVar.N();
        cVar.i0(true);
        boolean M = cVar.M();
        cVar.g0(this.f7489i);
        boolean H = cVar.H();
        cVar.j0(this.f7487g);
        try {
            try {
                k10.d(cVar, obj);
            } catch (IOException e10) {
                throw new l(e10);
            } catch (AssertionError e11) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e11.getMessage());
                assertionError.initCause(e11);
                throw assertionError;
            }
        } finally {
            cVar.i0(N);
            cVar.g0(M);
            cVar.j0(H);
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(z4.l.c(appendable)));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }
}
