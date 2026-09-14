package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes.dex */
final /* synthetic */ class zzbtl implements zzbrn {
    static final zzbrn a = new zzbtl();

    private zzbtl() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final void zzp(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoEnd();
    }
}
