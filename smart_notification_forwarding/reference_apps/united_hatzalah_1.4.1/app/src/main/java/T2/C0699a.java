package t2;

import F0.AbstractC0008a;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0699a extends kotlin.jvm.internal.a implements ListIterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0701c f6462d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0699a(AbstractC0701c abstractC0701c, int i) {
        super(abstractC0701c);
        this.f6462d = abstractC0701c;
        int g3 = abstractC0701c.g();
        if (i >= 0 && i <= g3) {
            this.f5303b = i;
            return;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, g3, ", size: "));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f5303b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5303b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.f5303b - 1;
            this.f5303b = i;
            return this.f6462d.get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5303b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
