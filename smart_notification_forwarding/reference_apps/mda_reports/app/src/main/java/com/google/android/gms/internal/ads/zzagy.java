package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzagy implements InitializationStatus {
    private final Map<String, AdapterStatus> zzcyh;

    public zzagy(Map<String, AdapterStatus> map) {
        this.zzcyh = map;
    }

    @Override // com.google.android.gms.ads.initialization.InitializationStatus
    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzcyh;
    }
}
