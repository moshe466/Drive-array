package n3;

import java.util.Collections;
import java.util.Spliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m<E> extends g<E> {

    /* renamed from: g, reason: collision with root package name */
    final transient E f12204g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(E e10) {
        this.f12204g = (E) m3.d.h(e10);
    }

    @Override // java.util.List
    public E get(int i10) {
        m3.d.f(i10, 1);
        return this.f12204g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // n3.g, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.f12204g).spliterator();
    }

    @Override // n3.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: t */
    public n<E> iterator() {
        return h.d(this.f12204g);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f12204g.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // n3.g, java.util.List
    /* renamed from: y */
    public g<E> subList(int i10, int i11) {
        m3.d.k(i10, i11, 1);
        return i10 == i11 ? g.w() : this;
    }
}
