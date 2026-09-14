package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zzcl<T> {

    @SuppressLint({"StaticFieldLeak"})
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzcz<zzcy<zzch>> zzd;
    private final zzcr zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;
    private static final Object zza = new Object();
    private static final AtomicInteger zzh = new AtomicInteger();

    private zzcl(zzcr zzcrVar, String str, T t) {
        this.zzi = -1;
        if (zzcrVar.a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zze = zzcrVar;
        this.zzf = str;
        this.zzg = t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcl(zzcr zzcrVar, String str, Object obj, zzcn zzcnVar) {
        this(zzcrVar, str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        zzh.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzcy b() {
        new zzck();
        return zzck.zza(zzb);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbx.b();
                zzcu.a();
                zzcg.a();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdc.zza(zzco.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Double> zzb(zzcr zzcrVar, String str, double d) {
        return new zzcp(zzcrVar, str, Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Long> zzb(zzcr zzcrVar, String str, long j) {
        return new zzcn(zzcrVar, str, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<String> zzb(zzcr zzcrVar, String str, String str2) {
        return new zzcs(zzcrVar, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Boolean> zzb(zzcr zzcrVar, String str, boolean z) {
        return new zzcq(zzcrVar, str, Boolean.valueOf(z));
    }

    abstract T a(Object obj);

    public final String zzb() {
        return zza(this.zze.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0022, B:13:0x0038, B:14:0x00e4, B:15:0x00e2, B:16:0x003e, B:18:0x004e, B:22:0x005f, B:24:0x0065, B:26:0x0071, B:28:0x008a, B:30:0x0094, B:33:0x00c6, B:35:0x00da, B:41:0x0082, B:42:0x0099, B:44:0x00a2, B:46:0x00b4, B:47:0x00bf, B:48:0x00b9, B:50:0x00e9, B:51:0x00f0, B:53:0x00f1), top: B:4:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T zzc() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcl.zzc():java.lang.Object");
    }
}
