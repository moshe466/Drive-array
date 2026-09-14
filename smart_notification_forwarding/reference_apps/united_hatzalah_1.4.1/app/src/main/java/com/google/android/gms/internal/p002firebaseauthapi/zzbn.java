package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzbn {
    private final zzce zza;

    private zzbn(zzce zzceVar) {
        this.zza = zzceVar;
    }

    public static zzbn zza(zzce zzceVar) {
        return new zzbn(zzceVar);
    }

    private final zzww zzb() {
        try {
            zzce zzceVar = this.zza;
            if (zzceVar instanceof zzoh) {
                return ((zzoh) zzceVar).zzb().zza();
            }
            return ((zzqd) zzpc.zza().zza((zzpc) this.zza, zzqd.class)).zza();
        } catch (GeneralSecurityException e4) {
            throw new zzqo("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat(String.valueOf(this.zza)), e4);
        }
    }

    public final zzce zza() {
        zzce zzceVar = this.zza;
        return zzceVar != null ? zzceVar : zzcm.zza(zzb().zzk());
    }
}
