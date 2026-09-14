package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzaqs {
    private float zzboh;
    private int zzdgf;
    private int zzdgg;
    private int zzdmh;
    private boolean zzdmi;
    private boolean zzdmj;
    private int zzdmk;
    private int zzdml;
    private int zzdmm;
    private String zzdmn;
    private int zzdmo;
    private int zzdmp;
    private int zzdmq;
    private boolean zzdmr;
    private int zzdms;
    private double zzdmt;
    private boolean zzdmu;
    private String zzdmv;
    private String zzdmw;
    private boolean zzdmx;
    private boolean zzdmy;
    private String zzdmz;
    private boolean zzdna;
    private final boolean zzdnb;
    private boolean zzdnc;
    private String zzdnd;
    private String zzdne;
    private String zzdnf;
    private boolean zzdng;

    public zzaqs(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzt(context);
        zzu(context);
        zzv(context);
        Locale locale = Locale.getDefault();
        this.zzdmx = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdmy = zza(packageManager, "http://www.google.com") != null;
        this.zzdmz = locale.getCountry();
        zzve.zzou();
        this.zzdna = zzayk.zzxd();
        this.zzdnb = DeviceProperties.isLatchsky(context);
        this.zzdnc = DeviceProperties.isSidewinder(context);
        this.zzdnd = locale.getLanguage();
        this.zzdne = zza(context, packageManager);
        this.zzdnf = zzw(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.zzboh = displayMetrics.density;
        this.zzdgf = displayMetrics.widthPixels;
        this.zzdgg = displayMetrics.heightPixels;
    }

    public zzaqs(Context context, zzaqt zzaqtVar) {
        zzt(context);
        zzu(context);
        zzv(context);
        this.zzdmv = Build.FINGERPRINT;
        this.zzdmw = Build.DEVICE;
        this.zzdng = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaao.zzk(context);
        this.zzdmx = zzaqtVar.zzdmx;
        this.zzdmy = zzaqtVar.zzdmy;
        this.zzdmz = zzaqtVar.zzdmz;
        this.zzdna = zzaqtVar.zzdna;
        this.zzdnb = zzaqtVar.zzdnb;
        this.zzdnc = zzaqtVar.zzdnc;
        this.zzdnd = zzaqtVar.zzdnd;
        this.zzdne = zzaqtVar.zzdne;
        this.zzdnf = zzaqtVar.zzdnf;
        this.zzboh = zzaqtVar.zzboh;
        this.zzdgf = zzaqtVar.zzdgf;
        this.zzdgg = zzaqtVar.zzdgg;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final void zzt(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdmh = audioManager.getMode();
                this.zzdmi = audioManager.isMusicActive();
                this.zzdmj = audioManager.isSpeakerphoneOn();
                this.zzdmk = audioManager.getStreamVolume(3);
                this.zzdml = audioManager.getRingerMode();
                this.zzdmm = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzq.zzku().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdmh = -2;
        this.zzdmi = false;
        this.zzdmj = false;
        this.zzdmk = 0;
        this.zzdml = 2;
        this.zzdmm = 0;
    }

    @TargetApi(16)
    private final void zzu(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdmn = telephonyManager.getNetworkOperator();
        this.zzdmp = telephonyManager.getNetworkType();
        this.zzdmq = telephonyManager.getPhoneType();
        this.zzdmo = -2;
        this.zzdmr = false;
        this.zzdms = -1;
        com.google.android.gms.ads.internal.zzq.zzkq();
        if (zzawb.zzq(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdmo = activeNetworkInfo.getType();
                this.zzdms = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdmo = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzdmr = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzv(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            this.zzdmt = -1.0d;
            this.zzdmu = false;
        } else {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdmt = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / registerReceiver.getIntExtra("scale", -1);
            this.zzdmu = intExtra == 2 || intExtra == 5;
        }
    }

    private static String zzw(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzaqt zzug() {
        return new zzaqt(this.zzdmh, this.zzdmx, this.zzdmy, this.zzdmn, this.zzdmz, this.zzdna, this.zzdnb, this.zzdnc, this.zzdmi, this.zzdmj, this.zzdnd, this.zzdne, this.zzdnf, this.zzdmk, this.zzdmo, this.zzdmp, this.zzdmq, this.zzdml, this.zzdmm, this.zzboh, this.zzdgf, this.zzdgg, this.zzdmt, this.zzdmu, this.zzdmr, this.zzdms, this.zzdmv, this.zzdng, this.zzdmw);
    }
}
