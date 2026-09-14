package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class x extends AbstractList<String> implements RandomAccess, o {

    /* renamed from: f, reason: collision with root package name */
    private final o f11489f;

    /* loaded from: classes.dex */
    class a implements ListIterator<String> {

        /* renamed from: f, reason: collision with root package name */
        ListIterator<String> f11490f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f11491g;

        a(int i10) {
            this.f11491g = i10;
            this.f11490f = x.this.f11489f.listIterator(i10);
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f11490f.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f11490f.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f11490f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11490f.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f11490f.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f11490f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    class b implements Iterator<String> {

        /* renamed from: f, reason: collision with root package name */
        Iterator<String> f11493f;

        b() {
            this.f11493f = x.this.f11489f.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f11493f.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11493f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public x(o oVar) {
        this.f11489f = oVar;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        return this.f11489f.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public d k(int i10) {
        return this.f11489f.k(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public o m() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public List<?> p() {
        return this.f11489f.p();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void q(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11489f.size();
    }
}
