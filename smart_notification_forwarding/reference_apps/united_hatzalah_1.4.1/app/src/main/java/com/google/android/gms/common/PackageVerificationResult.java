package com.google.android.gms.common;

/* loaded from: classes.dex */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    private final String zzc;
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i, boolean z3, String str2, Throwable th, com.google.android.gms.common.signatureverification.zza zzaVar) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = str2;
        this.zzd = th;
    }

    public static PackageVerificationResult zza(String str, String str2, Throwable th, com.google.android.gms.common.signatureverification.zza zzaVar) {
        return new PackageVerificationResult(str, 1, false, str2, th, null);
    }

    public static PackageVerificationResult zzd(String str, int i, com.google.android.gms.common.signatureverification.zza zzaVar) {
        return new PackageVerificationResult(str, i, true, null, null, null);
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        if (!this.zzb) {
            String str = this.zzc;
            Throwable th = this.zzd;
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(str));
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }
}
