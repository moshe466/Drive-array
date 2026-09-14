package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class c1 extends m2.n {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d1 f4799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(d1 d1Var, Looper looper) {
        super(looper);
        this.f4799a = d1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            ((b1) message.obj).b(this.f4799a);
        } else {
            if (i10 == 2) {
                throw ((RuntimeException) message.obj);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown message id: ");
            sb2.append(i10);
        }
    }
}
