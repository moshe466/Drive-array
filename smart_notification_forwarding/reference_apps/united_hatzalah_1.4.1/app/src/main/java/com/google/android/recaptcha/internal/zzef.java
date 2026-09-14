package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzef implements zzcn {
    private final zzdt zza;
    private zzcm zzb;
    private zzsc zzc;

    public zzef(zzdt zzdtVar) {
        zzcl zzclVar;
        this.zza = zzdtVar;
        zzclVar = zzcm.zza;
        this.zzb = zzclVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(java.lang.String r17, com.google.android.recaptcha.RecaptchaAction r18, long r19, w2.InterfaceC0763d r21) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zza(java.lang.String, com.google.android.recaptcha.RecaptchaAction, long, w2.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0099, code lost:
    
        if (r13 == r1) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.google.android.recaptcha.internal.zzef] */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzb(long r12, w2.InterfaceC0763d r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzee
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzee r0 = (com.google.android.recaptcha.internal.zzee) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzee r0 = new com.google.android.recaptcha.internal.zzee
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.zzb
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzd
            s2.i r3 = s2.C0684i.f6340a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            com.google.android.recaptcha.internal.zzef r12 = r0.zze
            a.AbstractC0228a.C(r14)     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            goto L9b
        L2f:
            r13 = move-exception
            goto La6
        L32:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3a:
            double r12 = r0.zza
            com.google.android.recaptcha.internal.zzef r2 = r0.zze
            a.AbstractC0228a.C(r14)     // Catch: com.google.android.recaptcha.internal.zzbd -> L46
            r10 = r2
            r2 = r14
            r13 = r12
            r12 = r10
            goto L8a
        L46:
            r13 = move-exception
            r12 = r2
            goto La6
        L49:
            a.AbstractC0228a.C(r14)
            com.google.android.recaptcha.internal.zzcm r14 = r11.zzb
            com.google.android.recaptcha.internal.zzcj r2 = com.google.android.recaptcha.internal.zzcm.zzb()
            boolean r14 = kotlin.jvm.internal.j.a(r14, r2)
            if (r14 != 0) goto Lad
            com.google.android.recaptcha.internal.zzcm r14 = r11.zzb
            com.google.android.recaptcha.internal.zzci r2 = com.google.android.recaptcha.internal.zzcm.zza()
            boolean r14 = kotlin.jvm.internal.j.a(r14, r2)
            if (r14 == 0) goto L65
            goto Lad
        L65:
            com.google.android.recaptcha.internal.zzck r14 = com.google.android.recaptcha.internal.zzcm.zzc()
            r11.zzb = r14
            double r12 = (double) r12
            com.google.android.recaptcha.internal.zzdt r14 = r11.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            r6 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r6 = r6 * r12
            r0.zze = r11     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            r8 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r12 = r12 * r8
            r0.zza = r12     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            r0.zzd = r5     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            long r5 = (long) r6     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            java.lang.Object r14 = r14.zzo(r5, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> La3
            if (r14 == r1) goto La2
            r2 = r14
            r13 = r12
            r12 = r11
        L8a:
            com.google.android.recaptcha.internal.zzsc r2 = (com.google.android.recaptcha.internal.zzsc) r2     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            r12.zzc = r2     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            com.google.android.recaptcha.internal.zzdt r5 = r12.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            long r13 = (long) r13     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            r0.zze = r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            r0.zzd = r4     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            java.lang.Object r13 = r5.zzn(r2, r13, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            if (r13 == r1) goto La2
        L9b:
            com.google.android.recaptcha.internal.zzcj r13 = com.google.android.recaptcha.internal.zzcm.zzb()     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            r12.zzb = r13     // Catch: com.google.android.recaptcha.internal.zzbd -> L2f
            return r3
        La2:
            return r1
        La3:
            r12 = move-exception
            r13 = r12
            r12 = r11
        La6:
            com.google.android.recaptcha.internal.zzci r14 = com.google.android.recaptcha.internal.zzcm.zza()
            r12.zzb = r14
            throw r13
        Lad:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zzb(long, w2.d):java.lang.Object");
    }
}
