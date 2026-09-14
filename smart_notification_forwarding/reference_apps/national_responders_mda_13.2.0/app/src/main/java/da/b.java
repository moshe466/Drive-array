package da;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* loaded from: classes.dex */
final class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: f, reason: collision with root package name */
    private final la.b f8756f;

    public b(la.b bVar) {
        y8.k.e(bVar, "fqNameToMatch");
        this.f8756f = bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        if (y8.k.a(bVar, this.f8756f)) {
            return a.f8755a;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        List d10;
        d10 = m8.q.d();
        return d10.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        return g.b.b(this, bVar);
    }
}
