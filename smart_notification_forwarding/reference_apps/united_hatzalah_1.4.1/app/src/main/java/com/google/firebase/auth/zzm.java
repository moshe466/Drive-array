package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzm extends zzbo<AuthResult> {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ EmailAuthCredential zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public zzm(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = firebaseUser;
        this.zzb = emailAuthCredential;
        this.zzc = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<AuthResult> zza(String str) {
        zzach zzachVar;
        FirebaseApp firebaseApp;
        TextUtils.isEmpty(str);
        zzachVar = this.zzc.zze;
        firebaseApp = this.zzc.zza;
        return zzachVar.zza(firebaseApp, this.zza, (AuthCredential) this.zzb, str, (zzcf) new FirebaseAuth.zza());
    }
}
