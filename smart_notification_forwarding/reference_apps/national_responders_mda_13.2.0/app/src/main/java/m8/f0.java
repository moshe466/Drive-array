package m8;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class f0<T> implements Iterator<d0<? extends T>>, z8.a {

    /* renamed from: f, reason: collision with root package name */
    private final Iterator<T> f12040f;

    /* renamed from: g, reason: collision with root package name */
    private int f12041g;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(Iterator<? extends T> it) {
        y8.k.e(it, "iterator");
        this.f12040f = it;
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final d0<T> next() {
        int i10 = this.f12041g;
        this.f12041g = i10 + 1;
        if (i10 < 0) {
            q.m();
        }
        return new d0<>(i10, this.f12040f.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12040f.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
