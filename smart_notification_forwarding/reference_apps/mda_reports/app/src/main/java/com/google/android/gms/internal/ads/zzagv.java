package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* loaded from: classes.dex */
public final class zzagv implements AdapterStatus {
    private final String description;
    private final int zzcye;
    private final AdapterStatus.State zzcyf;

    public zzagv(AdapterStatus.State state, String str, int i) {
        this.zzcyf = state;
        this.description = str;
        this.zzcye = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzcyf;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzcye;
    }
}
