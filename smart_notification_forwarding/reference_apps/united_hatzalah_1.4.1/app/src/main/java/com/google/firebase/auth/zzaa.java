package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaa extends zzbo<AuthResult> {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ FirebaseUser zzb;
    private final /* synthetic */ EmailAuthCredential zzc;
    private final /* synthetic */ FirebaseAuth zzd;

    public zzaa(FirebaseAuth firebaseAuth, boolean z3, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = z3;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
        this.zzd = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<AuthResult> zza(String str) {
        zzach zzachVar;
        FirebaseApp firebaseApp;
        zzach zzachVar2;
        FirebaseApp firebaseApp2;
        TextUtils.isEmpty(str);
        if (this.zza) {
            zzachVar2 = this.zzd.zze;
            firebaseApp2 = this.zzd.zza;
            return zzachVar2.zzb(firebaseApp2, (FirebaseUser) Preconditions.checkNotNull(this.zzb), this.zzc, str, (zzcf) new FirebaseAuth.zza());
        }
        zzachVar = this.zzd.zze;
        firebaseApp = this.zzd.zza;
        return zzachVar.zza(firebaseApp, this.zzc, str, (com.google.firebase.auth.internal.zzl) new FirebaseAuth.zzb());
    }
}
