package com.google.firebase.sessions;

import com.google.firebase.sessions.InstallationId;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", l = {32, 40}, m = "create")
/* loaded from: classes.dex */
public final class InstallationId$Companion$create$1 extends AbstractC0787c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstallationId.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallationId$Companion$create$1(InstallationId.Companion companion, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = companion;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, this);
    }
}
