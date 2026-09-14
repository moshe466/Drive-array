package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzakk {
    static final zzakk zza = new zzakk(true);
    private static volatile boolean zzb = false;
    private final Map<zzakn, zzaky.zzd<?, ?>> zzc;

    public zzakk() {
        this.zzc = new HashMap();
    }

    public static zzakk zza() {
        return zza;
    }

    public final <ContainingType extends zzamc> zzaky.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzaky.zzd) this.zzc.get(new zzakn(containingtype, i));
    }

    private zzakk(boolean z3) {
        this.zzc = Collections.EMPTY_MAP;
    }
}
