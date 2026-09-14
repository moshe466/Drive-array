package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes2.dex */
abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedIterator(Iterator<? extends F> it) {
        this.a = (Iterator) Preconditions.checkNotNull(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
