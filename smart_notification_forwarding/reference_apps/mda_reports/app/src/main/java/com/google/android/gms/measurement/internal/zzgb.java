package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class zzgb extends zzen {
    private final zzke zza;
    private Boolean zzb;

    @Nullable
    private String zzc;

    public zzgb(zzke zzkeVar) {
        this(zzkeVar, null);
    }

    private zzgb(zzke zzkeVar, @Nullable String str) {
        Preconditions.checkNotNull(zzkeVar);
        this.zza = zzkeVar;
        this.zzc = null;
    }

    @VisibleForTesting
    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }

    @BinderThread
    private final void zza(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.zza.zzr().zzf().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    z2 = true;
                    this.zzb = Boolean.valueOf(z2);
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzew.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @BinderThread
    private final void zzb(zzm zzmVar, boolean z) {
        Preconditions.checkNotNull(zzmVar);
        zza(zzmVar.zza, false);
        this.zza.zzj().zza(zzmVar.zzb, zzmVar.zzr, zzmVar.zzv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzan a(zzan zzanVar, zzm zzmVar) {
        zzam zzamVar;
        boolean z = false;
        if ("_cmp".equals(zzanVar.zza) && (zzamVar = zzanVar.zzb) != null && zzamVar.zza() != 0) {
            String c = zzanVar.zzb.c("_cis");
            if (!TextUtils.isEmpty(c) && (("referrer broadcast".equals(c) || "referrer API".equals(c)) && this.zza.zzb().zze(zzmVar.zza, zzap.zzao))) {
                z = true;
            }
        }
        if (!z) {
            return zzanVar;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzanVar.toString());
        return new zzan("_cmpx", zzanVar.zzb, zzanVar.zzc, zzanVar.zzd);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final List<zzkl> zza(zzm zzmVar, boolean z) {
        zzb(zzmVar, false);
        try {
            List<zzkn> list = (List) this.zza.zzq().zza(new zzgn(this, zzmVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzknVar : list) {
                if (z || !zzkm.zze(zzknVar.c)) {
                    arrayList.add(new zzkl(zzknVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzew.zza(zzmVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final List<zzv> zza(String str, String str2, zzm zzmVar) {
        zzb(zzmVar, false);
        try {
            return (List) this.zza.zzq().zza(new zzgi(this, zzmVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final List<zzv> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgh(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final List<zzkl> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzkn> list = (List) this.zza.zzq().zza(new zzgf(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzknVar : list) {
                if (z || !zzkm.zze(zzknVar.c)) {
                    arrayList.add(new zzkl(zzknVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzew.zza(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final List<zzkl> zza(String str, String str2, boolean z, zzm zzmVar) {
        zzb(zzmVar, false);
        try {
            List<zzkn> list = (List) this.zza.zzq().zza(new zzgg(this, zzmVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkn zzknVar : list) {
                if (z || !zzkm.zze(zzknVar.c)) {
                    arrayList.add(new zzkl(zzknVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzew.zza(zzmVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzgp(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzan zzanVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzanVar);
        zzb(zzmVar, false);
        zza(new zzgj(this, zzanVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzan zzanVar, String str, String str2) {
        Preconditions.checkNotNull(zzanVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzgm(this, zzanVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzkl zzklVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzklVar);
        zzb(zzmVar, false);
        zza(new zzgo(this, zzklVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzm zzmVar) {
        zzb(zzmVar, false);
        zza(new zzgq(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzv zzvVar) {
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotNull(zzvVar.zzc);
        zza(zzvVar.zza, true);
        zza(new zzgd(this, new zzv(zzvVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zza(zzv zzvVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotNull(zzvVar.zzc);
        zzb(zzmVar, false);
        zzv zzvVar2 = new zzv(zzvVar);
        zzvVar2.zza = zzmVar.zza;
        zza(new zzgs(this, zzvVar2, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final byte[] zza(zzan zzanVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzanVar);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzanVar.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgl(this, zzanVar, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzew.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzanVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzew.zza(str), this.zza.zzi().zza(zzanVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zzb(zzm zzmVar) {
        zzb(zzmVar, false);
        zza(new zzge(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final String zzc(zzm zzmVar) {
        zzb(zzmVar, false);
        return this.zza.d(zzmVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    @BinderThread
    public final void zzd(zzm zzmVar) {
        zza(zzmVar.zza, false);
        zza(new zzgk(this, zzmVar));
    }
}
