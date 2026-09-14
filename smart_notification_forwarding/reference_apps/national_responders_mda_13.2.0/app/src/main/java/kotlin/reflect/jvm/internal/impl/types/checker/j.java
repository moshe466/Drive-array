package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.b0;
import bb.g1;
import bb.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import n9.a1;

/* loaded from: classes.dex */
public final class j implements oa.b {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f11574a;

    /* renamed from: b, reason: collision with root package name */
    private x8.a<? extends List<? extends g1>> f11575b;

    /* renamed from: c, reason: collision with root package name */
    private final j f11576c;

    /* renamed from: d, reason: collision with root package name */
    private final a1 f11577d;

    /* renamed from: e, reason: collision with root package name */
    private final l8.h f11578e;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends g1>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<g1> f11579f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends g1> list) {
            super(0);
            this.f11579f = list;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<g1> b() {
            return this.f11579f;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<List<? extends g1>> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<g1> b() {
            x8.a aVar = j.this.f11575b;
            if (aVar == null) {
                return null;
            }
            return (List) aVar.b();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<List<? extends g1>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<g1> f11581f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends g1> list) {
            super(0);
            this.f11581f = list;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<g1> b() {
            return this.f11581f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends y8.l implements x8.a<List<? extends g1>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f11583g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.f11583g = gVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<g1> b() {
            int n10;
            List<g1> x10 = j.this.x();
            g gVar = this.f11583g;
            n10 = m8.r.n(x10, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = x10.iterator();
            while (it.hasNext()) {
                arrayList.add(((g1) it.next()).g1(gVar));
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(v0 v0Var, List<? extends g1> list, j jVar) {
        this(v0Var, new a(list), jVar, null, 8, null);
        y8.k.e(v0Var, "projection");
        y8.k.e(list, "supertypes");
    }

    public /* synthetic */ j(v0 v0Var, List list, j jVar, int i10, y8.g gVar) {
        this(v0Var, list, (i10 & 4) != 0 ? null : jVar);
    }

    public j(v0 v0Var, x8.a<? extends List<? extends g1>> aVar, j jVar, a1 a1Var) {
        l8.h a10;
        y8.k.e(v0Var, "projection");
        this.f11574a = v0Var;
        this.f11575b = aVar;
        this.f11576c = jVar;
        this.f11577d = a1Var;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new b());
        this.f11578e = a10;
    }

    public /* synthetic */ j(v0 v0Var, x8.a aVar, j jVar, a1 a1Var, int i10, y8.g gVar) {
        this(v0Var, (i10 & 2) != 0 ? null : aVar, (i10 & 4) != 0 ? null : jVar, (i10 & 8) != 0 ? null : a1Var);
    }

    private final List<g1> d() {
        return (List) this.f11578e.getValue();
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

    @Override // oa.b
    public v0 a() {
        return this.f11574a;
    }

    @Override // bb.t0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<g1> x() {
        List<g1> d10;
        List<g1> d11 = d();
        if (d11 != null) {
            return d11;
        }
        d10 = m8.q.d();
        return d10;
    }

    public final void e(List<? extends g1> list) {
        y8.k.e(list, "supertypes");
        this.f11575b = new c(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!y8.k.a(j.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j jVar = (j) obj;
        j jVar2 = this.f11576c;
        if (jVar2 == null) {
            jVar2 = this;
        }
        j jVar3 = jVar.f11576c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return jVar2 == jVar;
    }

    @Override // bb.t0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public j y(g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        v0 y10 = a().y(gVar);
        y8.k.d(y10, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f11575b == null ? null : new d(gVar);
        j jVar = this.f11576c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(y10, dVar, jVar, this.f11577d);
    }

    public int hashCode() {
        j jVar = this.f11576c;
        return jVar == null ? super.hashCode() : jVar.hashCode();
    }

    public String toString() {
        return "CapturedType(" + a() + ')';
    }

    @Override // bb.t0
    public k9.h w() {
        b0 b10 = a().b();
        y8.k.d(b10, "projection.type");
        return eb.a.e(b10);
    }

    @Override // bb.t0
    public boolean z() {
        return false;
    }
}
