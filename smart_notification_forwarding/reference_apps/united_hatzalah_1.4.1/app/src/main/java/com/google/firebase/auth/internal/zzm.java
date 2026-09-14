package com.google.firebase.auth.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzm extends zzi {
    private String zza;
    private String zzb;
    private String zzc;

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi zzb(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi zzc(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzj zza() {
        return new zzn(this.zza, this.zzb, this.zzc);
    }
}
