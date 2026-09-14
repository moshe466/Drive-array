package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class zzdsm extends zzdqe<String> implements zzdsl, RandomAccess {
    private static final zzdsm zzhof;
    private static final zzdsl zzhog;
    private final List<Object> zzhoh;

    static {
        zzdsm zzdsmVar = new zzdsm();
        zzhof = zzdsmVar;
        zzdsmVar.zzaxq();
        zzhog = zzhof;
    }

    public zzdsm() {
        this(10);
    }

    public zzdsm(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzdsm(ArrayList<Object> arrayList) {
        this.zzhoh = arrayList;
    }

    private static String zzap(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzdqk ? ((zzdqk) obj).zzaxt() : zzdrv.zzz((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.zzhoh.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof zzdsl) {
            collection = ((zzdsl) collection).zzbav();
        }
        boolean addAll = this.zzhoh.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.zzhoh.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzhoh.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdqk) {
            zzdqk zzdqkVar = (zzdqk) obj;
            String zzaxt = zzdqkVar.zzaxt();
            if (zzdqkVar.zzaxu()) {
                this.zzhoh.set(i, zzaxt);
            }
            return zzaxt;
        }
        byte[] bArr = (byte[]) obj;
        String zzz = zzdrv.zzz(bArr);
        if (zzdrv.zzy(bArr)) {
            this.zzhoh.set(i, zzz);
        }
        return zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.zzhoh.remove(i);
        ((AbstractList) this).modCount++;
        return zzap(remove);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return zzap(this.zzhoh.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhoh.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdqe, com.google.android.gms.internal.ads.zzdsb
    public final /* bridge */ /* synthetic */ boolean zzaxp() {
        return super.zzaxp();
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final List<?> zzbav() {
        return Collections.unmodifiableList(this.zzhoh);
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final zzdsl zzbaw() {
        return zzaxp() ? new zzdut(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final void zzbg(zzdqk zzdqkVar) {
        a();
        this.zzhoh.add(zzdqkVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdsb
    public final /* synthetic */ zzdsb zzfd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzhoh);
        return new zzdsm((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final Object zzgm(int i) {
        return this.zzhoh.get(i);
    }
}
