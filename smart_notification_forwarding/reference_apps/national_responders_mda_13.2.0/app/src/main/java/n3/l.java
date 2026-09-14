package n3;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l<E> extends g<E> {

    /* renamed from: h, reason: collision with root package name */
    static final g<Object> f12202h = new l(new Object[0]);

    /* renamed from: g, reason: collision with root package name */
    final transient Object[] f12203g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Object[] objArr) {
        this.f12203g = objArr;
    }

    @Override // n3.g, n3.e
    int c(Object[] objArr, int i10) {
        Object[] objArr2 = this.f12203g;
        System.arraycopy(objArr2, 0, objArr, i10, objArr2.length);
        return i10 + this.f12203g.length;
    }

    @Override // n3.e
    Object[] f() {
        return this.f12203g;
    }

    @Override // n3.e
    int g() {
        return this.f12203g.length;
    }

    @Override // java.util.List
    public E get(int i10) {
        return (E) this.f12203g[i10];
    }

    @Override // n3.e
    int j() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12203g.length;
    }

    @Override // n3.g, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f12203g, 1296);
    }

    @Override // n3.g, java.util.List
    /* renamed from: v */
    public o<E> listIterator(int i10) {
        Object[] objArr = this.f12203g;
        return h.c(objArr, 0, objArr.length, i10);
    }
}
