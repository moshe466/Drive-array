package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzavc {
    private long zzdpw = -1;
    private long zzdpx = -1;
    private final /* synthetic */ zzavd zzdpy;

    public zzavc(zzavd zzavdVar) {
        this.zzdpy = zzavdVar;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzdpw);
        bundle.putLong("tclose", this.zzdpx);
        return bundle;
    }

    public final long zzus() {
        return this.zzdpx;
    }

    public final void zzut() {
        Clock clock;
        clock = this.zzdpy.zzbmq;
        this.zzdpx = clock.elapsedRealtime();
    }

    public final void zzuu() {
        Clock clock;
        clock = this.zzdpy.zzbmq;
        this.zzdpw = clock.elapsedRealtime();
    }
}
