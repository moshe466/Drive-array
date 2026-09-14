package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaar implements zzafn<zzaic> {
    private final /* synthetic */ zzaid zza;
    private final /* synthetic */ zzahc zzb;
    private final /* synthetic */ zzaeg zzc;
    private final /* synthetic */ zzahn zzd;
    private final /* synthetic */ zzafk zze;
    private final /* synthetic */ zzaam zzf;

    public zzaar(zzaam zzaamVar, zzaid zzaidVar, zzahc zzahcVar, zzaeg zzaegVar, zzahn zzahnVar, zzafk zzafkVar) {
        this.zza = zzaidVar;
        this.zzb = zzahcVar;
        this.zzc = zzaegVar;
        this.zzd = zzahnVar;
        this.zze = zzafkVar;
        this.zzf = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zze.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzaic zzaicVar) {
        zzaic zzaicVar2 = zzaicVar;
        if (this.zza.zzi("EMAIL")) {
            this.zzb.zzb(null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzb(this.zza.zzc());
        }
        if (this.zza.zzi("DISPLAY_NAME")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zzi("PHOTO_URL")) {
            this.zzb.zzc(null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            Preconditions.checkNotEmpty(Base64Utils.encode("redacted".getBytes()));
        }
        if (this.zza.zzi("delete_passkey")) {
            this.zzb.zza(zzaj.zzh());
        }
        List<zzaht> zze = zzaicVar2.zze();
        if (zze == null) {
            zze = new ArrayList<>();
        }
        this.zzb.zza(zze);
        zzaeg zzaegVar = this.zzc;
        zzahn zzahnVar = this.zzd;
        Preconditions.checkNotNull(zzahnVar);
        Preconditions.checkNotNull(zzaicVar2);
        String zzc = zzaicVar2.zzc();
        String zzd = zzaicVar2.zzd();
        if (!TextUtils.isEmpty(zzc) && !TextUtils.isEmpty(zzd)) {
            zzahnVar = new zzahn(zzd, zzc, Long.valueOf(zzaicVar2.zza()), zzahnVar.zze());
        }
        zzaegVar.zza(zzahnVar, this.zzb);
    }
}
