package com.google.android.gms.internal.location;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzew extends zzex {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzex zzc;

    public zzew(zzex zzexVar, int i, int i3) {
        this.zzc = zzexVar;
        this.zza = i;
        this.zzb = i3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzer.zzc(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzex, java.util.List
    /* renamed from: zzh */
    public final zzex subList(int i, int i3) {
        zzer.zze(i, i3, this.zzb);
        int i4 = this.zza;
        return this.zzc.subList(i + i4, i3 + i4);
    }
}
