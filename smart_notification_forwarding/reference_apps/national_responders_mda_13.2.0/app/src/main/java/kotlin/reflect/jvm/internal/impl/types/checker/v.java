package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.a0;
import bb.b0;
import bb.g1;
import bb.i0;
import bb.l0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m8.y;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f11595a = new v();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    private static final class a {
        private static final /* synthetic */ a[] $VALUES;
        public static final a ACCEPT_NULL;
        public static final a NOT_NULL;
        public static final a START;
        public static final a UNKNOWN;

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0242a extends a {
            C0242a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.v.a
            public a combine(g1 g1Var) {
                y8.k.e(g1Var, "nextType");
                return getResultNullability(g1Var);
            }
        }

        /* loaded from: classes.dex */
        static final class b extends a {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.v.a
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b combine(g1 g1Var) {
                y8.k.e(g1Var, "nextType");
                return this;
            }
        }

        /* loaded from: classes.dex */
        static final class c extends a {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.v.a
            public a combine(g1 g1Var) {
                y8.k.e(g1Var, "nextType");
                return getResultNullability(g1Var);
            }
        }

        /* loaded from: classes.dex */
        static final class d extends a {
            d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.v.a
            public a combine(g1 g1Var) {
                y8.k.e(g1Var, "nextType");
                a resultNullability = getResultNullability(g1Var);
                return resultNullability == a.ACCEPT_NULL ? this : resultNullability;
            }
        }

        static {
            c cVar = new c("START", 0);
            START = cVar;
            C0242a c0242a = new C0242a("ACCEPT_NULL", 1);
            ACCEPT_NULL = c0242a;
            d dVar = new d("UNKNOWN", 2);
            UNKNOWN = dVar;
            b bVar = new b("NOT_NULL", 3);
            NOT_NULL = bVar;
            $VALUES = new a[]{cVar, c0242a, dVar, bVar};
        }

        private a(String str, int i10) {
        }

        public /* synthetic */ a(String str, int i10, y8.g gVar) {
            this(str, i10);
        }

        public static a valueOf(String str) {
            y8.k.e(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = $VALUES;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a combine(g1 g1Var);

        protected final a getResultNullability(g1 g1Var) {
            y8.k.e(g1Var, "<this>");
            return g1Var.X0() ? ACCEPT_NULL : n.f11589a.a(g1Var) ? NOT_NULL : UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<String> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Set<i0> f11596f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends i0> set) {
            super(0);
            this.f11596f = set;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String b() {
            String Q;
            Q = y.Q(this.f11596f, null, null, null, 0, null, null, 63, null);
            return y8.k.j("This collections cannot be empty! input types: ", Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class c extends y8.i implements x8.p<b0, b0, Boolean> {
        c(v vVar) {
            super(2, vVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "isStrictSupertype";
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(b0 b0Var, b0 b0Var2) {
            return Boolean.valueOf(n(b0Var, b0Var2));
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(v.class);
        }

        @Override // y8.c
        public final String m() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        public final boolean n(b0 b0Var, b0 b0Var2) {
            y8.k.e(b0Var, "p0");
            y8.k.e(b0Var2, "p1");
            return ((v) this.f15934g).e(b0Var, b0Var2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class d extends y8.i implements x8.p<b0, b0, Boolean> {
        d(m mVar) {
            super(2, mVar);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "equalTypes";
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ Boolean g(b0 b0Var, b0 b0Var2) {
            return Boolean.valueOf(n(b0Var, b0Var2));
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(m.class);
        }

        @Override // y8.c
        public final String m() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        public final boolean n(b0 b0Var, b0 b0Var2) {
            y8.k.e(b0Var, "p0");
            y8.k.e(b0Var2, "p1");
            return ((m) this.f15934g).c(b0Var, b0Var2);
        }
    }

    private v() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[EDGE_INSN: B:23:0x0051->B:7:0x0051 BREAK  A[LOOP:1: B:14:0x0028->B:24:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:1: B:14:0x0028->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Collection<bb.i0> b(java.util.Collection<? extends bb.i0> r8, x8.p<? super bb.i0, ? super bb.i0, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            y8.k.d(r8, r1)
        Le:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L57
            java.lang.Object r1 = r8.next()
            bb.i0 r1 = (bb.i0) r1
            boolean r2 = r0.isEmpty()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L24
        L22:
            r3 = 0
            goto L51
        L24:
            java.util.Iterator r2 = r0.iterator()
        L28:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L22
            java.lang.Object r5 = r2.next()
            bb.i0 r5 = (bb.i0) r5
            if (r5 == r1) goto L4e
            java.lang.String r6 = "lower"
            y8.k.d(r5, r6)
            java.lang.String r6 = "upper"
            y8.k.d(r1, r6)
            java.lang.Object r5 = r9.g(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4e
            r5 = 1
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r5 == 0) goto L28
        L51:
            if (r3 == 0) goto Le
            r8.remove()
            goto Le
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.v.b(java.util.Collection, x8.p):java.util.Collection");
    }

    private final i0 d(Set<? extends i0> set) {
        if (set.size() == 1) {
            return (i0) m8.o.c0(set);
        }
        new b(set);
        Collection<i0> b10 = b(set, new c(this));
        b10.isEmpty();
        i0 b11 = pa.n.f13336f.b(b10);
        if (b11 != null) {
            return b11;
        }
        Collection<i0> b12 = b(b10, new d(l.f11584b.a()));
        b12.isEmpty();
        return b12.size() < 2 ? (i0) m8.o.c0(b12) : new a0(set).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(b0 b0Var, b0 b0Var2) {
        m a10 = l.f11584b.a();
        return a10.b(b0Var, b0Var2) && !a10.b(b0Var2, b0Var);
    }

    public final i0 c(List<? extends i0> list) {
        int n10;
        y8.k.e(list, "types");
        list.size();
        ArrayList<i0> arrayList = new ArrayList();
        for (i0 i0Var : list) {
            if (i0Var.W0() instanceof a0) {
                Collection<b0> x10 = i0Var.W0().x();
                y8.k.d(x10, "type.constructor.supertypes");
                n10 = m8.r.n(x10, 10);
                ArrayList arrayList2 = new ArrayList(n10);
                for (b0 b0Var : x10) {
                    y8.k.d(b0Var, "it");
                    i0 d10 = bb.y.d(b0Var);
                    if (i0Var.X0()) {
                        d10 = d10.a1(true);
                    }
                    arrayList2.add(d10);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(i0Var);
            }
        }
        a aVar = a.START;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar = aVar.combine((g1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (i0 i0Var2 : arrayList) {
            if (aVar == a.NOT_NULL) {
                if (i0Var2 instanceof i) {
                    i0Var2 = l0.k((i) i0Var2);
                }
                i0Var2 = l0.i(i0Var2, false, 1, null);
            }
            linkedHashSet.add(i0Var2);
        }
        return d(linkedHashSet);
    }
}
