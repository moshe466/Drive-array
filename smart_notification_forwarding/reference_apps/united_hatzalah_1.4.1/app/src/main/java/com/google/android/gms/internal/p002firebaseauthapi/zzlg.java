package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzuy;

/* loaded from: classes.dex */
public final class zzlg {
    public static final zzww zza;
    private static final byte[] zzb;

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzvn zzvnVar = zzvn.NIST_P256;
        zzvt zzvtVar = zzvt.SHA256;
        zzuw zzuwVar = zzuw.UNCOMPRESSED;
        zzww zzwwVar = zzcy.zza;
        zzxu zzxuVar = zzxu.TINK;
        zza = zza(zzvnVar, zzvtVar, zzuwVar, zzwwVar, zzxuVar, bArr);
        zza(zzvnVar, zzvtVar, zzuw.COMPRESSED, zzwwVar, zzxu.RAW, bArr);
        zza(zzvnVar, zzvtVar, zzuwVar, zzcy.zzc, zzxuVar, bArr);
    }

    @Deprecated
    private static zzww zza(zzvn zzvnVar, zzvt zzvtVar, zzuw zzuwVar, zzww zzwwVar, zzxu zzxuVar, byte[] bArr) {
        zzuy.zza zza2 = zzuy.zza();
        zzvk zzvkVar = (zzvk) ((zzaky) zzvk.zza().zza(zzvnVar).zza(zzvtVar).zza(zzajp.zza(bArr)).zze());
        return (zzww) ((zzaky) zzww.zza().zza(zzka.zza()).zza(zzxuVar).zza(((zzuy) ((zzaky) zza2.zza((zzvb) ((zzaky) zzvb.zzc().zza(zzvkVar).zza((zzuv) ((zzaky) zzuv.zza().zza(zzwwVar).zze())).zza(zzuwVar).zze())).zze())).a_()).zze());
    }
}
