package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbtj extends zzbrl<VideoController.VideoLifecycleCallbacks> {

    @GuardedBy("this")
    private boolean zzehh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbtj(Set<zzbsu<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        a(zzbtl.a);
    }

    public final void onVideoPause() {
        a(zzbtm.a);
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzehh) {
            a(zzbtn.a);
            this.zzehh = true;
        }
        a(zzbtq.a);
    }

    public final synchronized void onVideoStart() {
        a(zzbto.a);
        this.zzehh = true;
    }
}
