package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzn extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ com.google.firebase.auth.internal.zzj zzb;
    private final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc;
    private final /* synthetic */ FirebaseAuth zzd;

    public zzn(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, com.google.firebase.auth.internal.zzj zzjVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.zza = phoneAuthOptions;
        this.zzb = zzjVar;
        this.zzc = onVerificationStateChangedCallbacks;
        this.zzd = firebaseAuth;
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.zzc.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zzc.onCodeSent(str, forceResendingToken);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.zzc.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        if (zzaei.zza(firebaseException)) {
            this.zza.zza(true);
            this.zza.zzh();
            FirebaseAuth.zza(this.zza);
            return;
        }
        if (!TextUtils.isEmpty(this.zzb.zzc())) {
            if (zzaei.zzb(firebaseException) && this.zzd.zzb().zza("PHONE_PROVIDER") && TextUtils.isEmpty(this.zzb.zzb())) {
                this.zza.zzb(true);
                this.zza.zzh();
                FirebaseAuth.zza(this.zza);
                return;
            } else {
                this.zza.zzh();
                firebaseException.getMessage();
                this.zzc.onVerificationFailed(firebaseException);
                return;
            }
        }
        this.zza.zzh();
        firebaseException.getMessage();
        this.zzc.onVerificationFailed(firebaseException);
    }
}
