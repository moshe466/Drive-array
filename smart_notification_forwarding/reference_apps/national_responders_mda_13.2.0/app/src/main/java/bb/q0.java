package bb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4247e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final q0 f4248a;

    /* renamed from: b, reason: collision with root package name */
    private final n9.z0 f4249b;

    /* renamed from: c, reason: collision with root package name */
    private final List<v0> f4250c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<n9.a1, v0> f4251d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final q0 a(q0 q0Var, n9.z0 z0Var, List<? extends v0> list) {
            int n10;
            List u02;
            Map p10;
            y8.k.e(z0Var, "typeAliasDescriptor");
            y8.k.e(list, "arguments");
            List<n9.a1> B = z0Var.o().B();
            y8.k.d(B, "typeAliasDescriptor.typeConstructor.parameters");
            n10 = m8.r.n(B, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = B.iterator();
            while (it.hasNext()) {
                arrayList.add(((n9.a1) it.next()).a());
            }
            u02 = m8.y.u0(arrayList, list);
            p10 = m8.l0.p(u02);
            return new q0(q0Var, z0Var, list, p10, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private q0(q0 q0Var, n9.z0 z0Var, List<? extends v0> list, Map<n9.a1, ? extends v0> map) {
        this.f4248a = q0Var;
        this.f4249b = z0Var;
        this.f4250c = list;
        this.f4251d = map;
    }

    public /* synthetic */ q0(q0 q0Var, n9.z0 z0Var, List list, Map map, y8.g gVar) {
        this(q0Var, z0Var, list, map);
    }

    public final List<v0> a() {
        return this.f4250c;
    }

    public final n9.z0 b() {
        return this.f4249b;
    }

    public final v0 c(t0 t0Var) {
        y8.k.e(t0Var, "constructor");
        n9.h A = t0Var.A();
        if (A instanceof n9.a1) {
            return this.f4251d.get(A);
        }
        return null;
    }

    public final boolean d(n9.z0 z0Var) {
        y8.k.e(z0Var, "descriptor");
        if (!y8.k.a(this.f4249b, z0Var)) {
            q0 q0Var = this.f4248a;
            if (!(q0Var == null ? false : q0Var.d(z0Var))) {
                return false;
            }
        }
        return true;
    }
}
