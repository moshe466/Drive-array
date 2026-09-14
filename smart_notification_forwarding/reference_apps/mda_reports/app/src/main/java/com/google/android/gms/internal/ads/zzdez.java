package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
public final class zzdez<E> extends zzdeu<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdeu zzguo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdez(zzdeu zzdeuVar, int i, int i2) {
        this.zzguo = zzdeuVar;
        this.offset = i;
        this.length = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final Object[] a() {
        return this.zzguo.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int b() {
        return this.zzguo.b() + this.offset;
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    final int c() {
        return this.zzguo.b() + this.offset + this.length;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdei.zzs(i, this.length);
        return this.zzguo.get(i + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdeu, java.util.List
    /* renamed from: zzu */
    public final zzdeu<E> subList(int i, int i2) {
        zzdei.zzf(i, i2, this.length);
        zzdeu zzdeuVar = this.zzguo;
        int i3 = this.offset;
        return (zzdeu) zzdeuVar.subList(i + i3, i2 + i3);
    }
}
