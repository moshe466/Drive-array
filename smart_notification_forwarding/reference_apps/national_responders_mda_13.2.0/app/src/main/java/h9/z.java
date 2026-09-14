package h9;

import h9.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import n9.a1;

/* loaded from: classes.dex */
public final class z implements e9.l {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ e9.j[] f10692i = {y8.w.g(new y8.t(y8.w.b(z.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* renamed from: f, reason: collision with root package name */
    private final d0.a f10693f;

    /* renamed from: g, reason: collision with root package name */
    private final a0 f10694g;

    /* renamed from: h, reason: collision with root package name */
    private final a1 f10695h;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends x>> {
        a() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<x> b() {
            int n10;
            List<bb.b0> upperBounds = z.this.d().getUpperBounds();
            y8.k.d(upperBounds, "descriptor.upperBounds");
            n10 = m8.r.n(upperBounds, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new x((bb.b0) it.next(), null, 2, 0 == true ? 1 : 0));
            }
            return arrayList;
        }
    }

    public z(a0 a0Var, a1 a1Var) {
        h<?> hVar;
        Object J0;
        y8.k.e(a1Var, "descriptor");
        this.f10695h = a1Var;
        this.f10693f = d0.d(new a());
        if (a0Var == null) {
            n9.m d10 = d().d();
            y8.k.d(d10, "descriptor.containingDeclaration");
            if (d10 instanceof n9.e) {
                J0 = e((n9.e) d10);
            } else {
                if (!(d10 instanceof n9.b)) {
                    throw new b0("Unknown type parameter container: " + d10);
                }
                n9.m d11 = ((n9.b) d10).d();
                y8.k.d(d11, "declaration.containingDeclaration");
                if (d11 instanceof n9.e) {
                    hVar = e((n9.e) d11);
                } else {
                    za.g gVar = (za.g) (!(d10 instanceof za.g) ? null : d10);
                    if (gVar == null) {
                        throw new b0("Non-class callable descriptor must be deserialized: " + d10);
                    }
                    e9.b e10 = w8.a.e(b(gVar));
                    Objects.requireNonNull(e10, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    hVar = (h) e10;
                }
                J0 = d10.J0(new h9.a(hVar), l8.w.f11824a);
            }
            y8.k.d(J0, "when (val declaration = … $declaration\")\n        }");
            a0Var = (a0) J0;
        }
        this.f10694g = a0Var;
    }

    private final Class<?> b(za.g gVar) {
        Class<?> e10;
        za.f F = gVar.F();
        if (!(F instanceof ea.i)) {
            F = null;
        }
        ea.i iVar = (ea.i) F;
        ea.o f10 = iVar != null ? iVar.f() : null;
        r9.f fVar = (r9.f) (f10 instanceof r9.f ? f10 : null);
        if (fVar != null && (e10 = fVar.e()) != null) {
            return e10;
        }
        throw new b0("Container of deserialized member is not resolved: " + gVar);
    }

    private final h<?> e(n9.e eVar) {
        Class<?> l10 = k0.l(eVar);
        h<?> hVar = (h) (l10 != null ? w8.a.e(l10) : null);
        if (hVar != null) {
            return hVar;
        }
        throw new b0("Type parameter container is not resolved: " + eVar.d());
    }

    @Override // e9.l
    public String c() {
        String k10 = d().c().k();
        y8.k.d(k10, "descriptor.name.asString()");
        return k10;
    }

    public a1 d() {
        return this.f10695h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (y8.k.a(this.f10694g, zVar.f10694g) && y8.k.a(c(), zVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // e9.l
    public List<e9.k> getUpperBounds() {
        return (List) this.f10693f.c(this, f10692i[0]);
    }

    public int hashCode() {
        return (this.f10694g.hashCode() * 31) + c().hashCode();
    }

    public String toString() {
        return y8.a0.f15930f.a(this);
    }

    @Override // e9.l
    public e9.n v() {
        int i10 = y.f10691a[d().v().ordinal()];
        if (i10 == 1) {
            return e9.n.INVARIANT;
        }
        if (i10 == 2) {
            return e9.n.IN;
        }
        if (i10 == 3) {
            return e9.n.OUT;
        }
        throw new l8.l();
    }
}
