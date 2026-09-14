package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@ShowFirstParty
@KeepForSdk
@CheckReturnValue
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzam;
    private final Context mContext;
    private volatile String zzan;

    private GoogleSignatureVerifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zzam == null) {
                zzc.a(context);
                zzam = new GoogleSignatureVerifier(context);
            }
        }
        return zzam;
    }

    private static zze zza(PackageInfo packageInfo, zze... zzeVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzf zzfVar = new zzf(signatureArr[0].toByteArray());
        for (int i = 0; i < zzeVarArr.length; i++) {
            if (zzeVarArr[i].equals(zzfVar)) {
                return zzeVarArr[i];
            }
        }
        return null;
    }

    private final zzm zza(String str, int i) {
        try {
            PackageInfo zza = Wrappers.packageManager(this.mContext).zza(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
            if (zza == null) {
                return zzm.a("null pkg");
            }
            if (zza.signatures.length != 1) {
                return zzm.a("single cert required");
            }
            zzf zzfVar = new zzf(zza.signatures[0].toByteArray());
            String str2 = zza.packageName;
            zzm a = zzc.a(str2, zzfVar, honorsDebugCertificates, false);
            return (!a.a || zza.applicationInfo == null || (zza.applicationInfo.flags & 2) == 0 || !zzc.a(str2, zzfVar, false, true).a) ? a : zzm.a("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzm.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzh.a) : zza(packageInfo, zzh.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.common.zzm zzc(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null pkg"
            if (r8 != 0) goto L9
            com.google.android.gms.common.zzm r8 = com.google.android.gms.common.zzm.a(r0)
            return r8
        L9:
            java.lang.String r1 = r7.zzan
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L16
            com.google.android.gms.common.zzm r8 = com.google.android.gms.common.zzm.c()
            return r8
        L16:
            android.content.Context r1 = r7.mContext     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6b
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6b
            r2 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r8, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6b
            android.content.Context r2 = r7.mContext
            boolean r2 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r2)
            if (r1 != 0) goto L2f
        L2a:
            com.google.android.gms.common.zzm r0 = com.google.android.gms.common.zzm.a(r0)
            goto L64
        L2f:
            android.content.pm.Signature[] r0 = r1.signatures
            int r3 = r0.length
            r4 = 1
            if (r3 == r4) goto L38
            java.lang.String r0 = "single cert required"
            goto L2a
        L38:
            com.google.android.gms.common.zzf r3 = new com.google.android.gms.common.zzf
            r5 = 0
            r0 = r0[r5]
            byte[] r0 = r0.toByteArray()
            r3.<init>(r0)
            java.lang.String r0 = r1.packageName
            com.google.android.gms.common.zzm r2 = com.google.android.gms.common.zzc.a(r0, r3, r2, r5)
            boolean r6 = r2.a
            if (r6 == 0) goto L63
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo
            if (r1 == 0) goto L63
            int r1 = r1.flags
            r1 = r1 & 2
            if (r1 == 0) goto L63
            com.google.android.gms.common.zzm r0 = com.google.android.gms.common.zzc.a(r0, r3, r5, r4)
            boolean r0 = r0.a
            if (r0 == 0) goto L63
            java.lang.String r0 = "debuggable release cert app rejected"
            goto L2a
        L63:
            r0 = r2
        L64:
            boolean r1 = r0.a
            if (r1 == 0) goto L6a
            r7.zzan = r8
        L6a:
            return r0
        L6b:
            java.lang.String r0 = "no pkg "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L7d
            java.lang.String r8 = r0.concat(r8)
            goto L82
        L7d:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r0)
        L82:
            com.google.android.gms.common.zzm r8 = com.google.android.gms.common.zzm.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzc(java.lang.String):com.google.android.gms.common.zzm");
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzm zzc = zzc(str);
        zzc.b();
        return zzc.a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        zzm a;
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            a = zzm.a("no pkgs");
        } else {
            a = null;
            for (String str : packagesForUid) {
                a = zza(str, i);
                if (a.a) {
                    break;
                }
            }
        }
        a.b();
        return a.a;
    }
}
