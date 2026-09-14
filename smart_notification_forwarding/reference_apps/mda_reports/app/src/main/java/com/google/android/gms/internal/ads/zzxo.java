package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzxo extends zzvd {
    private final /* synthetic */ zzxl zzcew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxo(zzxl zzxlVar) {
        this.zzcew = zzxlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvd, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        VideoController videoController;
        videoController = this.zzcew.zzcel;
        videoController.zza(this.zzcew.zzdl());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzvd, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.zzcew.zzcel;
        videoController.zza(this.zzcew.zzdl());
        super.onAdLoaded();
    }
}
