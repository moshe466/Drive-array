package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.y;

/* loaded from: classes.dex */
public final class k implements g {

    /* renamed from: f, reason: collision with root package name */
    private final List<g> f11371f;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<g, c> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ la.b f11372f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(la.b bVar) {
            super(1);
            this.f11372f = bVar;
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c h(g gVar) {
            y8.k.e(gVar, "it");
            return gVar.e(this.f11372f);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<g, lb.h<? extends c>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11373f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lb.h<c> h(g gVar) {
            lb.h<c> A;
            y8.k.e(gVar, "it");
            A = y.A(gVar);
            return A;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        y8.k.e(list, "delegates");
        this.f11371f = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g... r2) {
        /*
            r1 = this;
            java.lang.String r0 = "delegates"
            y8.k.e(r2, r0)
            java.util.List r2 = m8.g.O(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.k.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g[]):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public c e(la.b bVar) {
        lb.h A;
        lb.h r10;
        y8.k.e(bVar, "fqName");
        A = y.A(this.f11371f);
        r10 = lb.n.r(A, new a(bVar));
        return (c) lb.i.o(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        List<g> list = this.f11371f;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        lb.h A;
        lb.h p10;
        A = y.A(this.f11371f);
        p10 = lb.n.p(A, b.f11373f);
        return p10.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        lb.h A;
        y8.k.e(bVar, "fqName");
        A = y.A(this.f11371f);
        Iterator it = A.iterator();
        while (it.hasNext()) {
            if (((g) it.next()).r(bVar)) {
                return true;
            }
        }
        return false;
    }
}
