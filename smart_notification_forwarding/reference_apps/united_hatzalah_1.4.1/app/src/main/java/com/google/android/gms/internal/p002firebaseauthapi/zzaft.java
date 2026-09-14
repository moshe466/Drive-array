package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;
import t.C0694j;

/* loaded from: classes.dex */
public final class zzaft {
    private static final Map<String, zzafv> zza = new C0694j(0);

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzaex zzaexVar) {
        zza(str, zzaexVar);
        return new zzafs(onVerificationStateChangedCallbacks, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaex zzaexVar) {
        zza.put(str, new zzafv(zzaexVar, DefaultClock.getInstance().currentTimeMillis()));
    }

    public static boolean zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzafv> map = zza;
        if (map.containsKey(str)) {
            zzafv zzafvVar = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzafvVar.zzb < 120000) {
                zzaex zzaexVar = zzafvVar.zza;
                if (zzaexVar == null) {
                    return true;
                }
                zzaexVar.zza(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zza(str, null);
            return false;
        }
        zza(str, null);
        return false;
    }
}
