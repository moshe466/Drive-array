package bb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class u0 extends y0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4270b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: bb.u0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0073a extends u0 {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<t0, v0> f4271c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f4272d;

            /* JADX WARN: Multi-variable type inference failed */
            C0073a(Map<t0, ? extends v0> map, boolean z10) {
                this.f4271c = map;
                this.f4272d = z10;
            }

            @Override // bb.y0
            public boolean a() {
                return this.f4272d;
            }

            @Override // bb.y0
            public boolean f() {
                return this.f4271c.isEmpty();
            }

            @Override // bb.u0
            public v0 j(t0 t0Var) {
                y8.k.e(t0Var, "key");
                return this.f4271c.get(t0Var);
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public static /* synthetic */ u0 e(a aVar, Map map, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.d(map, z10);
        }

        public final y0 a(b0 b0Var) {
            y8.k.e(b0Var, "kotlinType");
            return b(b0Var.W0(), b0Var.V0());
        }

        public final y0 b(t0 t0Var, List<? extends v0> list) {
            int n10;
            List u02;
            Map p10;
            y8.k.e(t0Var, "typeConstructor");
            y8.k.e(list, "arguments");
            List<n9.a1> B = t0Var.B();
            y8.k.d(B, "typeConstructor.parameters");
            n9.a1 a1Var = (n9.a1) m8.o.U(B);
            if (!y8.k.a(a1Var == null ? null : Boolean.valueOf(a1Var.Z()), Boolean.TRUE)) {
                return new z(B, list);
            }
            List<n9.a1> B2 = t0Var.B();
            y8.k.d(B2, "typeConstructor.parameters");
            n10 = m8.r.n(B2, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = B2.iterator();
            while (it.hasNext()) {
                arrayList.add(((n9.a1) it.next()).o());
            }
            u02 = m8.y.u0(arrayList, list);
            p10 = m8.l0.p(u02);
            return e(this, p10, false, 2, null);
        }

        public final u0 c(Map<t0, ? extends v0> map) {
            y8.k.e(map, "map");
            return e(this, map, false, 2, null);
        }

        public final u0 d(Map<t0, ? extends v0> map, boolean z10) {
            y8.k.e(map, "map");
            return new C0073a(map, z10);
        }
    }

    public static final y0 h(t0 t0Var, List<? extends v0> list) {
        return f4270b.b(t0Var, list);
    }

    public static final u0 i(Map<t0, ? extends v0> map) {
        return f4270b.c(map);
    }

    @Override // bb.y0
    public v0 e(b0 b0Var) {
        y8.k.e(b0Var, "key");
        return j(b0Var.W0());
    }

    public abstract v0 j(t0 t0Var);
}
