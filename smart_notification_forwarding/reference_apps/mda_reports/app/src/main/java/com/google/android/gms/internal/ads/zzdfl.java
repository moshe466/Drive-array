package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdfl extends zzdeu<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzguw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfl(Object[] objArr, int i, int i2) {
        this.zzguw = objArr;
        this.offset = i;
        this.size = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdei.zzs(i, this.size);
        return this.zzguw[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return true;
    }
}
