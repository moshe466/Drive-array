package com.google.android.recaptcha.internal;

import T.b;
import Y2.a;
import Y2.e;
import android.app.Application;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.j;
import w2.InterfaceC0763d;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public final class zzcv {
    private final Application zza;
    private zzdc zzc;
    private final a zzb = e.a();
    private final String zzd = UUID.randomUUID().toString();
    private zzbi zzf = new zzbi();
    private final zzl zze = new zzl(null, 1, null);

    public zzcv(Application application) {
        Map map;
        Map map2;
        this.zza = application;
        int i = zzav.zza;
        zzaw[] zzawVarArr = {new zzaw(915034652, new zzaz(null, 1, null)), new zzaw(915034802, new zzfu()), new zzaw(915034662, new zzbe()), new zzaw(915034909, new zzjd()), new zzaw(915034675, new zzbr("https://www.recaptcha.net/recaptcha/api3")), new zzaw(915034774, new zzex(null, 1, null)), new zzaw(915034792, new zzfk(true)), new zzaw(735120228, application), new zzaw(915034663, new zzbf(application)), new zzaw(915034791, new zzfj()), new zzaw(915034643, new zzbm(application)), new zzaw(915034775, new zzfa()), new zzaw(915034787, new zzff())};
        for (int i3 = 0; i3 < 13; i3++) {
            zzaw zzawVar = zzawVarArr[i3];
            map = zzav.zzc;
            if (!map.containsKey(Integer.valueOf(zzawVar.zza()))) {
                map2 = zzav.zzc;
                map2.put(Integer.valueOf(zzawVar.zza()), zzawVar);
            }
        }
    }

    public static final /* synthetic */ zzdc zza(zzcv zzcvVar, String str) {
        zzdc zzdcVar = zzcvVar.zzc;
        if (zzdcVar == null) {
            return null;
        }
        if (j.a(zzdcVar.zzd(), str)) {
            return zzdcVar;
        }
        throw new zzbd(zzbb.zzd, zzba.zzam, null);
    }

    public static final /* synthetic */ void zzc(zzcv zzcvVar, long j2) {
        if (j2 >= 5000) {
            if (AbstractC0773d.a(zzcvVar.zza, "android.permission.INTERNET") == 0) {
                return;
            } else {
                throw new zzbd(zzbb.zzc, zzba.zzao, null);
            }
        }
        throw new zzbd(zzbb.zzj, zzba.zzI, null);
    }

    public static final /* synthetic */ zzcn zze(zzcv zzcvVar, String str, zzbi zzbiVar, zzch zzchVar, zzek zzekVar) {
        zzdt zzdtVar = new zzdt(str, zzbiVar, zzekVar, zzcvVar.zze);
        if (j.a(zzchVar, zzch.zza)) {
            return new zzef(zzdtVar);
        }
        return new zzec(zzdtVar, zzbiVar, zzekVar, new zzbo());
    }

    public static /* synthetic */ Object zzh(zzcv zzcvVar, String str, long j2, zzcn zzcnVar, zzbi zzbiVar, zzch zzchVar, InterfaceC0763d interfaceC0763d, int i, Object obj) {
        if ((i & 8) != 0) {
            zzbiVar = zzcvVar.zzf;
        }
        zzbi zzbiVar2 = zzbiVar;
        if ((i & 16) != 0) {
            zzchVar = zzch.zza;
        }
        zzch zzchVar2 = zzchVar;
        if ((i & 2) != 0) {
            j2 = 10000;
        }
        return zzcvVar.zzg(str, j2, null, zzbiVar2, zzchVar2, interfaceC0763d);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzj(java.lang.String r6, int r7, F2.p r8, w2.InterfaceC0763d r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzcu
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzcu r0 = (com.google.android.recaptcha.internal.zzcu) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzcu r0 = new com.google.android.recaptcha.internal.zzcu
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.zza
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            a.AbstractC0228a.C(r9)     // Catch: java.lang.Exception -> L29 com.google.android.recaptcha.internal.zzbd -> L2b
            goto L4e
        L29:
            r7 = move-exception
            goto L5a
        L2b:
            r7 = move-exception
            goto L72
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            a.AbstractC0228a.C(r9)
            com.google.android.recaptcha.internal.zzbi r9 = r5.zzf
            com.google.android.recaptcha.internal.zzek r6 = r5.zzk(r6, r9, r7)
            r7 = 6
            com.google.android.recaptcha.internal.zzen r7 = r6.zzf(r7)
            r0.zzd = r7     // Catch: java.lang.Exception -> L53 com.google.android.recaptcha.internal.zzbd -> L55
            r0.zzc = r3     // Catch: java.lang.Exception -> L53 com.google.android.recaptcha.internal.zzbd -> L55
            java.lang.Object r9 = r8.invoke(r6, r0)     // Catch: java.lang.Exception -> L53 com.google.android.recaptcha.internal.zzbd -> L55
            if (r9 == r1) goto L52
            r6 = r7
        L4e:
            r6.zza()     // Catch: java.lang.Exception -> L29 com.google.android.recaptcha.internal.zzbd -> L2b
            return r9
        L52:
            return r1
        L53:
            r6 = move-exception
            goto L57
        L55:
            r6 = move-exception
            goto L6f
        L57:
            r4 = r7
            r7 = r6
            r6 = r4
        L5a:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zza
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            com.google.android.recaptcha.RecaptchaException r6 = r8.zzc()
            throw r6
        L6f:
            r4 = r7
            r7 = r6
            r6 = r4
        L72:
            r6.zzb(r7)
            com.google.android.recaptcha.RecaptchaException r6 = r7.zzc()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzj(java.lang.String, int, F2.p, w2.d):java.lang.Object");
    }

    private final zzek zzk(String str, zzbi zzbiVar, int i) {
        String uuid = UUID.randomUUID().toString();
        int i3 = zzav.zza;
        zzes zzesVar = new zzes(this.zza, new zzeu(((zzbr) b.A(zzcr.zza).a()).zzc()), zzbiVar.zza());
        zzek zzekVar = new zzek(str, this.zzd, uuid, i, this.zza, zzesVar, null);
        zzekVar.zzc(uuid);
        return zzekVar;
    }

    public final zzbi zzd() {
        return this.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:25:0x0084, B:28:0x0099, B:33:0x008e), top: B:24:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzg(java.lang.String r18, long r19, com.google.android.recaptcha.internal.zzcn r21, com.google.android.recaptcha.internal.zzbi r22, com.google.android.recaptcha.internal.zzch r23, w2.InterfaceC0763d r24) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzg(java.lang.String, long, com.google.android.recaptcha.internal.zzcn, com.google.android.recaptcha.internal.zzbi, com.google.android.recaptcha.internal.zzch, w2.d):java.lang.Object");
    }
}
