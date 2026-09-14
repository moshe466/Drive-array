package m8;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class g0 implements Iterator<Integer>, z8.a {
    public abstract int b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
