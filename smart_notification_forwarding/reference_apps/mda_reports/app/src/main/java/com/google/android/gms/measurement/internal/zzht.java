package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzht implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzht(zzhb zzhbVar, boolean z) {
        this.zzb = zzhbVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zzab = this.zzb.a.zzab();
        boolean zzaa = this.zzb.a.zzaa();
        this.zzb.a.a(this.zza);
        if (zzaa == this.zza) {
            this.zzb.a.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.a.zzab() == zzab || this.zzb.a.zzab() != this.zzb.a.zzaa()) {
            this.zzb.a.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzab));
        }
        this.zzb.zzam();
    }
}
