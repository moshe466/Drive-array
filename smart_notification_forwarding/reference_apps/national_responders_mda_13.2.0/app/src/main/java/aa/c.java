package aa;

import bb.b0;
import bb.c0;
import bb.h1;
import bb.i0;
import bb.t;
import bb.t0;
import bb.v0;
import bb.x0;
import ca.i;
import ca.j;
import ca.v;
import ca.x;
import ca.y;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import m8.o;
import m8.p;
import n9.a1;
import n9.f0;
import n9.h;
import y8.l;
import y9.g;
import y9.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final g f337a;

    /* renamed from: b, reason: collision with root package name */
    private final k f338b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends l implements x8.a<b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a1 f339f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ aa.a f340g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ t0 f341h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: aa.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0011a extends l implements x8.a<b0> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ t0 f342f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0011a(t0 t0Var) {
                super(0);
                this.f342f = t0Var;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b0 b() {
                h o10 = this.f342f.o();
                y8.k.b(o10);
                i0 s10 = o10.s();
                y8.k.d(s10, "constructor.declarationDescriptor!!.defaultType");
                return eb.a.m(s10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a1 a1Var, aa.a aVar, t0 t0Var) {
            super(0);
            this.f339f = a1Var;
            this.f340g = aVar;
            this.f341h = t0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 b() {
            a1 a1Var = this.f339f;
            y8.k.d(a1Var, "parameter");
            return d.b(a1Var, this.f340g.e(), new C0011a(this.f341h));
        }
    }

    public c(g gVar, k kVar) {
        y8.k.e(gVar, "c");
        y8.k.e(kVar, "typeParameterResolver");
        this.f337a = gVar;
        this.f338b = kVar;
    }

    private final boolean a(j jVar, n9.e eVar) {
        if (!b((x) o.U(jVar.A()))) {
            return false;
        }
        List<a1> B = m9.d.f12071a.b(eVar).o().B();
        y8.k.d(B, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
        a1 a1Var = (a1) o.U(B);
        h1 v10 = a1Var == null ? null : a1Var.v();
        return (v10 == null || v10 == h1.OUT_VARIANCE) ? false : true;
    }

    private static final boolean b(x xVar) {
        ca.b0 b0Var = xVar instanceof ca.b0 ? (ca.b0) xVar : null;
        return (b0Var == null || b0Var.o() == null || b0Var.K()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if ((!r4.isEmpty()) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<bb.v0> c(ca.j r8, aa.a r9, bb.t0 r10) {
        /*
            r7 = this;
            boolean r0 = r8.W()
            r1 = 0
            java.lang.String r2 = "constructor.parameters"
            r3 = 1
            if (r0 != 0) goto L24
            java.util.List r4 = r8.A()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L23
            java.util.List r4 = r10.B()
            y8.k.d(r4, r2)
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L23
            goto L24
        L23:
            r3 = 0
        L24:
            java.util.List r4 = r10.B()
            y8.k.d(r4, r2)
            java.lang.String r2 = "parameter"
            r5 = 10
            if (r3 == 0) goto L76
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = m8.o.n(r4, r5)
            r8.<init>(r1)
            java.util.Iterator r1 = r4.iterator()
        L3e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L71
            java.lang.Object r3 = r1.next()
            n9.a1 r3 = (n9.a1) r3
            bb.e0 r4 = new bb.e0
            y9.g r5 = r7.f337a
            ab.n r5 = r5.e()
            aa.c$a r6 = new aa.c$a
            r6.<init>(r3, r9, r10)
            r4.<init>(r5, r6)
            aa.e r5 = aa.e.f345b
            y8.k.d(r3, r2)
            if (r0 == 0) goto L63
            r6 = r9
            goto L69
        L63:
            aa.b r6 = aa.b.INFLEXIBLE
            aa.a r6 = r9.g(r6)
        L69:
            bb.v0 r3 = r5.i(r3, r6, r4)
            r8.add(r3)
            goto L3e
        L71:
            java.util.List r8 = m8.o.n0(r8)
            return r8
        L76:
            int r9 = r4.size()
            java.util.List r10 = r8.A()
            int r10 = r10.size()
            if (r9 == r10) goto Lb7
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = m8.o.n(r4, r5)
            r8.<init>(r9)
            java.util.Iterator r9 = r4.iterator()
        L91:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lb2
            java.lang.Object r10 = r9.next()
            n9.a1 r10 = (n9.a1) r10
            bb.x0 r0 = new bb.x0
            la.e r10 = r10.c()
            java.lang.String r10 = r10.k()
            bb.i0 r10 = bb.t.j(r10)
            r0.<init>(r10)
            r8.add(r0)
            goto L91
        Lb2:
            java.util.List r8 = m8.o.n0(r8)
            return r8
        Lb7:
            java.util.List r8 = r8.A()
            java.lang.Iterable r8 = m8.o.t0(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = m8.o.n(r8, r5)
            r9.<init>(r10)
            java.util.Iterator r8 = r8.iterator()
        Lcc:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Lfe
            java.lang.Object r10 = r8.next()
            m8.d0 r10 = (m8.d0) r10
            int r0 = r10.a()
            java.lang.Object r10 = r10.b()
            ca.x r10 = (ca.x) r10
            r4.size()
            java.lang.Object r0 = r4.get(r0)
            n9.a1 r0 = (n9.a1) r0
            w9.k r3 = w9.k.COMMON
            r5 = 3
            r6 = 0
            aa.a r3 = aa.d.f(r3, r1, r6, r5, r6)
            y8.k.d(r0, r2)
            bb.v0 r10 = r7.o(r10, r3, r0)
            r9.add(r10)
            goto Lcc
        Lfe:
            java.util.List r8 = m8.o.n0(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.c.c(ca.j, aa.a, bb.t0):java.util.List");
    }

    private final i0 d(j jVar, aa.a aVar, i0 i0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = i0Var == null ? null : i0Var.u();
        if (u10 == null) {
            u10 = new y9.d(this.f337a, jVar, false, 4, null);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = u10;
        t0 e10 = e(jVar, aVar);
        if (e10 == null) {
            return null;
        }
        boolean h10 = h(aVar);
        if (y8.k.a(i0Var != null ? i0Var.W0() : null, e10) && !jVar.W() && h10) {
            return i0Var.a1(true);
        }
        List<v0> c10 = c(jVar, aVar, e10);
        c0 c0Var = c0.f4165a;
        return c0.i(gVar, e10, c10, h10, null, 16, null);
    }

    private final t0 e(j jVar, aa.a aVar) {
        i a10 = jVar.a();
        if (a10 == null) {
            return f(jVar);
        }
        if (!(a10 instanceof ca.g)) {
            if (!(a10 instanceof y)) {
                throw new IllegalStateException(y8.k.j("Unknown classifier kind: ", a10));
            }
            a1 a11 = this.f338b.a((y) a10);
            if (a11 == null) {
                return null;
            }
            return a11.o();
        }
        ca.g gVar = (ca.g) a10;
        la.b f10 = gVar.f();
        if (f10 == null) {
            throw new AssertionError(y8.k.j("Class type should have a FQ name: ", a10));
        }
        n9.e i10 = i(jVar, aVar, f10);
        if (i10 == null) {
            i10 = this.f337a.a().m().a(gVar);
        }
        t0 o10 = i10 != null ? i10.o() : null;
        return o10 == null ? f(jVar) : o10;
    }

    private final t0 f(j jVar) {
        List<Integer> b10;
        la.a m10 = la.a.m(new la.b(jVar.X()));
        y8.k.d(m10, "topLevel(FqName(javaType.classifierQualifiedName))");
        f0 q10 = this.f337a.a().b().f().q();
        b10 = p.b(0);
        t0 o10 = q10.d(m10, b10).o();
        y8.k.d(o10, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return o10;
    }

    private final boolean g(h1 h1Var, a1 a1Var) {
        return (a1Var.v() == h1.INVARIANT || h1Var == a1Var.v()) ? false : true;
    }

    private final boolean h(aa.a aVar) {
        return (aVar.c() == b.FLEXIBLE_LOWER_BOUND || aVar.f() || aVar.d() == w9.k.SUPERTYPE) ? false : true;
    }

    private final n9.e i(j jVar, aa.a aVar, la.b bVar) {
        if (aVar.f() && y8.k.a(bVar, d.a())) {
            return this.f337a.a().o().c();
        }
        m9.d dVar = m9.d.f12071a;
        n9.e h10 = m9.d.h(dVar, bVar, this.f337a.d().w(), null, 4, null);
        if (h10 == null) {
            return null;
        }
        return (dVar.f(h10) && (aVar.c() == b.FLEXIBLE_LOWER_BOUND || aVar.d() == w9.k.SUPERTYPE || a(jVar, h10))) ? dVar.b(h10) : h10;
    }

    public static /* synthetic */ b0 k(c cVar, ca.f fVar, aa.a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return cVar.j(fVar, aVar, z10);
    }

    private final b0 l(j jVar, aa.a aVar) {
        i0 d10;
        boolean z10 = (aVar.f() || aVar.d() == w9.k.SUPERTYPE) ? false : true;
        boolean W = jVar.W();
        if (!W && !z10) {
            i0 d11 = d(jVar, aVar, null);
            return d11 == null ? m(jVar) : d11;
        }
        i0 d12 = d(jVar, aVar.g(b.FLEXIBLE_LOWER_BOUND), null);
        if (d12 != null && (d10 = d(jVar, aVar.g(b.FLEXIBLE_UPPER_BOUND), d12)) != null) {
            if (W) {
                return new f(d12, d10);
            }
            c0 c0Var = c0.f4165a;
            return c0.d(d12, d10);
        }
        return m(jVar);
    }

    private static final i0 m(j jVar) {
        i0 j10 = t.j(y8.k.j("Unresolved java class ", jVar.D()));
        y8.k.d(j10, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return j10;
    }

    private final v0 o(x xVar, aa.a aVar, a1 a1Var) {
        if (!(xVar instanceof ca.b0)) {
            return new x0(h1.INVARIANT, n(xVar, aVar));
        }
        ca.b0 b0Var = (ca.b0) xVar;
        x o10 = b0Var.o();
        h1 h1Var = b0Var.K() ? h1.OUT_VARIANCE : h1.IN_VARIANCE;
        return (o10 == null || g(h1Var, a1Var)) ? d.d(a1Var, aVar) : eb.a.d(n(o10, d.f(w9.k.COMMON, false, null, 3, null)), h1Var, a1Var);
    }

    public final b0 j(ca.f fVar, aa.a aVar, boolean z10) {
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> Y;
        y8.k.e(fVar, "arrayType");
        y8.k.e(aVar, "attr");
        x p10 = fVar.p();
        v vVar = p10 instanceof v ? (v) p10 : null;
        k9.i b10 = vVar == null ? null : vVar.b();
        y9.d dVar = new y9.d(this.f337a, fVar, true);
        if (b10 != null) {
            i0 N = this.f337a.d().w().N(b10);
            y8.k.d(N, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            g.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b;
            Y = m8.y.Y(dVar, N.u());
            N.c1(aVar2.a(Y));
            if (aVar.f()) {
                return N;
            }
            c0 c0Var = c0.f4165a;
            return c0.d(N, N.a1(true));
        }
        b0 n10 = n(p10, d.f(w9.k.COMMON, aVar.f(), null, 2, null));
        if (aVar.f()) {
            i0 m10 = this.f337a.d().w().m(z10 ? h1.OUT_VARIANCE : h1.INVARIANT, n10, dVar);
            y8.k.d(m10, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
            return m10;
        }
        c0 c0Var2 = c0.f4165a;
        i0 m11 = this.f337a.d().w().m(h1.INVARIANT, n10, dVar);
        y8.k.d(m11, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
        return c0.d(m11, this.f337a.d().w().m(h1.OUT_VARIANCE, n10, dVar).a1(true));
    }

    public final b0 n(x xVar, aa.a aVar) {
        y8.k.e(aVar, "attr");
        if (xVar instanceof v) {
            k9.i b10 = ((v) xVar).b();
            i0 Q = b10 != null ? this.f337a.d().w().Q(b10) : this.f337a.d().w().Y();
            y8.k.d(Q, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return Q;
        }
        if (xVar instanceof j) {
            return l((j) xVar, aVar);
        }
        if (xVar instanceof ca.f) {
            return k(this, (ca.f) xVar, aVar, false, 4, null);
        }
        if (xVar instanceof ca.b0) {
            x o10 = ((ca.b0) xVar).o();
            b0 n10 = o10 == null ? null : n(o10, aVar);
            if (n10 != null) {
                return n10;
            }
        } else if (xVar != null) {
            throw new UnsupportedOperationException(y8.k.j("Unsupported type: ", xVar));
        }
        i0 y10 = this.f337a.d().w().y();
        y8.k.d(y10, "c.module.builtIns.defaultBound");
        return y10;
    }
}
