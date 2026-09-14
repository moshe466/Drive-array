package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.c;

/* loaded from: classes.dex */
final class g1 implements c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(g gVar) {
        this.f4861a = gVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z10) {
        Handler handler;
        Handler handler2;
        g gVar = this.f4861a;
        handler = gVar.f4858p;
        handler2 = gVar.f4858p;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
