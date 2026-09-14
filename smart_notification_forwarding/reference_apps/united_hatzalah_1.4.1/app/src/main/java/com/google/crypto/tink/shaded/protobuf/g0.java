package com.google.crypto.tink.shaded.protobuf;

import java.util.ListIterator;

/* loaded from: classes.dex */
public final class g0 implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public ListIterator f4104a;

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4104a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4104a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f4104a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4104a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f4104a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4104a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
