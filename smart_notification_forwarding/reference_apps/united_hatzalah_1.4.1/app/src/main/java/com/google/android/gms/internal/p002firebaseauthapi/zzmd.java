package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzmd implements zzbh {
    private static final byte[] zza = new byte[0];
    private final zzmh zzb;
    private final zzme zzc;
    private final zzmf zzd;
    private final zzmb zze;
    private final int zzf;
    private final byte[] zzg;

    private zzmd(zzmh zzmhVar, zzme zzmeVar, zzmf zzmfVar, zzmb zzmbVar, int i, zzaae zzaaeVar) {
        this.zzb = zzmhVar;
        this.zzc = zzmeVar;
        this.zzd = zzmfVar;
        this.zze = zzmbVar;
        this.zzf = i;
        this.zzg = zzaaeVar.zzb();
    }

    public static zzbh zza(zzkl zzklVar) {
        int i;
        zzki zzkiVar = (zzki) ((zzlj) zzklVar.zza());
        zzme zza2 = zzmg.zza(zzkiVar.zze());
        zzmf zza3 = zzmg.zza(zzkiVar.zzd());
        zzmb zza4 = zzmg.zza(zzkiVar.zzb());
        zzki.zzd zze = zzkiVar.zze();
        zzki.zzd zzdVar = zzki.zzd.zzd;
        if (zze.equals(zzdVar)) {
            i = 32;
        } else if (zze.equals(zzki.zzd.zza)) {
            i = 65;
        } else if (zze.equals(zzki.zzd.zzb)) {
            i = 97;
        } else {
            if (!zze.equals(zzki.zzd.zzc)) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            i = 133;
        }
        int i3 = i;
        zzki.zzd zze2 = ((zzki) ((zzlj) zzklVar.zza())).zze();
        if (!zze2.equals(zzdVar) && !zze2.equals(zzki.zzd.zza) && !zze2.equals(zzki.zzd.zzb) && !zze2.equals(zzki.zzd.zzc)) {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        }
        return new zzmd(new zzmh(zzaae.zza(zzklVar.zzf().zza(zzbj.zza())), ((zzkt) ((zzll) zzklVar.zzc())).zze()), zza2, zza3, zza4, i3, zzklVar.zzh());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length >= length) {
            if (zzqq.zza(bArr3, bArr)) {
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                return zzma.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
            }
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
