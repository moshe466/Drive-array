package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;

/* loaded from: classes.dex */
final class zzdkd extends zzdii<zzdmn> {
    public zzdkd() {
        super(zzdmn.class, new zzdkg(zzdie.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdna.zzb zzasd() {
        return zzdna.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ void zze(zzdmn zzdmnVar) {
        zzdmn zzdmnVar2 = zzdmnVar;
        zzdpo.zzx(zzdmnVar2.getVersion(), 0);
        zzdkk.zza(zzdmnVar2.zzauf());
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdmn zzr(zzdqk zzdqkVar) {
        return zzdmn.zzap(zzdqkVar);
    }
}
