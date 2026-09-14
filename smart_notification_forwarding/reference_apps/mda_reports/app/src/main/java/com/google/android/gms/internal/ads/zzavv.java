package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public final class zzavv extends zzddu {
    public zzavv(Looper looper) {
        super(looper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzddu
    public final void a(Message message) {
        try {
            super.a(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            zzawb.zza(com.google.android.gms.ads.internal.zzq.zzku().getApplicationContext(), th);
            throw th;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdMobHandler.handleMessage");
        }
    }
}
