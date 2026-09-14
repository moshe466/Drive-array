package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class zzx extends zzgr {
    private Boolean zza;

    @NonNull
    private zzz zzb;
    private Boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzga zzgaVar) {
        super(zzgaVar);
        this.zzb = zzaa.a;
    }

    private final String zza(String str, String str2) {
        zzey zzf;
        String str3;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            e = e;
            zzf = zzr().zzf();
            str3 = "Could not find SystemProperties class";
            zzf.zza(str3, e);
            return str2;
        } catch (IllegalAccessException e2) {
            e = e2;
            zzf = zzr().zzf();
            str3 = "Could not access SystemProperties.get()";
            zzf.zza(str3, e);
            return str2;
        } catch (NoSuchMethodException e3) {
            e = e3;
            zzf = zzr().zzf();
            str3 = "Could not find SystemProperties.get() method";
            zzf.zza(str3, e);
            return str2;
        } catch (InvocationTargetException e4) {
            e = e4;
            zzf = zzr().zzf();
            str3 = "SystemProperties.get() threw an exception";
            zzf.zza(str3, e);
            return str2;
        }
    }

    public static long zzj() {
        return zzap.zzad.zza(null).longValue();
    }

    public static long zzk() {
        return zzap.zzd.zza(null).longValue();
    }

    @Nullable
    @VisibleForTesting
    private final Bundle zzy() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NonNull zzz zzzVar) {
        this.zzb = zzzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean a(String str) {
        return zzd(str, zzap.zzah);
    }

    @WorkerThread
    public final int zza(@Size(min = 1) String str) {
        return zzb(str, zzap.zzo);
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzel<Long> zzelVar) {
        if (str != null) {
            String zza = this.zzb.zza(str, zzelVar.zza());
            if (!TextUtils.isEmpty(zza)) {
                try {
                    return zzelVar.zza(Long.valueOf(Long.parseLong(zza))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzelVar.zza(null).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzg r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.zzle.zzb()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.zzx r1 = r5.zzt()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzel<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzcc
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.zzf()
        L33:
            com.google.android.gms.measurement.internal.zzel<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzap.zze
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzel<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzap.zzf
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.zzd()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.zze()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(com.google.android.gms.measurement.internal.zzg):java.lang.String");
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(zzel<Boolean> zzelVar) {
        return zzd(null, zzelVar);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzel<Integer> zzelVar) {
        if (str != null) {
            String zza = this.zzb.zza(str, zzelVar.zza());
            if (!TextUtils.isEmpty(zza)) {
                try {
                    return zzelVar.zza(Integer.valueOf(Integer.parseInt(zza))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzelVar.zza(null).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public final Boolean zzb(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzy = zzy();
        if (zzy == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (zzy.containsKey(str)) {
            return Boolean.valueOf(zzy.getBoolean(str));
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzel<Double> zzelVar) {
        if (str != null) {
            String zza = this.zzb.zza(str, zzelVar.zza());
            if (!TextUtils.isEmpty(zza)) {
                try {
                    return zzelVar.zza(Double.valueOf(Double.parseDouble(zza))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzelVar.zza(null).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> zzc(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzy()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzew r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zzn()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzew r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzf()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzc(java.lang.String):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final boolean zzd(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzel<Boolean> zzelVar) {
        Boolean zza;
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzelVar.zza());
            if (!TextUtils.isEmpty(zza2)) {
                zza = zzelVar.zza(Boolean.valueOf(Boolean.parseBoolean(zza2)));
                return zza.booleanValue();
            }
        }
        zza = zzelVar.zza(null);
        return zza.booleanValue();
    }

    public final long zze() {
        zzu();
        return 19000L;
    }

    public final boolean zze(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zze(String str, zzel<Boolean> zzelVar) {
        return zzd(str, zzelVar);
    }

    public final boolean zzf() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzg(String str) {
        zzel<String> zzelVar = zzap.zzai;
        return zzelVar.zza(str == null ? null : this.zzb.zza(str, zzelVar.zza()));
    }

    public final boolean zzg() {
        zzu();
        Boolean zzb = zzb("firebase_analytics_collection_deactivated");
        return zzb != null && zzb.booleanValue();
    }

    public final Boolean zzh() {
        zzu();
        return zzb("firebase_analytics_collection_enabled");
    }

    public final Boolean zzi() {
        zzb();
        Boolean zzb = zzb("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzb == null || zzb.booleanValue());
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeu zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkm zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzft zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzew zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }

    public final String zzv() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzw() {
        return zza("debug.deferred.deeplink", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzx() {
        if (this.zza == null) {
            this.zza = zzb("app_measurement_lite");
            if (this.zza == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.a.zzt();
    }
}
