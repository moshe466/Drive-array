package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaos;
import com.google.android.gms.internal.ads.zzty;

/* loaded from: classes.dex */
public final class zzu extends zzaos {
    private AdOverlayInfoParcel zzdia;
    private Activity zzzk;
    private boolean zzdgt = false;
    private boolean zzdib = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdia = adOverlayInfoParcel;
        this.zzzk = activity;
    }

    private final synchronized void zztw() {
        if (!this.zzdib) {
            if (this.zzdia.zzdhq != null) {
                this.zzdia.zzdhq.zzte();
            }
            this.zzdib = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onBackPressed() {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onCreate(Bundle bundle) {
        zzo zzoVar;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdia;
        if (adOverlayInfoParcel == null || z) {
            this.zzzk.finish();
            return;
        }
        if (bundle == null) {
            zzty zztyVar = adOverlayInfoParcel.zzcbt;
            if (zztyVar != null) {
                zztyVar.onAdClicked();
            }
            if (this.zzzk.getIntent() != null && this.zzzk.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzoVar = this.zzdia.zzdhq) != null) {
                zzoVar.zztf();
            }
        }
        com.google.android.gms.ads.internal.zzq.zzko();
        Activity activity = this.zzzk;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdia;
        if (zzb.zza(activity, adOverlayInfoParcel2.zzdhp, adOverlayInfoParcel2.zzdhu)) {
            return;
        }
        this.zzzk.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onDestroy() {
        if (this.zzzk.isFinishing()) {
            zztw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onPause() {
        zzo zzoVar = this.zzdia.zzdhq;
        if (zzoVar != null) {
            zzoVar.onPause();
        }
        if (this.zzzk.isFinishing()) {
            zztw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onResume() {
        if (this.zzdgt) {
            this.zzzk.finish();
            return;
        }
        this.zzdgt = true;
        zzo zzoVar = this.zzdia.zzdhq;
        if (zzoVar != null) {
            zzoVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdgt);
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void onStop() {
        if (this.zzzk.isFinishing()) {
            zztw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzad(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final void zzdf() {
    }

    @Override // com.google.android.gms.internal.ads.zzaot
    public final boolean zztm() {
        return false;
    }
}
