package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zabc extends com.google.android.gms.internal.base.zar {
    final /* synthetic */ zabd zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabc(zabd zabdVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zabdVar);
        this.zaa = zabdVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                new StringBuilder(String.valueOf(i).length() + 20);
                return;
            }
            throw ((RuntimeException) message.obj);
        }
        ((zabb) message.obj).zab(this.zaa);
    }
}
