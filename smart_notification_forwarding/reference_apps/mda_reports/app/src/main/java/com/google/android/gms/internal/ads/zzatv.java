package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzatv {
    private final AtomicReference<ThreadPoolExecutor> zzdpe = new AtomicReference<>(null);
    private final Object zzdpf = new Object();

    @Nullable
    @GuardedBy("gmpAppIdLock")
    private String zzdpg = null;

    @Nullable
    @GuardedBy("gmpAppIdLock")
    private String zzdph = null;

    @VisibleForTesting
    private final AtomicBoolean zzdpi = new AtomicBoolean(false);
    private final AtomicInteger zzdpj = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdpk = new AtomicReference<>(null);
    private final AtomicReference<Object> zzdpl = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzdpm = new ConcurrentHashMap(9);
    private final AtomicReference<zzbfq> zzdpn = new AtomicReference<>(null);

    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> zzdpo = new ArrayBlockingQueue(20);
    private final Object zzdpp = new Object();

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpk, true)) {
            return null;
        }
        try {
            return zzm(context, str).invoke(this.zzdpk.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final <T> T zza(String str, @Nullable T t, zzaui<T> zzauiVar) {
        synchronized (this.zzdpn) {
            if (this.zzdpn.get() != null) {
                try {
                    return zzauiVar.zzb(this.zzdpn.get());
                } catch (Exception e) {
                    zza(e, str, false);
                }
            }
            return t;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpk, true)) {
            try {
                zzl(context, str2).invoke(this.zzdpk.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzavs.zzed(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final void zza(Context context, final String str, String str2, @Nullable Bundle bundle) {
        if (zzab(context)) {
            final Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            if (zzac(context)) {
                zza("logEventInternal", new zzaul(str, zzl) { // from class: com.google.android.gms.internal.ads.zzatw
                    private final String zzcyz;
                    private final Bundle zzdpq;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcyz = str;
                        this.zzdpq = zzl;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaul
                    public final void zza(zzbfq zzbfqVar) {
                        zzbfqVar.logEvent("am", this.zzcyz, this.zzdpq);
                    }
                });
                return;
            }
            if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpk, true)) {
                try {
                    zzai(context).invoke(this.zzdpk.get(), "am", str, zzl);
                } catch (Exception e) {
                    zza(e, "logEventInternal", true);
                }
            }
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (this.zzdpi.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzayu.zzez(sb.toString());
        if (z) {
            zzayu.zzez("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzdpi.set(true);
        }
    }

    private final void zza(final String str, final zzaul zzaulVar) {
        synchronized (this.zzdpn) {
            FutureTask<?> futureTask = new FutureTask<>(new Runnable(this, zzaulVar, str) { // from class: com.google.android.gms.internal.ads.zzatz
                private final String zzdbl;
                private final zzatv zzdps;
                private final zzaul zzdpt;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdps = this;
                    this.zzdpt = zzaulVar;
                    this.zzdbl = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdps.a(this.zzdpt, this.zzdbl);
                }
            }, null);
            if (this.zzdpn.get() != null) {
                futureTask.run();
            } else {
                this.zzdpo.offer(futureTask);
            }
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    private static boolean zzac(Context context) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcih)).booleanValue()) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcig)).booleanValue()) {
                return false;
            }
        }
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcii)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    @Nullable
    private final Method zzai(Context context) {
        Method method = this.zzdpm.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzdpm.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzayu.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    @Nullable
    private final Method zzl(Context context, String str) {
        Method method = this.zzdpm.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzdpm.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    @Nullable
    private final Method zzm(Context context, String str) {
        Method method = this.zzdpm.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdpm.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzn(Context context, String str) {
        Method method = this.zzdpm.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzdpm.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final ThreadPoolExecutor zzuq() {
        if (this.zzdpe.get() == null) {
            this.zzdpe.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzve.zzoy().zzd(zzzn.zzcif)).intValue(), ((Integer) zzve.zzoy().zzd(zzzn.zzcif)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzauj(this)));
        }
        return this.zzdpe.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a() {
        return (String) zza("getAppInstanceId", (String) null, (zzaui<String>) zzaty.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String a(Context context) {
        return (String) zza("getAppInstanceId", context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzaul zzaulVar, String str) {
        if (this.zzdpn.get() != null) {
            try {
                zzaulVar.zza(this.zzdpn.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }

    public final void zza(Context context, zzug zzugVar) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcim)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdpp) {
            }
        }
    }

    public final void zza(Context context, zzyq zzyqVar) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcim)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdpp) {
            }
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzab(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzavs.zzed(sb.toString());
        }
    }

    public final boolean zzab(Context context) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzchz)).booleanValue() && !this.zzdpi.get()) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcij)).booleanValue()) {
                return true;
            }
            if (this.zzdpj.get() == -1) {
                zzve.zzou();
                if (!zzayk.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzve.zzou();
                    if (zzayk.zzbk(context)) {
                        zzayu.zzez("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdpj.set(0);
                    }
                }
                this.zzdpj.set(1);
            }
            if (this.zzdpj.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final String zzad(Context context) {
        if (!zzab(context)) {
            return "";
        }
        if (zzac(context)) {
            return (String) zza("getCurrentScreenNameOrScreenClass", "", (zzaui<String>) zzaua.a);
        }
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpk, true)) {
            return "";
        }
        try {
            String str = (String) zzm(context, "getCurrentScreenName").invoke(this.zzdpk.get(), new Object[0]);
            if (str == null) {
                str = (String) zzm(context, "getCurrentScreenClass").invoke(this.zzdpk.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception e) {
            zza(e, "getCurrentScreenName", false);
            return "";
        }
    }

    @Nullable
    public final String zzae(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdpf) {
            if (this.zzdpg != null) {
                return this.zzdpg;
            }
            this.zzdpg = zzac(context) ? (String) zza("getGmpAppId", this.zzdpg, (zzaui<String>) zzauc.a) : (String) zza("getGmpAppId", context);
            return this.zzdpg;
        }
    }

    @Nullable
    public final String zzaf(final Context context) {
        if (!zzab(context)) {
            return null;
        }
        long longValue = ((Long) zzve.zzoy().zzd(zzzn.zzcie)).longValue();
        if (zzac(context)) {
            try {
                return longValue < 0 ? (String) zza("getAppInstanceId", (String) null, (zzaui<String>) zzauf.a) : (String) zzuq().submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzaue
                    private final zzatv zzdps;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdps = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzdps.a();
                    }
                }).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        }
        if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        }
        try {
            return (String) zzuq().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.zzauh
                private final Context zzcey;
                private final zzatv zzdps;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdps = this;
                    this.zzcey = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzdps.a(this.zzcey);
                }
            }).get(longValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused3) {
            return "TIME_OUT";
        } catch (Exception unused4) {
            return null;
        }
    }

    @Nullable
    public final String zzag(Context context) {
        if (!zzab(context)) {
            return null;
        }
        if (zzac(context)) {
            Long l = (Long) zza("getAdEventId", (String) null, (zzaui<String>) zzaug.a);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    @Nullable
    public final String zzah(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdpf) {
            if (this.zzdph != null) {
                return this.zzdph;
            }
            this.zzdph = zzac(context) ? (String) zza("getAppIdOrigin", this.zzdph, (zzaui<String>) zzatx.a) : "fa";
            return this.zzdph;
        }
    }

    public final void zze(Context context, final String str) {
        if (zzab(context)) {
            if (zzac(context)) {
                zza("beginAdUnitExposure", new zzaul(str) { // from class: com.google.android.gms.internal.ads.zzatu
                    private final String zzcyz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcyz = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaul
                    public final void zza(zzbfq zzbfqVar) {
                        zzbfqVar.beginAdUnitExposure(this.zzcyz);
                    }
                });
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzf(Context context, final String str) {
        if (zzab(context)) {
            if (zzac(context)) {
                zza("endAdUnitExposure", new zzaul(str) { // from class: com.google.android.gms.internal.ads.zzaub
                    private final String zzcyz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcyz = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaul
                    public final void zza(zzbfq zzbfqVar) {
                        zzbfqVar.endAdUnitExposure(this.zzcyz);
                    }
                });
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final void zzg(final Context context, final String str) {
        if (zzab(context) && (context instanceof Activity)) {
            if (zzac(context)) {
                zza("setScreenName", new zzaul(context, str) { // from class: com.google.android.gms.internal.ads.zzaud
                    private final Context zzcri;
                    private final String zzcyr;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcri = context;
                        this.zzcyr = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaul
                    public final void zza(zzbfq zzbfqVar) {
                        Context context2 = this.zzcri;
                        zzbfqVar.zzb(ObjectWrapper.wrap(context2), this.zzcyr, context2.getPackageName());
                    }
                });
                return;
            }
            if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdpl, false)) {
                try {
                    zzn(context, "setCurrentScreen").invoke(this.zzdpl.get(), (Activity) context, str, context.getPackageName());
                } catch (Exception e) {
                    zza(e, "setCurrentScreen", false);
                }
            }
        }
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }
}
