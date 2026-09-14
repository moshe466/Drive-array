package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzbo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzo extends zzbo<Void> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ ActionCodeSettings zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public zzo(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zza = str;
        this.zzb = actionCodeSettings;
        this.zzc = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzbo
    public final Task<Void> zza(String str) {
        zzach zzachVar;
        FirebaseApp firebaseApp;
        String str2;
        TextUtils.isEmpty(str);
        zzachVar = this.zzc.zze;
        firebaseApp = this.zzc.zza;
        String str3 = this.zza;
        ActionCodeSettings actionCodeSettings = this.zzb;
        str2 = this.zzc.zzk;
        return zzachVar.zza(firebaseApp, str3, actionCodeSettings, str2, str);
    }
}
