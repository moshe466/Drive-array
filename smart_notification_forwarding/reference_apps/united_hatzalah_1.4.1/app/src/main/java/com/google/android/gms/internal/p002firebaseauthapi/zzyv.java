package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class zzyv implements zzbh {
    private final ECPrivateKey zza;
    private final zzyx zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzzb zze;
    private final zzlq zzf;
    private final byte[] zzg;

    private zzyv(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzzb zzzbVar, zzlq zzlqVar, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzyx(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzzbVar;
        this.zzf = zzlqVar;
        this.zzg = bArr2;
    }

    public static zzbh zza(zzkh zzkhVar) {
        ECPrivateKey zza = zzyz.zza(zzyy.zza.zza((zznk<zzzc, zzke.zza>) ((zzke) ((zzlj) zzkhVar.zza())).zzd()), zznh.zza(zzkhVar.zzf().zza(zzbj.zza())));
        byte[] bArr = new byte[0];
        if (((zzke) ((zzlj) zzkhVar.zza())).zzh() != null) {
            bArr = ((zzke) ((zzlj) zzkhVar.zza())).zzh().zzb();
        }
        return new zzyv(zza, bArr, zzyy.zza(((zzke) ((zzlj) zzkhVar.zza())).zze()), zzyy.zzb.zza((zznk<zzzb, zzke.zzc>) ((zzke) ((zzlj) zzkhVar.zza())).zzf()), zzlm.zza((zzke) ((zzlj) zzkhVar.zza())), zzkhVar.zzh().zzb());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] zza(byte[] r11, byte[] r12) {
        /*
            r10 = this;
            byte[] r0 = r10.zzg
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzqq.zza(r0, r11)
            if (r0 == 0) goto L5f
            byte[] r0 = r10.zzg
            int r0 = r0.length
            java.security.interfaces.ECPrivateKey r1 = r10.zza
            java.security.spec.ECParameterSpec r1 = r1.getParams()
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            com.google.android.gms.internal.firebase-auth-api.zzzb r2 = r10.zze
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyz.zza(r1)
            int r2 = r2.ordinal()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            int r1 = r1 * r3
            goto L35
        L29:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "unknown EC point format"
            r11.<init>(r12)
            throw r11
        L31:
            int r1 = r1 + r4
            goto L35
        L33:
            int r1 = r1 * r3
            goto L31
        L35:
            int r2 = r11.length
            int r1 = r1 + r0
            if (r2 < r1) goto L57
            byte[] r4 = java.util.Arrays.copyOfRange(r11, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzyx r3 = r10.zzb
            java.lang.String r5 = r10.zzc
            byte[] r6 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzlq r0 = r10.zzf
            int r8 = r0.zza()
            com.google.android.gms.internal.firebase-auth-api.zzzb r9 = r10.zze
            r7 = r12
            byte[] r12 = r3.zza(r4, r5, r6, r7, r8, r9)
            com.google.android.gms.internal.firebase-auth-api.zzlq r0 = r10.zzf
            byte[] r11 = r0.zza(r12, r11, r1)
            return r11
        L57:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "ciphertext too short"
            r11.<init>(r12)
            throw r11
        L5f:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "Invalid ciphertext (output prefix mismatch)"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzyv.zza(byte[], byte[]):byte[]");
    }
}
