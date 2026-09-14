package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zziy extends AbstractC0793i implements p {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    int zze;
    final /* synthetic */ zzja zzf;
    final /* synthetic */ zzen zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziy(zzja zzjaVar, zzen zzenVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzf = zzjaVar;
        this.zzg = zzenVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zziy(this.zzf, this.zzg, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zziy) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00d0, code lost:
    
        r8.zzg.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00d7, code lost:
    
        return s2.C0684i.f6340a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00bc, code lost:
    
        if (((P2.C0169t) r9).j(r8) != r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
    
        if (r9 != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r1 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00be, code lost:
    
        r9 = r8.zzf.zzm();
        r1 = com.google.android.recaptcha.internal.zzje.zzc;
        r8.zze = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00cd, code lost:
    
        if (r9.zzc(r1, r8) != r0) goto L29;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r8.zze
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L29
            if (r1 == r4) goto L15
            a.AbstractC0228a.C(r9)
            if (r1 == r3) goto L9f
            if (r1 == r2) goto Lbe
            goto Ld0
        L15:
            java.lang.Object r1 = r8.zzd
            com.google.android.recaptcha.internal.zzcg r1 = (com.google.android.recaptcha.internal.zzcg) r1
            java.lang.Object r4 = r8.zzc
            com.google.android.recaptcha.internal.zzsc r4 = (com.google.android.recaptcha.internal.zzsc) r4
            java.lang.Object r6 = r8.zzb
            com.google.android.recaptcha.internal.zzja r6 = (com.google.android.recaptcha.internal.zzja) r6
            java.lang.Object r7 = r8.zza
            com.google.android.recaptcha.internal.zzja r7 = (com.google.android.recaptcha.internal.zzja) r7
            a.AbstractC0228a.C(r9)
            goto L5d
        L29:
            a.AbstractC0228a.C(r9)
            com.google.android.recaptcha.internal.zzja r6 = r8.zzf
            com.google.android.recaptcha.internal.zzsc r9 = com.google.android.recaptcha.internal.zzja.zzs(r6)
            if (r9 != 0) goto L35
            r9 = r5
        L35:
            com.google.android.recaptcha.internal.zzja r1 = r8.zzf
            com.google.android.recaptcha.internal.zzcg r7 = new com.google.android.recaptcha.internal.zzcg
            com.google.android.recaptcha.internal.zzsc r1 = com.google.android.recaptcha.internal.zzja.zzs(r1)
            if (r1 != 0) goto L40
            r1 = r5
        L40:
            com.google.android.recaptcha.internal.zzle r1 = r1.zzf()
            r7.<init>(r1)
            com.google.android.recaptcha.internal.zzja r1 = r8.zzf
            r8.zza = r6
            r8.zzb = r6
            r8.zzc = r9
            r8.zzd = r7
            r8.zze = r4
            java.lang.Object r1 = r1.zzw(r8)
            if (r1 == r0) goto Ld8
            r4 = r9
            r9 = r1
            r1 = r7
            r7 = r6
        L5d:
            android.webkit.WebView r9 = (android.webkit.WebView) r9
            com.google.android.recaptcha.internal.zzft r9 = r6.zzC(r4, r1, r9)
            r7.zzb = r9
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            P2.s r9 = r9.zzA()
            int r9 = r9.hashCode()
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r9)
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            com.google.android.recaptcha.internal.zzjh r9 = com.google.android.recaptcha.internal.zzja.zzr(r9)
            r9.zzd()
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            com.google.android.recaptcha.internal.zzjh r9 = com.google.android.recaptcha.internal.zzja.zzr(r9)
            r9.zze()
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            com.google.android.recaptcha.internal.zzsc r1 = com.google.android.recaptcha.internal.zzja.zzs(r9)
            if (r1 != 0) goto L8f
            r1 = r5
        L8f:
            r8.zza = r5
            r8.zzb = r5
            r8.zzc = r5
            r8.zzd = r5
            r8.zze = r3
            java.lang.Object r9 = com.google.android.recaptcha.internal.zzja.zzt(r9, r1, r8)
            if (r9 == r0) goto Ld8
        L9f:
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            P2.s r9 = r9.zzA()
            int r9 = r9.hashCode()
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r9)
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            P2.s r9 = r9.zzA()
            r8.zze = r2
            P2.t r9 = (P2.C0169t) r9
            java.lang.Object r9 = r9.j(r8)
            if (r9 == r0) goto Ld8
        Lbe:
            com.google.android.recaptcha.internal.zzja r9 = r8.zzf
            com.google.android.recaptcha.internal.zzcb r9 = r9.zzm()
            com.google.android.recaptcha.internal.zzje r1 = com.google.android.recaptcha.internal.zzje.zzc
            r2 = 4
            r8.zze = r2
            java.lang.Object r9 = r9.zzc(r1, r8)
            if (r9 != r0) goto Ld0
            goto Ld8
        Ld0:
            com.google.android.recaptcha.internal.zzen r9 = r8.zzg
            r9.zza()
            s2.i r9 = s2.C0684i.f6340a
            return r9
        Ld8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zziy.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
