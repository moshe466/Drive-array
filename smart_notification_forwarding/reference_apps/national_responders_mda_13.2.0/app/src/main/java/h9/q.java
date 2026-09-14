package h9;

import e9.g;
import h9.d0;
import java.lang.annotation.Annotation;
import java.util.List;
import n9.d1;
import n9.m0;

/* loaded from: classes.dex */
public final class q implements e9.g {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ e9.j[] f10632e = {y8.w.g(new y8.t(y8.w.b(q.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), y8.w.g(new y8.t(y8.w.b(q.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: a, reason: collision with root package name */
    private final d0.a f10633a;

    /* renamed from: b, reason: collision with root package name */
    private final f<?> f10634b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10635c;

    /* renamed from: d, reason: collision with root package name */
    private final g.a f10636d;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends Annotation>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Annotation> b() {
            return k0.c(q.this.d());
        }
    }

    public q(f<?> fVar, int i10, g.a aVar, x8.a<? extends m0> aVar2) {
        y8.k.e(fVar, "callable");
        y8.k.e(aVar, "kind");
        y8.k.e(aVar2, "computeDescriptor");
        this.f10634b = fVar;
        this.f10635c = i10;
        this.f10636d = aVar;
        this.f10633a = d0.d(aVar2);
        d0.d(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m0 d() {
        return (m0) this.f10633a.c(this, f10632e[0]);
    }

    public final f<?> b() {
        return this.f10634b;
    }

    @Override // e9.g
    public String c() {
        m0 d10 = d();
        if (!(d10 instanceof d1)) {
            d10 = null;
        }
        d1 d1Var = (d1) d10;
        if (d1Var == null || d1Var.d().c0()) {
            return null;
        }
        la.e c10 = d1Var.c();
        y8.k.d(c10, "valueParameter.name");
        if (c10.s()) {
            return null;
        }
        return c10.k();
    }

    public int e() {
        return this.f10635c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (y8.k.a(this.f10634b, qVar.f10634b) && e() == qVar.e()) {
                return true;
            }
        }
        return false;
    }

    public g.a f() {
        return this.f10636d;
    }

    public int hashCode() {
        return (this.f10634b.hashCode() * 31) + Integer.valueOf(e()).hashCode();
    }

    public String toString() {
        return g0.f10543b.f(this);
    }
}
