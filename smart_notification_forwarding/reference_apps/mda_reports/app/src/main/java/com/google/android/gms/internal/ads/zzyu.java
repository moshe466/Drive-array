package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzyu extends zzadz {
    private final ShouldDelayBannerRenderingListener zzcfs;

    public zzyu(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzcfs = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        return this.zzcfs.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
