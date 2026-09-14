package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import e0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafw implements OnFailureListener {
    public zzafw(zzafu zzafuVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        logger = zzafu.zza;
        logger.e(a.d("SmsRetrieverClient failed to start: ", exc.getMessage()), new Object[0]);
    }
}
