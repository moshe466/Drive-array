package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* loaded from: classes.dex */
final class zzduw implements ListIterator<String> {
    private final /* synthetic */ int zzgvz;
    private final /* synthetic */ zzdut zzhrh;
    private ListIterator<String> zzhri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduw(zzdut zzdutVar, int i) {
        zzdsl zzdslVar;
        this.zzhrh = zzdutVar;
        this.zzgvz = i;
        zzdslVar = this.zzhrh.zzhrf;
        this.zzhri = zzdslVar.listIterator(this.zzgvz);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzhri.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzhri.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzhri.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzhri.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzhri.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzhri.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
