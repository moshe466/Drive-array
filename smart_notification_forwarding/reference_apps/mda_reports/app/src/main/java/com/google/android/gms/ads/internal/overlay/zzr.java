package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzavs;

/* loaded from: classes.dex */
public final class zzr extends zzc {
    public zzr(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzc, com.google.android.gms.internal.ads.zzaot
    public final void onCreate(Bundle bundle) {
        zzavs.zzed("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = 3;
        this.a.finish();
    }
}
