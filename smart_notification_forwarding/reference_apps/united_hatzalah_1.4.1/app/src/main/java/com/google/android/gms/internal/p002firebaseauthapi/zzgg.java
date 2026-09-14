package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzgg extends zzcx {
    private final zza zza;

    /* loaded from: classes.dex */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzgg(zza zzaVar) {
        this.zza = zzaVar;
    }

    public static zzgg zza(zza zzaVar) {
        return new zzgg(zzaVar);
    }

    public static zzgg zzc() {
        return new zzgg(zza.zzc);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgg) || ((zzgg) obj).zza != this.zza) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(zzgg.class, this.zza);
    }

    public final String toString() {
        return a.e("XChaCha20Poly1305 Parameters (variant: ", String.valueOf(this.zza), ")");
    }

    public final zza zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}
