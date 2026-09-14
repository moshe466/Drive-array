package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;

/* loaded from: classes.dex */
final class zzp extends zzbo<AuthResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public zzp(FirebaseAuth firebaseAuth, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<AuthResult> zza(String str) {
        zzach zzachVar;
        FirebaseApp firebaseApp;
        String str2;
        TextUtils.isEmpty(str);
        zzachVar = this.zzc.zze;
        firebaseApp = this.zzc.zza;
        String str3 = this.zza;
        String str4 = this.zzb;
        str2 = this.zzc.zzk;
        return zzachVar.zza(firebaseApp, str3, str4, str2, str, new FirebaseAuth.zzb());
    }
}
