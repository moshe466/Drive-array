package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhf implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzhb zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhf(zzhb zzhbVar, String str, String str2, Object obj, long j) {
        this.zze = zzhbVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.a(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
