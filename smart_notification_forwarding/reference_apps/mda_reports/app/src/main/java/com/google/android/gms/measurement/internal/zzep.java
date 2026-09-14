package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmu;
import java.util.List;

/* loaded from: classes.dex */
public final class zzep extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzep(zzga zzgaVar, long j) {
        super(zzgaVar);
        this.zzg = j;
    }

    @VisibleForTesting
    @WorkerThread
    private final String zzai() {
        zzey zzj;
        String str;
        if (zzmu.zzb() && zzt().zza(zzap.zzcf)) {
            zzj = zzr().zzx();
            str = "Disabled IID for tests.";
        } else {
            try {
                Class<?> loadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzj = zzr().zzk();
                        str = "Failed to retrieve Firebase Instance Id";
                    }
                } catch (Exception unused2) {
                    zzj = zzr().zzj();
                    str = "Failed to obtain Firebase Analytics instance";
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        }
        zzj.zza(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final zzm zza(String str) {
        boolean z;
        Boolean bool;
        Boolean zzb;
        zzd();
        zzb();
        String zzab = zzab();
        String zzac = zzac();
        zzw();
        String str2 = this.zzb;
        long zzaf = zzaf();
        zzw();
        String str3 = this.zzd;
        long zze = zzt().zze();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.a.zzi().a(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zzab2 = this.a.zzab();
        boolean z2 = !zzs().zzs;
        zzd();
        zzb();
        String zzai = !this.a.zzab() ? null : zzai();
        long b = this.a.b();
        int zzag = zzag();
        boolean booleanValue = zzt().zzi().booleanValue();
        zzx zzt = zzt();
        zzt.zzb();
        Boolean zzb2 = zzt.zzb("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzb2 == null || zzb2.booleanValue()).booleanValue();
        zzff zzs = zzs();
        zzs.zzd();
        boolean z3 = zzs.zzg().getBoolean("deferred_analytics_collection", false);
        String zzad = zzad();
        if (!zzt().zza(zzap.zzba) || (zzb = zzt().zzb("google_analytics_default_allow_ad_personalization_signals")) == null) {
            z = z2;
            bool = null;
        } else {
            bool = Boolean.valueOf(!zzb.booleanValue());
            z = z2;
        }
        return new zzm(zzab, zzac, str2, zzaf, str3, zze, j, str, zzab2, z, zzai, 0L, b, zzag, booleanValue, booleanValue2, z3, zzad, bool, this.zzg, zzt().zza(zzap.zzbk) ? this.zzh : null, (zzle.zzb() && zzt().zza(zzap.zzcc)) ? zzae() : null);
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(1:3)(6:102|103|(1:105)(2:120|(1:122))|106|107|(27:109|(1:111)(1:118)|113|114|5|(1:101)(1:9)|10|(1:100)(1:14)|15|(1:(1:18)(1:19))|(10:21|(2:23|(2:25|26))(2:(1:(1:37)(1:36))(2:30|(1:32))|26)|38|(1:42)|43|44|(1:46)(1:96)|47|48|(7:93|(2:95|91)|(1:60)|62|(3:64|(3:66|(1:68)(3:70|(3:73|(1:75)(1:76)|71)|77)|69)(0)|(1:79))|80|(1:(2:83|84)(2:86|87))(2:88|89))(9:52|(1:54)(1:92)|55|(2:90|91)|(0)|62|(0)|80|(0)(0)))|99|38|(2:40|42)|43|44|(0)(0)|47|48|(1:50)|93|(0)|(0)|62|(0)|80|(0)(0)))|4|5|(1:7)|101|10|(1:12)|100|15|(0)|(0)|99|38|(0)|43|44|(0)(0)|47|48|(0)|93|(0)|(0)|62|(0)|80|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0204, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0205, code lost:
    
        zzr().zzf().zza("getGoogleAppId or isMeasurementEnabled failed with exception. appId", com.google.android.gms.measurement.internal.zzew.zza(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a4 A[Catch: IllegalStateException -> 0x0204, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x0204, blocks: (B:44:0x018d, B:47:0x019a, B:50:0x01a4, B:52:0x01b0, B:55:0x01c7, B:57:0x01cf, B:60:0x01f2, B:90:0x01d5, B:91:0x01d9, B:93:0x01dc, B:95:0x01e2), top: B:43:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f2 A[Catch: IllegalStateException -> 0x0204, TRY_LEAVE, TryCatch #3 {IllegalStateException -> 0x0204, blocks: (B:44:0x018d, B:47:0x019a, B:50:0x01a4, B:52:0x01b0, B:55:0x01c7, B:57:0x01cf, B:60:0x01f2, B:90:0x01d5, B:91:0x01d9, B:93:0x01dc, B:95:0x01e2), top: B:43:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2 A[Catch: IllegalStateException -> 0x0204, TryCatch #3 {IllegalStateException -> 0x0204, blocks: (B:44:0x018d, B:47:0x019a, B:50:0x01a4, B:52:0x01b0, B:55:0x01c7, B:57:0x01cf, B:60:0x01f2, B:90:0x01d5, B:91:0x01d9, B:93:0x01dc, B:95:0x01e2), top: B:43:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0199  */
    @Override // com.google.android.gms.measurement.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzaa() {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zzaa():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzab() {
        zzw();
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzac() {
        zzw();
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzad() {
        zzw();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzae() {
        zzw();
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzaf() {
        zzw();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzag() {
        zzw();
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final List<String> zzah() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhb zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzep zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzij zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzii zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzes zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzjo zzk() {
        return super.zzk();
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

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return true;
    }
}
