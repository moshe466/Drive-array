package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdku {

    @Deprecated
    private static final zzdny zzgyy;

    @Deprecated
    private static final zzdny zzgyz;

    @Deprecated
    private static final zzdny zzgza;
    private static final String zzgzz = new zzdkq().getKeyType();

    static {
        zzdny zzawv = zzdny.zzawv();
        zzgyy = zzawv;
        zzgyz = zzawv;
        zzgza = zzgyy;
        try {
            zzasq();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzasq() {
        zzdit.zza((zzdii) new zzdkq(), true);
        zzdit.zza((zzdii) new zzdkp(), true);
        zzdit.zza(new zzdkx());
    }
}
