package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzao extends zzaj {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaj zzc;

    public zzao(zzaj zzajVar, int i, int i3) {
        this.zzc = zzajVar;
        this.zza = i;
        this.zzb = i3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzw.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final Object[] zzf() {
        return this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj, java.util.List
    /* renamed from: zza */
    public final zzaj subList(int i, int i3) {
        zzw.zza(i, i3, this.zzb);
        zzaj zzajVar = this.zzc;
        int i4 = this.zza;
        return (zzaj) zzajVar.subList(i + i4, i3 + i4);
    }
}
