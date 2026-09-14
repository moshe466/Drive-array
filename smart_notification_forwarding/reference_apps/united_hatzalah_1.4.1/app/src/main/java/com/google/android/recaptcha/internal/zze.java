package com.google.android.recaptcha.internal;

import s2.C0684i;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public abstract class zze {
    private boolean zza;

    public zzen zza(String str) {
        throw null;
    }

    public zzen zzb() {
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:(1:(2:12|13)(2:15|16))(3:17|18|(1:21)(1:20)))(4:22|23|24|25))(5:45|46|47|(1:49)|21)|26|27|(2:29|30)(1:32)))|53|6|7|(0)(0)|26|27|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        r16 = r3;
        r4 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[Catch: Exception -> 0x0094, TRY_LEAVE, TryCatch #2 {Exception -> 0x0094, blocks: (B:27:0x0085, B:29:0x0090), top: B:26:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(java.lang.String r19, long r20, w2.InterfaceC0763d r22) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zzc(java.lang.String, long, w2.d):java.lang.Object");
    }

    public abstract Object zzd(String str, InterfaceC0763d interfaceC0763d);

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
    
        if (r12 != r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[Catch: Exception -> 0x0051, TRY_LEAVE, TryCatch #1 {Exception -> 0x0051, blocks: (B:27:0x004d, B:28:0x0077, B:30:0x0082), top: B:26:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zze(long r9, com.google.android.recaptcha.internal.zzsc r11, w2.InterfaceC0763d r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.google.android.recaptcha.internal.zzc
            if (r0 == 0) goto L13
            r0 = r12
            com.google.android.recaptcha.internal.zzc r0 = (com.google.android.recaptcha.internal.zzc) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzc r0 = new com.google.android.recaptcha.internal.zzc
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.zzb
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzd
            r3 = 0
            s2.i r4 = s2.C0684i.f6340a
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L53
            if (r2 == r7) goto L47
            if (r2 == r6) goto L3d
            if (r2 != r5) goto L35
            java.lang.Object r9 = r0.zza
            com.google.android.recaptcha.internal.zzbd r9 = (com.google.android.recaptcha.internal.zzbd) r9
            a.AbstractC0228a.C(r12)
            goto Lae
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            com.google.android.recaptcha.internal.zzen r9 = r0.zze
            java.lang.Object r10 = r0.zza
            com.google.android.recaptcha.internal.zze r10 = (com.google.android.recaptcha.internal.zze) r10
            a.AbstractC0228a.C(r12)
            goto L99
        L47:
            com.google.android.recaptcha.internal.zzen r9 = r0.zze
            java.lang.Object r10 = r0.zza
            com.google.android.recaptcha.internal.zze r10 = (com.google.android.recaptcha.internal.zze) r10
            a.AbstractC0228a.C(r12)     // Catch: java.lang.Exception -> L51
            goto L77
        L51:
            r11 = move-exception
            goto L8a
        L53:
            a.AbstractC0228a.C(r12)
            com.google.android.recaptcha.internal.zzen r12 = r8.zzb()
            boolean r2 = r8.zza
            if (r2 == 0) goto L62
            r12.zza()
            return r4
        L62:
            com.google.android.recaptcha.internal.zzd r2 = new com.google.android.recaptcha.internal.zzd     // Catch: java.lang.Exception -> L86
            r2.<init>(r8, r11, r3)     // Catch: java.lang.Exception -> L86
            r0.zza = r8     // Catch: java.lang.Exception -> L86
            r0.zze = r12     // Catch: java.lang.Exception -> L86
            r0.zzd = r7     // Catch: java.lang.Exception -> L86
            java.lang.Object r9 = P2.G.A(r9, r2, r0)     // Catch: java.lang.Exception -> L86
            if (r9 == r1) goto Lb3
            r10 = r12
            r12 = r9
            r9 = r10
            r10 = r8
        L77:
            s2.f r12 = (s2.C0681f) r12     // Catch: java.lang.Exception -> L51
            java.lang.Object r11 = r12.f6335a     // Catch: java.lang.Exception -> L51
            a.AbstractC0228a.C(r11)     // Catch: java.lang.Exception -> L51
            r10.zza = r7     // Catch: java.lang.Exception -> L51
            if (r9 == 0) goto L85
            r9.zza()     // Catch: java.lang.Exception -> L51
        L85:
            return r4
        L86:
            r9 = move-exception
            r11 = r9
            r10 = r8
            r9 = r12
        L8a:
            r12 = 0
            r10.zza = r12
            r0.zza = r10
            r0.zze = r9
            r0.zzd = r6
            java.lang.Object r12 = r10.zzj(r11, r0)
            if (r12 == r1) goto Lb3
        L99:
            r11 = r12
            com.google.android.recaptcha.internal.zzbd r11 = (com.google.android.recaptcha.internal.zzbd) r11
            if (r9 == 0) goto La1
            r9.zzb(r11)
        La1:
            r0.zza = r11
            r0.zze = r3
            r0.zzd = r5
            java.lang.Object r9 = r10.zzg(r11, r0)
            if (r9 == r1) goto Lb3
            r9 = r11
        Lae:
            s2.e r9 = a.AbstractC0228a.g(r9)
            return r9
        Lb3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zze(long, com.google.android.recaptcha.internal.zzsc, w2.d):java.lang.Object");
    }

    public abstract Object zzf(String str, InterfaceC0763d interfaceC0763d);

    public Object zzg(zzbd zzbdVar, InterfaceC0763d interfaceC0763d) {
        return C0684i.f6340a;
    }

    public abstract Object zzh(zzsc zzscVar, InterfaceC0763d interfaceC0763d);

    public Object zzi(String str, long j2, Exception exc, InterfaceC0763d interfaceC0763d) {
        return C0684i.f6340a;
    }

    public Object zzj(Exception exc, InterfaceC0763d interfaceC0763d) {
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzap, exc.getMessage()));
    }

    public void zzk(zzsr zzsrVar) {
    }

    public final boolean zzl() {
        return this.zza;
    }
}
