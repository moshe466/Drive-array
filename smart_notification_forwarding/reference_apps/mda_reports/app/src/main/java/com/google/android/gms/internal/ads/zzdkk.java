package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
final class zzdkk {
    public static zzdow zza(zzdmd zzdmdVar) {
        int i = zzdkn.c[zzdmdVar.ordinal()];
        if (i == 1) {
            return zzdow.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzdow.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzdow.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdmdVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzdox zza(zzdmr zzdmrVar) {
        int i = zzdkn.b[zzdmrVar.ordinal()];
        if (i == 1) {
            return zzdox.NIST_P256;
        }
        if (i == 2) {
            return zzdox.NIST_P384;
        }
        if (i == 3) {
            return zzdox.NIST_P521;
        }
        String valueOf = String.valueOf(zzdmrVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static String zza(zzdmt zzdmtVar) {
        int i = zzdkn.a[zzdmtVar.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdmtVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static void zza(zzdmj zzdmjVar) {
        zzdov.zza(zza(zzdmjVar.zzauh().zzauu()));
        zza(zzdmjVar.zzauh().zzauv());
        if (zzdmjVar.zzauj() == zzdmd.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdit.zza(zzdmjVar.zzaui().zzauc());
    }
}
