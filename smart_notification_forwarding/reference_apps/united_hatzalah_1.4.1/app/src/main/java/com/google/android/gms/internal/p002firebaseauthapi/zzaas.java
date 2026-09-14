package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaas implements zzafn<zzahd> {
    private final /* synthetic */ zzafk zza;
    private final /* synthetic */ zzaeg zzb;
    private final /* synthetic */ zzahn zzc;
    private final /* synthetic */ zzaid zzd;
    private final /* synthetic */ zzaam zze;

    public zzaas(zzaam zzaamVar, zzafk zzafkVar, zzaeg zzaegVar, zzahn zzahnVar, zzaid zzaidVar) {
        this.zza = zzafkVar;
        this.zzb = zzaegVar;
        this.zzc = zzahnVar;
        this.zzd = zzaidVar;
        this.zze = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahd zzahdVar) {
        List<zzahc> zza = zzahdVar.zza();
        if (zza != null && !zza.isEmpty()) {
            zzaam.zza(this.zze, this.zzb, this.zzc, zza.get(0), this.zzd, this.zza);
        } else {
            this.zza.zza("No users");
        }
    }
}
