package com.google.firebase.auth.internal;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzn extends zzj {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzjVar.zzd()) : zzjVar.zzd() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzjVar.zzb()) : zzjVar.zzb() == null) {
                    String str3 = this.zzc;
                    if (str3 != null ? str3.equals(zzjVar.zzc()) : zzjVar.zzc() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.zza;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.zzb;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i4 = (i3 ^ hashCode2) * 1000003;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i4 ^ i;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return AbstractC0008a.u(AbstractC0008a.y("AttestationResult{recaptchaV2Token=", str, ", playIntegrityToken=", str2, ", recaptchaEnterpriseToken="), this.zzc, "}");
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzd() {
        return this.zza;
    }

    private zzn(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
