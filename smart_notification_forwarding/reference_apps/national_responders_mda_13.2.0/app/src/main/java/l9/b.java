package l9;

import ab.n;
import bb.h1;
import bb.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l8.w;
import m8.q;
import m8.r;
import m8.y;
import n9.a0;
import n9.a1;
import n9.f;
import n9.g0;
import n9.t;
import n9.u;
import n9.v0;
import n9.y0;
import p9.j0;
import ua.h;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class b extends p9.a {

    /* renamed from: r, reason: collision with root package name */
    private static final la.a f11829r;

    /* renamed from: s, reason: collision with root package name */
    private static final la.a f11830s;

    /* renamed from: k, reason: collision with root package name */
    private final n f11831k;

    /* renamed from: l, reason: collision with root package name */
    private final g0 f11832l;

    /* renamed from: m, reason: collision with root package name */
    private final c f11833m;

    /* renamed from: n, reason: collision with root package name */
    private final int f11834n;

    /* renamed from: o, reason: collision with root package name */
    private final C0246b f11835o;

    /* renamed from: p, reason: collision with root package name */
    private final d f11836p;

    /* renamed from: q, reason: collision with root package name */
    private final List<a1> f11837q;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: l9.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0246b extends bb.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f11838d;

        /* renamed from: l9.b$b$a */
        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11839a;

            static {
                int[] iArr = new int[c.values().length];
                iArr[c.Function.ordinal()] = 1;
                iArr[c.KFunction.ordinal()] = 2;
                iArr[c.SuspendFunction.ordinal()] = 3;
                iArr[c.KSuspendFunction.ordinal()] = 4;
                f11839a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0246b(b bVar) {
            super(bVar.f11831k);
            k.e(bVar, "this$0");
            this.f11838d = bVar;
        }

        @Override // bb.t0
        public List<a1> B() {
            return this.f11838d.f11837q;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
        @Override // bb.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected java.util.Collection<bb.b0> d() {
            /*
                r9 = this;
                l9.b r0 = r9.f11838d
                l9.c r0 = r0.f1()
                int[] r1 = l9.b.C0246b.a.f11839a
                int r0 = r0.ordinal()
                r0 = r1[r0]
                r1 = 1
                if (r0 == r1) goto L65
                r2 = 0
                r3 = 2
                if (r0 == r3) goto L43
                r4 = 3
                if (r0 == r4) goto L65
                r4 = 4
                if (r0 != r4) goto L3d
                la.a[] r0 = new la.a[r3]
                la.a r3 = l9.b.Y0()
                r0[r2] = r3
                la.a r2 = new la.a
                la.b r3 = k9.k.f11238d
                l9.c r4 = l9.c.SuspendFunction
                l9.b r5 = r9.f11838d
                int r5 = r5.b1()
                la.e r4 = r4.numberedClassName(r5)
                r2.<init>(r3, r4)
                r0[r1] = r2
                java.util.List r0 = m8.o.g(r0)
                goto L6d
            L3d:
                l8.l r0 = new l8.l
                r0.<init>()
                throw r0
            L43:
                la.a[] r0 = new la.a[r3]
                la.a r3 = l9.b.Y0()
                r0[r2] = r3
                la.a r2 = new la.a
                la.b r3 = k9.k.f11246l
                l9.c r4 = l9.c.Function
                l9.b r5 = r9.f11838d
                int r5 = r5.b1()
                la.e r4 = r4.numberedClassName(r5)
                r2.<init>(r3, r4)
                r0[r1] = r2
                java.util.List r0 = m8.o.g(r0)
                goto L6d
            L65:
                la.a r0 = l9.b.X0()
                java.util.List r0 = m8.o.b(r0)
            L6d:
                l9.b r1 = r9.f11838d
                n9.g0 r1 = l9.b.W0(r1)
                n9.d0 r1 = r1.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r4 = m8.o.n(r0, r3)
                r2.<init>(r4)
                java.util.Iterator r0 = r0.iterator()
            L86:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L102
                java.lang.Object r4 = r0.next()
                la.a r4 = (la.a) r4
                n9.e r5 = n9.w.a(r1, r4)
                if (r5 == 0) goto Le2
                java.util.List r4 = r9.B()
                bb.t0 r6 = r5.o()
                java.util.List r6 = r6.B()
                int r6 = r6.size()
                java.util.List r4 = m8.o.j0(r4, r6)
                java.util.ArrayList r6 = new java.util.ArrayList
                int r7 = m8.o.n(r4, r3)
                r6.<init>(r7)
                java.util.Iterator r4 = r4.iterator()
            Lb9:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto Ld2
                java.lang.Object r7 = r4.next()
                n9.a1 r7 = (n9.a1) r7
                bb.x0 r8 = new bb.x0
                bb.i0 r7 = r7.s()
                r8.<init>(r7)
                r6.add(r8)
                goto Lb9
            Ld2:
                bb.c0 r4 = bb.c0.f4165a
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r4 = r4.b()
                bb.i0 r4 = bb.c0.g(r4, r5, r6)
                r2.add(r4)
                goto L86
            Le2:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Built-in class "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " not found"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L102:
                java.util.List r0 = m8.o.n0(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l9.b.C0246b.d():java.util.Collection");
        }

        @Override // bb.g
        protected y0 h() {
            return y0.a.f12328a;
        }

        @Override // bb.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b o() {
            return this.f11838d;
        }

        public String toString() {
            return o().toString();
        }

        @Override // bb.t0
        public boolean z() {
            return true;
        }
    }

    static {
        new a(null);
        f11829r = new la.a(k9.k.f11246l, la.e.r("Function"));
        f11830s = new la.a(k9.k.f11243i, la.e.r("KFunction"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar, g0 g0Var, c cVar, int i10) {
        super(nVar, cVar.numberedClassName(i10));
        int n10;
        List<a1> n02;
        k.e(nVar, "storageManager");
        k.e(g0Var, "containingDeclaration");
        k.e(cVar, "functionKind");
        this.f11831k = nVar;
        this.f11832l = g0Var;
        this.f11833m = cVar;
        this.f11834n = i10;
        this.f11835o = new C0246b(this);
        this.f11836p = new d(nVar, this);
        ArrayList arrayList = new ArrayList();
        d9.c cVar2 = new d9.c(1, i10);
        n10 = r.n(cVar2, 10);
        ArrayList arrayList2 = new ArrayList(n10);
        Iterator<Integer> it = cVar2.iterator();
        while (it.hasNext()) {
            V0(arrayList, this, h1.IN_VARIANCE, k.j("P", Integer.valueOf(((m8.g0) it).b())));
            arrayList2.add(w.f11824a);
        }
        V0(arrayList, this, h1.OUT_VARIANCE, "R");
        n02 = y.n0(arrayList);
        this.f11837q = n02;
    }

    private static final void V0(ArrayList<a1> arrayList, b bVar, h1 h1Var, String str) {
        arrayList.add(j0.c1(bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), false, h1Var, la.e.r(str), arrayList.size(), bVar.f11831k));
    }

    @Override // n9.e
    public /* bridge */ /* synthetic */ n9.e A0() {
        return (n9.e) c1();
    }

    @Override // n9.e, n9.i
    public List<a1> B() {
        return this.f11837q;
    }

    @Override // n9.z
    public boolean H0() {
        return false;
    }

    @Override // n9.z
    public boolean I() {
        return false;
    }

    @Override // n9.e
    public boolean N() {
        return false;
    }

    @Override // n9.e
    public boolean R0() {
        return false;
    }

    @Override // n9.e
    public boolean W() {
        return false;
    }

    public final int b1() {
        return this.f11834n;
    }

    public Void c1() {
        return null;
    }

    @Override // n9.e
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public List<n9.d> q() {
        List<n9.d> d10;
        d10 = q.d();
        return d10;
    }

    @Override // n9.e, n9.n, n9.m
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public g0 d() {
        return this.f11832l;
    }

    public final c f1() {
        return this.f11833m;
    }

    @Override // n9.e
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public List<n9.e> g0() {
        List<n9.e> d10;
        d10 = q.d();
        return d10;
    }

    @Override // n9.e, n9.q, n9.z
    public u h() {
        u uVar = t.f12303e;
        k.d(uVar, "PUBLIC");
        return uVar;
    }

    @Override // n9.e
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public h.b x0() {
        return h.b.f14541b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.t
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public d v0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return this.f11836p;
    }

    @Override // n9.e
    public boolean j0() {
        return false;
    }

    public Void j1() {
        return null;
    }

    @Override // n9.p
    public v0 k() {
        v0 v0Var = v0.f12324a;
        k.d(v0Var, "NO_SOURCE");
        return v0Var;
    }

    @Override // n9.z
    public boolean l0() {
        return false;
    }

    @Override // n9.i
    public boolean m0() {
        return false;
    }

    @Override // n9.h
    public t0 o() {
        return this.f11835o;
    }

    @Override // n9.e, n9.z
    public a0 p() {
        return a0.ABSTRACT;
    }

    @Override // n9.e
    public f r() {
        return f.INTERFACE;
    }

    public String toString() {
        String k10 = c().k();
        k.d(k10, "name.asString()");
        return k10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
    }

    @Override // n9.e
    public /* bridge */ /* synthetic */ n9.d w0() {
        return (n9.d) j1();
    }

    @Override // n9.e
    public boolean x() {
        return false;
    }
}
