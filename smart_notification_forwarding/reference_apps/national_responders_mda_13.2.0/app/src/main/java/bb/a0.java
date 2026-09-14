package bb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a0 implements t0, db.g {

    /* renamed from: a, reason: collision with root package name */
    private b0 f4155a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<b0> f4156b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4157c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> {
        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 h(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            y8.k.e(gVar, "kotlinTypeRefiner");
            return a0.this.y(gVar).c();
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int a10;
            a10 = o8.b.a(((b0) t10).toString(), ((b0) t11).toString());
            return a10;
        }
    }

    public a0(Collection<? extends b0> collection) {
        y8.k.e(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<b0> linkedHashSet = new LinkedHashSet<>(collection);
        this.f4156b = linkedHashSet;
        this.f4157c = linkedHashSet.hashCode();
    }

    private a0(Collection<? extends b0> collection, b0 b0Var) {
        this(collection);
        this.f4155a = b0Var;
    }

    private final String e(Iterable<? extends b0> iterable) {
        List h02;
        String Q;
        h02 = m8.y.h0(iterable, new b());
        Q = m8.y.Q(h02, " & ", "{", "}", 0, null, null, 56, null);
        return Q;
    }

    @Override // bb.t0
    /* renamed from: A */
    public n9.h o() {
        return null;
    }

    @Override // bb.t0
    public List<n9.a1> B() {
        List<n9.a1> d10;
        d10 = m8.q.d();
        return d10;
    }

    public final ua.h b() {
        return ua.n.f14551c.a("member scope for intersection type", this.f4156b);
    }

    public final i0 c() {
        List d10;
        c0 c0Var = c0.f4165a;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
        d10 = m8.q.d();
        return c0.k(b10, this, d10, false, b(), new a());
    }

    public final b0 d() {
        return this.f4155a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return y8.k.a(this.f4156b, ((a0) obj).f4156b);
        }
        return false;
    }

    @Override // bb.t0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        int n10;
        y8.k.e(gVar, "kotlinTypeRefiner");
        Collection<b0> x10 = x();
        n10 = m8.r.n(x10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = x10.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            arrayList.add(((b0) it.next()).g1(gVar));
            z10 = true;
        }
        a0 a0Var = null;
        if (z10) {
            b0 d10 = d();
            a0Var = new a0(arrayList).g(d10 != null ? d10.g1(gVar) : null);
        }
        return a0Var == null ? this : a0Var;
    }

    public final a0 g(b0 b0Var) {
        return new a0(this.f4156b, b0Var);
    }

    public int hashCode() {
        return this.f4157c;
    }

    public String toString() {
        return e(this.f4156b);
    }

    @Override // bb.t0
    public k9.h w() {
        k9.h w10 = this.f4156b.iterator().next().W0().w();
        y8.k.d(w10, "intersectedTypes.iterator().next().constructor.builtIns");
        return w10;
    }

    @Override // bb.t0
    public Collection<b0> x() {
        return this.f4156b;
    }

    @Override // bb.t0
    public boolean z() {
        return false;
    }
}
