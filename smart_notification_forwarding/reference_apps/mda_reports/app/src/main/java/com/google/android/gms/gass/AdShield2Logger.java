package com.google.android.gms.gass;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbm;
import com.google.android.gms.internal.ads.zzdem;
import com.google.android.gms.internal.ads.zzsr;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class AdShield2Logger {
    public static final int EVENTID_CLICK_SIGNALS = 5000;
    public static final int EVENTID_ERROR_GET_PROGRAM = 4002;
    public static final int EVENTID_ERROR_LAST_CRASH = 4001;
    public static final int EVENTID_ERROR_RUN_VM_INIT = 4000;
    public static final int EVENTID_GASSDGCLIENT_CONNECTED_EXCEPTION = 2010;
    public static final int EVENTID_GASSDGCLIENT_EXCEPTION = 2009;
    public static final int EVENTID_LATENCY_CLOSE = 3001;
    public static final int EVENTID_LATENCY_GASSDGCLIENT_GET_PROGRAM = 3004;
    public static final int EVENTID_LATENCY_INIT_VM = 3000;
    public static final int EVENTID_LATENCY_REPORT_TOUCH = 3003;
    public static final int EVENTID_LATENCY_SNAPSHOT = 3002;
    public static final int EVENTID_LOAD_CLASS_EXCEPTION = 2008;
    public static final int EVENTID_QUERY_SIGNALS = 5001;
    public static final int EVENTID_VIEW_SIGNALS = 5002;
    public static final int EVENTID_VM_CLOSE_EXCEPTION = 2003;
    public static final int EVENTID_VM_CREATE_EXCEPTION = 2004;
    public static final int EVENTID_VM_INIT_EXCEPTION = 2001;
    public static final int EVENTID_VM_INIT_PROGRAM_EXCEPTION = 2002;
    public static final int EVENTID_VM_LAST_CRASH_EXCEPTION = 2006;
    public static final int EVENTID_VM_SNAP_EXCEPTION = 2007;
    public static final int EVENTID_VM_TOUCH_EXCEPTION = 2005;
    public static final int GASS_EVENTID_NO_PROGRAM = 5004;
    public static final int GASS_EVENTID_RETURN_PROGRAM = 5003;
    private final Executor executor;
    private final Task<zzsr> zzgrx;
    private final Context zzup;

    private AdShield2Logger(@NonNull Context context, @NonNull Executor executor, @NonNull Task<zzsr> task) {
        this.zzup = context;
        this.executor = executor;
        this.zzgrx = task;
    }

    public static AdShield2Logger createAdShield2Logger(@NonNull final Context context, @NonNull Executor executor) {
        return new AdShield2Logger(context, executor, Tasks.call(executor, new Callable(context) { // from class: com.google.android.gms.gass.zzb
            private final Context zzcri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzsr(this.zzcri, "GLAS", null);
            }
        }));
    }

    private final Task<Boolean> zza(final int i, long j, Exception exc, String str, Map<String, String> map) {
        final zzbm.zza.C0009zza zzc = zzbm.zza.zzs().zzi(this.zzup.getPackageName()).zzc(j);
        if (exc != null) {
            zzc.zzj(zzdem.zza(exc)).zzk(exc.getClass().getName());
        }
        if (str != null) {
            zzc.zzm(str);
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                zzc.zza(zzbm.zza.zzb.zzu().zzs(str2).zzt(map.get(str2)));
            }
        }
        return this.zzgrx.continueWith(this.executor, new Continuation(zzc, i) { // from class: com.google.android.gms.gass.zza
            private final int zzdtf;
            private final zzbm.zza.C0009zza zzgry;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgry = zzc;
                this.zzdtf = i;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                boolean z;
                zzbm.zza.C0009zza c0009zza = this.zzgry;
                int i2 = this.zzdtf;
                if (task.isSuccessful()) {
                    zzsv zzf = ((zzsr) task.getResult()).zzf(((zzbm.zza) c0009zza.zzbaf()).toByteArray());
                    zzf.zzbr(i2);
                    zzf.zzdn();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public Task<Boolean> logException(int i, long j, Exception exc) {
        return zza(i, j, exc, null, null);
    }

    public Task<Boolean> logLatency(int i, long j) {
        return zza(i, j, null, null, null);
    }

    public Task<Boolean> logSignals(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, null, str, map);
    }
}
