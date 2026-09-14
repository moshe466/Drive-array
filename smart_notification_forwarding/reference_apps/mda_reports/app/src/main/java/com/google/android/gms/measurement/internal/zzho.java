package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzho implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzhb zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzho(zzhb zzhbVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zzhbVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.a.zzw().a(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
