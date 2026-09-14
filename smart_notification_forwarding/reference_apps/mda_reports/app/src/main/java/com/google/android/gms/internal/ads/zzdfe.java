package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfe<E> extends zzdeu<E> {
    static final zzdeu<Object> a = new zzdfe(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzguu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfe(Object[] objArr, int i) {
        this.zzguu = objArr;
        this.size = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdeu, com.google.android.gms.internal.ads.zzdet
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.zzguu, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final Object[] a() {
        return this.zzguu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    final int c() {
        return this.size;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdei.zzs(i, this.size);
        return (E) this.zzguu[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return false;
    }
}
