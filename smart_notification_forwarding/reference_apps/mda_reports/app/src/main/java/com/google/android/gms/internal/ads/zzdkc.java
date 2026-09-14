package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdkc extends zzdiu<zzdmk, zzdmn> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkc() {
        super(zzdmk.class, zzdmn.class, new zzdkb(zzdib.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdna.zzb zzasd() {
        return zzdna.zzb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdih<zzdmg, zzdmk> zzasg() {
        return new zzdke(this, zzdmg.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ void zze(zzdte zzdteVar) {
        zzdmk zzdmkVar = (zzdmk) zzdteVar;
        if (zzdmkVar.zzass().isEmpty()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzdpo.zzx(zzdmkVar.getVersion(), 0);
        zzdkk.zza(zzdmkVar.zzaum().zzauf());
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdte zzr(zzdqk zzdqkVar) {
        return zzdmk.zzal(zzdqkVar);
    }
}
