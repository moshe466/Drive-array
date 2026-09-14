package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzcm {
    public static zzce zza(byte[] bArr) {
        try {
            zzww zza = zzww.zza(bArr, zzakk.zza());
            zzpc zza2 = zzpc.zza();
            zzqd zza3 = zzqd.zza(zza);
            if (!zza2.zzc(zza3)) {
                return new zzoh(zza3);
            }
            return zza2.zza((zzpc) zza3);
        } catch (IOException e4) {
            throw new GeneralSecurityException("Failed to parse proto", e4);
        }
    }

    public static byte[] zza(zzce zzceVar) {
        if (zzceVar instanceof zzoh) {
            return ((zzoh) zzceVar).zzb().zza().zzk();
        }
        return ((zzqd) zzpc.zza().zza((zzpc) zzceVar, zzqd.class)).zza().zzk();
    }
}
