package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes.dex */
final class zzu implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ FirebaseAuth zzb;

    public zzu(FirebaseAuth firebaseAuth, String str) {
        this.zza = str;
        this.zzb = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) {
        zzach zzachVar;
        String str;
        if (task.isSuccessful()) {
            zzachVar = this.zzb.zze;
            String str2 = this.zza;
            String str3 = (String) Preconditions.checkNotNull(task.getResult().getToken());
            str = this.zzb.zzk;
            return zzachVar.zza(str2, str3, "apple.com", str);
        }
        return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
    }
}
