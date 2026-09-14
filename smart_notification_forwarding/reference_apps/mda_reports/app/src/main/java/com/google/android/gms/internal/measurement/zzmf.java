package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzmf implements zzmg {
    private static final zzcl<Boolean> zza = new zzcr(zzcm.zza("com.google.android.gms.measurement")).zza("measurement.experiment.enable_experiment_reporting", true);

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
