package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh implements OnFailureListener {
    private final /* synthetic */ TaskCompletionSource zza;

    public zzh(zzb zzbVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        String str;
        str = zzb.zza;
        Log.e(str, "Failed to get reCAPTCHA token with error [" + exc.getMessage() + "]- calling backend without app verification");
        if ((exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.zza.setException(exc);
        } else {
            this.zza.setResult(new zzm().zza());
        }
    }
}
