package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class zzaz extends zzav implements List, RandomAccess {
    private static final zzcc zza = new zzaw(zzbs.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzaz zzh(Object[] objArr, int i) {
        if (i == 0) {
            return zzbs.zza;
        }
        return new zzbs(objArr, i);
    }

    public static zzaz zzi(Object[] objArr) {
        if (objArr.length == 0) {
            return zzbs.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzbq.zzb(objArr2, length);
        return zzh(objArr2, length);
    }

    public static zzaz zzj(Object obj) {
        Object[] objArr = {obj};
        zzbq.zzb(objArr, 1);
        return zzh(objArr, 1);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                if (!zzao.zza(get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzao.zza(it.next(), it2.next())) {
                return false;
            }
        }
        if (!it2.hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i = (i * 31) + get(i3).hashCode();
        }
        return i;
    }

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

    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

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
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    /* renamed from: zzd */
    public final zzcb iterator() {
        return listIterator(0);
    }

    public zzaz zzf() {
        if (size() <= 1) {
            return this;
        }
        return new zzax(this);
    }

    @Override // java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public zzaz subList(int i, int i3) {
        zzap.zze(i, i3, size());
        int i4 = i3 - i;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return zzbs.zza;
        }
        return new zzay(this, i, i4);
    }

    @Override // java.util.List
    /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzcc listIterator(int i) {
        zzap.zzb(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzaw(this, i);
    }
}
