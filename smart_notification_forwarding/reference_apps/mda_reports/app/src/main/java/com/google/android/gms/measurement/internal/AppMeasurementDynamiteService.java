package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;

@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzl {

    @VisibleForTesting
    zzga a = null;
    private Map<Integer, zzgz> zzb = new ArrayMap();

    /* loaded from: classes.dex */
    class zza implements zzha {
        private com.google.android.gms.internal.measurement.zzs zza;

        zza(com.google.android.gms.internal.measurement.zzs zzsVar) {
            this.zza = zzsVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzha
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.a.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* loaded from: classes.dex */
    class zzb implements zzgz {
        private com.google.android.gms.internal.measurement.zzs zza;

        zzb(com.google.android.gms.internal.measurement.zzs zzsVar) {
            this.zza = zzsVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgz
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.a.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zza(com.google.android.gms.internal.measurement.zzn zznVar, String str) {
        this.a.zzi().zza(zznVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void beginAdUnitExposure(String str, long j) {
        zza();
        this.a.zzz().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza();
        this.a.zzh().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void endAdUnitExposure(String str, long j) {
        zza();
        this.a.zzz().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void generateEventId(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzi().zza(zznVar, this.a.zzi().zzg());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzq().zza(new zzi(this, zznVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        zza(zznVar, this.a.zzh().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzq().zza(new zzj(this, zznVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        zza(zznVar, this.a.zzh().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        zza(zznVar, this.a.zzh().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        zza(zznVar, this.a.zzh().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzh();
        Preconditions.checkNotEmpty(str);
        this.a.zzi().zza(zznVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getTestFlag(com.google.android.gms.internal.measurement.zzn zznVar, int i) {
        zza();
        if (i == 0) {
            this.a.zzi().zza(zznVar, this.a.zzh().zzad());
            return;
        }
        if (i == 1) {
            this.a.zzi().zza(zznVar, this.a.zzh().zzae().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.a.zzi().zza(zznVar, this.a.zzh().zzaf().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.a.zzi().zza(zznVar, this.a.zzh().zzac().booleanValue());
                return;
            }
        }
        zzkm zzi = this.a.zzi();
        double doubleValue = this.a.zzh().zzag().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            zzi.a.zzr().zzi().zza("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzq().zza(new zzk(this, zznVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initForTests(Map map) {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzv zzvVar, long j) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzga zzgaVar = this.a;
        if (zzgaVar == null) {
            this.a = zzga.zza(context, zzvVar);
        } else {
            zzgaVar.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzn zznVar) {
        zza();
        this.a.zzq().zza(new zzl(this, zznVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zza();
        this.a.zzh().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzn zznVar, long j) {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", SettingsJsonConstants.APP_KEY);
        this.a.zzq().zza(new zzh(this, zznVar, new zzan(str2, new zzam(bundle), SettingsJsonConstants.APP_KEY, j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zza();
        this.a.zzr().a(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzn zznVar, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        Bundle bundle = new Bundle();
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.a.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzhy zzhyVar = this.a.zzh().b;
        if (zzhyVar != null) {
            this.a.zzh().zzab();
            zzhyVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzn zznVar, long j) {
        zza();
        zznVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzs zzsVar) {
        zza();
        zzgz zzgzVar = this.zzb.get(Integer.valueOf(zzsVar.zza()));
        if (zzgzVar == null) {
            zzgzVar = new zzb(zzsVar);
            this.zzb.put(Integer.valueOf(zzsVar.zza()), zzgzVar);
        }
        this.a.zzh().zza(zzgzVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void resetAnalyticsData(long j) {
        zza();
        this.a.zzh().zzd(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setConditionalUserProperty(Bundle bundle, long j) {
        zza();
        if (bundle == null) {
            this.a.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.a.zzh().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        zza();
        this.a.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setDataCollectionEnabled(boolean z) {
        zza();
        this.a.zzh().zzb(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzs zzsVar) {
        zza();
        zzhb zzh = this.a.zzh();
        zza zzaVar = new zza(zzsVar);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza(new zzhj(zzh, zzaVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzt zztVar) {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMeasurementEnabled(boolean z, long j) {
        zza();
        this.a.zzh().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMinimumSessionDuration(long j) {
        zza();
        this.a.zzh().zza(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setSessionTimeoutDuration(long j) {
        zza();
        this.a.zzh().zzb(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserId(String str, long j) {
        zza();
        this.a.zzh().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        zza();
        this.a.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzs zzsVar) {
        zza();
        zzgz remove = this.zzb.remove(Integer.valueOf(zzsVar.zza()));
        if (remove == null) {
            remove = new zzb(zzsVar);
        }
        this.a.zzh().zzb(remove);
    }
}
