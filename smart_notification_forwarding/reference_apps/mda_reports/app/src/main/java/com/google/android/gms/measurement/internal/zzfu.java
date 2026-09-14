package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzfu extends zzkb implements zzz {

    @VisibleForTesting
    private static int zzb = 65535;

    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzf;
    private final Map<String, zzbo.zzb> zzg;
    private final Map<String, Map<String, Integer>> zzh;
    private final Map<String, String> zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(zzke zzkeVar) {
        super(zzkeVar);
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    @WorkerThread
    private final zzbo.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbo.zzb.zzj();
        }
        try {
            zzbo.zzb zzbVar = (zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) ((zzbo.zzb.zza) zzki.a(zzbo.zzb.zzi(), bArr)).zzu());
            zzr().zzx().zza("Parsed config. version, gmp_app_id", zzbVar.zza() ? Long.valueOf(zzbVar.zzb()) : null, zzbVar.zzc() ? zzbVar.zzd() : null);
            return zzbVar;
        } catch (com.google.android.gms.internal.measurement.zzfo | RuntimeException e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzew.zza(str), e);
            return zzbo.zzb.zzj();
        }
    }

    private static Map<String, String> zza(zzbo.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null) {
            for (zzbo.zzc zzcVar : zzbVar.zze()) {
                arrayMap.put(zzcVar.zza(), zzcVar.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzbo.zzb.zza zzaVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzbo.zza.C0031zza zzbm = zzaVar.zza(i).zzbm();
                if (TextUtils.isEmpty(zzbm.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String zzb2 = zzgv.zzb(zzbm.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzbm = zzbm.zza(zzb2);
                        zzaVar.zza(i, zzbm);
                    }
                    arrayMap.put(zzbm.zza(), Boolean.valueOf(zzbm.zzb()));
                    arrayMap2.put(zzbm.zza(), Boolean.valueOf(zzbm.zzc()));
                    if (zzbm.zzd()) {
                        if (zzbm.zze() < zzc || zzbm.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", zzbm.zza(), Integer.valueOf(zzbm.zze()));
                        } else {
                            arrayMap3.put(zzbm.zza(), Integer.valueOf(zzbm.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzi(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd = zzi().zzd(str);
            if (zzd != null) {
                zzbo.zzb.zza zzbm = zza(str, zzd).zzbm();
                zza(str, zzbm);
                this.zzd.put(str, zza((zzbo.zzb) zzbm.zzu()));
                this.zzg.put(str, (zzbo.zzb) zzbm.zzu());
                this.zzi.put(str, null);
                return;
            }
            this.zzd.put(str, null);
            this.zze.put(str, null);
            this.zzf.put(str, null);
            this.zzg.put(str, null);
            this.zzi.put(str, null);
            this.zzh.put(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long a(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0L;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzew.zza(str), e);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean a(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzbo.zzb.zza zzbm = zza(str, bArr).zzbm();
        if (zzbm == null) {
            return false;
        }
        zza(str, zzbm);
        this.zzg.put(str, (zzbo.zzb) zzbm.zzu());
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzbo.zzb) zzbm.zzu()));
        zzi().b(str, new ArrayList(zzbm.zzb()));
        try {
            zzbm.zzc();
            bArr = ((zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzbm.zzu())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzew.zza(str), e);
        }
        zzac zzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzi.zzd();
        zzi.zzak();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzi.a().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                zzi.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzew.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi.zzr().zzf().zza("Error storing remote config. appId", zzew.zza(str), e2);
        }
        this.zzg.put(str, (zzbo.zzb) zzbm.zzu());
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzkc
    public final /* bridge */ /* synthetic */ zzn e_() {
        return super.e_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final zzbo.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    @WorkerThread
    public final String zza(String str, String str2) {
        zzd();
        zzi(str);
        Map<String, String> map = this.zzd.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzkm.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzkm.zza(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        this.zzi.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzf.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int zzd(String str, String str2) {
        Integer num;
        zzd();
        zzi(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzkb
    protected final boolean zze() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zze(String str) {
        zzd();
        zzbo.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzkc
    public final /* bridge */ /* synthetic */ zzki zzg() {
        return super.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzkc
    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzkc
    public final /* bridge */ /* synthetic */ zzfu zzj() {
        return super.zzj();
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
}
