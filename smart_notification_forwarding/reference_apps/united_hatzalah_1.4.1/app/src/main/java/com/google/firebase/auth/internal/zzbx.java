package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbx {
    FirebaseApp zza;
    zzbs zzb;
    private final Object zzc;
    private final Map<String, Task<RecaptchaTasksClient>> zzd;
    private zzahk zze;
    private FirebaseAuth zzf;

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbv());
    }

    private final Task<RecaptchaTasksClient> zzc(String str) {
        Task<RecaptchaTasksClient> task;
        synchronized (this.zzc) {
            task = this.zzd.get(str);
        }
        return task;
    }

    private static String zzd(String str) {
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(str)) {
            return "*";
        }
        return str;
    }

    public final Task<String> zza(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String zzd = zzd(str);
        Task<RecaptchaTasksClient> zzc = zzc(zzd);
        if (bool.booleanValue() || zzc == null) {
            zzc = zza(zzd, bool);
        }
        return zzc.continueWithTask(new zzbz(this, recaptchaAction));
    }

    public final boolean zzb(String str) {
        boolean z3;
        synchronized (this.zzc) {
            try {
                zzahk zzahkVar = this.zze;
                if (zzahkVar != null && zzahkVar.zzc(str)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } finally {
            }
        }
        return z3;
    }

    private zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbs zzbsVar) {
        this.zzc = new Object();
        this.zzd = new HashMap();
        this.zza = firebaseApp;
        this.zzf = firebaseAuth;
        this.zzb = zzbsVar;
    }

    public final Task<RecaptchaTasksClient> zza(String str, Boolean bool) {
        Task<RecaptchaTasksClient> zzc;
        String zzd = zzd(str);
        return (bool.booleanValue() || (zzc = zzc(zzd)) == null) ? this.zzf.zza("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbw(this, zzd)) : zzc;
    }

    public static /* synthetic */ void zza(zzbx zzbxVar, zzahk zzahkVar, Task task, String str) {
        synchronized (zzbxVar.zzc) {
            zzbxVar.zze = zzahkVar;
            zzbxVar.zzd.put(str, task);
        }
    }

    public final boolean zza(String str) {
        String zzb;
        Preconditions.checkNotNull(str);
        zzahk zzahkVar = this.zze;
        if (zzahkVar == null || (zzb = zzahkVar.zzb(str)) == null) {
            return false;
        }
        return zzb.equals("AUDIT");
    }
}
