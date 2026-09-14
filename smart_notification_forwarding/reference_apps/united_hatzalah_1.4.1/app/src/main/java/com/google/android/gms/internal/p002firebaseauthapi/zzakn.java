package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
final class zzakn {
    private final Object zza;
    private final int zzb;

    public zzakn(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakn)) {
            return false;
        }
        zzakn zzaknVar = (zzakn) obj;
        if (this.zza != zzaknVar.zza || this.zzb != zzaknVar.zzb) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
