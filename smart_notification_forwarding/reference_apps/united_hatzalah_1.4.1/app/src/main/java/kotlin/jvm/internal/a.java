package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import t2.AbstractC0701c;

/* loaded from: classes.dex */
public class a implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5302a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f5303b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5304c;

    public a(Object[] array) {
        j.e(array, "array");
        this.f5304c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5302a) {
            case 0:
                if (this.f5303b < ((Object[]) this.f5304c).length) {
                    return true;
                }
                return false;
            default:
                if (this.f5303b < ((AbstractC0701c) this.f5304c).g()) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5302a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f5304c;
                    int i = this.f5303b;
                    this.f5303b = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e4) {
                    this.f5303b--;
                    throw new NoSuchElementException(e4.getMessage());
                }
            default:
                if (hasNext()) {
                    AbstractC0701c abstractC0701c = (AbstractC0701c) this.f5304c;
                    int i3 = this.f5303b;
                    this.f5303b = i3 + 1;
                    return abstractC0701c.get(i3);
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5302a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(AbstractC0701c abstractC0701c) {
        this.f5304c = abstractC0701c;
    }
}
