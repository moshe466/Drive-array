package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzfv<T> {
    private final Map<String, AtomicReference<T>> zzaah = new HashMap();

    public final AtomicReference<T> zzav(String str) {
        synchronized (this) {
            if (!this.zzaah.containsKey(str)) {
                this.zzaah.put(str, new AtomicReference<>());
            }
        }
        return this.zzaah.get(str);
    }
}
