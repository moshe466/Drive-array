package com.google.firebase.sessions.settings;

import F2.p;
import U.b;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SettingsCache$removeConfigs$2 extends AbstractC0793i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$2(SettingsCache settingsCache, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = settingsCache;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        SettingsCache$removeConfigs$2 settingsCache$removeConfigs$2 = new SettingsCache$removeConfigs$2(this.this$0, interfaceC0763d);
        settingsCache$removeConfigs$2.L$0 = obj;
        return settingsCache$removeConfigs$2;
    }

    @Override // F2.p
    public final Object invoke(b bVar, InterfaceC0763d interfaceC0763d) {
        return ((SettingsCache$removeConfigs$2) create(bVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.label == 0) {
            AbstractC0228a.C(obj);
            b bVar = (b) this.L$0;
            bVar.c();
            bVar.f2308a.clear();
            this.this$0.updateSessionConfigs(bVar);
            return C0684i.f6340a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
