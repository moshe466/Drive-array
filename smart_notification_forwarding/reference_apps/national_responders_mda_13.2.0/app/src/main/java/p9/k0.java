package p9;

import bb.a1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import n9.d1;
import n9.e1;
import n9.v0;

/* loaded from: classes.dex */
public class k0 extends l0 implements d1 {

    /* renamed from: q, reason: collision with root package name */
    public static final a f13219q = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private final int f13220k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f13221l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f13222m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f13223n;

    /* renamed from: o, reason: collision with root package name */
    private final bb.b0 f13224o;

    /* renamed from: p, reason: collision with root package name */
    private final d1 f13225p;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final k0 a(n9.a aVar, d1 d1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, boolean z10, boolean z11, boolean z12, bb.b0 b0Var2, v0 v0Var, x8.a<? extends List<? extends e1>> aVar2) {
            y8.k.e(aVar, "containingDeclaration");
            y8.k.e(gVar, "annotations");
            y8.k.e(eVar, "name");
            y8.k.e(b0Var, "outType");
            y8.k.e(v0Var, "source");
            return aVar2 == null ? new k0(aVar, d1Var, i10, gVar, eVar, b0Var, z10, z11, z12, b0Var2, v0Var) : new b(aVar, d1Var, i10, gVar, eVar, b0Var, z10, z11, z12, b0Var2, v0Var, aVar2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends k0 {

        /* renamed from: r, reason: collision with root package name */
        private final l8.h f13226r;

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.a<List<? extends e1>> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List<e1> b() {
                return b.this.Y0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n9.a aVar, d1 d1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, boolean z10, boolean z11, boolean z12, bb.b0 b0Var2, v0 v0Var, x8.a<? extends List<? extends e1>> aVar2) {
            super(aVar, d1Var, i10, gVar, eVar, b0Var, z10, z11, z12, b0Var2, v0Var);
            l8.h b10;
            y8.k.e(aVar, "containingDeclaration");
            y8.k.e(gVar, "annotations");
            y8.k.e(eVar, "name");
            y8.k.e(b0Var, "outType");
            y8.k.e(v0Var, "source");
            y8.k.e(aVar2, "destructuringVariables");
            b10 = l8.j.b(aVar2);
            this.f13226r = b10;
        }

        @Override // p9.k0, n9.d1
        public d1 Q(n9.a aVar, la.e eVar, int i10) {
            y8.k.e(aVar, "newOwner");
            y8.k.e(eVar, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = u();
            y8.k.d(u10, "annotations");
            bb.b0 b10 = b();
            y8.k.d(b10, "type");
            boolean k02 = k0();
            boolean E = E();
            boolean G0 = G0();
            bb.b0 R = R();
            v0 v0Var = v0.f12324a;
            y8.k.d(v0Var, "NO_SOURCE");
            return new b(aVar, null, i10, u10, eVar, b10, k02, E, G0, R, v0Var, new a());
        }

        public final List<e1> Y0() {
            return (List) this.f13226r.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n9.a aVar, d1 d1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, boolean z10, boolean z11, boolean z12, bb.b0 b0Var2, v0 v0Var) {
        super(aVar, gVar, eVar, b0Var, v0Var);
        y8.k.e(aVar, "containingDeclaration");
        y8.k.e(gVar, "annotations");
        y8.k.e(eVar, "name");
        y8.k.e(b0Var, "outType");
        y8.k.e(v0Var, "source");
        this.f13220k = i10;
        this.f13221l = z10;
        this.f13222m = z11;
        this.f13223n = z12;
        this.f13224o = b0Var2;
        this.f13225p = d1Var == null ? this : d1Var;
    }

    public static final k0 V0(n9.a aVar, d1 d1Var, int i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, bb.b0 b0Var, boolean z10, boolean z11, boolean z12, bb.b0 b0Var2, v0 v0Var, x8.a<? extends List<? extends e1>> aVar2) {
        return f13219q.a(aVar, d1Var, i10, gVar, eVar, b0Var, z10, z11, z12, b0Var2, v0Var, aVar2);
    }

    @Override // n9.d1
    public boolean E() {
        return this.f13222m;
    }

    @Override // n9.e1
    public /* bridge */ /* synthetic */ pa.g F0() {
        return (pa.g) W0();
    }

    @Override // n9.d1
    public boolean G0() {
        return this.f13223n;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        y8.k.e(oVar, "visitor");
        return oVar.l(this, d10);
    }

    @Override // n9.e1
    public boolean P() {
        return false;
    }

    @Override // n9.d1
    public d1 Q(n9.a aVar, la.e eVar, int i10) {
        y8.k.e(aVar, "newOwner");
        y8.k.e(eVar, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = u();
        y8.k.d(u10, "annotations");
        bb.b0 b10 = b();
        y8.k.d(b10, "type");
        boolean k02 = k0();
        boolean E = E();
        boolean G0 = G0();
        bb.b0 R = R();
        v0 v0Var = v0.f12324a;
        y8.k.d(v0Var, "NO_SOURCE");
        return new k0(aVar, null, i10, u10, eVar, b10, k02, E, G0, R, v0Var);
    }

    @Override // n9.d1
    public bb.b0 R() {
        return this.f13224o;
    }

    public Void W0() {
        return null;
    }

    @Override // n9.x0
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public d1 e(a1 a1Var) {
        y8.k.e(a1Var, "substitutor");
        if (a1Var.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // p9.k, p9.j, n9.m
    public d1 a() {
        d1 d1Var = this.f13225p;
        return d1Var == this ? this : d1Var.a();
    }

    @Override // p9.k, n9.m
    public n9.a d() {
        return (n9.a) super.d();
    }

    @Override // n9.a
    public Collection<d1> g() {
        int n10;
        Collection<? extends n9.a> g10 = d().g();
        y8.k.d(g10, "containingDeclaration.overriddenDescriptors");
        n10 = m8.r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = g10.iterator();
        while (it.hasNext()) {
            arrayList.add(((n9.a) it.next()).l().get(j()));
        }
        return arrayList;
    }

    @Override // n9.q, n9.z
    public n9.u h() {
        n9.u uVar = n9.t.f12304f;
        y8.k.d(uVar, "LOCAL");
        return uVar;
    }

    @Override // n9.d1
    public int j() {
        return this.f13220k;
    }

    @Override // n9.d1
    public boolean k0() {
        return this.f13221l && ((n9.b) d()).r().isReal();
    }
}
