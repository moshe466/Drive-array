package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzab extends zzbo<AuthResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ FirebaseUser zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ FirebaseAuth zzf;

    public zzab(FirebaseAuth firebaseAuth, String str, boolean z3, FirebaseUser firebaseUser, String str2, String str3) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = firebaseUser;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<AuthResult> zza(String str) {
        zzach zzachVar;
        FirebaseApp firebaseApp;
        zzach zzachVar2;
        FirebaseApp firebaseApp2;
        TextUtils.isEmpty(str);
        if (this.zzb) {
            zzachVar2 = this.zzf.zze;
            firebaseApp2 = this.zzf.zza;
            return zzachVar2.zzb(firebaseApp2, (FirebaseUser) Preconditions.checkNotNull(this.zzc), this.zza, this.zzd, this.zze, str, new FirebaseAuth.zza());
        }
        zzachVar = this.zzf.zze;
        firebaseApp = this.zzf.zza;
        return zzachVar.zzb(firebaseApp, this.zza, this.zzd, this.zze, str, new FirebaseAuth.zzb());
    }
}
