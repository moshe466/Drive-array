package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class zzgq extends zzddu {
    private final /* synthetic */ zzgr zzacp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgq(zzgr zzgrVar, Looper looper) {
        super(looper);
        this.zzacp = zzgrVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzacp.a(message);
    }
}
