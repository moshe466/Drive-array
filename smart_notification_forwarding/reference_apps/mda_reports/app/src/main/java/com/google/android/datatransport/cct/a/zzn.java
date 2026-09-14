package com.google.android.datatransport.cct.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzy;

/* loaded from: classes.dex */
final class zzn extends zzy {
    private final zzy.zzc zza;
    private final zzy.zzb zzb;

    /* loaded from: classes.dex */
    static final class zza extends zzy.zza {
        private zzy.zzc zza;
        private zzy.zzb zzb;

        @Override // com.google.android.datatransport.cct.a.zzy.zza
        public zzy.zza zza(@Nullable zzy.zzb zzbVar) {
            this.zzb = zzbVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzy.zza
        public zzy.zza zza(@Nullable zzy.zzc zzcVar) {
            this.zza = zzcVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzy.zza
        public zzy zza() {
            return new zzn(this.zza, this.zzb, null);
        }
    }

    /* synthetic */ zzn(zzy.zzc zzcVar, zzy.zzb zzbVar, zzm zzmVar) {
        this.zza = zzcVar;
        this.zzb = zzbVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy.zzc zzcVar = this.zza;
        if (zzcVar != null ? zzcVar.equals(((zzn) obj).zza) : ((zzn) obj).zza == null) {
            zzy.zzb zzbVar = this.zzb;
            zzy.zzb zzbVar2 = ((zzn) obj).zzb;
            if (zzbVar == null) {
                if (zzbVar2 == null) {
                    return true;
                }
            } else if (zzbVar.equals(zzbVar2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzy.zzc zzcVar = this.zza;
        int hashCode = ((zzcVar == null ? 0 : zzcVar.hashCode()) ^ 1000003) * 1000003;
        zzy.zzb zzbVar = this.zzb;
        return hashCode ^ (zzbVar != null ? zzbVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.zza + ", mobileSubtype=" + this.zzb + "}";
    }

    @Nullable
    public zzy.zzb zzb() {
        return this.zzb;
    }

    @Nullable
    public zzy.zzc zzc() {
        return this.zza;
    }
}
