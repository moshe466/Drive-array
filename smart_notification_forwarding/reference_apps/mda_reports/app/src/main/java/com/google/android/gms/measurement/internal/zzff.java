package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzff extends zzgu {

    @VisibleForTesting
    static final Pair<String, Long> b = new Pair<>("", 0L);
    private boolean zzaa;
    private long zzab;
    public zzfj zzb;
    public final zzfk zzc;
    public final zzfk zzd;
    public final zzfk zze;
    public final zzfk zzf;
    public final zzfk zzg;
    public final zzfk zzh;
    public final zzfk zzi;
    public final zzfm zzj;
    public final zzfk zzk;
    public final zzfk zzl;
    public final zzfh zzm;
    public final zzfm zzn;
    public final zzfh zzo;
    public final zzfh zzp;
    public final zzfk zzq;
    public final zzfk zzr;
    public boolean zzs;
    public zzfh zzt;
    public zzfh zzu;
    public zzfk zzv;
    public final zzfm zzw;
    private SharedPreferences zzy;
    private String zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzff(zzga zzgaVar) {
        super(zzgaVar);
        this.zzc = new zzfk(this, "last_upload", 0L);
        this.zzd = new zzfk(this, "last_upload_attempt", 0L);
        this.zze = new zzfk(this, "backoff", 0L);
        this.zzf = new zzfk(this, "last_delete_stale", 0L);
        this.zzk = new zzfk(this, "time_before_start", 10000L);
        this.zzl = new zzfk(this, "session_timeout", 1800000L);
        this.zzm = new zzfh(this, "start_new_session", true);
        this.zzq = new zzfk(this, "last_pause_time", 0L);
        this.zzr = new zzfk(this, "time_active", 0L);
        this.zzn = new zzfm(this, "non_personalized_ads", null);
        this.zzo = new zzfh(this, "use_dynamite_api", false);
        this.zzp = new zzfh(this, "allow_remote_dynamite", false);
        this.zzg = new zzfk(this, "midnight_offset", 0L);
        this.zzh = new zzfk(this, "first_open_time", 0L);
        this.zzi = new zzfk(this, "app_install_time", 0L);
        this.zzj = new zzfm(this, "app_instance_id", null);
        this.zzt = new zzfh(this, "app_backgrounded", false);
        this.zzu = new zzfh(this, "deep_link_retrieval_complete", false);
        this.zzv = new zzfk(this, "deep_link_retrieval_attempts", 0L);
        this.zzw = new zzfm(this, "firebase_feature_rollouts", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    @WorkerThread
    protected final void a() {
        this.zzy = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzs = this.zzy.getBoolean("has_been_opened", false);
        if (!this.zzs) {
            SharedPreferences.Editor edit = this.zzy.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzfj(this, "health_monitor", Math.max(0L, zzap.zzc.zza(null).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @WorkerThread
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        String str2 = this.zzz;
        if (str2 != null && elapsedRealtime < this.zzab) {
            return new Pair<>(str2, Boolean.valueOf(this.zzaa));
        }
        this.zzab = elapsedRealtime + zzt().zza(str, zzap.zzb);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzz = advertisingIdInfo.getId();
                this.zzaa = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzz == null) {
                this.zzz = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzz = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        zzd();
        zzr().zzx().zza("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi = zzkm.zzi();
        if (zzi == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzi.digest(str2.getBytes())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(boolean z) {
        zzd();
        zzr().zzx().zza("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    protected final boolean zze() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzj() {
        zzd();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzk() {
        zzd();
        zzr().zzx().zza("Clearing collection preferences.");
        Boolean zzv = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv != null) {
            zzb(zzv.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzx() {
        return this.zzy.contains("deferred_analytics_collection");
    }
}
