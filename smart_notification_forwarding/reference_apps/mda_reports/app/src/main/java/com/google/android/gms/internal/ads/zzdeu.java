package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class zzdeu<E> extends zzdet<E> implements List<E>, RandomAccess {
    private static final zzdfo<Object> zzgui = new zzdew(zzdfe.a, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdeu<E> a(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdeu<E> b(Object[] objArr, int i) {
        return i == 0 ? (zzdeu<E>) zzdfe.a : new zzdfe(objArr, i);
    }

    public static <E> zzdeu<E> zzaf(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdff.a(objArr[0], 0);
        }
        return b(objArr, 1);
    }

    public static <E> zzdeu<E> zzard() {
        return (zzdeu<E>) zzdfe.a;
    }

    public static <E> zzdeu<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdeu<E>) zzdfe.a;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdff.a(objArr[i], i);
        }
        return b(objArr, objArr.length);
    }

    public static <E> zzdeu<E> zzf(Iterable<? extends E> iterable) {
        zzdei.checkNotNull(iterable);
        if (!(iterable instanceof Collection)) {
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                return (zzdeu<E>) zzdfe.a;
            }
            E next = it.next();
            if (!it.hasNext()) {
                return zzaf(next);
            }
            zzdex zzdexVar = (zzdex) ((zzdex) new zzdex().zzae(next)).zza(it);
            zzdexVar.c = true;
            return b(zzdexVar.a, zzdexVar.b);
        }
        Collection collection = (Collection) iterable;
        if (collection instanceof zzdet) {
            zzdeu<E> zzarb = ((zzdet) collection).zzarb();
            if (!zzarb.zzarc()) {
                return zzarb;
            }
            Object[] array = zzarb.toArray();
            return b(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            zzdff.a(array2[i], i);
        }
        return b(array2, array2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdei.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzdeg.equal(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e = get(i2);
                        i2++;
                        if (!zzdeg.equal(e, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ (-1)) ^ (-1);
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdfo) listIterator(0);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdei.zzt(i, size());
        return isEmpty() ? zzgui : new zzdew(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx */
    public final zzdfp<E> iterator() {
        return (zzdfo) listIterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    public final zzdeu<E> zzarb() {
        return this;
    }

    @Override // java.util.List
    /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public zzdeu<E> subList(int i, int i2) {
        zzdei.zzf(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (zzdeu<E>) zzdfe.a : new zzdez(this, i, i3);
    }
}
