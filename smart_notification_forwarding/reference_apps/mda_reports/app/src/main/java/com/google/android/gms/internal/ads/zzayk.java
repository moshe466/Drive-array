package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzayk {
    private float zzdvn = -1.0f;
    public static final Handler zzyu = new zzddu(Looper.getMainLooper());
    private static final String zzdvh = AdView.class.getName();
    private static final String zzdvi = InterstitialAd.class.getName();
    private static final String zzdvj = PublisherAdView.class.getName();
    private static final String zzdvk = PublisherInterstitialAd.class.getName();
    private static final String zzdvl = SearchAdView.class.getName();
    private static final String zzdvm = AdLoader.class.getName();

    public static int zza(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public static int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.ads.AdSize zza(android.content.Context r1, int r2, int r3, int r4) {
        /*
            r3 = -1
            if (r1 != 0) goto L5
        L3:
            r1 = -1
            goto L38
        L5:
            android.content.Context r0 = r1.getApplicationContext()
            if (r0 == 0) goto Lf
            android.content.Context r1 = r1.getApplicationContext()
        Lf:
            android.content.res.Resources r1 = r1.getResources()
            if (r1 != 0) goto L16
            goto L3
        L16:
            android.util.DisplayMetrics r0 = r1.getDisplayMetrics()
            if (r0 != 0) goto L1d
            goto L3
        L1d:
            android.content.res.Configuration r1 = r1.getConfiguration()
            if (r1 != 0) goto L24
            goto L3
        L24:
            int r1 = r1.orientation
            if (r4 != 0) goto L29
            r4 = r1
        L29:
            if (r4 != r1) goto L2e
            int r1 = r0.heightPixels
            goto L30
        L2e:
            int r1 = r0.widthPixels
        L30:
            float r1 = (float) r1
            float r4 = r0.density
            float r1 = r1 / r4
            int r1 = java.lang.Math.round(r1)
        L38:
            if (r1 != r3) goto L3d
            com.google.android.gms.ads.AdSize r1 = com.google.android.gms.ads.AdSize.INVALID
            return r1
        L3d:
            r3 = 90
            float r1 = (float) r1
            r4 = 1041865114(0x3e19999a, float:0.15)
            float r1 = r1 * r4
            int r1 = java.lang.Math.round(r1)
            int r1 = java.lang.Math.min(r3, r1)
            r3 = 655(0x28f, float:9.18E-43)
            if (r2 <= r3) goto L5e
            float r3 = (float) r2
            r4 = 1144389632(0x44360000, float:728.0)
            float r3 = r3 / r4
            r4 = 1119092736(0x42b40000, float:90.0)
        L57:
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            goto L7e
        L5e:
            r3 = 632(0x278, float:8.86E-43)
            if (r2 <= r3) goto L65
            r3 = 81
            goto L7e
        L65:
            r3 = 526(0x20e, float:7.37E-43)
            if (r2 <= r3) goto L70
            float r3 = (float) r2
            r4 = 1139408896(0x43ea0000, float:468.0)
            float r3 = r3 / r4
            r4 = 1114636288(0x42700000, float:60.0)
            goto L57
        L70:
            r3 = 432(0x1b0, float:6.05E-43)
            if (r2 <= r3) goto L77
            r3 = 68
            goto L7e
        L77:
            float r3 = (float) r2
            r4 = 1134559232(0x43a00000, float:320.0)
            float r3 = r3 / r4
            r4 = 1112014848(0x42480000, float:50.0)
            goto L57
        L7e:
            int r1 = java.lang.Math.min(r3, r1)
            r3 = 50
            int r1 = java.lang.Math.max(r1, r3)
            com.google.android.gms.ads.AdSize r3 = new com.google.android.gms.ads.AdSize
            r3.<init>(r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayk.zza(android.content.Context, int, int, int):com.google.android.gms.ads.AdSize");
    }

    @Nullable
    @VisibleForTesting
    public static String zza(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int i2;
        String str2;
        while (true) {
            i2 = i + 1;
            if (i2 >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className = stackTraceElement.getClassName();
            i = ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzdvh.equalsIgnoreCase(className) || zzdvi.equalsIgnoreCase(className) || zzdvj.equalsIgnoreCase(className) || zzdvk.equalsIgnoreCase(className) || zzdvl.equalsIgnoreCase(className) || zzdvm.equalsIgnoreCase(className))) ? 0 : i2;
        }
        str2 = stackTraceElementArr[i2].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            int i3 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                    i3 = i4;
                }
                str = sb.toString();
            }
            if (str2 != null && !str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    public static void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z, zzayp zzaypVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
            StringBuilder sb = new StringBuilder(23);
            sb.append(apkVersion);
            sb.append(".19649000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzaypVar.zzen(appendQueryParameter.toString());
    }

    private final void zza(ViewGroup viewGroup, zzuj zzujVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setBackgroundColor(i2);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i);
        int zza = zza(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzujVar.widthPixels - zza, zzujVar.heightPixels - zza, 17));
        viewGroup.addView(frameLayout, zzujVar.widthPixels, zzujVar.heightPixels);
    }

    public static void zza(boolean z, HttpURLConnection httpURLConnection, @Nullable String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(i / displayMetrics.density);
    }

    public static String zzbi(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || zzxd()) {
            string = "emulator";
        }
        return zzes(string);
    }

    @Nullable
    public static String zzbj(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, "android_id");
    }

    public static boolean zzbk(Context context) {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
    }

    public static boolean zzbl(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public static boolean zzbm(Context context) {
        int intValue;
        int intValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public static int zzbn(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Throwable zzc(Throwable th) {
        if (zzabi.zzcuo.get().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzet(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!(!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java.")))) {
                        stackTraceElement = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(stackTraceElement);
                }
            }
            if (z) {
                th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    public static boolean zzc(Context context, int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i) == 0;
    }

    public static String zzes(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    @VisibleForTesting
    public static boolean zzet(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(zzabi.zzcum.get());
    }

    public static boolean zzxd() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean zzxe() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzxf() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return bigInteger;
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zza(context, str, str2, bundle, true, new zzayn(this));
    }

    public final void zza(ViewGroup viewGroup, zzuj zzujVar, String str) {
        zza(viewGroup, zzujVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public final void zza(ViewGroup viewGroup, zzuj zzujVar, String str, String str2) {
        zzayu.zzez(str2);
        zza(viewGroup, zzujVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public final int zzb(Context context, int i) {
        if (this.zzdvn < 0.0f) {
            synchronized (this) {
                if (this.zzdvn < 0.0f) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.zzdvn = displayMetrics.density;
                }
            }
        }
        return Math.round(i / this.zzdvn);
    }
}
