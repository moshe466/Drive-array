package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;
import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcd extends zzda {
    private final Context zza;
    private final zzdj zzb;

    public zzcd(Context context, zzdj zzdjVar) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzdjVar;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        zzdj zzdjVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzda) {
            zzda zzdaVar = (zzda) obj;
            if (this.zza.equals(zzdaVar.zza()) && ((zzdjVar = this.zzb) != null ? zzdjVar.equals(zzdaVar.zzb()) : zzdaVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdj zzdjVar = this.zzb;
        if (zzdjVar == null) {
            hashCode = 0;
        } else {
            hashCode = zzdjVar.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        return AbstractC0008a.p("FlagsContext{context=", this.zza.toString(), ", hermeticFileOverrides=", String.valueOf(this.zzb), "}");
    }

    @Override // com.google.android.gms.internal.auth.zzda
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.auth.zzda
    public final zzdj zzb() {
        return this.zzb;
    }
}
