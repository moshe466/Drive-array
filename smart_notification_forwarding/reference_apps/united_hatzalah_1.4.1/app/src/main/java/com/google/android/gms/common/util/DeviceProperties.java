package com.google.android.gms.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;
    private static Boolean zzo;
    private static Boolean zzp;
    private static Boolean zzq;
    private static Boolean zzr;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        return zze(context.getPackageManager());
    }

    public static boolean isBstar(Context context) {
        if (zzo == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z3 = true;
            }
            zzo = Boolean.valueOf(z3);
        }
        return zzo.booleanValue();
    }

    public static boolean isFoldable(Context context) {
        if (zzd == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
                z3 = true;
            }
            zzd = Boolean.valueOf(z3);
        }
        return zzd.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        if (zzh == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z3 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z3 = true;
            }
            zzh = Boolean.valueOf(z3);
        }
        return zzh.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
    
        if (r0.charAt(0) <= 'C') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
    
        if (com.google.android.gms.common.util.DeviceProperties.zzr.booleanValue() == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isPhone(android.content.Context r5) {
        /*
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zza
            if (r0 != 0) goto Ld3
            boolean r0 = isFoldable(r5)
            r1 = 1
            if (r0 != 0) goto Lcd
            boolean r0 = isTablet(r5)
            r2 = 0
            if (r0 != 0) goto Lcc
            boolean r0 = isWearable(r5)
            if (r0 != 0) goto Lcc
            boolean r0 = zzd(r5)
            if (r0 != 0) goto Lcc
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzk
            if (r0 != 0) goto L32
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            java.lang.String r3 = "org.chromium.arc"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzk = r0
        L32:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzk
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lcc
            boolean r0 = isAuto(r5)
            if (r0 != 0) goto Lcc
            boolean r0 = isTv(r5)
            if (r0 != 0) goto Lcc
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzn
            if (r0 != 0) goto L5a
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            java.lang.String r3 = "com.google.android.feature.AMATI_EXPERIENCE"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzn = r0
        L5a:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzn
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lcc
            boolean r0 = isBstar(r5)
            if (r0 != 0) goto Lcc
            boolean r0 = isXr(r5)
            if (r0 != 0) goto Lcc
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzq
            if (r0 != 0) goto L82
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            java.lang.String r3 = "com.google.desktop.gms"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzq = r0
        L82:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzq
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lcc
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzr
            if (r0 != 0) goto Lc3
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastV()
            if (r0 != 0) goto L9a
        L98:
            r5 = r2
            goto Lbd
        L9a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 36
            if (r0 < r3) goto La1
            goto Lb4
        La1:
            java.lang.String r0 = android.os.Build.VERSION.CODENAME
            char r3 = r0.charAt(r2)
            r4 = 66
            if (r3 < r4) goto L98
            char r0 = r0.charAt(r2)
            r3 = 67
            if (r0 <= r3) goto Lb4
            goto L98
        Lb4:
            java.lang.String r0 = "android.hardware.type.xr_peripheral"
            boolean r5 = r5.hasSystemFeature(r0)
            if (r5 == 0) goto L98
            r5 = r1
        Lbd:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            com.google.android.gms.common.util.DeviceProperties.zzr = r5
        Lc3:
            java.lang.Boolean r5 = com.google.android.gms.common.util.DeviceProperties.zzr
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto Lcc
            goto Lcd
        Lcc:
            r1 = r2
        Lcd:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            com.google.android.gms.common.util.DeviceProperties.zza = r5
        Ld3:
            java.lang.Boolean r5 = com.google.android.gms.common.util.DeviceProperties.zza
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isPhone(android.content.Context):boolean");
    }

    public static boolean isPhoneGo(Context context) {
        ActivityManager activityManager;
        boolean z3 = false;
        if (context == null) {
            return false;
        }
        if (zzb == null) {
            if (isPhone(context)) {
                if (zzi == null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                    zzi = Boolean.valueOf(activityManager.isLowRamDevice());
                }
                if (Objects.equal(zzi, Boolean.TRUE) && Build.VERSION.SDK_INT >= 27) {
                    z3 = true;
                }
            }
            zzb = Boolean.valueOf(z3);
        }
        return zzb.booleanValue();
    }

    public static boolean isSevenInchTablet(Context context) {
        return zza(context.getResources());
    }

    public static boolean isSidewinder(Context context) {
        return zzc(context);
    }

    public static boolean isTablet(Context context) {
        return isTablet(context.getResources());
    }

    public static boolean isTv(Context context) {
        return zzf(context.getPackageManager());
    }

    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return zzb(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (!isWearable(context) || PlatformVersion.isAtLeastN()) {
            if (zzc(context)) {
                if (!PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean isXr(Context context) {
        return zzg(context.getPackageManager());
    }

    public static boolean zza(Resources resources) {
        boolean z3 = false;
        if (resources == null) {
            return false;
        }
        if (zze == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z3 = true;
            }
            zze = Boolean.valueOf(z3);
        }
        return zze.booleanValue();
    }

    public static boolean zzb(PackageManager packageManager) {
        if (zzf == null) {
            zzf = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzf.booleanValue();
    }

    public static boolean zzc(Context context) {
        if (zzg == null) {
            zzg = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzg.booleanValue();
    }

    public static boolean zzd(Context context) {
        boolean hasSystemFeature;
        if (zzj == null) {
            if (PlatformVersion.isAtLeastO()) {
                hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
            } else {
                hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.iot");
            }
            zzj = Boolean.valueOf(hasSystemFeature);
        }
        return zzj.booleanValue();
    }

    public static boolean zze(PackageManager packageManager) {
        if (zzl == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z3 = true;
            }
            zzl = Boolean.valueOf(z3);
        }
        return zzl.booleanValue();
    }

    public static boolean zzf(PackageManager packageManager) {
        if (zzm == null) {
            boolean z3 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback") && !packageManager.hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
                z3 = false;
            }
            zzm = Boolean.valueOf(z3);
        }
        return zzm.booleanValue();
    }

    public static boolean zzg(PackageManager packageManager) {
        if (zzp == null) {
            zzp = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.api.spatial"));
        }
        return zzp.booleanValue();
    }

    public static boolean isTablet(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (zzc == null) {
            zzc = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zza(resources));
        }
        return zzc.booleanValue();
    }
}
