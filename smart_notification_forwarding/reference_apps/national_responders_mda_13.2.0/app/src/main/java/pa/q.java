package pa;

import bb.b0;
import bb.c0;
import bb.d0;
import bb.h1;
import bb.i0;
import bb.v0;
import bb.x0;
import java.util.List;
import k9.k;
import n9.a1;

/* loaded from: classes.dex */
public final class q extends g<b> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13348b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final g<?> a(b0 b0Var) {
            y8.k.e(b0Var, "argumentType");
            if (d0.a(b0Var)) {
                return null;
            }
            b0 b0Var2 = b0Var;
            int i10 = 0;
            while (k9.h.b0(b0Var2)) {
                b0Var2 = ((v0) m8.o.d0(b0Var2.V0())).b();
                y8.k.d(b0Var2, "type.arguments.single().type");
                i10++;
            }
            n9.h o10 = b0Var2.W0().o();
            if (o10 instanceof n9.e) {
                la.a h10 = ra.a.h(o10);
                return h10 == null ? new q(new b.a(b0Var)) : new q(h10, i10);
            }
            if (!(o10 instanceof a1)) {
                return null;
            }
            la.a m10 = la.a.m(k.a.f11253b.l());
            y8.k.d(m10, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new q(m10, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {

        /* loaded from: classes.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final b0 f13349a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b0 b0Var) {
                super(null);
                y8.k.e(b0Var, "type");
                this.f13349a = b0Var;
            }

            public final b0 a() {
                return this.f13349a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && y8.k.a(this.f13349a, ((a) obj).f13349a);
            }

            public int hashCode() {
                return this.f13349a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.f13349a + ')';
            }
        }

        /* renamed from: pa.q$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0277b extends b {

            /* renamed from: a, reason: collision with root package name */
            private final f f13350a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0277b(f fVar) {
                super(null);
                y8.k.e(fVar, "value");
                this.f13350a = fVar;
            }

            public final int a() {
                return this.f13350a.c();
            }

            public final la.a b() {
                return this.f13350a.d();
            }

            public final f c() {
                return this.f13350a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0277b) && y8.k.a(this.f13350a, ((C0277b) obj).f13350a);
            }

            public int hashCode() {
                return this.f13350a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.f13350a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(la.a aVar, int i10) {
        this(new f(aVar, i10));
        y8.k.e(aVar, "classId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(f fVar) {
        this(new b.C0277b(fVar));
        y8.k.e(fVar, "value");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b bVar) {
        super(bVar);
        y8.k.e(bVar, "value");
    }

    @Override // pa.g
    public b0 a(n9.d0 d0Var) {
        List b10;
        y8.k.e(d0Var, "module");
        c0 c0Var = c0.f4165a;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        n9.e E = d0Var.w().E();
        y8.k.d(E, "module.builtIns.kClass");
        b10 = m8.p.b(new x0(c(d0Var)));
        return c0.g(b11, E, b10);
    }

    public final b0 c(n9.d0 d0Var) {
        y8.k.e(d0Var, "module");
        b b10 = b();
        if (b10 instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(b10 instanceof b.C0277b)) {
            throw new l8.l();
        }
        f c10 = ((b.C0277b) b()).c();
        la.a a10 = c10.a();
        int b11 = c10.b();
        n9.e a11 = n9.w.a(d0Var, a10);
        if (a11 == null) {
            i0 j10 = bb.t.j("Unresolved type: " + a10 + " (arrayDimensions=" + b11 + ')');
            y8.k.d(j10, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return j10;
        }
        i0 s10 = a11.s();
        y8.k.d(s10, "descriptor.defaultType");
        b0 m10 = eb.a.m(s10);
        for (int i10 = 0; i10 < b11; i10++) {
            m10 = d0Var.w().l(h1.INVARIANT, m10);
            y8.k.d(m10, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return m10;
    }
}
