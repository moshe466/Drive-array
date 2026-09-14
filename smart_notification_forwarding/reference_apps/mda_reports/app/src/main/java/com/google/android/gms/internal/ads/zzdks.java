package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdks extends zzdih<zzdmw, zzdmv> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdks(zzdkq zzdkqVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ void zzc(zzdmw zzdmwVar) {
        zzdmw zzdmwVar2 = zzdmwVar;
        if (zzdmwVar2.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzdkq.zza(zzdmwVar2.zzauz());
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdmv zzd(zzdmw zzdmwVar) {
        zzdmw zzdmwVar2 = zzdmwVar;
        return (zzdmv) zzdmv.zzava().zzen(0).zzd(zzdmwVar2.zzauz()).zzau(zzdqk.zzu(zzdpn.zzey(zzdmwVar2.getKeySize()))).zzbaf();
    }

    @Override // com.google.android.gms.internal.ads.zzdih
    public final /* synthetic */ zzdmw zzq(zzdqk zzdqkVar) {
        return zzdmw.zzat(zzdqkVar);
    }
}
