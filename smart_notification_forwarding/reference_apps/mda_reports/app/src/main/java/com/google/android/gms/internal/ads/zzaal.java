package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* loaded from: classes.dex */
public final class zzaal extends zzaaj {
    private final OnCustomRenderedAdLoadedListener zzcen;

    public zzaal(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcen = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final void zza(zzaaf zzaafVar) {
        this.zzcen.onCustomRenderedAdLoaded(new zzaag(zzaafVar));
    }
}
