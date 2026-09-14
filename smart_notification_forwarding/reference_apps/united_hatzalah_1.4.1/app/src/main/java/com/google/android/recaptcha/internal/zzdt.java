package com.google.android.recaptcha.internal;

import P2.G;
import T.b;
import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.recaptcha.RecaptchaAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import s2.C0682g;
import s2.InterfaceC0678c;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.u;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzdt {
    private final String zza;
    private final zzek zzb;
    private final zzl zzc;
    private final InterfaceC0678c zzd;
    private final InterfaceC0678c zze;
    private final InterfaceC0678c zzf;
    private final InterfaceC0678c zzg;
    private final InterfaceC0678c zzh;
    private final zzbi zzi;

    public zzdt(String str, zzbi zzbiVar, zzek zzekVar, zzl zzlVar) {
        this.zza = str;
        this.zzi = zzbiVar;
        this.zzb = zzekVar;
        this.zzc = zzlVar;
        int i = zzav.zza;
        this.zzd = b.A(zzdm.zza);
        this.zze = b.A(zzdn.zza);
        this.zzf = b.A(zzdo.zza);
        this.zzg = b.A(zzdp.zza);
        this.zzh = b.A(zzdq.zza);
    }

    public static final /* synthetic */ zzbr zzd(zzdt zzdtVar) {
        return (zzbr) ((C0682g) zzdtVar.zze).a();
    }

    public static final /* synthetic */ zzff zzg(zzdt zzdtVar) {
        return (zzff) ((C0682g) zzdtVar.zzd).a();
    }

    public static final /* synthetic */ zzfj zzh(zzdt zzdtVar) {
        return (zzfj) ((C0682g) zzdtVar.zzg).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application zzr() {
        return (Application) ((C0682g) this.zzh).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbd zzs(Exception exc, zzbd zzbdVar) {
        if (!zzx()) {
            return new zzbd(zzbb.zzc, zzba.zzao, exc.getMessage());
        }
        return zzbdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbf zzt() {
        return (zzbf) ((C0682g) this.zzf).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzek zzu(String str) {
        zzek zza = this.zzb.zza();
        zza.zzc(str);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzv(com.google.android.recaptcha.internal.zzsc r9, long r10, w2.InterfaceC0763d r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.google.android.recaptcha.internal.zzdj
            if (r0 == 0) goto L14
            r0 = r12
            com.google.android.recaptcha.internal.zzdj r0 = (com.google.android.recaptcha.internal.zzdj) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.zzd = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.google.android.recaptcha.internal.zzdj r0 = new com.google.android.recaptcha.internal.zzdj
            r0.<init>(r8, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.zzb
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r6.zzd
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L45
            if (r1 == r2) goto L39
            if (r1 == r7) goto L30
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L30:
            java.lang.Object r9 = r6.zza
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            a.AbstractC0228a.C(r12)
            goto Lbd
        L39:
            java.lang.Object r9 = r6.zza
            com.google.android.recaptcha.internal.zzdt r9 = (com.google.android.recaptcha.internal.zzdt) r9
            a.AbstractC0228a.C(r12)
            s2.f r12 = (s2.C0681f) r12
            java.lang.Object r10 = r12.f6335a
            goto L7f
        L45:
            a.AbstractC0228a.C(r12)
            java.lang.String r12 = r9.zzO()
            zzy(r12)
            java.util.List r12 = r8.zzw()
            java.util.Iterator r12 = r12.iterator()
        L57:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r12.next()
            com.google.android.recaptcha.internal.zze r1 = (com.google.android.recaptcha.internal.zze) r1
            com.google.android.recaptcha.internal.zzl r3 = r8.zzc
            com.google.android.recaptcha.internal.zze[] r1 = new com.google.android.recaptcha.internal.zze[]{r1}
            r3.zzf(r1)
            goto L57
        L6d:
            com.google.android.recaptcha.internal.zzl r1 = r8.zzc
            com.google.android.recaptcha.internal.zzek r5 = r8.zzb
            r6.zza = r8
            r6.zzd = r2
            r4 = r9
            r2 = r10
            java.lang.Object r10 = r1.zzc(r2, r4, r5, r6)
            if (r10 != r0) goto L7e
            goto Lbb
        L7e:
            r9 = r8
        L7f:
            java.lang.Throwable r10 = s2.C0681f.a(r10)
            if (r10 != 0) goto L88
            s2.i r9 = s2.C0684i.f6340a
            return r9
        L88:
            com.google.android.recaptcha.internal.zzbi r11 = r9.zzi
            P2.E r11 = r11.zzd()
            w2.i r11 = r11.a()
            P2.G.f(r11)
            com.google.android.recaptcha.internal.zzbi r9 = r9.zzi
            P2.E r9 = r9.zzd()
            w2.i r9 = r9.a()
            P2.B r11 = P2.B.f1595b
            w2.g r11 = r9.get(r11)
            P2.i0 r11 = (P2.InterfaceC0157i0) r11
            if (r11 == 0) goto Lbe
            M2.d r9 = r11.getChildren()
            java.util.List r9 = M2.f.B(r9)
            r6.zza = r10
            r6.zzd = r7
            java.lang.Object r9 = P2.G.p(r9, r6)
            if (r9 != r0) goto Lbc
        Lbb:
            return r0
        Lbc:
            r9 = r10
        Lbd:
            throw r9
        Lbe:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Current context doesn't contain Job in it: "
            r11.<init>(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzv(com.google.android.recaptcha.internal.zzsc, long, w2.d):java.lang.Object");
    }

    private final List zzw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzv(zzr(), this.zzb.zza(), this.zzi, null, 8, null));
        arrayList.add(new zzja(this.zzb, this.zzi));
        return AbstractC0707i.q0(arrayList);
    }

    private final boolean zzx() {
        NetworkCapabilities networkCapabilities;
        int i = zzav.zza;
        try {
            Object systemService = zzr().getSystemService("connectivity");
            j.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static final void zzy(String str) {
        try {
            zzrv zzj = zzrv.zzj(zzbt.zza(str));
            int i = zzav.zza;
            ((zzfu) b.A(zzde.zza).a()).zza(zzj);
        } catch (Exception e4) {
            throw new zzbd(zzbb.zzl, zzba.zzan, e4.getMessage());
        }
    }

    public final zzsp zzi(RecaptchaAction recaptchaAction, zzsi zzsiVar, zzsc zzscVar) {
        zzso zzf = zzsp.zzf();
        zzf.zzs(this.zza);
        zzf.zze(recaptchaAction.getAction());
        zzf.zzf(zzscVar.zzN());
        zzf.zzq(zzscVar.zzM());
        zzf.zzr(zzsiVar);
        return (zzsp) zzf.zzk();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzl(java.lang.String r6, long r7, w2.InterfaceC0763d r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdd
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzdd r0 = (com.google.android.recaptcha.internal.zzdd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdd r0 = new com.google.android.recaptcha.internal.zzdd
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            a.AbstractC0228a.C(r9)     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2b com.google.android.recaptcha.internal.zzbd -> L2d
            goto L53
        L29:
            r7 = move-exception
            goto L64
        L2b:
            r7 = move-exception
            goto L76
        L2d:
            r7 = move-exception
            goto L88
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            a.AbstractC0228a.C(r9)
            com.google.android.recaptcha.internal.zzek r9 = r5.zzu(r6)
            r2 = 27
            com.google.android.recaptcha.internal.zzen r9 = r9.zzf(r2)
            com.google.android.recaptcha.internal.zzl r2 = r5.zzc     // Catch: java.lang.Exception -> L5a kotlinx.coroutines.TimeoutCancellationException -> L5d com.google.android.recaptcha.internal.zzbd -> L60
            r0.zzd = r9     // Catch: java.lang.Exception -> L5a kotlinx.coroutines.TimeoutCancellationException -> L5d com.google.android.recaptcha.internal.zzbd -> L60
            r0.zzc = r3     // Catch: java.lang.Exception -> L5a kotlinx.coroutines.TimeoutCancellationException -> L5d com.google.android.recaptcha.internal.zzbd -> L60
            java.lang.Object r6 = r2.zzb(r6, r7, r0)     // Catch: java.lang.Exception -> L5a kotlinx.coroutines.TimeoutCancellationException -> L5d com.google.android.recaptcha.internal.zzbd -> L60
            if (r6 == r1) goto L59
            r4 = r9
            r9 = r6
            r6 = r4
        L53:
            com.google.android.recaptcha.internal.zzsi r9 = (com.google.android.recaptcha.internal.zzsi) r9     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2b com.google.android.recaptcha.internal.zzbd -> L2d
            r6.zza()     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2b com.google.android.recaptcha.internal.zzbd -> L2d
            return r9
        L59:
            return r1
        L5a:
            r6 = move-exception
            r7 = r6
            goto L63
        L5d:
            r6 = move-exception
            r7 = r6
            goto L75
        L60:
            r6 = move-exception
            r7 = r6
            goto L87
        L63:
            r6 = r9
        L64:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzaa
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L75:
            r6 = r9
        L76:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L87:
            r6 = r9
        L88:
            r6.zzb(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzl(java.lang.String, long, w2.d):java.lang.Object");
    }

    public final Object zzm(zzsp zzspVar, String str, long j2, InterfaceC0763d interfaceC0763d) {
        return G.z(this.zzi.zza().a(), new zzdg(this, str, j2, zzspVar, null), interfaceC0763d);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzn(com.google.android.recaptcha.internal.zzsc r11, long r12, w2.InterfaceC0763d r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzdk
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzdk r0 = (com.google.android.recaptcha.internal.zzdk) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdk r0 = new com.google.android.recaptcha.internal.zzdk
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            a.AbstractC0228a.C(r14)     // Catch: java.lang.Exception -> L27 kotlinx.coroutines.TimeoutCancellationException -> L2a com.google.android.recaptcha.internal.zzbd -> L2d
            goto L4d
        L27:
            r0 = move-exception
            r11 = r0
            goto L50
        L2a:
            r0 = move-exception
            r11 = r0
            goto L5e
        L2d:
            r0 = move-exception
            r11 = r0
            goto L6c
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            a.AbstractC0228a.C(r14)
            com.google.android.recaptcha.internal.zzdl r4 = new com.google.android.recaptcha.internal.zzdl     // Catch: java.lang.Exception -> L27 kotlinx.coroutines.TimeoutCancellationException -> L2a com.google.android.recaptcha.internal.zzbd -> L2d
            r9 = 0
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r9)     // Catch: java.lang.Exception -> L27 kotlinx.coroutines.TimeoutCancellationException -> L2a com.google.android.recaptcha.internal.zzbd -> L2d
            r0.zzc = r3     // Catch: java.lang.Exception -> L27 kotlinx.coroutines.TimeoutCancellationException -> L2a com.google.android.recaptcha.internal.zzbd -> L2d
            java.lang.Object r11 = P2.G.A(r7, r4, r0)     // Catch: java.lang.Exception -> L27 kotlinx.coroutines.TimeoutCancellationException -> L2a com.google.android.recaptcha.internal.zzbd -> L2d
            if (r11 != r1) goto L4d
            return r1
        L4d:
            s2.i r11 = s2.C0684i.f6340a
            return r11
        L50:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzap
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L5e:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L6c:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzn(com.google.android.recaptcha.internal.zzsc, long, w2.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzo(long r6, w2.InterfaceC0763d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzdr
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.internal.zzdr r0 = (com.google.android.recaptcha.internal.zzdr) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdr r0 = new com.google.android.recaptcha.internal.zzdr
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            com.google.android.recaptcha.internal.zzen r6 = r0.zze
            com.google.android.recaptcha.internal.zzdt r7 = r0.zzd
            a.AbstractC0228a.C(r8)     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d com.google.android.recaptcha.internal.zzbd -> L2f
            goto L5b
        L2b:
            r8 = move-exception
            goto L69
        L2d:
            r8 = move-exception
            goto L82
        L2f:
            r8 = move-exception
            goto L9b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            a.AbstractC0228a.C(r8)
            com.google.android.recaptcha.internal.zzek r8 = r5.zzb
            r2 = 22
            com.google.android.recaptcha.internal.zzen r8 = r8.zzf(r2)
            com.google.android.recaptcha.internal.zzds r2 = new com.google.android.recaptcha.internal.zzds     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            r4 = 0
            r2.<init>(r5, r8, r4)     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            r0.zzd = r5     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            r0.zze = r8     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            r0.zzc = r3     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            java.lang.Object r6 = P2.G.A(r6, r2, r0)     // Catch: java.lang.Exception -> L5f kotlinx.coroutines.TimeoutCancellationException -> L61 com.google.android.recaptcha.internal.zzbd -> L63
            if (r6 == r1) goto L5e
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L5b:
            com.google.android.recaptcha.internal.zzsc r8 = (com.google.android.recaptcha.internal.zzsc) r8     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d com.google.android.recaptcha.internal.zzbd -> L2f
            return r8
        L5e:
            return r1
        L5f:
            r6 = move-exception
            goto L65
        L61:
            r6 = move-exception
            goto L7e
        L63:
            r6 = move-exception
            goto L97
        L65:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L69:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r2 = com.google.android.recaptcha.internal.zzba.zzaw
            java.lang.String r3 = r8.getMessage()
            r0.<init>(r1, r2, r3)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r8, r0)
            r6.zzb(r7)
            throw r7
        L7e:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L82:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r2 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r3 = r8.getMessage()
            r0.<init>(r1, r2, r3)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r8, r0)
            r6.zzb(r7)
            throw r7
        L97:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L9b:
            com.google.android.recaptcha.internal.zzbb r0 = r8.zzb()
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            if (r0 == 0) goto Lab
            com.google.android.recaptcha.internal.zzbd r8 = r7.zzs(r8, r8)
        Lab:
            r6.zzb(r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzo(long, w2.d):java.lang.Object");
    }

    public final void zzq(String str, zzsr zzsrVar) {
        zzen zzf = zzu(str).zzf(29);
        try {
            List<zzst> zzk = zzsrVar.zzk();
            int F3 = u.F(AbstractC0709k.Y(zzk, 10));
            if (F3 < 16) {
                F3 = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(F3);
            for (zzst zzstVar : zzk) {
                linkedHashMap.put(zzstVar.zzg(), zzstVar.zzi());
            }
            zzt().zzb(linkedHashMap);
            this.zzc.zzg(zzsrVar);
            zzf.zza();
        } catch (zzbd e4) {
            zzf.zzb(e4);
        } catch (Exception e5) {
            zzf.zzb(new zzbd(zzbb.zzb, zzba.zzas, e5.getMessage()));
        }
    }
}
