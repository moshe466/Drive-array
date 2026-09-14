package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;
import com.google.android.gms.internal.ads.zzdnk;
import com.google.android.gms.internal.ads.zzdnl;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzdiz {
    private static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);

    public static zzdnl zzb(zzdnk zzdnkVar) {
        zzdnl.zza zzer = zzdnl.zzawd().zzer(zzdnkVar.zzavv());
        for (zzdnk.zza zzaVar : zzdnkVar.zzavw()) {
            zzer.zzb((zzdnl.zzb) zzdnl.zzb.zzawf().zzhc(zzaVar.zzawa().zzavi()).zza(zzaVar.zzasj()).zza(zzaVar.zzask()).zzes(zzaVar.zzawb()).zzbaf());
        }
        return (zzdnl) zzer.zzbaf();
    }

    public static void zzc(zzdnk zzdnkVar) {
        int zzavv = zzdnkVar.zzavv();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdnk.zza zzaVar : zzdnkVar.zzavw()) {
            if (zzaVar.zzasj() == zzdne.ENABLED) {
                if (!zzaVar.zzavz()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.zzawb())));
                }
                if (zzaVar.zzask() == zzdnw.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.zzawb())));
                }
                if (zzaVar.zzasj() == zzdne.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.zzawb())));
                }
                if (zzaVar.zzawb() == zzavv) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzaVar.zzawa().zzavk() != zzdna.zzb.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
