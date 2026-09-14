package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.FirebaseApp;

/* loaded from: classes.dex */
public final class zzca {
    private volatile int zza;
    private final zzaq zzb;
    private volatile boolean zzc;

    public zzca(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzaq(firebaseApp));
    }

    private zzca(Context context, zzaq zzaqVar) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzaqVar;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzcd(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zza() {
        this.zzb.zzb();
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzb()) {
                this.zzb.zzc();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i;
    }

    public final void zza(zzahn zzahnVar) {
        if (zzahnVar == null) {
            return;
        }
        long zza = zzahnVar.zza();
        if (zza <= 0) {
            zza = 3600;
        }
        long zzb = (zza * 1000) + zzahnVar.zzb();
        zzaq zzaqVar = this.zzb;
        zzaqVar.zza = zzb;
        zzaqVar.zzb = -1L;
        if (zzb()) {
            this.zzb.zzc();
        }
    }
}
