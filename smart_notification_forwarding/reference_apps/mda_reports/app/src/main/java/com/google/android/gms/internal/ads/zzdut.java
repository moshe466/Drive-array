package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class zzdut extends AbstractList<String> implements zzdsl, RandomAccess {
    private final zzdsl zzhrf;

    public zzdut(zzdsl zzdslVar) {
        this.zzhrf = zzdslVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzhrf.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzduv(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzduw(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhrf.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final List<?> zzbav() {
        return this.zzhrf.zzbav();
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final zzdsl zzbaw() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final void zzbg(zzdqk zzdqkVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final Object zzgm(int i) {
        return this.zzhrf.zzgm(i);
    }
}
