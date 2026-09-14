package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zaax extends com.google.android.gms.internal.base.zar {
    final /* synthetic */ zaaz zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaax(zaaz zaazVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zaazVar);
        this.zaa = zaazVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                new StringBuilder(String.valueOf(i).length() + 20);
                return;
            } else {
                this.zaa.zai();
                return;
            }
        }
        this.zaa.zaj();
    }
}
