package p9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.r0;
import n9.d0;

/* loaded from: classes.dex */
public final class x extends j implements n9.d0 {

    /* renamed from: h, reason: collision with root package name */
    private final ab.n f13306h;

    /* renamed from: i, reason: collision with root package name */
    private final k9.h f13307i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<n9.c0<?>, Object> f13308j;

    /* renamed from: k, reason: collision with root package name */
    private v f13309k;

    /* renamed from: l, reason: collision with root package name */
    private n9.h0 f13310l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13311m;

    /* renamed from: n, reason: collision with root package name */
    private final ab.g<la.b, n9.l0> f13312n;

    /* renamed from: o, reason: collision with root package name */
    private final l8.h f13313o;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<i> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i b() {
            int n10;
            v vVar = x.this.f13309k;
            x xVar = x.this;
            if (vVar == null) {
                throw new AssertionError("Dependencies of module " + xVar.Z0() + " were not set before querying module content");
            }
            List<x> b10 = vVar.b();
            b10.contains(x.this);
            Iterator<T> it = b10.iterator();
            while (it.hasNext()) {
                ((x) it.next()).d1();
            }
            n10 = m8.r.n(b10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it2 = b10.iterator();
            while (it2.hasNext()) {
                n9.h0 h0Var = ((x) it2.next()).f13310l;
                y8.k.b(h0Var);
                arrayList.add(h0Var);
            }
            return new i(arrayList);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<la.b, n9.l0> {
        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.l0 h(la.b bVar) {
            y8.k.e(bVar, "fqName");
            x xVar = x.this;
            return new r(xVar, bVar, xVar.f13306h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(la.e eVar, ab.n nVar, k9.h hVar, ma.a aVar) {
        this(eVar, nVar, hVar, aVar, null, null, 48, null);
        y8.k.e(eVar, "moduleName");
        y8.k.e(nVar, "storageManager");
        y8.k.e(hVar, "builtIns");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(la.e eVar, ab.n nVar, k9.h hVar, ma.a aVar, Map<n9.c0<?>, ? extends Object> map, la.e eVar2) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), eVar);
        Map<n9.c0<?>, Object> t10;
        l8.h b10;
        y8.k.e(eVar, "moduleName");
        y8.k.e(nVar, "storageManager");
        y8.k.e(hVar, "builtIns");
        y8.k.e(map, "capabilities");
        this.f13306h = nVar;
        this.f13307i = hVar;
        if (!eVar.s()) {
            throw new IllegalArgumentException(y8.k.j("Module name must be special: ", eVar));
        }
        t10 = m8.l0.t(map);
        this.f13308j = t10;
        t10.put(kotlin.reflect.jvm.internal.impl.types.checker.h.a(), new kotlin.reflect.jvm.internal.impl.types.checker.o(null));
        this.f13311m = true;
        this.f13312n = nVar.i(new b());
        b10 = l8.j.b(new a());
        this.f13313o = b10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ x(la.e r10, ab.n r11, k9.h r12, ma.a r13, java.util.Map r14, la.e r15, int r16, y8.g r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r13
        L8:
            r0 = r16 & 16
            if (r0 == 0) goto L12
            java.util.Map r0 = m8.i0.h()
            r7 = r0
            goto L13
        L12:
            r7 = r14
        L13:
            r0 = r16 & 32
            if (r0 == 0) goto L19
            r8 = r1
            goto L1a
        L19:
            r8 = r15
        L1a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.x.<init>(la.e, ab.n, k9.h, ma.a, java.util.Map, la.e, int, y8.g):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Z0() {
        String eVar = c().toString();
        y8.k.d(eVar, "name.toString()");
        return eVar;
    }

    private final i b1() {
        return (i) this.f13313o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d1() {
        return this.f13310l != null;
    }

    @Override // n9.d0
    public n9.l0 C(la.b bVar) {
        y8.k.e(bVar, "fqName");
        Y0();
        return this.f13312n.h(bVar);
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        return (R) d0.a.a(this, oVar, d10);
    }

    @Override // n9.d0
    public <T> T Q0(n9.c0<T> c0Var) {
        y8.k.e(c0Var, "capability");
        return (T) this.f13308j.get(c0Var);
    }

    @Override // n9.d0
    public boolean V(n9.d0 d0Var) {
        boolean B;
        y8.k.e(d0Var, "targetModule");
        if (y8.k.a(this, d0Var)) {
            return true;
        }
        v vVar = this.f13309k;
        y8.k.b(vVar);
        B = m8.y.B(vVar.a(), d0Var);
        return B || i0().contains(d0Var) || d0Var.i0().contains(this);
    }

    public void Y0() {
        if (!e1()) {
            throw new n9.y(y8.k.j("Accessing invalid module descriptor ", this));
        }
    }

    public final n9.h0 a1() {
        Y0();
        return b1();
    }

    public final void c1(n9.h0 h0Var) {
        y8.k.e(h0Var, "providerForModuleContent");
        d1();
        this.f13310l = h0Var;
    }

    @Override // n9.m
    public n9.m d() {
        return d0.a.b(this);
    }

    public boolean e1() {
        return this.f13311m;
    }

    public final void f1(List<x> list) {
        Set<x> b10;
        y8.k.e(list, "descriptors");
        b10 = r0.b();
        g1(list, b10);
    }

    public final void g1(List<x> list, Set<x> set) {
        List d10;
        Set b10;
        y8.k.e(list, "descriptors");
        y8.k.e(set, "friends");
        d10 = m8.q.d();
        b10 = r0.b();
        h1(new w(list, set, d10, b10));
    }

    public final void h1(v vVar) {
        y8.k.e(vVar, "dependencies");
        this.f13309k = vVar;
    }

    @Override // n9.d0
    public List<n9.d0> i0() {
        v vVar = this.f13309k;
        if (vVar != null) {
            return vVar.c();
        }
        throw new AssertionError("Dependencies of module " + Z0() + " were not set");
    }

    public final void i1(x... xVarArr) {
        List<x> O;
        y8.k.e(xVarArr, "descriptors");
        O = m8.k.O(xVarArr);
        f1(O);
    }

    @Override // n9.d0
    public k9.h w() {
        return this.f13307i;
    }

    @Override // n9.d0
    public Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(bVar, "fqName");
        y8.k.e(lVar, "nameFilter");
        Y0();
        return a1().z(bVar, lVar);
    }
}
