package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzapn implements zzapr {
    private static final Object lock = new Object();

    @VisibleForTesting
    private static zzapr zzdif;

    @VisibleForTesting
    private static zzapr zzdig;
    private final Context zzcgd;
    private final Object zzdih;
    private final WeakHashMap<Thread, Boolean> zzdii;
    private final zzazb zzdij;
    private final ExecutorService zzxk;

    private zzapn(Context context) {
        this(context, zzazb.zzxm());
    }

    private zzapn(Context context, zzazb zzazbVar) {
        this.zzdih = new Object();
        this.zzdii = new WeakHashMap<>();
        this.zzxk = zzddq.zzaqs().zzdt(zzddv.zzgtv);
        this.zzcgd = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdij = zzazbVar;
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.packageManager(this.zzcgd).isCallerInstantApp();
        } catch (Throwable th) {
            zzayu.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzcgd.getPackageName();
        } catch (Throwable unused) {
            zzayu.zzez("Cannot obtain package name, proceeding.");
            str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdij.zzbma).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzzn.zzqg())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "278033407").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzve.zzoz()).appendQueryParameter(SettingsJsonConstants.ANALYTICS_SAMPLING_RATE_KEY, Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzabi.zzcul.get()));
    }

    public static zzapr zzc(Context context, zzazb zzazbVar) {
        synchronized (lock) {
            if (zzdig == null) {
                if (zzabi.zzcun.get().booleanValue()) {
                    zzapn zzapnVar = new zzapn(context, zzazbVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzapnVar.zzdih) {
                            zzapnVar.zzdii.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new zzapo(zzapnVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new zzapp(zzapnVar, Thread.getDefaultUncaughtExceptionHandler()));
                    zzdig = zzapnVar;
                } else {
                    zzdig = new zzapq();
                }
            }
        }
        return zzdig;
    }

    public static zzapr zzs(Context context) {
        synchronized (lock) {
            if (zzdif == null) {
                if (zzabi.zzcun.get().booleanValue()) {
                    zzdif = new zzapn(context);
                } else {
                    zzdif = new zzapq();
                }
            }
        }
        return zzdif;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r3 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L40
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L3b
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L11:
            if (r2 >= r5) goto L34
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzayk.zzet(r8)
            if (r8 == 0) goto L20
            r3 = 1
        L20:
            java.lang.Class<com.google.android.gms.internal.ads.zzapn> r8 = com.google.android.gms.internal.ads.zzapn.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L31
            r6 = 1
        L31:
            int r2 = r2 + 1
            goto L11
        L34:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3b:
            if (r2 == 0) goto L40
            if (r3 != 0) goto L40
            goto L41
        L40:
            r10 = 0
        L41:
            if (r10 == 0) goto L4a
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapn.a(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzapr
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzapr
    public final void zza(Throwable th, String str, float f) {
        if (zzayk.zzc(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzdpt.zza(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f);
        int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza(name, stringWriter2, str, i2).toString());
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                final String str2 = (String) obj;
                final zzayy zzayyVar = new zzayy();
                this.zzxk.execute(new Runnable(zzayyVar, str2) { // from class: com.google.android.gms.internal.ads.zzapm
                    private final String zzcyr;
                    private final zzayy zzdie;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdie = zzayyVar;
                        this.zzcyr = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzdie.zzen(this.zzcyr);
                    }
                });
            }
        }
    }
}
