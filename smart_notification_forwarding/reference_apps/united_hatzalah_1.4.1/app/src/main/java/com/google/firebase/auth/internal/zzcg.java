package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes.dex */
public final class zzcg {
    private static final zzcg zza = new zzcg();
    private final zzbl zzb;
    private final zzax zzc;

    private zzcg() {
        this(zzbl.zzc(), zzax.zza());
    }

    public static zzcg zzc() {
        return zza;
    }

    public final Task<AuthResult> zza() {
        return this.zzb.zza();
    }

    public final Task<String> zzb() {
        return this.zzb.zzb();
    }

    private zzcg(zzbl zzblVar, zzax zzaxVar) {
        this.zzb = zzblVar;
        this.zzc = zzaxVar;
    }

    public final void zza(Context context) {
        this.zzb.zza(context);
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        this.zzb.zza(firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
