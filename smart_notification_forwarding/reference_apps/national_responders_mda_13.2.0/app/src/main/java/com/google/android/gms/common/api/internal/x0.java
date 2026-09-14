package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x0 extends m2.n {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z0 f5034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(z0 z0Var, Looper looper) {
        super(looper);
        this.f5034a = z0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            z0.r(this.f5034a);
        } else {
            if (i10 == 2) {
                z0.q(this.f5034a);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown message id: ");
            sb2.append(i10);
        }
    }
}
