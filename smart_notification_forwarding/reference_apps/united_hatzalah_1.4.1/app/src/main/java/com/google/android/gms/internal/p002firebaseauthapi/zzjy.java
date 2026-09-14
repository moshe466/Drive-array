package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzjy implements zzbi {
    private final zzbi zza;
    private final zzxu zzb;
    private final byte[] zzc;

    private zzjy(zzbi zzbiVar, zzxu zzxuVar, byte[] bArr) {
        this.zza = zzbiVar;
        this.zzb = zzxuVar;
        this.zzc = bArr;
    }

    public static zzbi zza(zzoe zzoeVar) {
        byte[] zzb;
        zzqe zza = zzoeVar.zza(zzbj.zza());
        zzbi zzbiVar = (zzbi) zznt.zza().zza(zza.zzf(), zzbi.class).zzb(zza.zzd());
        zzxu zzc = zza.zzc();
        int i = zzjx.zza[zzc.ordinal()];
        if (i == 1) {
            zzb = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            zzb = zzpd.zza(zzoeVar.zzb().intValue()).zzb();
        } else if (i == 4) {
            zzb = zzpd.zzb(zzoeVar.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException(a.c(zzc.zza(), "unknown output prefix type "));
        }
        return new zzjy(zzbiVar, zzc, zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (this.zzb == zzxu.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
