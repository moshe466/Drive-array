package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzoh extends zzce {
    private final zzqd zza;

    public zzoh(zzqd zzqdVar) {
        this.zza = zzqdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoh)) {
            return false;
        }
        zzqd zzqdVar = ((zzoh) obj).zza;
        if (!this.zza.zza().zzd().equals(zzqdVar.zza().zzd()) || !this.zza.zza().zzf().equals(zzqdVar.zza().zzf()) || !this.zza.zza().zze().equals(zzqdVar.zza().zze())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zza.zza(), this.zza.zzb());
    }

    public final String toString() {
        String str;
        String zzf = this.zza.zza().zzf();
        int i = zzok.zza[this.zza.zza().zzd().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "UNKNOWN";
                    } else {
                        str = "CRUNCHY";
                    }
                } else {
                    str = "RAW";
                }
            } else {
                str = "LEGACY";
            }
        } else {
            str = "TINK";
        }
        return AbstractC0008a.p("(typeUrl=", zzf, ", outputPrefixType=", str, ")");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final boolean zza() {
        if (this.zza.zza().zzd() != zzxu.RAW) {
            return true;
        }
        return false;
    }

    public final zzqd zzb() {
        return this.zza;
    }
}
