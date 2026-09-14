package n3;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class a<E> extends o<E> {

    /* renamed from: f, reason: collision with root package name */
    private final int f12178f;

    /* renamed from: g, reason: collision with root package name */
    private int f12179g;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i10, int i11) {
        m3.d.i(i11, i10);
        this.f12178f = i10;
        this.f12179g = i11;
    }

    protected abstract E b(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f12179g < this.f12178f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12179g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12179g;
        this.f12179g = i10 + 1;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12179g;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12179g - 1;
        this.f12179g = i10;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12179g - 1;
    }
}
