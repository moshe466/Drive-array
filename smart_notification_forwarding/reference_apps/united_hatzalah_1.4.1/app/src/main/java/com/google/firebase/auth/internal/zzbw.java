package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import e0.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbw implements Continuation<zzahk, Task<RecaptchaTasksClient>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;

    public zzbw(zzbx zzbxVar, String str) {
        this.zza = str;
        this.zzb = zzbxVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzahk> task) {
        String str;
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbu((String) Preconditions.checkNotNull(((Exception) Preconditions.checkNotNull(task.getException())).getMessage())));
        }
        zzahk result = task.getResult();
        String zza = result.zza();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(zza)) {
            return Tasks.forException(new zzbu(a.d("No Recaptcha Enterprise siteKey configured for tenant/project ", this.zza)));
        }
        List<String> zza2 = com.google.android.gms.internal.p002firebaseauthapi.zzv.zza('/').zza((CharSequence) zza);
        if (zza2.size() != 4) {
            str = null;
        } else {
            str = zza2.get(3);
        }
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception(a.d("Invalid siteKey format ", zza)));
        }
        Log.isLoggable("RecaptchaHandler", 4);
        zzbx zzbxVar = this.zzb;
        Task<RecaptchaTasksClient> zza3 = zzbxVar.zzb.zza((Application) zzbxVar.zza.getApplicationContext(), str);
        zzbx.zza(this.zzb, result, zza3, this.zza);
        return zza3;
    }
}
