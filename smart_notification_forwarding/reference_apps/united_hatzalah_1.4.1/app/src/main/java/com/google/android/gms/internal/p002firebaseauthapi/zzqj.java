package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzqj {
    private final Class<? extends zzqi> zza;
    private final zzaae zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqj)) {
            return false;
        }
        zzqj zzqjVar = (zzqj) obj;
        if (!zzqjVar.zza.equals(this.zza) || !zzqjVar.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return AbstractC0008a.o(this.zza.getSimpleName(), ", object identifier: ", String.valueOf(this.zzb));
    }

    private zzqj(Class<? extends zzqi> cls, zzaae zzaaeVar) {
        this.zza = cls;
        this.zzb = zzaaeVar;
    }
}
