package com.google.android.datatransport.cct.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zza;

/* loaded from: classes.dex */
final class zzd extends com.google.android.datatransport.cct.a.zza {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zza extends zza.AbstractC0007zza {
        private Integer zza;
        private String zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private String zzg;
        private String zzh;

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zza(int i) {
            this.zza = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zza(@Nullable String str) {
            this.zzd = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public com.google.android.datatransport.cct.a.zza zza() {
            String str = "";
            if (this.zza == null) {
                str = " sdkVersion";
            }
            if (str.isEmpty()) {
                return new zzd(this.zza.intValue(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zzb(@Nullable String str) {
            this.zzh = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zzc(@Nullable String str) {
            this.zzc = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zzd(@Nullable String str) {
            this.zzg = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zze(@Nullable String str) {
            this.zzb = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zzf(@Nullable String str) {
            this.zzf = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0007zza
        public zza.AbstractC0007zza zzg(@Nullable String str) {
            this.zze = str;
            return this;
        }
    }

    /* synthetic */ zzd(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, zzc zzcVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = str7;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.android.datatransport.cct.a.zza)) {
            return false;
        }
        zzd zzdVar = (zzd) obj;
        if (this.zza == zzdVar.zza && ((str = this.zzb) != null ? str.equals(zzdVar.zzb) : zzdVar.zzb == null) && ((str2 = this.zzc) != null ? str2.equals(zzdVar.zzc) : zzdVar.zzc == null) && ((str3 = this.zzd) != null ? str3.equals(zzdVar.zzd) : zzdVar.zzd == null) && ((str4 = this.zze) != null ? str4.equals(zzdVar.zze) : zzdVar.zze == null) && ((str5 = this.zzf) != null ? str5.equals(zzdVar.zzf) : zzdVar.zzf == null) && ((str6 = this.zzg) != null ? str6.equals(zzdVar.zzg) : zzdVar.zzg == null)) {
            String str7 = this.zzh;
            String str8 = zzdVar.zzh;
            if (str7 == null) {
                if (str8 == null) {
                    return true;
                }
            } else if (str7.equals(str8)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.zza ^ 1000003) * 1000003;
        String str = this.zzb;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzc;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzd;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.zze;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.zzf;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.zzg;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.zzh;
        return hashCode6 ^ (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.zza + ", model=" + this.zzb + ", hardware=" + this.zzc + ", device=" + this.zzd + ", product=" + this.zze + ", osBuild=" + this.zzf + ", manufacturer=" + this.zzg + ", fingerprint=" + this.zzh + "}";
    }

    @Nullable
    public String zzb() {
        return this.zzd;
    }

    @Nullable
    public String zzc() {
        return this.zzh;
    }

    @Nullable
    public String zzd() {
        return this.zzc;
    }

    @Nullable
    public String zze() {
        return this.zzg;
    }

    @Nullable
    public String zzf() {
        return this.zzb;
    }

    @Nullable
    public String zzg() {
        return this.zzf;
    }

    @Nullable
    public String zzh() {
        return this.zze;
    }

    public int zzi() {
        return this.zza;
    }
}
