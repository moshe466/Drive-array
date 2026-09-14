package pa;

import bb.b0;
import bb.c0;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.x0;
import bb.z0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n9.a1;
import n9.d0;

/* loaded from: classes.dex */
public final class n implements t0 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f13336f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f13337a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f13338b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b0> f13339c;

    /* renamed from: d, reason: collision with root package name */
    private final i0 f13340d;

    /* renamed from: e, reason: collision with root package name */
    private final l8.h f13341e;

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: pa.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0276a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static EnumC0276a[] valuesCustom() {
                EnumC0276a[] valuesCustom = values();
                EnumC0276a[] enumC0276aArr = new EnumC0276a[valuesCustom.length];
                System.arraycopy(valuesCustom, 0, enumC0276aArr, 0, valuesCustom.length);
                return enumC0276aArr;
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13342a;

            static {
                int[] iArr = new int[EnumC0276a.valuesCustom().length];
                iArr[EnumC0276a.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[EnumC0276a.INTERSECTION_TYPE.ordinal()] = 2;
                f13342a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        private final i0 a(Collection<? extends i0> collection, EnumC0276a enumC0276a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = c((i0) next, (i0) it.next(), enumC0276a);
            }
            return (i0) next;
        }

        private final i0 c(i0 i0Var, i0 i0Var2, EnumC0276a enumC0276a) {
            if (i0Var == null || i0Var2 == null) {
                return null;
            }
            t0 W0 = i0Var.W0();
            t0 W02 = i0Var2.W0();
            boolean z10 = W0 instanceof n;
            if (z10 && (W02 instanceof n)) {
                return e((n) W0, (n) W02, enumC0276a);
            }
            if (z10) {
                return d((n) W0, i0Var2);
            }
            if (W02 instanceof n) {
                return d((n) W02, i0Var);
            }
            return null;
        }

        private final i0 d(n nVar, i0 i0Var) {
            if (nVar.g().contains(i0Var)) {
                return i0Var;
            }
            return null;
        }

        private final i0 e(n nVar, n nVar2, EnumC0276a enumC0276a) {
            Set M;
            int i10 = b.f13342a[enumC0276a.ordinal()];
            if (i10 == 1) {
                M = m8.y.M(nVar.g(), nVar2.g());
            } else {
                if (i10 != 2) {
                    throw new l8.l();
                }
                M = m8.y.s0(nVar.g(), nVar2.g());
            }
            n nVar3 = new n(nVar.f13337a, nVar.f13338b, M, null);
            c0 c0Var = c0.f4165a;
            return c0.e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), nVar3, false);
        }

        public final i0 b(Collection<? extends i0> collection) {
            y8.k.e(collection, "types");
            return a(collection, EnumC0276a.INTERSECTION_TYPE);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<List<i0>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<i0> b() {
            List b10;
            List<i0> j10;
            i0 s10 = n.this.w().x().s();
            y8.k.d(s10, "builtIns.comparable.defaultType");
            b10 = m8.p.b(new x0(h1.IN_VARIANCE, n.this.f13340d));
            j10 = m8.q.j(z0.f(s10, b10, null, 2, null));
            if (!n.this.i()) {
                j10.add(n.this.w().L());
            }
            return j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<b0, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f13344f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(b0 b0Var) {
            y8.k.e(b0Var, "it");
            return b0Var.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n(long j10, d0 d0Var, Set<? extends b0> set) {
        l8.h b10;
        c0 c0Var = c0.f4165a;
        this.f13340d = c0.e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), this, false);
        b10 = l8.j.b(new b());
        this.f13341e = b10;
        this.f13337a = j10;
        this.f13338b = d0Var;
        this.f13339c = set;
    }

    public /* synthetic */ n(long j10, d0 d0Var, Set set, y8.g gVar) {
        this(j10, d0Var, set);
    }

    private final List<b0> h() {
        return (List) this.f13341e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        Collection<b0> a10 = t.a(this.f13338b);
        if ((a10 instanceof Collection) && a10.isEmpty()) {
            return true;
        }
        Iterator<T> it = a10.iterator();
        while (it.hasNext()) {
            if (!(!g().contains((b0) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final String j() {
        String Q;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Q = m8.y.Q(this.f13339c, ",", null, null, 0, null, c.f13344f, 30, null);
        sb2.append(Q);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // bb.t0
    /* renamed from: A */
    public n9.h o() {
        return null;
    }

    @Override // bb.t0
    public List<a1> B() {
        List<a1> d10;
        d10 = m8.q.d();
        return d10;
    }

    public final boolean f(t0 t0Var) {
        y8.k.e(t0Var, "constructor");
        Set<b0> set = this.f13339c;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (y8.k.a(((b0) it.next()).W0(), t0Var)) {
                return true;
            }
        }
        return false;
    }

    public final Set<b0> g() {
        return this.f13339c;
    }

    public String toString() {
        return y8.k.j("IntegerLiteralType", j());
    }

    @Override // bb.t0
    public k9.h w() {
        return this.f13338b.w();
    }

    @Override // bb.t0
    public Collection<b0> x() {
        return h();
    }

    @Override // bb.t0
    public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // bb.t0
    public boolean z() {
        return false;
    }
}
