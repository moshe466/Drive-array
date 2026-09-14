package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzom {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzoj zza() {
        if (this.zza != null) {
            zzoj zzojVar = new zzoj(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzojVar;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
