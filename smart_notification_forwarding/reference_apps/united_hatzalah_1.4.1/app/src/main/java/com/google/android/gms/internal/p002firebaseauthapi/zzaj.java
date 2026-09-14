package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class zzaj<E> extends zzai<E> implements List<E>, RandomAccess {
    private static final zzaz<Object> zza = new zzal(zzar.zza, 0);

    public static <E> zzaj<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return (zzaj<E>) zzar.zza;
        }
        return new zzar(objArr, i);
    }

    public static <E> zzam<E> zzg() {
        return new zzam<>();
    }

    public static <E> zzaj<E> zzh() {
        return (zzaj<E>) zzar.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == zzw.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzp.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e4 = get(i3);
                        i3++;
                        if (!zzp.zza(e4, it.next())) {
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
        for (int i3 = 0; i3 < size; i3++) {
            i = ~(~(get(i3).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzaz) listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i + i3] = get(i3);
        }
        return i + size;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    @Deprecated
    public final zzaj<E> zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzba<E> iterator() {
        return (zzaz) listIterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzw.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzal(this, i);
    }

    public static <E> zzaj<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    private static <E> zzaj<E> zzb(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(a.c(i, "at index "));
            }
        }
        return zzb(objArr, objArr.length);
    }

    public static <E> zzaj<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzai) {
            zzaj<E> zzc = ((zzai) collection).zzc();
            if (!zzc.zze()) {
                return zzc;
            }
            Object[] array = zzc.toArray();
            return zzb(array, array.length);
        }
        return zzb(collection.toArray());
    }

    public static <E> zzaj<E> zza(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return zzb(e4, e5, e6, e7, e8, e9, e10, e11);
    }

    @Override // java.util.List
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzaj<E> subList(int i, int i3) {
        zzw.zza(i, i3, size());
        int i4 = i3 - i;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return (zzaj<E>) zzar.zza;
        }
        return new zzao(this, i, i4);
    }
}
