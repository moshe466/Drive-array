package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class zzdet<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzguh = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        zzdfp zzdfpVar = (zzdfp) iterator();
        while (zzdfpVar.hasNext()) {
            objArr[i] = zzdfpVar.next();
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] a() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        throw new UnsupportedOperationException();
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(@NullableDecl Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(zzguh);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdei.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] a = a();
            if (a != null) {
                return (T[]) Arrays.copyOfRange(a, b(), c(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx, reason: merged with bridge method [inline-methods] */
    public abstract zzdfp<E> iterator();

    public zzdeu<E> zzarb() {
        return isEmpty() ? zzdeu.zzard() : zzdeu.a(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzarc();
}
