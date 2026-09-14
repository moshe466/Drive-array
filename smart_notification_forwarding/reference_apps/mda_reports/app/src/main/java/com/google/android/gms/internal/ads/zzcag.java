package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* loaded from: classes.dex */
final class zzcag implements zzabw {
    private final /* synthetic */ zzcad zzfqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcag(zzcad zzcadVar) {
        this.zzfqe = zzcadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void zzrd() {
        zzbwk zzbwkVar;
        zzbwkVar = this.zzfqe.zzfnf;
        zzbwkVar.zzfu(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }
}
