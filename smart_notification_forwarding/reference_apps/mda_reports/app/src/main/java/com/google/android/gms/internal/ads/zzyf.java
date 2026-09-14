package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzyf extends zzwj {
    private zzagu zzcfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        zzagu zzaguVar = this.zzcfl;
        if (zzaguVar != null) {
            try {
                zzaguVar.zzc(Collections.emptyList());
            } catch (RemoteException e) {
                zzayu.zzd("Could not notify onComplete event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final String getVersionString() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void initialize() {
        zzayu.zzex("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzayk.zzyu.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzyi
            private final zzyf zzcfn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcfn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcfn.c();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void setAppMuted(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void setAppVolume(float f) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzagu zzaguVar) {
        this.zzcfl = zzaguVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzalc zzalcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(zzyq zzyqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzcd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzce(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final float zzpe() {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzpf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final List<zzagn> zzpg() {
        return Collections.emptyList();
    }
}
