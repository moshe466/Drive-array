package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpd extends zzbrl<zzbpe> {
    private boolean zzfhq;

    public zzbpd(Set<zzbsu<zzbpe>> set) {
        super(set);
        this.zzfhq = false;
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfhq) {
            a(zzbpc.a);
            this.zzfhq = true;
        }
    }
}
