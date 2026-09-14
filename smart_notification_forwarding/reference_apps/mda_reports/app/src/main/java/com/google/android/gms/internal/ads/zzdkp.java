package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdkp extends zzdii<zzdky> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkp() {
        super(zzdky.class, new zzdko(zzdio.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzdlc zzdlcVar) {
        if (zzdlcVar.zzasx() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzdlcVar.zzasx() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzea(int i) {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdna.zzb zzasd() {
        return zzdna.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdih<?, zzdky> zzasg() {
        return new zzdkr(this, zzdlb.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ void zze(zzdky zzdkyVar) {
        zzdky zzdkyVar2 = zzdkyVar;
        zzdpo.zzx(zzdkyVar2.getVersion(), 0);
        zzea(zzdkyVar2.zzass().size());
        zza(zzdkyVar2.zzast());
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdky zzr(zzdqk zzdqkVar) {
        return zzdky.zzt(zzdqkVar);
    }
}
