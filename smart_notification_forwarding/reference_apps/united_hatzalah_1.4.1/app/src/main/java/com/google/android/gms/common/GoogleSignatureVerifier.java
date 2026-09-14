package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;

/* loaded from: classes.dex */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile HashSet zzd;
    private static volatile HashSet zze;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    zzo.zza(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean zza(android.content.pm.PackageInfo r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zza(android.content.pm.PackageInfo, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c2  */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.common.zzy zzb(java.lang.String r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r7 = "null pkg"
            if (r6 != 0) goto L9
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzc(r7)
            return r6
        L9:
            java.lang.String r8 = r5.zzc
            boolean r8 = r6.equals(r8)
            if (r8 == 0) goto L16
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzb()
            return r6
        L16:
            int r8 = com.google.android.gms.common.zzo.zzh
            android.os.StrictMode$ThreadPolicy r8 = android.os.StrictMode.allowThreadDiskReads()
            r0 = 1
            com.google.android.gms.common.zzo.zzb()     // Catch: java.lang.Throwable -> L4a android.os.RemoteException -> L4d com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L4f
            com.google.android.gms.common.internal.zzad r1 = com.google.android.gms.common.zzo.zzg     // Catch: java.lang.Throwable -> L4a android.os.RemoteException -> L4d com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L4f
            boolean r1 = r1.zzg()     // Catch: java.lang.Throwable -> L4a android.os.RemoteException -> L4d com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L4f
            android.os.StrictMode.setThreadPolicy(r8)
            if (r1 == 0) goto L5a
            com.google.android.gms.common.zzv r7 = new com.google.android.gms.common.zzv
            r8 = 0
            r7.<init>(r8)
            r7.zza(r6)
            android.content.Context r8 = r5.zzb
            boolean r8 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r8)
            r7.zzb(r8)
            r7.zzc(r0)
            com.google.android.gms.common.zzw r7 = r7.zzd()
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzo.zzc(r7)
            goto Lbe
        L4a:
            r6 = move-exception
            goto Ld1
        L4d:
            r1 = move-exception
            goto L50
        L4f:
            r1 = move-exception
        L50:
            java.lang.String r2 = "GoogleCertificates"
            java.lang.String r3 = "Failed to get Google certificates from remote"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L4a
            android.os.StrictMode.setThreadPolicy(r8)
        L5a:
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r8 < r1) goto L64
            r8 = 134217792(0x8000040, float:3.8518893E-34)
            goto L66
        L64:
            r8 = 64
        L66:
            android.content.Context r1 = r5.zzb     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lc5
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lc5
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r6, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lc5
            android.content.Context r1 = r5.zzb
            boolean r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r1)
            if (r8 != 0) goto L7d
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
            goto Lbe
        L7d:
            android.content.pm.Signature[] r7 = r8.signatures
            if (r7 == 0) goto Lb8
            int r7 = r7.length
            if (r7 == r0) goto L85
            goto Lb8
        L85:
            com.google.android.gms.common.zzk r7 = new com.google.android.gms.common.zzk
            android.content.pm.Signature[] r2 = r8.signatures
            r3 = 0
            r2 = r2[r3]
            byte[] r2 = r2.toByteArray()
            r7.<init>(r2)
            java.lang.String r2 = r8.packageName
            com.google.android.gms.common.zzy r1 = com.google.android.gms.common.zzo.zzd(r2, r7, r1, r3)
            boolean r4 = r1.zza
            if (r4 == 0) goto Lb6
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            if (r8 == 0) goto Lb6
            int r8 = r8.flags
            r8 = r8 & 2
            if (r8 == 0) goto Lb6
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzo.zzd(r2, r7, r3, r0)
            boolean r7 = r7.zza
            if (r7 == 0) goto Lb6
            java.lang.String r7 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
            goto Lbe
        Lb6:
            r7 = r1
            goto Lbe
        Lb8:
            java.lang.String r7 = "single cert required"
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
        Lbe:
            boolean r8 = r7.zza
            if (r8 == 0) goto Lc4
            r5.zzc = r6
        Lc4:
            return r7
        Lc5:
            r7 = move-exception
            java.lang.String r8 = "no pkg "
            java.lang.String r6 = r8.concat(r6)
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzd(r6, r7)
            return r6
        Ld1:
            android.os.StrictMode.setThreadPolicy(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzb(java.lang.String, boolean, boolean):com.google.android.gms.common.zzy");
    }

    private static zzj zzc(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjVarArr.length; i++) {
            if (zzjVarArr[i].equals(zzkVar)) {
                return zzjVarArr[i];
            }
        }
        return null;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (!zza(packageInfo, true) || !GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
            return false;
        }
        return true;
    }

    public boolean isPackageGoogleSigned(String str) {
        zzy zzb = zzb(str, false, false);
        zzb.zze();
        return zzb.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzy zzc;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    zzc = zzb(packagesForUid[i3], false, false);
                    if (zzc.zza) {
                        break;
                    }
                    i3++;
                } else {
                    Preconditions.checkNotNull(zzc);
                    break;
                }
            }
        } else {
            zzc = zzy.zzc("no pkgs");
        }
        zzc.zze();
        return zzc.zza;
    }
}
