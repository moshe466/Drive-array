package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class v3<E> extends j5<E> {

    /* renamed from: f, reason: collision with root package name */
    private final int f5634f;

    /* renamed from: g, reason: collision with root package name */
    private int f5635g;

    /* JADX INFO: Access modifiers changed from: protected */
    public v3(int i10, int i11) {
        n3.g(i11, i10);
        this.f5634f = i10;
        this.f5635g = i11;
    }

    protected abstract E b(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f5635g < this.f5634f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5635g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5635g;
        this.f5635g = i10 + 1;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5635g;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5635g - 1;
        this.f5635g = i10;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5635g - 1;
    }
}
