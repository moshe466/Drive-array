package com.google.android.recaptcha.internal;

import P2.G;
import android.app.Application;
import com.google.android.gms.tasks.Task;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzcq {
    private static zzcv zza;

    public static final zzcv zza(Application application) {
        zzcv zzcvVar = zza;
        if (zzcvVar == null) {
            zzcvVar = new zzcv(application);
        }
        if (zza == null) {
            zza = zzcvVar;
        }
        return zzcvVar;
    }

    public static final Object zzb(Application application, String str, long j2, InterfaceC0763d interfaceC0763d) {
        return zzcv.zzh(zza(application), str, j2, null, null, null, interfaceC0763d, 28, null);
    }

    public static final Task zzc(Application application, String str, long j2) {
        return zzas.zza(G.c(zza(application).zzd().zza(), new zzco(application, str, j2, null)));
    }

    public static final Object zzd(Application application, String str, InterfaceC0763d interfaceC0763d) {
        return zzcv.zzf(zza(application), str, null, null, interfaceC0763d, 6, null);
    }

    public static final Task zze(Application application, String str) {
        return zzas.zza(G.c(zza(application).zzd().zza(), new zzcp(application, str, null)));
    }
}
