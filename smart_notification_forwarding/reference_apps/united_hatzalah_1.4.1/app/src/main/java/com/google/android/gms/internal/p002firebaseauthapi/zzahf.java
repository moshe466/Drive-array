package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzahf {
    private List<zzahc> zza;

    public zzahf() {
        this.zza = new ArrayList();
    }

    public final List<zzahc> zza() {
        return this.zza;
    }

    public zzahf(List<zzahc> list) {
        this.zza = Collections.unmodifiableList(list);
    }
}
