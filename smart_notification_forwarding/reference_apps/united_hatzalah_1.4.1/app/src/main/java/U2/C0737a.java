package u2;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import t2.AbstractC0702d;

/* renamed from: u2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0737a implements ListIterator, G2.a {

    /* renamed from: b, reason: collision with root package name */
    public int f6600b;

    /* renamed from: d, reason: collision with root package name */
    public int f6602d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0702d f6603e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6599a = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f6601c = -1;

    public C0737a(C0739c c0739c, int i) {
        int i3;
        this.f6603e = c0739c;
        this.f6600b = i;
        i3 = ((AbstractList) c0739c).modCount;
        this.f6602d = i3;
    }

    public void a() {
        int i;
        i = ((AbstractList) ((C0738b) this.f6603e).f6608e).modCount;
        if (i == this.f6602d) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i;
        int i3;
        switch (this.f6599a) {
            case 0:
                a();
                C0738b c0738b = (C0738b) this.f6603e;
                int i4 = this.f6600b;
                this.f6600b = i4 + 1;
                c0738b.add(i4, obj);
                this.f6601c = -1;
                i = ((AbstractList) c0738b).modCount;
                this.f6602d = i;
                return;
            default:
                b();
                C0739c c0739c = (C0739c) this.f6603e;
                int i5 = this.f6600b;
                this.f6600b = i5 + 1;
                c0739c.add(i5, obj);
                this.f6601c = -1;
                i3 = ((AbstractList) c0739c).modCount;
                this.f6602d = i3;
                return;
        }
    }

    public void b() {
        int i;
        i = ((AbstractList) ((C0739c) this.f6603e)).modCount;
        if (i == this.f6602d) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6599a) {
            case 0:
                if (this.f6600b < ((C0738b) this.f6603e).f6606c) {
                    return true;
                }
                return false;
            default:
                if (this.f6600b < ((C0739c) this.f6603e).f6611b) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f6599a) {
            case 0:
                if (this.f6600b > 0) {
                    return true;
                }
                return false;
            default:
                if (this.f6600b > 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f6599a) {
            case 0:
                a();
                int i = this.f6600b;
                C0738b c0738b = (C0738b) this.f6603e;
                if (i < c0738b.f6606c) {
                    this.f6600b = i + 1;
                    this.f6601c = i;
                    return c0738b.f6604a[c0738b.f6605b + i];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i3 = this.f6600b;
                C0739c c0739c = (C0739c) this.f6603e;
                if (i3 < c0739c.f6611b) {
                    this.f6600b = i3 + 1;
                    this.f6601c = i3;
                    return c0739c.f6610a[i3];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f6599a) {
            case 0:
                return this.f6600b;
            default:
                return this.f6600b;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f6599a) {
            case 0:
                a();
                int i = this.f6600b;
                if (i > 0) {
                    int i3 = i - 1;
                    this.f6600b = i3;
                    this.f6601c = i3;
                    C0738b c0738b = (C0738b) this.f6603e;
                    return c0738b.f6604a[c0738b.f6605b + i3];
                }
                throw new NoSuchElementException();
            default:
                b();
                int i4 = this.f6600b;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f6600b = i5;
                    this.f6601c = i5;
                    return ((C0739c) this.f6603e).f6610a[i5];
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.f6599a) {
            case 0:
                i = this.f6600b;
                break;
            default:
                i = this.f6600b;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i;
        int i3;
        switch (this.f6599a) {
            case 0:
                C0738b c0738b = (C0738b) this.f6603e;
                a();
                int i4 = this.f6601c;
                if (i4 != -1) {
                    c0738b.h(i4);
                    this.f6600b = this.f6601c;
                    this.f6601c = -1;
                    i = ((AbstractList) c0738b).modCount;
                    this.f6602d = i;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            default:
                C0739c c0739c = (C0739c) this.f6603e;
                b();
                int i5 = this.f6601c;
                if (i5 != -1) {
                    c0739c.h(i5);
                    this.f6600b = this.f6601c;
                    this.f6601c = -1;
                    i3 = ((AbstractList) c0739c).modCount;
                    this.f6602d = i3;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f6599a) {
            case 0:
                a();
                int i = this.f6601c;
                if (i != -1) {
                    ((C0738b) this.f6603e).set(i, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            default:
                b();
                int i3 = this.f6601c;
                if (i3 != -1) {
                    ((C0739c) this.f6603e).set(i3, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    public C0737a(C0738b c0738b, int i) {
        int i3;
        this.f6603e = c0738b;
        this.f6600b = i;
        i3 = ((AbstractList) c0738b).modCount;
        this.f6602d = i3;
    }
}
