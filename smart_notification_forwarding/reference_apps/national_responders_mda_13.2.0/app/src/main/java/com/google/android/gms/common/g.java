package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public final class g extends m2.n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5103a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f5104b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f5104b = bVar;
        this.f5103a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i10);
        } else {
            int i11 = this.f5104b.i(this.f5103a);
            if (this.f5104b.m(i11)) {
                this.f5104b.r(this.f5103a, i11);
            }
        }
    }
}
