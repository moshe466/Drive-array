package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzqa {
    private final Class<?> zza;
    private final Class<?> zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqa)) {
            return false;
        }
        zzqa zzqaVar = (zzqa) obj;
        if (!zzqaVar.zza.equals(this.zza) || !zzqaVar.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return AbstractC0008a.o(this.zza.getSimpleName(), " with primitive type: ", this.zzb.getSimpleName());
    }

    private zzqa(Class<?> cls, Class<?> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
