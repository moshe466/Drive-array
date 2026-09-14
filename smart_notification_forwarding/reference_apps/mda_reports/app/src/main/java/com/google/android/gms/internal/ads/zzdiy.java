package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdiy {
    public static final String zzgyr = new zzdjc().getKeyType();
    public static final String zzgys = new zzdjm().getKeyType();
    private static final String zzgyt = new zzdjh().getKeyType();
    private static final String zzgyu = new zzdjs().getKeyType();
    private static final String zzgyv = new zzdjw().getKeyType();
    private static final String zzgyw = new zzdjn().getKeyType();
    private static final String zzgyx = new zzdjx().getKeyType();

    @Deprecated
    private static final zzdny zzgyy;

    @Deprecated
    private static final zzdny zzgyz;

    @Deprecated
    private static final zzdny zzgza;

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
        zzdku.zzasq();
        zzdit.zza((zzdii) new zzdjc(), true);
        zzdit.zza((zzdii) new zzdjh(), true);
        zzdit.zza((zzdii) new zzdjm(), true);
        zzdit.zza((zzdii) new zzdjn(), true);
        zzdit.zza((zzdii) new zzdjs(), true);
        zzdit.zza((zzdii) new zzdjw(), true);
        zzdit.zza((zzdii) new zzdjx(), true);
        zzdit.zza(new zzdjb());
    }
}
