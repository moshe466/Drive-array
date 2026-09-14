package com.google.firebase.sessions.settings;

import F0.AbstractC0008a;
import F2.p;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettings$updateSettings$2$2 extends AbstractC0793i implements p {
    /* synthetic */ Object L$0;
    int label;

    public RemoteSettings$updateSettings$2$2(InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(interfaceC0763d);
        remoteSettings$updateSettings$2$2.L$0 = obj;
        return remoteSettings$updateSettings$2$2;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.label == 0) {
            AbstractC0228a.C(obj);
            AbstractC0008a.A("Error failing to fetch the remote configs: ", (String) this.L$0, RemoteSettings.TAG);
            return C0684i.f6340a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // F2.p
    public final Object invoke(String str, InterfaceC0763d interfaceC0763d) {
        return ((RemoteSettings$updateSettings$2$2) create(str, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }
}
