package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import e0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzl implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public zzl(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        this.zzc = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String zzd;
        String zzb;
        String zzc;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
        zzach zzachVar;
        String str;
        boolean z3;
        zzach zzachVar2;
        String str2;
        boolean z4;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str3 = "Error while validating application identity: ";
            if (exception != null) {
                str3 = a.d("Error while validating application identity: ", exception.getMessage());
            }
            Log.e("FirebaseAuth", str3);
            if (exception != null && com.google.firebase.auth.internal.zzb.zza(exception)) {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            zzc = null;
            zzd = null;
            zzb = null;
        } else {
            zzd = task.getResult().zzd();
            zzb = task.getResult().zzb();
            zzc = task.getResult().zzc();
        }
        long longValue = this.zza.zzg().longValue();
        zza = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(zzd)) {
            zza = this.zzc.zza(this.zza, zza, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zza;
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) Preconditions.checkNotNull(this.zza.zzc());
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(zzc) && this.zzc.zzb() != null && this.zzc.zzb().zza("PHONE_PROVIDER")) {
            zzc = "NO_RECAPTCHA";
        }
        String str4 = zzc;
        if (zzamVar.zzd()) {
            zzachVar2 = this.zzc.zze;
            String str5 = (String) Preconditions.checkNotNull(this.zza.zzh());
            str2 = this.zzc.zzi;
            if (this.zza.zzd() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzachVar2.zza(zzamVar, str5, str2, longValue, z4, this.zza.zzk(), zzd, zzb, str4, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
            return;
        }
        zzachVar = this.zzc.zze;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf());
        str = this.zzc.zzi;
        if (this.zza.zzd() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzachVar.zza(zzamVar, phoneMultiFactorInfo, str, longValue, z3, this.zza.zzk(), zzd, zzb, str4, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
    }
}
