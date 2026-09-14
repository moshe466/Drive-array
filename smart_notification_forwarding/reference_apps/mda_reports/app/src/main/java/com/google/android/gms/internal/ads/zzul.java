package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* loaded from: classes.dex */
public final class zzul extends zzwb {
    private final AppEventListener zzbkj;

    public zzul(AppEventListener appEventListener) {
        this.zzbkj = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbkj;
    }

    @Override // com.google.android.gms.internal.ads.zzwc
    public final void onAppEvent(String str, String str2) {
        this.zzbkj.onAppEvent(str, str2);
    }
}
