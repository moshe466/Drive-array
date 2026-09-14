package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzc implements OnFailureListener {
    private final /* synthetic */ FirebaseAuth zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzcg zzf;
    private final /* synthetic */ TaskCompletionSource zzg;
    private final /* synthetic */ zzb zzh;

    public zzc(zzb zzbVar, FirebaseAuth firebaseAuth, String str, Activity activity, boolean z3, boolean z4, zzcg zzcgVar, TaskCompletionSource taskCompletionSource) {
        this.zza = firebaseAuth;
        this.zzb = str;
        this.zzc = activity;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = zzcgVar;
        this.zzg = taskCompletionSource;
        this.zzh = zzbVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        String str;
        str = zzb.zza;
        Log.e(str, "Failed to get reCAPTCHA enterprise token: " + exc.getMessage() + "\n\n Using fallback methods.");
        if (this.zza.zzb().zza("PHONE_PROVIDER")) {
            this.zzh.zza(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (TaskCompletionSource<zzj>) this.zzg);
        } else {
            this.zzg.setResult(new zzm().zza());
        }
    }
}
