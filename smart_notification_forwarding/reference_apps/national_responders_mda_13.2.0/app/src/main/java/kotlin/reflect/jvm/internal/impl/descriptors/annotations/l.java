package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l implements g {

    /* renamed from: f, reason: collision with root package name */
    private final g f11374f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11375g;

    /* renamed from: h, reason: collision with root package name */
    private final x8.l<la.b, Boolean> f11376h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(g gVar, x8.l<? super la.b, Boolean> lVar) {
        this(gVar, false, lVar);
        y8.k.e(gVar, "delegate");
        y8.k.e(lVar, "fqNameFilter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(g gVar, boolean z10, x8.l<? super la.b, Boolean> lVar) {
        y8.k.e(gVar, "delegate");
        y8.k.e(lVar, "fqNameFilter");
        this.f11374f = gVar;
        this.f11375g = z10;
        this.f11376h = lVar;
    }

    private final boolean c(c cVar) {
        la.b f10 = cVar.f();
        return f10 != null && this.f11376h.h(f10).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public c e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        if (this.f11376h.h(bVar).booleanValue()) {
            return this.f11374f.e(bVar);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        boolean z10;
        g gVar = this.f11374f;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                if (c(it.next())) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        return this.f11375g ? !z10 : z10;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.f11374f;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (c(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        y8.k.e(bVar, "fqName");
        if (this.f11376h.h(bVar).booleanValue()) {
            return this.f11374f.r(bVar);
        }
        return false;
    }
}
