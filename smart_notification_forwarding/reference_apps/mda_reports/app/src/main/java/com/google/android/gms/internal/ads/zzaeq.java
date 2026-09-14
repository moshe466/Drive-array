package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* loaded from: classes.dex */
public final class zzaeq extends zzads {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzcwl;

    public zzaeq(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzcwl = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzb(zzade zzadeVar) {
        this.zzcwl.onCustomTemplateAdLoaded(zzadf.zza(zzadeVar));
    }
}
