package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzdww<E> extends AbstractList<E> {
    private static final zzdwy zzcr = zzdwy.zzn(zzdww.class);
    List<E> a;
    Iterator<E> b;

    public zzdww(List<E> list, Iterator<E> it) {
        this.a = list;
        this.b = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        if (!this.b.hasNext()) {
            throw new NoSuchElementException();
        }
        this.a.add(this.b.next());
        return get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new zzdwv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        zzcr.zzhp("potentially expensive size() call");
        zzcr.zzhp("blowup running");
        while (this.b.hasNext()) {
            this.a.add(this.b.next());
        }
        return this.a.size();
    }
}
