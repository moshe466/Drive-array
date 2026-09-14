package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* loaded from: classes.dex */
final class zzbt implements Continuation {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;
    private final /* synthetic */ RecaptchaAction zzc;
    private final /* synthetic */ Continuation zzd;

    public zzbt(String str, zzbx zzbxVar, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.zza = str;
        this.zzb = zzbxVar;
        this.zzc = recaptchaAction;
        this.zzd = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (!task.isSuccessful() && zzaei.zzc((Exception) Preconditions.checkNotNull(task.getException()))) {
            Log.isLoggable("RecaptchaCallWrapper", 4);
            return this.zzb.zza(this.zza, Boolean.TRUE, this.zzc).continueWithTask(this.zzd);
        }
        return task;
    }
}
