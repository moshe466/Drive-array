package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzbq {
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        if (P2.G.h(r7, r1) != r3) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ad -> B:11:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(F2.l r18, long r19, long r21, double r23, F2.l r25, w2.InterfaceC0763d r26) {
        /*
            r17 = this;
            r0 = r26
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzbp
            if (r1 == 0) goto L17
            r1 = r0
            com.google.android.recaptcha.internal.zzbp r1 = (com.google.android.recaptcha.internal.zzbp) r1
            int r2 = r1.zzh
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.zzh = r2
            r2 = r17
            goto L1e
        L17:
            com.google.android.recaptcha.internal.zzbp r1 = new com.google.android.recaptcha.internal.zzbp
            r2 = r17
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.zzf
            x2.a r3 = x2.EnumC0779a.f6740a
            int r4 = r1.zzh
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L60
            if (r4 == r6) goto L4c
            if (r4 != r5) goto L44
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            F2.l r4 = (F2.l) r4
            java.lang.Object r13 = r1.zza
            F2.l r13 = (F2.l) r13
            a.AbstractC0228a.C(r0)
        L3d:
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
            goto L6e
        L44:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4c:
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            F2.l r4 = (F2.l) r4
            java.lang.Object r13 = r1.zza
            F2.l r13 = (F2.l) r13
            a.AbstractC0228a.C(r0)     // Catch: java.lang.Exception -> L5e
            return r0
        L5e:
            r0 = move-exception
            goto L89
        L60:
            a.AbstractC0228a.C(r0)
            r7 = r19
            r9 = r21
            r11 = r23
            r4 = r25
            r13 = r1
            r1 = r18
        L6e:
            r13.zza = r1     // Catch: java.lang.Exception -> L82
            r13.zzb = r4     // Catch: java.lang.Exception -> L82
            r13.zzc = r9     // Catch: java.lang.Exception -> L82
            r13.zze = r11     // Catch: java.lang.Exception -> L82
            r13.zzd = r7     // Catch: java.lang.Exception -> L82
            r13.zzh = r6     // Catch: java.lang.Exception -> L82
            java.lang.Object r0 = r4.invoke(r13)     // Catch: java.lang.Exception -> L82
            if (r0 != r3) goto L81
            goto Lb0
        L81:
            return r0
        L82:
            r0 = move-exception
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
        L89:
            java.lang.Object r14 = r13.invoke(r0)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto Lb1
            double r7 = (double) r7
            double r7 = r7 * r9
            long r7 = (long) r7
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 <= 0) goto L9d
            r7 = r11
        L9d:
            r1.zza = r13
            r1.zzb = r4
            r1.zzc = r11
            r1.zze = r9
            r1.zzd = r7
            r1.zzh = r5
            java.lang.Object r0 = P2.G.h(r7, r1)
            if (r0 == r3) goto Lb0
            goto L3d
        Lb0:
            return r3
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zza(F2.l, long, long, double, F2.l, w2.d):java.lang.Object");
    }
}
