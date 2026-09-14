package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzaxz {
    private Map<Integer, Bitmap> zzdur = new ConcurrentHashMap();
    private AtomicInteger zzdus = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdur.get(num);
    }
}
