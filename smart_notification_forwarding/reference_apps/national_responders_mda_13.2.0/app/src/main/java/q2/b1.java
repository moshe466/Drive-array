package q2;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class b1 extends i1 {

    /* renamed from: f, reason: collision with root package name */
    private final int f13473f;

    /* renamed from: g, reason: collision with root package name */
    private int f13474g;

    /* JADX INFO: Access modifiers changed from: protected */
    public b1(int i10, int i11) {
        z0.b(i11, i10, "index");
        this.f13473f = i10;
        this.f13474g = i11;
    }

    protected abstract Object b(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f13474g < this.f13473f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13474g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f13474g;
        this.f13474g = i10 + 1;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13474g;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f13474g - 1;
        this.f13474g = i10;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13474g - 1;
    }
}
