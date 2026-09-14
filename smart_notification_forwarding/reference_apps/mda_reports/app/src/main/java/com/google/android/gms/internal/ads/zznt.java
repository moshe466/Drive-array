package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zznt {
    private final Map<String, String> zzbfm = new HashMap();
    private Map<String, String> zzbfn;

    public final synchronized Map<String, String> zzik() {
        if (this.zzbfn == null) {
            this.zzbfn = Collections.unmodifiableMap(new HashMap(this.zzbfm));
        }
        return this.zzbfn;
    }
}
