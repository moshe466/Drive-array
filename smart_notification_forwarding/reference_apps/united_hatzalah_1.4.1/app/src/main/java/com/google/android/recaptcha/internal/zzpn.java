package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
final class zzpn extends zzpl {
    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        if (zzpmVar == zzpm.zzc()) {
            zzpm zzf = zzpm.zzf();
            zzndVar.zzc = zzf;
            return zzf;
        }
        return zzpmVar;
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* synthetic */ Object zzb() {
        return zzpm.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* synthetic */ Object zzc(Object obj) {
        zzpm zzpmVar = (zzpm) obj;
        zzpmVar.zzh();
        return zzpmVar;
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i3) {
        ((zzpm) obj).zzj((i << 3) | 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j2) {
        ((zzpm) obj).zzj((i << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzpm) obj).zzj((i << 3) | 3, (zzpm) obj2);
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzle zzleVar) {
        ((zzpm) obj).zzj((i << 3) | 2, zzleVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j2) {
        ((zzpm) obj).zzj(i << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final void zzi(Object obj) {
        ((zznd) obj).zzc.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzpl
    public final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zznd) obj).zzc = (zzpm) obj2;
    }
}
