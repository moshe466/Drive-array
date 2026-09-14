package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zziz extends AbstractC0793i implements p {
    Object zza;
    int zzb;
    final /* synthetic */ zzja zzc;
    final /* synthetic */ zzen zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziz(zzja zzjaVar, zzen zzenVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzc = zzjaVar;
        this.zzd = zzenVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zziz(this.zzc, this.zzd, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zziz) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (P2.G.A(com.google.android.gms.location.DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, r6, r5) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if (r6.zzx(r5) != r0) goto L15;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r5.zzb
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 == r2) goto L14
            java.lang.Object r0 = r5.zza
            com.google.android.recaptcha.internal.zzbd r0 = (com.google.android.recaptcha.internal.zzbd) r0
            a.AbstractC0228a.C(r6)
            goto L69
        L14:
            a.AbstractC0228a.C(r6)     // Catch: java.lang.Exception -> L18
            goto L6e
        L18:
            r6 = move-exception
            goto L40
        L1a:
            a.AbstractC0228a.C(r6)     // Catch: java.lang.Exception -> L18
            goto L2b
        L1e:
            a.AbstractC0228a.C(r6)
            com.google.android.recaptcha.internal.zzja r6 = r5.zzc     // Catch: java.lang.Exception -> L18
            r5.zzb = r3     // Catch: java.lang.Exception -> L18
            java.lang.Object r6 = r6.zzx(r5)     // Catch: java.lang.Exception -> L18
            if (r6 == r0) goto L67
        L2b:
            com.google.android.recaptcha.internal.zziy r6 = new com.google.android.recaptcha.internal.zziy     // Catch: java.lang.Exception -> L18
            com.google.android.recaptcha.internal.zzja r1 = r5.zzc     // Catch: java.lang.Exception -> L18
            com.google.android.recaptcha.internal.zzen r3 = r5.zzd     // Catch: java.lang.Exception -> L18
            r4 = 0
            r6.<init>(r1, r3, r4)     // Catch: java.lang.Exception -> L18
            r5.zzb = r2     // Catch: java.lang.Exception -> L18
            r1 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Object r6 = P2.G.A(r1, r6, r5)     // Catch: java.lang.Exception -> L18
            if (r6 != r0) goto L6e
            goto L67
        L40:
            r6.getMessage()
            com.google.android.recaptcha.internal.zzbd r1 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r2 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r3 = com.google.android.recaptcha.internal.zzba.zzV
            java.lang.String r4 = r6.getMessage()
            r1.<init>(r2, r3, r4)
            com.google.android.recaptcha.internal.zzbd r6 = com.google.android.recaptcha.internal.zzf.zza(r6, r1)
            com.google.android.recaptcha.internal.zzja r1 = r5.zzc
            com.google.android.recaptcha.internal.zzcb r1 = r1.zzm()
            com.google.android.recaptcha.internal.zzje r2 = com.google.android.recaptcha.internal.zzje.zza
            r5.zza = r6
            r3 = 3
            r5.zzb = r3
            java.lang.Object r1 = r1.zzc(r2, r5)
            if (r1 != r0) goto L68
        L67:
            return r0
        L68:
            r0 = r6
        L69:
            com.google.android.recaptcha.internal.zzen r6 = r5.zzd
            r6.zzb(r0)
        L6e:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zziz.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
