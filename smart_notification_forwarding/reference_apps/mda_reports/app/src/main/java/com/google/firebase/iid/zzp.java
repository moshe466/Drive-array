package com.google.firebase.iid;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzp implements Continuation<Bundle, String> {
    private final /* synthetic */ zzl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzl zzlVar) {
        this.zza = zzlVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(@NonNull Task<Bundle> task) {
        String zza;
        Bundle result = task.getResult(IOException.class);
        zzl zzlVar = this.zza;
        zza = zzl.zza(result);
        return zza;
    }
}
