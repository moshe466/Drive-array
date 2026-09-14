package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbc extends BroadcastReceiver {
    private final WeakReference<Activity> zza;
    private final TaskCompletionSource<AuthResult> zzb;
    private final FirebaseAuth zzc;
    private final FirebaseUser zzd;
    private final /* synthetic */ zzax zze;

    public zzbc(zzax zzaxVar, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zze = zzaxVar;
        this.zza = new WeakReference<>(activity);
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzb.setException(zzaei.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zza(context);
            return;
        }
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.zzc.signInWithCredential(zzax.zza(intent)).addOnSuccessListener(new zzaz(r0, r1, context)).addOnFailureListener(new zzaw(this.zze, this.zzb, context));
                return;
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.zzd.linkWithCredential(zzax.zza(intent)).addOnSuccessListener(new zzbb(r0, r1, context)).addOnFailureListener(new zzay(this.zze, this.zzb, context));
                return;
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.zzd.reauthenticateAndRetrieveData(zzax.zza(intent)).addOnSuccessListener(new zzbd(r0, r1, context)).addOnFailureListener(new zzba(this.zze, this.zzb, context));
                return;
            } else {
                this.zzb.setException(zzaei.zza(zzao.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
                return;
            }
        }
        if (zzce.zzb(intent)) {
            this.zzb.setException(zzaei.zza(zzce.zza(intent)));
            zzax.zza(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzb.setException(zzaei.zza(zzao.zza("WEB_CONTEXT_CANCELED")));
            zzax.zza(context);
        }
    }
}
