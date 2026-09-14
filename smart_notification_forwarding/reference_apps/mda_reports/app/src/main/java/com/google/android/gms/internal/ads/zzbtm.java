package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes.dex */
final /* synthetic */ class zzbtm implements zzbrn {
    static final zzbrn a = new zzbtm();

    private zzbtm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final void zzp(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoPause();
    }
}
