package bb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import n9.b;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final n9.d0 f4258a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final c f4259b = new c(la.e.u("<ERROR CLASS>"));

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f4260c = j("<LOOP IN SUPERTYPES>");

    /* renamed from: d, reason: collision with root package name */
    private static final b0 f4261d = j("<ERROR PROPERTY TYPE>");

    /* renamed from: e, reason: collision with root package name */
    private static final n9.p0 f4262e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set<n9.p0> f4263f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements n9.d0 {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void e0(int r12) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: bb.t.a.e0(int):void");
        }

        @Override // n9.d0
        public n9.l0 C(la.b bVar) {
            if (bVar == null) {
                e0(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // n9.m
        public <R, D> R J0(n9.o<R, D> oVar, D d10) {
            if (oVar != null) {
                return null;
            }
            e0(11);
            return null;
        }

        @Override // n9.d0
        public <T> T Q0(n9.c0<T> c0Var) {
            if (c0Var != null) {
                return null;
            }
            e0(0);
            return null;
        }

        @Override // n9.d0
        public boolean V(n9.d0 d0Var) {
            if (d0Var != null) {
                return false;
            }
            e0(12);
            return false;
        }

        @Override // n9.m
        public n9.m a() {
            return this;
        }

        @Override // n9.e0
        public la.e c() {
            la.e u10 = la.e.u("<ERROR MODULE>");
            if (u10 == null) {
                e0(5);
            }
            return u10;
        }

        @Override // n9.m
        public n9.m d() {
            return null;
        }

        @Override // n9.d0
        public List<n9.d0> i0() {
            List<n9.d0> d10;
            d10 = m8.q.d();
            if (d10 == null) {
                e0(9);
            }
            return d10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
            if (b10 == null) {
                e0(1);
            }
            return b10;
        }

        @Override // n9.d0
        public k9.h w() {
            k9.e N0 = k9.e.N0();
            if (N0 == null) {
                e0(14);
            }
            return N0;
        }

        @Override // n9.d0
        public Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
            List d10;
            if (bVar == null) {
                e0(2);
            }
            if (lVar == null) {
                e0(3);
            }
            d10 = m8.q.d();
            if (d10 == null) {
                e0(4);
            }
            return d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements t0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4264a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4265b;

        b(c cVar, String str) {
            this.f4264a = cVar;
            this.f4265b = str;
        }

        private static /* synthetic */ void b(int i10) {
            String str = i10 != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i10 != 3 ? 2 : 3];
            if (i10 != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i10 == 1) {
                objArr[1] = "getSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i10 != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i10 == 3) {
                objArr[2] = "refine";
            }
            String format = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // bb.t0
        /* renamed from: A */
        public n9.h o() {
            return this.f4264a;
        }

        @Override // bb.t0
        public List<n9.a1> B() {
            List<n9.a1> d10;
            d10 = m8.q.d();
            if (d10 == null) {
                b(0);
            }
            return d10;
        }

        public String toString() {
            return this.f4265b;
        }

        @Override // bb.t0
        public k9.h w() {
            k9.e N0 = k9.e.N0();
            if (N0 == null) {
                b(2);
            }
            return N0;
        }

        @Override // bb.t0
        public Collection<b0> x() {
            List d10;
            d10 = m8.q.d();
            if (d10 == null) {
                b(1);
            }
            return d10;
        }

        @Override // bb.t0
        public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                b(3);
            }
            return this;
        }

        @Override // bb.t0
        public boolean z() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends p9.h {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(la.e r11) {
            /*
                r10 = this;
                if (r11 != 0) goto L6
                r0 = 0
                I0(r0)
            L6:
                n9.d0 r2 = bb.t.q()
                n9.a0 r4 = n9.a0.OPEN
                n9.f r5 = n9.f.CLASS
                java.util.List r6 = java.util.Collections.emptyList()
                n9.v0 r0 = n9.v0.f12324a
                r8 = 0
                ab.n r9 = ab.f.f359e
                r1 = r10
                r3 = r11
                r7 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a r11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r11 = r11.b()
                r1 = 1
                p9.f r11 = p9.f.x1(r10, r11, r1, r0)
                java.util.List r0 = java.util.Collections.emptyList()
                n9.u r1 = n9.t.f12302d
                r11.A1(r0, r1)
                la.e r0 = r10.c()
                java.lang.String r0 = r0.k()
                ua.h r0 = bb.t.h(r0)
                bb.s r1 = new bb.s
                java.lang.String r2 = "<ERROR>"
                bb.t0 r2 = bb.t.d(r2, r10)
                r1.<init>(r2, r0)
                r11.r1(r1)
                java.util.Set r1 = java.util.Collections.singleton(r11)
                r10.V0(r0, r1, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bb.t.c.<init>(la.e):void");
        }

        private static /* synthetic */ void I0(int i10) {
            String str = (i10 == 2 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 2 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i10 == 2) {
                objArr[1] = "substitute";
            } else if (i10 == 5 || i10 == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i10) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i10 != 2 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // p9.a, n9.x0
        /* renamed from: U0, reason: merged with bridge method [inline-methods] */
        public n9.e e(a1 a1Var) {
            if (a1Var == null) {
                I0(1);
            }
            return this;
        }

        @Override // p9.a, p9.t
        public ua.h e0(y0 y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (y0Var == null) {
                I0(6);
            }
            if (gVar == null) {
                I0(7);
            }
            ua.h h10 = t.h("Error scope for class " + c() + " with arguments: " + y0Var);
            if (h10 == null) {
                I0(8);
            }
            return h10;
        }

        @Override // p9.h
        public String toString() {
            return c().k();
        }
    }

    /* loaded from: classes.dex */
    public static class d implements ua.h {

        /* renamed from: b, reason: collision with root package name */
        private final String f4266b;

        private d(String str) {
            if (str == null) {
                h(0);
            }
            this.f4266b = str;
        }

        /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void h(int r10) {
            /*
                r0 = 18
                r1 = 7
                if (r10 == r1) goto Ld
                if (r10 == r0) goto Ld
                switch(r10) {
                    case 10: goto Ld;
                    case 11: goto Ld;
                    case 12: goto Ld;
                    case 13: goto Ld;
                    default: goto La;
                }
            La:
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lf
            Ld:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lf:
                r3 = 2
                if (r10 == r1) goto L19
                if (r10 == r0) goto L19
                switch(r10) {
                    case 10: goto L19;
                    case 11: goto L19;
                    case 12: goto L19;
                    case 13: goto L19;
                    default: goto L17;
                }
            L17:
                r4 = 3
                goto L1a
            L19:
                r4 = 2
            L1a:
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope"
                r6 = 0
                switch(r10) {
                    case 1: goto L3e;
                    case 2: goto L39;
                    case 3: goto L3e;
                    case 4: goto L39;
                    case 5: goto L3e;
                    case 6: goto L39;
                    case 7: goto L36;
                    case 8: goto L3e;
                    case 9: goto L39;
                    case 10: goto L36;
                    case 11: goto L36;
                    case 12: goto L36;
                    case 13: goto L36;
                    case 14: goto L3e;
                    case 15: goto L39;
                    case 16: goto L31;
                    case 17: goto L2c;
                    case 18: goto L36;
                    case 19: goto L3e;
                    case 20: goto L27;
                    default: goto L22;
                }
            L22:
                java.lang.String r7 = "debugMessage"
                r4[r6] = r7
                goto L42
            L27:
                java.lang.String r7 = "p"
                r4[r6] = r7
                goto L42
            L2c:
                java.lang.String r7 = "nameFilter"
                r4[r6] = r7
                goto L42
            L31:
                java.lang.String r7 = "kindFilter"
                r4[r6] = r7
                goto L42
            L36:
                r4[r6] = r5
                goto L42
            L39:
                java.lang.String r7 = "location"
                r4[r6] = r7
                goto L42
            L3e:
                java.lang.String r7 = "name"
                r4[r6] = r7
            L42:
                java.lang.String r6 = "getContributedDescriptors"
                java.lang.String r7 = "getContributedFunctions"
                java.lang.String r8 = "getContributedVariables"
                r9 = 1
                if (r10 == r1) goto L68
                if (r10 == r0) goto L65
                switch(r10) {
                    case 10: goto L62;
                    case 11: goto L5d;
                    case 12: goto L58;
                    case 13: goto L53;
                    default: goto L50;
                }
            L50:
                r4[r9] = r5
                goto L6a
            L53:
                java.lang.String r5 = "getClassifierNames"
                r4[r9] = r5
                goto L6a
            L58:
                java.lang.String r5 = "getVariableNames"
                r4[r9] = r5
                goto L6a
            L5d:
                java.lang.String r5 = "getFunctionNames"
                r4[r9] = r5
                goto L6a
            L62:
                r4[r9] = r7
                goto L6a
            L65:
                r4[r9] = r6
                goto L6a
            L68:
                r4[r9] = r8
            L6a:
                switch(r10) {
                    case 1: goto L8f;
                    case 2: goto L8f;
                    case 3: goto L8a;
                    case 4: goto L8a;
                    case 5: goto L87;
                    case 6: goto L87;
                    case 7: goto L93;
                    case 8: goto L84;
                    case 9: goto L84;
                    case 10: goto L93;
                    case 11: goto L93;
                    case 12: goto L93;
                    case 13: goto L93;
                    case 14: goto L7f;
                    case 15: goto L7f;
                    case 16: goto L7c;
                    case 17: goto L7c;
                    case 18: goto L93;
                    case 19: goto L77;
                    case 20: goto L72;
                    default: goto L6d;
                }
            L6d:
                java.lang.String r5 = "<init>"
                r4[r3] = r5
                goto L93
            L72:
                java.lang.String r5 = "printScopeStructure"
                r4[r3] = r5
                goto L93
            L77:
                java.lang.String r5 = "definitelyDoesNotContainName"
                r4[r3] = r5
                goto L93
            L7c:
                r4[r3] = r6
                goto L93
            L7f:
                java.lang.String r5 = "recordLookup"
                r4[r3] = r5
                goto L93
            L84:
                r4[r3] = r7
                goto L93
            L87:
                r4[r3] = r8
                goto L93
            L8a:
                java.lang.String r5 = "getContributedClassifierIncludeDeprecated"
                r4[r3] = r5
                goto L93
            L8f:
                java.lang.String r5 = "getContributedClassifier"
                r4[r3] = r5
            L93:
                java.lang.String r2 = java.lang.String.format(r2, r4)
                if (r10 == r1) goto La4
                if (r10 == r0) goto La4
                switch(r10) {
                    case 10: goto La4;
                    case 11: goto La4;
                    case 12: goto La4;
                    case 13: goto La4;
                    default: goto L9e;
                }
            L9e:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r2)
                goto La9
            La4:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r2)
            La9:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: bb.t.d.h(int):void");
        }

        @Override // ua.h
        public Set<la.e> c() {
            Set<la.e> emptySet = Collections.emptySet();
            if (emptySet == null) {
                h(11);
            }
            return emptySet;
        }

        @Override // ua.h
        public Set<la.e> d() {
            Set<la.e> emptySet = Collections.emptySet();
            if (emptySet == null) {
                h(12);
            }
            return emptySet;
        }

        @Override // ua.k
        public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
            if (dVar == null) {
                h(16);
            }
            if (lVar == null) {
                h(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                h(18);
            }
            return emptyList;
        }

        @Override // ua.h
        public Set<la.e> f() {
            Set<la.e> emptySet = Collections.emptySet();
            if (emptySet == null) {
                h(13);
            }
            return emptySet;
        }

        @Override // ua.k
        public n9.h g(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            return t.e(eVar.k());
        }

        @Override // ua.h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Set<? extends n9.u0> b(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(8);
            }
            if (bVar == null) {
                h(9);
            }
            Set<? extends n9.u0> singleton = Collections.singleton(t.f(this));
            if (singleton == null) {
                h(10);
            }
            return singleton;
        }

        @Override // ua.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Set<? extends n9.p0> a(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            Set<? extends n9.p0> set = t.f4263f;
            if (set == null) {
                h(7);
            }
            return set;
        }

        public String toString() {
            return "ErrorScope{" + this.f4266b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e implements ua.h {

        /* renamed from: b, reason: collision with root package name */
        private final String f4267b;

        private e(String str) {
            if (str == null) {
                h(0);
            }
            this.f4267b = str;
        }

        /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        private static /* synthetic */ void h(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ua.h
        public Collection<? extends n9.p0> a(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            throw new IllegalStateException(this.f4267b + ", required name: " + eVar);
        }

        @Override // ua.h
        public Collection<? extends n9.u0> b(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(7);
            }
            if (bVar == null) {
                h(8);
            }
            throw new IllegalStateException(this.f4267b + ", required name: " + eVar);
        }

        @Override // ua.h
        public Set<la.e> c() {
            throw new IllegalStateException();
        }

        @Override // ua.h
        public Set<la.e> d() {
            throw new IllegalStateException();
        }

        @Override // ua.k
        public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
            if (dVar == null) {
                h(9);
            }
            if (lVar == null) {
                h(10);
            }
            throw new IllegalStateException(this.f4267b);
        }

        @Override // ua.h
        public Set<la.e> f() {
            throw new IllegalStateException();
        }

        @Override // ua.k
        public n9.h g(la.e eVar, u9.b bVar) {
            if (eVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            throw new IllegalStateException(this.f4267b + ", required name: " + eVar);
        }

        public String toString() {
            return "ThrowingScope{" + this.f4267b + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class f implements t0 {

        /* renamed from: a, reason: collision with root package name */
        private final n9.a1 f4268a;

        /* renamed from: b, reason: collision with root package name */
        private final t0 f4269b;

        private static /* synthetic */ void b(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 6) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getSupertypes";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 6) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // bb.t0
        /* renamed from: A */
        public n9.h o() {
            return this.f4269b.o();
        }

        @Override // bb.t0
        public List<n9.a1> B() {
            List<n9.a1> B = this.f4269b.B();
            if (B == null) {
                b(2);
            }
            return B;
        }

        public n9.a1 c() {
            n9.a1 a1Var = this.f4268a;
            if (a1Var == null) {
                b(1);
            }
            return a1Var;
        }

        @Override // bb.t0
        public k9.h w() {
            k9.h g10 = ra.a.g(this.f4268a);
            if (g10 == null) {
                b(4);
            }
            return g10;
        }

        @Override // bb.t0
        public Collection<b0> x() {
            Collection<b0> x10 = this.f4269b.x();
            if (x10 == null) {
                b(3);
            }
            return x10;
        }

        @Override // bb.t0
        public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                b(5);
            }
            return this;
        }

        @Override // bb.t0
        public boolean z() {
            return this.f4269b.z();
        }
    }

    static {
        p9.b0 g10 = g();
        f4262e = g10;
        f4263f = Collections.singleton(g10);
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 4 || i10 == 6 || i10 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 6 || i10 == 19) ? 2 : 3];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i10 == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i10 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i10) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 != 4 && i10 != 6 && i10 != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static n9.e e(String str) {
        if (str == null) {
            a(1);
        }
        return new c(la.e.u("<ERROR CLASS: " + str + ">"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n9.u0 f(d dVar) {
        if (dVar == null) {
            a(5);
        }
        cb.a aVar = new cb.a(f4259b, dVar);
        aVar.c1(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), n9.a0.OPEN, n9.t.f12303e);
        return aVar;
    }

    private static p9.b0 g() {
        p9.b0 Y0 = p9.b0.Y0(f4259b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), n9.a0.OPEN, n9.t.f12303e, true, la.e.u("<ERROR PROPERTY>"), b.a.DECLARATION, n9.v0.f12324a, false, false, false, false, false, false);
        Y0.k1(f4261d, Collections.emptyList(), null, null);
        return Y0;
    }

    public static ua.h h(String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    public static ua.h i(String str, boolean z10) {
        if (str == null) {
            a(3);
        }
        a aVar = null;
        return z10 ? new e(str, aVar) : new d(str, aVar);
    }

    public static i0 j(String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    public static t0 k(String str) {
        if (str == null) {
            a(15);
        }
        return m("[ERROR : " + str + "]", f4259b);
    }

    public static t0 l(String str) {
        if (str == null) {
            a(16);
        }
        return m(str, f4259b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t0 m(String str, c cVar) {
        if (str == null) {
            a(17);
        }
        if (cVar == null) {
            a(18);
        }
        return new b(cVar, str);
    }

    public static i0 n(String str, List<v0> list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new s(k(str), h(str), list, false);
    }

    public static i0 o(String str, t0 t0Var) {
        if (str == null) {
            a(9);
        }
        if (t0Var == null) {
            a(10);
        }
        return new s(t0Var, h(str));
    }

    public static i0 p(String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    public static n9.d0 q() {
        n9.d0 d0Var = f4258a;
        if (d0Var == null) {
            a(19);
        }
        return d0Var;
    }

    public static boolean r(n9.m mVar) {
        if (mVar == null) {
            return false;
        }
        return s(mVar) || s(mVar.d()) || mVar == f4258a;
    }

    private static boolean s(n9.m mVar) {
        return mVar instanceof c;
    }

    public static boolean t(b0 b0Var) {
        return b0Var != null && (b0Var.W0() instanceof f);
    }
}
