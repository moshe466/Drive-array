package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzga implements zzgt {
    private static volatile zzga zza;
    private long zzaa;
    private volatile Boolean zzab;

    @VisibleForTesting
    private Boolean zzac;

    @VisibleForTesting
    private Boolean zzad;
    private int zzae;
    private final long zzag;
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;
    private final zzw zzg;
    private final zzx zzh;
    private final zzff zzi;
    private final zzew zzj;
    private final zzft zzk;
    private final zzjo zzl;
    private final zzkm zzm;
    private final zzeu zzn;
    private final Clock zzo;
    private final zzii zzp;
    private final zzhb zzq;
    private final zzb zzr;
    private final zzhz zzs;
    private zzes zzt;
    private zzij zzu;
    private zzah zzv;
    private zzep zzw;
    private zzfl zzx;
    private Boolean zzz;
    private boolean zzy = false;
    private AtomicInteger zzaf = new AtomicInteger(0);

    private zzga(zzhc zzhcVar) {
        zzey zzi;
        String str;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzhcVar);
        this.zzg = new zzw(zzhcVar.a);
        zzem.a = this.zzg;
        this.zzb = zzhcVar.a;
        this.zzc = zzhcVar.b;
        this.zzd = zzhcVar.c;
        this.zze = zzhcVar.d;
        this.zzf = zzhcVar.h;
        this.zzab = zzhcVar.e;
        com.google.android.gms.internal.measurement.zzv zzvVar = zzhcVar.g;
        if (zzvVar != null && (bundle = zzvVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzac = (Boolean) obj;
            }
            Object obj2 = zzvVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzad = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzcl.zza(this.zzb);
        this.zzo = DefaultClock.getInstance();
        this.zzag = this.zzo.currentTimeMillis();
        this.zzh = new zzx(this);
        zzff zzffVar = new zzff(this);
        zzffVar.zzab();
        this.zzi = zzffVar;
        zzew zzewVar = new zzew(this);
        zzewVar.zzab();
        this.zzj = zzewVar;
        zzkm zzkmVar = new zzkm(this);
        zzkmVar.zzab();
        this.zzm = zzkmVar;
        zzeu zzeuVar = new zzeu(this);
        zzeuVar.zzab();
        this.zzn = zzeuVar;
        this.zzr = new zzb(this);
        zzii zziiVar = new zzii(this);
        zziiVar.zzx();
        this.zzp = zziiVar;
        zzhb zzhbVar = new zzhb(this);
        zzhbVar.zzx();
        this.zzq = zzhbVar;
        zzjo zzjoVar = new zzjo(this);
        zzjoVar.zzx();
        this.zzl = zzjoVar;
        zzhz zzhzVar = new zzhz(this);
        zzhzVar.zzab();
        this.zzs = zzhzVar;
        zzft zzftVar = new zzft(this);
        zzftVar.zzab();
        this.zzk = zzftVar;
        com.google.android.gms.internal.measurement.zzv zzvVar2 = zzhcVar.g;
        if (zzvVar2 != null && zzvVar2.zzb != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzb.getApplicationContext() instanceof Application) {
            zzhb zzh = zzh();
            if (zzh.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzh.zzn().getApplicationContext();
                if (zzh.b == null) {
                    zzh.b = new zzhy(zzh, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzh.b);
                    application.registerActivityLifecycleCallbacks(zzh.b);
                    zzi = zzh.zzr().zzx();
                    str = "Registered activity lifecycle callback";
                }
            }
            this.zzk.zza(new zzgc(this, zzhcVar));
        }
        zzi = zzr().zzi();
        str = "Application context is not an Application";
        zzi.zza(str);
        this.zzk.zza(new zzgc(this, zzhcVar));
    }

    public static zzga zza(Context context, com.google.android.gms.internal.measurement.zzv zzvVar) {
        Bundle bundle;
        if (zzvVar != null && (zzvVar.zze == null || zzvVar.zzf == null)) {
            zzvVar = new com.google.android.gms.internal.measurement.zzv(zzvVar.zza, zzvVar.zzb, zzvVar.zzc, zzvVar.zzd, null, null, zzvVar.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzga.class) {
                if (zza == null) {
                    zza = new zzga(new zzhc(context, zzvVar));
                }
            }
        } else if (zzvVar != null && (bundle = zzvVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            zza.a(zzvVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zza;
    }

    @VisibleForTesting
    public static zzga zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new com.google.android.gms.internal.measurement.zzv(0L, 0L, true, null, null, null, bundle));
    }

    private static void zza(zzgr zzgrVar) {
        if (zzgrVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzhc zzhcVar) {
        zzey zzv;
        String concat;
        zzq().zzd();
        zzah zzahVar = new zzah(this);
        zzahVar.zzab();
        this.zzv = zzahVar;
        zzep zzepVar = new zzep(this, zzhcVar.f);
        zzepVar.zzx();
        this.zzw = zzepVar;
        zzes zzesVar = new zzes(this);
        zzesVar.zzx();
        this.zzt = zzesVar;
        zzij zzijVar = new zzij(this);
        zzijVar.zzx();
        this.zzu = zzijVar;
        this.zzm.zzac();
        this.zzi.zzac();
        this.zzx = new zzfl(this);
        this.zzw.zzy();
        zzr().zzv().zza("App measurement is starting up, version", Long.valueOf(this.zzh.zze()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzab = zzepVar.zzab();
        if (TextUtils.isEmpty(this.zzc)) {
            if (zzi().a(zzab)) {
                zzv = zzr().zzv();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzv = zzr().zzv();
                String valueOf = String.valueOf(zzab);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            zzv.zza(concat);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzae != this.zzaf.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzae), Integer.valueOf(this.zzaf.get()));
        }
        this.zzy = true;
    }

    private final zzhz zzai() {
        zzb(this.zzs);
        return this.zzs;
    }

    private final void zzaj() {
        if (!this.zzy) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zzb(zze zzeVar) {
        if (zzeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzeVar.zzv()) {
            return;
        }
        String valueOf = String.valueOf(zzeVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zzb(zzgu zzguVar) {
        if (zzguVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzguVar.zzz()) {
            return;
        }
        String valueOf = String.valueOf(zzguVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void a() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzo.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zzag));
            zzc().zzh.zza(this.zzag);
        }
        if (f()) {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzkm.a(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzu.zzah();
                    this.zzu.zzaf();
                    zzc().zzh.zza(this.zzag);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (com.google.android.gms.internal.measurement.zzkb.zzb() && this.zzh.zza(zzap.zzcl) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzw.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzw.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zzab = zzab();
                if (!zzc().zzx() && !this.zzh.zzg()) {
                    zzc().zzc(!zzab);
                }
                if (zzab) {
                    zzh().zzai();
                }
                zze().b.a();
                zzw().zza(new AtomicReference<>());
            }
        } else if (zzab()) {
            if (!zzi().zzd("android.permission.INTERNET")) {
                zzr().zzf().zza("App is missing INTERNET permission");
            }
            if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zzb).isCallerInstantApp() && !this.zzh.zzx()) {
                if (!zzfq.zza(this.zzb)) {
                    zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkm.a(this.zzb, false)) {
                    zzr().zzf().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzr().zzf().zza("Uploading is not possible. App measurement disabled");
        }
        zzc().zzo.zza(this.zzh.zza(zzap.zzbh));
        zzc().zzp.zza(this.zzh.zza(zzap.zzbi));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zze zzeVar) {
        this.zzae++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzgu zzguVar) {
        this.zzae++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzu.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkm zzi = zzi();
            zzi.zzb();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzi.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzq.zza("auto", "_cmp", bundle);
            zzkm zzi2 = zzi();
            if (TextUtils.isEmpty(optString) || !zzi2.a(optString, optDouble)) {
                return;
            }
            zzi2.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(boolean z) {
        this.zzab = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b() {
        Long valueOf = Long.valueOf(zzc().zzh.zza());
        return valueOf.longValue() == 0 ? this.zzag : Math.min(this.zzag, valueOf.longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.zzaf.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean f() {
        zzaj();
        zzq().zzd();
        Boolean bool = this.zzz;
        if (bool == null || this.zzaa == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzo.elapsedRealtime() - this.zzaa) > 1000)) {
            this.zzaa = this.zzo.elapsedRealtime();
            boolean z = true;
            this.zzz = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzb).isCallerInstantApp() || this.zzh.zzx() || (zzfq.zza(this.zzb) && zzkm.a(this.zzb, false))));
            if (this.zzz.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzz = Boolean.valueOf(z);
            }
        }
        return this.zzz.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzft g() {
        return this.zzk;
    }

    @WorkerThread
    public final boolean zzaa() {
        return this.zzab != null && this.zzab.booleanValue();
    }

    @WorkerThread
    public final boolean zzab() {
        zzq().zzd();
        zzaj();
        if (this.zzh.zzg()) {
            return false;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean zzv = zzc().zzv();
        if (zzv != null) {
            return zzv.booleanValue();
        }
        Boolean zzh = this.zzh.zzh();
        if (zzh != null) {
            return zzh.booleanValue();
        }
        Boolean bool2 = this.zzac;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return false;
        }
        if (!this.zzh.zza(zzap.zzax) || this.zzab == null) {
            return true;
        }
        return this.zzab.booleanValue();
    }

    @WorkerThread
    public final void zzah() {
        zzq().zzd();
        zzb(zzai());
        String zzab = zzy().zzab();
        Pair<String, Boolean> zza2 = zzc().zza(zzab);
        if (!this.zzh.zzi().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!zzai().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL zza3 = zzi().zza(zzy().zzt().zze(), zzab, (String) zza2.first, zzc().zzv.zza() - 1);
        zzhz zzai = zzai();
        zzic zzicVar = new zzic(this) { // from class: com.google.android.gms.measurement.internal.zzfz
            private final zzga zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.measurement.internal.zzic
            public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.a(str, i, th, bArr, map);
            }
        };
        zzai.zzd();
        zzai.zzaa();
        Preconditions.checkNotNull(zza3);
        Preconditions.checkNotNull(zzicVar);
        zzai.zzq().zzb(new zzib(zzai, zzab, zza3, null, null, zzicVar));
    }

    public final zzx zzb() {
        return this.zzh;
    }

    public final zzff zzc() {
        zza(this.zzi);
        return this.zzi;
    }

    public final zzew zzd() {
        zzew zzewVar = this.zzj;
        if (zzewVar == null || !zzewVar.zzz()) {
            return null;
        }
        return this.zzj;
    }

    public final zzjo zze() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzfl zzf() {
        return this.zzx;
    }

    public final zzhb zzh() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzkm zzi() {
        zza(this.zzm);
        return this.zzm;
    }

    public final zzeu zzj() {
        zza(this.zzn);
        return this.zzn;
    }

    public final zzes zzk() {
        zzb(this.zzt);
        return this.zzt;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzc);
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzm() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzn() {
        return this.zzb;
    }

    public final String zzo() {
        return this.zzc;
    }

    public final String zzp() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzft zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzew zzr() {
        zzb(this.zzj);
        return this.zzj;
    }

    public final String zzs() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzu() {
        return this.zzg;
    }

    public final zzii zzv() {
        zzb(this.zzp);
        return this.zzp;
    }

    public final zzij zzw() {
        zzb(this.zzu);
        return this.zzu;
    }

    public final zzah zzx() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzep zzy() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzb zzz() {
        zzb zzbVar = this.zzr;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }
}
