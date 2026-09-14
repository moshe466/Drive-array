package da;

import bb.b0;
import bb.c1;
import bb.d0;
import bb.g1;
import bb.h0;
import bb.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.y;
import n9.a1;
import n9.d1;
import n9.s0;
import v9.w;
import v9.z;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final v9.c f8813a;

    /* renamed from: b, reason: collision with root package name */
    private final jb.e f8814b;

    /* renamed from: c, reason: collision with root package name */
    private final da.d f8815c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f8816a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8817b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f8818c;

        public a(b0 b0Var, boolean z10, boolean z11) {
            y8.k.e(b0Var, "type");
            this.f8816a = b0Var;
            this.f8817b = z10;
            this.f8818c = z11;
        }

        public final boolean a() {
            return this.f8818c;
        }

        public final b0 b() {
            return this.f8816a;
        }

        public final boolean c() {
            return this.f8817b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.a f8819a;

        /* renamed from: b, reason: collision with root package name */
        private final b0 f8820b;

        /* renamed from: c, reason: collision with root package name */
        private final Collection<b0> f8821c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f8822d;

        /* renamed from: e, reason: collision with root package name */
        private final y9.g f8823e;

        /* renamed from: f, reason: collision with root package name */
        private final v9.a f8824f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f8825g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.l<Integer, da.e> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ da.e[] f8827f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(da.e[] eVarArr) {
                super(1);
                this.f8827f = eVarArr;
            }

            public final da.e a(int i10) {
                int s10;
                da.e[] eVarArr = this.f8827f;
                if (i10 >= 0) {
                    s10 = m8.k.s(eVarArr);
                    if (i10 <= s10) {
                        return eVarArr[i10];
                    }
                }
                return da.e.f8764e.a();
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ da.e h(Integer num) {
                return a(num.intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: da.l$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0147b extends y8.l implements x8.l<g1, Boolean> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0147b f8828f = new C0147b();

            C0147b() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean h(g1 g1Var) {
                n9.h o10 = g1Var.W0().o();
                if (o10 == null) {
                    return Boolean.FALSE;
                }
                la.e c10 = o10.c();
                m9.c cVar = m9.c.f12055a;
                return Boolean.valueOf(y8.k.a(c10, cVar.i().g()) && y8.k.a(ra.a.e(o10), cVar.i()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class c extends y8.l implements x8.l<Integer, da.e> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ s f8829f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ x8.l<Integer, da.e> f8830g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(s sVar, x8.l<? super Integer, da.e> lVar) {
                super(1);
                this.f8829f = sVar;
                this.f8830g = lVar;
            }

            public final da.e a(int i10) {
                da.e eVar = this.f8829f.a().get(Integer.valueOf(i10));
                return eVar == null ? this.f8830g.h(Integer.valueOf(i10)) : eVar;
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ da.e h(Integer num) {
                return a(num.intValue());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, b0 b0Var, Collection<? extends b0> collection, boolean z10, y9.g gVar, v9.a aVar2, boolean z11) {
            y8.k.e(lVar, "this$0");
            y8.k.e(b0Var, "fromOverride");
            y8.k.e(collection, "fromOverridden");
            y8.k.e(gVar, "containerContext");
            y8.k.e(aVar2, "containerApplicabilityType");
            l.this = lVar;
            this.f8819a = aVar;
            this.f8820b = b0Var;
            this.f8821c = collection;
            this.f8822d = z10;
            this.f8823e = gVar;
            this.f8824f = aVar2;
            this.f8825g = z11;
        }

        public /* synthetic */ b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, b0 b0Var, Collection collection, boolean z10, y9.g gVar, v9.a aVar2, boolean z11, int i10, y8.g gVar2) {
            this(l.this, aVar, b0Var, collection, z10, gVar, aVar2, (i10 & 64) != 0 ? false : z11);
        }

        private final h a(a1 a1Var) {
            boolean z10;
            boolean b10;
            boolean z11;
            if (!(a1Var instanceof z9.m)) {
                return null;
            }
            z9.m mVar = (z9.m) a1Var;
            List<b0> upperBounds = mVar.getUpperBounds();
            y8.k.d(upperBounds, "upperBounds");
            boolean z12 = false;
            if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                Iterator<T> it = upperBounds.iterator();
                while (it.hasNext()) {
                    if (!d0.a((b0) it.next())) {
                        z10 = false;
                        break;
                    }
                }
            }
            z10 = true;
            if (z10) {
                return null;
            }
            List<b0> upperBounds2 = mVar.getUpperBounds();
            y8.k.d(upperBounds2, "upperBounds");
            if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                Iterator<T> it2 = upperBounds2.iterator();
                while (it2.hasNext()) {
                    b10 = n.b((b0) it2.next());
                    if (!b10) {
                        z11 = false;
                        break;
                    }
                }
            }
            z11 = true;
            if (z11) {
                return null;
            }
            List<b0> upperBounds3 = mVar.getUpperBounds();
            y8.k.d(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                Iterator<T> it3 = upperBounds3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    y8.k.d((b0) it3.next(), "it");
                    if (!d0.b(r0)) {
                        z12 = true;
                        break;
                    }
                }
            }
            return z12 ? h.NOT_NULL : h.NULLABLE;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final x8.l<java.lang.Integer, da.e> b() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection<bb.b0> r0 = r7.f8821c
                java.util.ArrayList r8 = new java.util.ArrayList
                r1 = 10
                int r1 = m8.o.n(r0, r1)
                r8.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L27
                java.lang.Object r1 = r0.next()
                bb.b0 r1 = (bb.b0) r1
                java.util.List r1 = r7.o(r1)
                r8.add(r1)
                goto L13
            L27:
                bb.b0 r0 = r7.f8820b
                java.util.List r9 = r7.o(r0)
                boolean r0 = r7.f8822d
                r11 = 1
                if (r0 == 0) goto L60
                java.util.Collection<bb.b0> r0 = r7.f8821c
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L40
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L40
            L3e:
                r0 = 0
                goto L5c
            L40:
                java.util.Iterator r0 = r0.iterator()
            L44:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L3e
                java.lang.Object r1 = r0.next()
                bb.b0 r1 = (bb.b0) r1
                kotlin.reflect.jvm.internal.impl.types.checker.f r2 = kotlin.reflect.jvm.internal.impl.types.checker.f.f11565a
                bb.b0 r3 = r7.f8820b
                boolean r1 = r2.c(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L44
                r0 = 1
            L5c:
                if (r0 == 0) goto L60
                r12 = 1
                goto L61
            L60:
                r12 = 0
            L61:
                if (r12 == 0) goto L65
                r13 = 1
                goto L6a
            L65:
                int r0 = r9.size()
                r13 = r0
            L6a:
                da.e[] r14 = new da.e[r13]
                r15 = 0
            L6d:
                if (r15 >= r13) goto Lc0
                if (r15 != 0) goto L73
                r4 = 1
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.Object r0 = r9.get(r15)
                da.o r0 = (da.o) r0
                bb.b0 r1 = r0.a()
                v9.s r3 = r0.b()
                n9.a1 r5 = r0.c()
                boolean r6 = r0.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r8.iterator()
            L93:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb5
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = m8.o.K(r10, r15)
                da.o r10 = (da.o) r10
                if (r10 != 0) goto Lab
                r10 = 0
                goto Laf
            Lab:
                bb.b0 r10 = r10.e()
            Laf:
                if (r10 == 0) goto L93
                r2.add(r10)
                goto L93
            Lb5:
                r0 = r17
                da.e r0 = r0.d(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L6d
            Lc0:
                da.l$b$a r0 = new da.l$b$a
                r0.<init>(r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: da.l.b.b():x8.l");
        }

        private final i c(i iVar, v9.s sVar, a1 a1Var) {
            i e10;
            if (iVar == null) {
                iVar = (sVar == null || (e10 = sVar.e()) == null) ? null : new i(e10.c(), e10.d());
            }
            h a10 = a1Var == null ? null : a(a1Var);
            return a10 == null ? iVar : iVar == null ? new i(a10, false, 2, null) : new i(m(a10, iVar.c()), false, 2, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final da.e d(bb.b0 r10, java.util.Collection<? extends bb.b0> r11, v9.s r12, boolean r13, n9.a1 r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: da.l.b.d(bb.b0, java.util.Collection, v9.s, boolean, n9.a1, boolean):da.e");
        }

        public static /* synthetic */ a f(b bVar, s sVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                sVar = null;
            }
            return bVar.e(sVar);
        }

        private final i g(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11) {
            l lVar = l.this;
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = gVar.iterator();
            while (it.hasNext()) {
                i h10 = lVar.h(it.next(), z10, z11);
                if (h10 != null) {
                    return h10;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final da.e h(bb.b0 r12) {
            /*
                r11 = this;
                boolean r0 = bb.y.b(r12)
                if (r0 == 0) goto L18
                bb.v r0 = bb.y.a(r12)
                l8.n r1 = new l8.n
                bb.i0 r2 = r0.e1()
                bb.i0 r0 = r0.f1()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                l8.n r1 = new l8.n
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.a()
                bb.b0 r0 = (bb.b0) r0
                java.lang.Object r1 = r1.b()
                bb.b0 r1 = (bb.b0) r1
                m9.d r2 = m9.d.f12071a
                da.e r10 = new da.e
                boolean r3 = r0.X0()
                r4 = 0
                if (r3 == 0) goto L38
                da.h r3 = da.h.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.X0()
                if (r3 != 0) goto L41
                da.h r3 = da.h.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.e(r0)
                if (r0 == 0) goto L4b
                da.f r0 = da.f.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.c(r1)
                if (r0 == 0) goto L54
                da.f r0 = da.f.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                bb.g1 r12 = r12.Z0()
                boolean r6 = r12 instanceof da.g
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: da.l.b.h(bb.b0):da.e");
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ce, code lost:
        
            if (r0.c() == da.h.NOT_NULL) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
        
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00e7, code lost:
        
            if (y8.k.a(r12 == null ? null : java.lang.Boolean.valueOf(r12.d()), java.lang.Boolean.TRUE) != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x009c, code lost:
        
            if ((r12.c() || !eb.a.i(r10)) != false) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x008c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final da.e i(bb.b0 r10, boolean r11, v9.s r12, n9.a1 r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 301
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: da.l.b.i(bb.b0, boolean, v9.s, n9.a1, boolean):da.e");
        }

        private static final <T> T j(List<la.b> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, T t10) {
            boolean z10 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (gVar.e((la.b) it.next()) != null) {
                        break;
                    }
                }
            }
            z10 = false;
            if (z10) {
                return t10;
            }
            return null;
        }

        private static final <T> T k(T t10, T t11) {
            if (t10 == null || t11 == null || y8.k.a(t10, t11)) {
                return t10 == null ? t11 : t10;
            }
            return null;
        }

        private final boolean l() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f8819a;
            if (!(aVar instanceof d1)) {
                aVar = null;
            }
            d1 d1Var = (d1) aVar;
            return (d1Var != null ? d1Var.R() : null) != null;
        }

        private final h m(h hVar, h hVar2) {
            h hVar3 = h.FORCE_FLEXIBILITY;
            if (hVar == hVar3) {
                return hVar2;
            }
            if (hVar2 == hVar3) {
                return hVar;
            }
            h hVar4 = h.NULLABLE;
            if (hVar == hVar4) {
                return hVar2;
            }
            if (hVar2 == hVar4) {
                return hVar;
            }
            if (hVar == hVar2) {
                h hVar5 = h.NOT_NULL;
            }
            return h.NOT_NULL;
        }

        private final l8.n<i, Boolean> n(b0 b0Var) {
            n9.h o10 = b0Var.W0().o();
            a1 a1Var = o10 instanceof a1 ? (a1) o10 : null;
            h a10 = a1Var == null ? null : a(a1Var);
            if (a10 == null) {
                return new l8.n<>(null, Boolean.FALSE);
            }
            h hVar = h.NOT_NULL;
            return new l8.n<>(new i(hVar, false, 2, null), Boolean.valueOf(a10 == hVar));
        }

        private final List<o> o(b0 b0Var) {
            ArrayList arrayList = new ArrayList(1);
            p(this, arrayList, b0Var, this.f8823e, null);
            return arrayList;
        }

        private static final void p(b bVar, ArrayList<o> arrayList, b0 b0Var, y9.g gVar, a1 a1Var) {
            List<l8.n> u02;
            y9.g h10 = y9.a.h(gVar, b0Var.u());
            w b10 = h10.b();
            v9.s a10 = b10 == null ? null : b10.a(bVar.f8825g ? v9.a.TYPE_PARAMETER_BOUNDS : v9.a.TYPE_USE);
            arrayList.add(new o(b0Var, a10, a1Var, false));
            List<v0> V0 = b0Var.V0();
            List<a1> B = b0Var.W0().B();
            y8.k.d(B, "type.constructor.parameters");
            u02 = y.u0(V0, B);
            for (l8.n nVar : u02) {
                v0 v0Var = (v0) nVar.a();
                a1 a1Var2 = (a1) nVar.b();
                if (v0Var.d()) {
                    b0 b11 = v0Var.b();
                    y8.k.d(b11, "arg.type");
                    arrayList.add(new o(b11, a10, a1Var2, true));
                } else {
                    b0 b12 = v0Var.b();
                    y8.k.d(b12, "arg.type");
                    p(bVar, arrayList, b12, h10, a1Var2);
                }
            }
        }

        public final a e(s sVar) {
            x8.l<Integer, da.e> b10 = b();
            c cVar = sVar == null ? null : new c(sVar, b10);
            boolean c10 = c1.c(this.f8820b, C0147b.f8828f);
            da.d dVar = l.this.f8815c;
            b0 b0Var = this.f8820b;
            if (cVar != null) {
                b10 = cVar;
            }
            b0 b11 = dVar.b(b0Var, b10);
            a aVar = b11 != null ? new a(b11, true, c10) : null;
            return aVar == null ? new a(this.f8820b, false, c10) : aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        private final boolean f8831d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b0 b0Var, boolean z10, boolean z11, boolean z12) {
            super(b0Var, z11, z12);
            y8.k.e(b0Var, "type");
            this.f8831d = z10;
        }

        public final boolean d() {
            return this.f8831d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends y8.l implements x8.l<n9.b, b0> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f8832f = new d();

        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(n9.b bVar) {
            y8.k.e(bVar, "it");
            s0 U = bVar.U();
            y8.k.b(U);
            b0 b10 = U.b();
            y8.k.d(b10, "it.extensionReceiverParameter!!.type");
            return b10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.l<n9.b, b0> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f8833f = new e();

        e() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(n9.b bVar) {
            y8.k.e(bVar, "it");
            b0 i10 = bVar.i();
            y8.k.b(i10);
            return i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.l<n9.b, b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d1 f8834f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(d1 d1Var) {
            super(1);
            this.f8834f = d1Var;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 h(n9.b bVar) {
            y8.k.e(bVar, "it");
            b0 b10 = bVar.l().get(this.f8834f.j()).b();
            y8.k.d(b10, "it.valueParameters[p.index].type");
            return b10;
        }
    }

    /* loaded from: classes.dex */
    static final class g extends y8.l implements x8.l<g1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final g f8835f = new g();

        g() {
            super(1);
        }

        public final boolean a(g1 g1Var) {
            y8.k.e(g1Var, "it");
            return g1Var instanceof h0;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(g1 g1Var) {
            return Boolean.valueOf(a(g1Var));
        }
    }

    public l(v9.c cVar, jb.e eVar, da.d dVar) {
        y8.k.e(cVar, "annotationTypeQualifierResolver");
        y8.k.e(eVar, "javaTypeEnhancementState");
        y8.k.e(dVar, "typeEnhancement");
        this.f8813a = cVar;
        this.f8814b = eVar;
        this.f8815c = dVar;
    }

    private final i c(la.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z10) {
        if (z.l().contains(bVar)) {
            return new i(h.NULLABLE, z10);
        }
        if (z.k().contains(bVar)) {
            return new i(h.NOT_NULL, z10);
        }
        if (y8.k.a(bVar, z.f())) {
            return j(cVar, z10);
        }
        if (y8.k.a(bVar, z.d()) && this.f8814b.c()) {
            return new i(h.NULLABLE, z10);
        }
        if (y8.k.a(bVar, z.c()) && this.f8814b.c()) {
            return new i(h.NOT_NULL, z10);
        }
        if (y8.k.a(bVar, z.a())) {
            return new i(h.NOT_NULL, true);
        }
        if (y8.k.a(bVar, z.b())) {
            return new i(h.NULLABLE, true);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022c A[LOOP:2: B:108:0x0226->B:110:0x022c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <D extends n9.b> D d(D r17, y9.g r18) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: da.l.d(n9.b, y9.g):n9.b");
    }

    private final i i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z10, boolean z11) {
        la.b f10 = cVar.f();
        if (f10 == null) {
            return null;
        }
        boolean z12 = (cVar instanceof z9.e) && (((z9.e) cVar).m() || z11) && !z10;
        i l10 = l(f10);
        if (l10 == null && (l10 = c(f10, cVar, z12)) == null) {
            return null;
        }
        return (!l10.d() && (cVar instanceof x9.i) && ((x9.i) cVar).j()) ? i.b(l10, null, true, 1, null) : l10;
    }

    private final i j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z10) {
        pa.g<?> b10 = ra.a.b(cVar);
        pa.j jVar = b10 instanceof pa.j ? (pa.j) b10 : null;
        if (jVar == null) {
            return new i(h.NOT_NULL, z10);
        }
        String k10 = jVar.c().k();
        switch (k10.hashCode()) {
            case 73135176:
                if (!k10.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!k10.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (k10.equals("UNKNOWN")) {
                    return new i(h.FORCE_FLEXIBILITY, z10);
                }
                return null;
            case 1933739535:
                if (k10.equals("ALWAYS")) {
                    return new i(h.NOT_NULL, z10);
                }
                return null;
            default:
                return null;
        }
        return new i(h.NULLABLE, z10);
    }

    private final boolean k(d1 d1Var, b0 b0Var) {
        boolean k02;
        x9.a b10 = x9.k.b(d1Var);
        if (b10 instanceof x9.j) {
            k02 = v9.d0.a(b0Var, ((x9.j) b10).a()) != null;
        } else if (y8.k.a(b10, x9.h.f15539a)) {
            k02 = c1.b(b0Var);
        } else {
            if (b10 != null) {
                throw new l8.l();
            }
            k02 = d1Var.k0();
        }
        return k02 && d1Var.g().isEmpty();
    }

    private final i l(la.b bVar) {
        if (this.f8814b.e() == jb.h.IGNORE) {
            return null;
        }
        boolean z10 = this.f8814b.e() == jb.h.WARN;
        if (y8.k.a(bVar, z.h())) {
            return new i(h.NULLABLE, z10);
        }
        if (y8.k.a(bVar, z.i())) {
            return new i(h.FORCE_FLEXIBILITY, z10);
        }
        return null;
    }

    private final b m(n9.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z10, y9.g gVar, v9.a aVar2, x8.l<? super n9.b, ? extends b0> lVar) {
        int n10;
        b0 h10 = lVar.h(bVar);
        Collection<? extends n9.b> g10 = bVar.g();
        y8.k.d(g10, "this.overriddenDescriptors");
        n10 = m8.r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (n9.b bVar2 : g10) {
            y8.k.d(bVar2, "it");
            arrayList.add(lVar.h(bVar2));
        }
        return new b(aVar, h10, arrayList, z10, y9.a.h(gVar, lVar.h(bVar).u()), aVar2, false, 64, null);
    }

    private final b n(n9.b bVar, d1 d1Var, y9.g gVar, x8.l<? super n9.b, ? extends b0> lVar) {
        y9.g h10;
        return m(bVar, d1Var, false, (d1Var == null || (h10 = y9.a.h(gVar, d1Var.u())) == null) ? gVar : h10, v9.a.VALUE_PARAMETER, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends n9.b> Collection<D> e(y9.g gVar, Collection<? extends D> collection) {
        int n10;
        y8.k.e(gVar, "c");
        y8.k.e(collection, "platformSignatures");
        n10 = m8.r.n(collection, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d((n9.b) it.next(), gVar));
        }
        return arrayList;
    }

    public final b0 f(b0 b0Var, y9.g gVar) {
        List d10;
        y8.k.e(b0Var, "type");
        y8.k.e(gVar, "context");
        d10 = m8.q.d();
        return b.f(new b(null, b0Var, d10, false, gVar, v9.a.TYPE_USE, false, 64, null), null, 1, null).b();
    }

    public final List<b0> g(a1 a1Var, List<? extends b0> list, y9.g gVar) {
        int n10;
        List d10;
        y8.k.e(a1Var, "typeParameter");
        y8.k.e(list, "bounds");
        y8.k.e(gVar, "context");
        n10 = m8.r.n(list, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (b0 b0Var : list) {
            if (!eb.a.b(b0Var, g.f8835f)) {
                d10 = m8.q.d();
                b0Var = b.f(new b(this, a1Var, b0Var, d10, false, gVar, v9.a.TYPE_PARAMETER_BOUNDS, true), null, 1, null).b();
            }
            arrayList.add(b0Var);
        }
        return arrayList;
    }

    public final i h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z10, boolean z11) {
        i i10;
        y8.k.e(cVar, "annotationDescriptor");
        i i11 = i(cVar, z10, z11);
        if (i11 != null) {
            return i11;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m10 = this.f8813a.m(cVar);
        if (m10 == null) {
            return null;
        }
        jb.h j10 = this.f8813a.j(cVar);
        if (j10.isIgnore() || (i10 = i(m10, z10, z11)) == null) {
            return null;
        }
        return i.b(i10, null, j10.isWarning(), 1, null);
    }
}
