package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: f, reason: collision with root package name */
    private final List<c> f11365f;

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> list) {
        y8.k.e(list, "annotations");
        this.f11365f = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public c e(la.b bVar) {
        return g.b.a(this, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return this.f11365f.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return this.f11365f.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean r(la.b bVar) {
        return g.b.b(this, bVar);
    }

    public String toString() {
        return this.f11365f.toString();
    }
}
