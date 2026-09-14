package y8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a<T> implements Iterator<T>, z8.a {

    /* renamed from: f, reason: collision with root package name */
    private final T[] f15928f;

    /* renamed from: g, reason: collision with root package name */
    private int f15929g;

    public a(T[] tArr) {
        k.e(tArr, "array");
        this.f15928f = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15929g < this.f15928f.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f15928f;
            int i10 = this.f15929g;
            this.f15929g = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f15929g--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
