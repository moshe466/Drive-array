package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.List;

/* loaded from: classes.dex */
final class zzabk implements zzafn<zzahd> {
    private final /* synthetic */ zzafn zza;
    private final /* synthetic */ zzahn zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaeg zzd;
    private final /* synthetic */ zzabh zze;

    public zzabk(zzabh zzabhVar, zzafn zzafnVar, zzahn zzahnVar, String str, zzaeg zzaegVar) {
        this.zza = zzafnVar;
        this.zzb = zzahnVar;
        this.zzc = str;
        this.zzd = zzaegVar;
        this.zze = zzabhVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahd zzahdVar) {
        List<zzahc> zza = zzahdVar.zza();
        if (zza != null && !zza.isEmpty()) {
            zzahc zzahcVar = zza.get(0);
            zzaid zzaidVar = new zzaid();
            zzaidVar.zzd(this.zzb.zzc()).zza(this.zzc);
            zzaam.zza(this.zze.zza, this.zzd, this.zzb, zzahcVar, zzaidVar, this.zza);
            return;
        }
        this.zza.zza("No users.");
    }
}
