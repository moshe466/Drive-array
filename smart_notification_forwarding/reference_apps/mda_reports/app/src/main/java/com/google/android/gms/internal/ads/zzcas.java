package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcas implements com.google.android.gms.ads.internal.overlay.zzo, com.google.android.gms.ads.internal.overlay.zzt, zzaew, zzaey, zzty {
    private zzty zzcbt;
    private zzaew zzcwq;
    private zzaey zzcws;
    private com.google.android.gms.ads.internal.overlay.zzo zzdhq;
    private com.google.android.gms.ads.internal.overlay.zzt zzdhu;

    private zzcas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcas(zzcao zzcaoVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zza(zzty zztyVar, zzaew zzaewVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzaey zzaeyVar, com.google.android.gms.ads.internal.overlay.zzt zztVar) {
        this.zzcbt = zztyVar;
        this.zzcwq = zzaewVar;
        this.zzdhq = zzoVar;
        this.zzcws = zzaeyVar;
        this.zzdhu = zztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final synchronized void onAdClicked() {
        if (this.zzcbt != null) {
            this.zzcbt.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaey
    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        if (this.zzcws != null) {
            this.zzcws.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        if (this.zzdhq != null) {
            this.zzdhq.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        if (this.zzdhq != null) {
            this.zzdhq.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzcwq != null) {
            this.zzcwq.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzte() {
        if (this.zzdhq != null) {
            this.zzdhq.zzte();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zztf() {
        if (this.zzdhq != null) {
            this.zzdhq.zztf();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final synchronized void zztv() {
        if (this.zzdhu != null) {
            this.zzdhu.zztv();
        }
    }
}
