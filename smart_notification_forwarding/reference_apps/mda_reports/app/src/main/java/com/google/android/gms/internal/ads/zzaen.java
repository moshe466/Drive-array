package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* loaded from: classes.dex */
public final class zzaen extends zzadn {
    private final NativeCustomTemplateAd.OnCustomClickListener zzcwi;

    public zzaen(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzcwi = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zza(zzade zzadeVar, String str) {
        this.zzcwi.onCustomClick(zzadf.zza(zzadeVar), str);
    }
}
