package com.google.firebase.sessions.settings;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.RemoteSettings$clearCachedSettings$1", f = "RemoteSettings.kt", l = {158}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettings$clearCachedSettings$1 extends AbstractC0793i implements p {
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$clearCachedSettings$1(RemoteSettings remoteSettings, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = remoteSettings;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new RemoteSettings$clearCachedSettings$1(this.this$0, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((RemoteSettings$clearCachedSettings$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        SettingsCache settingsCache;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            settingsCache = this.this$0.getSettingsCache();
            this.label = 1;
            if (settingsCache.removeConfigs$com_google_firebase_firebase_sessions(this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
