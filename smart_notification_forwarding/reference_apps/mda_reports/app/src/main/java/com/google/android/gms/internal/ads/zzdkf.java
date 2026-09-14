package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdkf {
    private static final String zzgzo = new zzdkd().getKeyType();
    private static final String zzgzp = new zzdkc().getKeyType();

    @Deprecated
    public static final zzdny zzgyy = zzdny.zzawv();

    @Deprecated
    private static final zzdny zzgyz = zzdny.zzawv();

    @Deprecated
    private static final zzdny zzgza = zzdny.zzawv();

    static {
        try {
            zzdiy.zzasq();
            zzdit.zza((zzdiu) new zzdkc(), (zzdii) new zzdkd(), true);
            zzdit.zza(new zzdkh());
            zzdit.zza(new zzdki());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
