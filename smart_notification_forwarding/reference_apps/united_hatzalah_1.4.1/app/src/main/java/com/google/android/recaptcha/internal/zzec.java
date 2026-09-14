package com.google.android.recaptcha.internal;

import P2.C0169t;
import P2.G;
import P2.InterfaceC0168s;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class zzec implements zzcn {
    private final zzdt zza;
    private final zzek zzb;
    private InterfaceC0168s zzc = G.a();
    private zzbd zzd;
    private zzsc zze;
    private zzcm zzf;
    private final zzbi zzg;

    public zzec(zzdt zzdtVar, zzbi zzbiVar, zzek zzekVar, zzbo zzboVar) {
        zzcl zzclVar;
        this.zza = zzdtVar;
        this.zzg = zzbiVar;
        this.zzb = zzekVar;
        zzclVar = zzcm.zza;
        this.zzf = zzclVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzl(F2.l r5, w2.InterfaceC0763d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzdv
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzdv r0 = (com.google.android.recaptcha.internal.zzdv) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdv r0 = new com.google.android.recaptcha.internal.zzdv
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            com.google.android.recaptcha.internal.zzbn r5 = r0.zzd
            a.AbstractC0228a.C(r6)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            a.AbstractC0228a.C(r6)
            com.google.android.recaptcha.internal.zzbn r6 = new com.google.android.recaptcha.internal.zzbn
            r6.<init>()
            r0.zzd = r6
            r0.zzc = r3
            java.lang.Object r5 = r5.invoke(r0)
            if (r5 == r1) goto L53
            r5 = r6
        L44:
            r5.zzc()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r5.zza(r6)
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r5)
            return r0
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzl(F2.l, w2.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: Exception -> 0x002f, TRY_ENTER, TryCatch #1 {Exception -> 0x002f, blocks: (B:12:0x002b, B:13:0x0063, B:19:0x0076, B:20:0x007f), top: B:11:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzm(long r7, w2.InterfaceC0763d r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdw
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzdw r0 = (com.google.android.recaptcha.internal.zzdw) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdw r0 = new com.google.android.recaptcha.internal.zzdw
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.zzb
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r0 = r0.zze
            a.AbstractC0228a.C(r9)     // Catch: java.lang.Exception -> L2f
            goto L63
        L2f:
            r7 = move-exception
            goto L82
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r2 = r0.zze
            a.AbstractC0228a.C(r9)
            goto L51
        L41:
            a.AbstractC0228a.C(r9)
            r0.zze = r6
            r0.zza = r7
            r0.zzd = r4
            java.lang.Object r9 = r6.zzn(r7, r0)
            if (r9 == r1) goto Lb8
            r2 = r6
        L51:
            com.google.android.recaptcha.internal.zzdy r9 = new com.google.android.recaptcha.internal.zzdy     // Catch: java.lang.Exception -> L80
            r9.<init>(r7, r2, r5)     // Catch: java.lang.Exception -> L80
            r0.zze = r2     // Catch: java.lang.Exception -> L80
            r0.zza = r7     // Catch: java.lang.Exception -> L80
            r0.zzd = r3     // Catch: java.lang.Exception -> L80
            java.lang.Object r9 = r2.zzl(r9, r0)     // Catch: java.lang.Exception -> L80
            if (r9 == r1) goto Lb8
            r0 = r2
        L63:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Exception -> L2f
            long r1 = r9.longValue()     // Catch: java.lang.Exception -> L2f
            long r7 = r7 - r1
            r1 = 500(0x1f4, double:2.47E-321)
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 < 0) goto L76
            java.lang.Long r9 = new java.lang.Long
            r9.<init>(r7)
            return r9
        L76:
            com.google.android.recaptcha.internal.zzbd r7 = new com.google.android.recaptcha.internal.zzbd     // Catch: java.lang.Exception -> L2f
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc     // Catch: java.lang.Exception -> L2f
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar     // Catch: java.lang.Exception -> L2f
            r7.<init>(r8, r9, r5)     // Catch: java.lang.Exception -> L2f
            throw r7     // Catch: java.lang.Exception -> L2f
        L80:
            r7 = move-exception
            r0 = r2
        L82:
            boolean r8 = r7 instanceof com.google.android.recaptcha.internal.zzbd
            if (r8 == 0) goto L89
            r5 = r7
            com.google.android.recaptcha.internal.zzbd r5 = (com.google.android.recaptcha.internal.zzbd) r5
        L89:
            if (r5 != 0) goto L98
            com.google.android.recaptcha.internal.zzbd r5 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar
            java.lang.String r7 = r7.getMessage()
            r5.<init>(r8, r9, r7)
        L98:
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzci r8 = com.google.android.recaptcha.internal.zzcm.zza()
            boolean r7 = kotlin.jvm.internal.j.a(r7, r8)
            if (r7 != 0) goto Lb2
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzck r8 = com.google.android.recaptcha.internal.zzcm.zzc()
            boolean r7 = kotlin.jvm.internal.j.a(r7, r8)
            if (r7 == 0) goto Lb1
            goto Lb2
        Lb1:
            throw r5
        Lb2:
            com.google.android.recaptcha.internal.zzbd r7 = r0.zzd
            if (r7 == 0) goto Lb7
            r5 = r7
        Lb7:
            throw r5
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzm(long, w2.d):java.lang.Object");
    }

    private final Object zzn(long j2, InterfaceC0763d interfaceC0763d) {
        zzcj zzcjVar;
        zzck zzckVar;
        zzci zzciVar;
        zzck zzckVar2;
        zzcm zzcmVar = this.zzf;
        zzcjVar = zzcm.zzb;
        boolean a2 = j.a(zzcmVar, zzcjVar);
        C0684i c0684i = C0684i.f6340a;
        if (!a2) {
            zzcm zzcmVar2 = this.zzf;
            zzckVar = zzcm.zzc;
            if (!j.a(zzcmVar2, zzckVar)) {
                zzcm zzcmVar3 = this.zzf;
                zzciVar = zzcm.zzd;
                if (!j.a(zzcmVar3, zzciVar) || zzo(this.zzd)) {
                    zzckVar2 = zzcm.zzc;
                    this.zzf = zzckVar2;
                    C0169t a4 = G.a();
                    this.zzc = a4;
                    G.r(this.zzg.zza(), null, new zzeb(this, a4, j2, null), 3);
                }
            }
        }
        return c0684i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzo(Exception exc) {
        if (!(exc instanceof zzbd)) {
            return true;
        }
        zzbd zzbdVar = (zzbd) exc;
        if (!j.a(zzbdVar.zzb(), zzbb.zzd) && !j.a(zzbdVar.zzb(), zzbb.zze) && !j.a(zzbdVar.zzb(), zzbb.zzf)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(java.lang.String r18, com.google.android.recaptcha.RecaptchaAction r19, long r20, w2.InterfaceC0763d r22) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zza(java.lang.String, com.google.android.recaptcha.RecaptchaAction, long, w2.d):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zzb(long j2, InterfaceC0763d interfaceC0763d) {
        Object zzn = zzn(j2, interfaceC0763d);
        if (zzn == EnumC0779a.f6740a) {
            return zzn;
        }
        return C0684i.f6340a;
    }
}
