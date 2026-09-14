package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcd implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzca zza;

    public zzcd(zzca zzcaVar) {
        this.zza = zzcaVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z3) {
        boolean zzb;
        zzaq zzaqVar;
        if (z3) {
            this.zza.zzc = true;
            this.zza.zza();
            return;
        }
        this.zza.zzc = false;
        zzb = this.zza.zzb();
        if (zzb) {
            zzaqVar = this.zza.zzb;
            zzaqVar.zzc();
        }
    }
}
