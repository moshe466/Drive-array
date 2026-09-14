package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
final class zzagg extends zzahw {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzagy zzd;
    private final String zze;

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzahw) {
            zzahw zzahwVar = (zzahw) obj;
            if (this.zza.equals(zzahwVar.zzd()) && ((str = this.zzb) != null ? str.equals(zzahwVar.zze()) : zzahwVar.zze() == null) && this.zzc.equals(zzahwVar.zzf()) && this.zzd.equals(zzahwVar.zzb()) && this.zze.equals(zzahwVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((hashCode2 ^ hashCode) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        String valueOf = String.valueOf(this.zzd);
        String str4 = this.zze;
        StringBuilder y = AbstractC0008a.y("RevokeTokenRequest{providerId=", str, ", tenantId=", str2, ", token=");
        y.append(str3);
        y.append(", tokenType=");
        y.append(valueOf);
        y.append(", idToken=");
        return AbstractC0008a.u(y, str4, "}");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final zzagy zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final String zzf() {
        return this.zzc;
    }

    private zzagg(String str, String str2, String str3, zzagy zzagyVar, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzagyVar;
        this.zze = str4;
    }
}
