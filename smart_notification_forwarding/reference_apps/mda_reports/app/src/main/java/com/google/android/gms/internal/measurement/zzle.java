package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzle implements zzcz<zzld> {
    private static zzle zza = new zzle();
    private final zzcz<zzld> zzb;

    public zzle() {
        this(zzdc.zza(new zzlg()));
    }

    private zzle(zzcz<zzld> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public static boolean zzb() {
        return ((zzld) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzld) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzld zza() {
        return this.zzb.zza();
    }
}
