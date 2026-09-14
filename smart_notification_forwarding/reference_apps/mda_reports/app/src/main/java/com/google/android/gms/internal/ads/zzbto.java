package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes.dex */
final /* synthetic */ class zzbto implements zzbrn {
    static final zzbrn a = new zzbto();

    private zzbto() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final void zzp(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoStart();
    }
}
