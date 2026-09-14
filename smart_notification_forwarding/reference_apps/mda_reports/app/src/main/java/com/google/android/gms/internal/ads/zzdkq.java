package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdkq extends zzdii<zzdmv> {
    public zzdkq() {
        super(zzdmv.class, new zzdkt(zzdio.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzdmz zzdmzVar) {
        if (zzdmzVar.zzasx() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = zzdkv.a[zzdmzVar.zzavf().ordinal()];
        if (i == 1) {
            if (zzdmzVar.zzasx() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 2) {
            if (zzdmzVar.zzasx() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i != 3) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzdmzVar.zzasx() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdna.zzb zzasd() {
        return zzdna.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdih<?, zzdmv> zzasg() {
        return new zzdks(this, zzdmw.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ void zze(zzdmv zzdmvVar) {
        zzdmv zzdmvVar2 = zzdmvVar;
        zzdpo.zzx(zzdmvVar2.getVersion(), 0);
        if (zzdmvVar2.zzass().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzdmvVar2.zzauz());
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdmv zzr(zzdqk zzdqkVar) {
        return zzdmv.zzas(zzdqkVar);
    }
}
