package za;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public class a implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16381g = {w.g(new t(w.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: f, reason: collision with root package name */
    private final ab.i f16382f;

    public a(ab.n nVar, x8.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> aVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(aVar, "compute");
        this.f16382f = nVar.a(aVar);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> c() {
        return (List) ab.m.a(this.f16382f, this, f16381g[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(la.b bVar) {
        return g.b.a(this, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return c().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return c().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        return g.b.b(this, bVar);
    }
}
