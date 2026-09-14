package m8;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class e0<T> implements Iterable<d0<? extends T>>, z8.a {

    /* renamed from: f, reason: collision with root package name */
    private final x8.a<Iterator<T>> f12037f;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(x8.a<? extends Iterator<? extends T>> aVar) {
        y8.k.e(aVar, "iteratorFactory");
        this.f12037f = aVar;
    }

    @Override // java.lang.Iterable
    public Iterator<d0<T>> iterator() {
        return new f0(this.f12037f.b());
    }
}
