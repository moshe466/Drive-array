package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* loaded from: classes.dex */
public final class zzaeo extends zzadm {
    private final NativeContentAd.OnContentAdLoadedListener zzcwj;

    public zzaeo(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzcwj = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzadj
    public final void zza(zzada zzadaVar) {
        this.zzcwj.onContentAdLoaded(new zzadb(zzadaVar));
    }
}
