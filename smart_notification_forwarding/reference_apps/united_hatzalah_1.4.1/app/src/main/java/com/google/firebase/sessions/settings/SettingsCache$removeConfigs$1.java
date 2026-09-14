package com.google.firebase.sessions.settings;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {109}, m = "removeConfigs$com_google_firebase_firebase_sessions")
/* loaded from: classes.dex */
public final class SettingsCache$removeConfigs$1 extends AbstractC0787c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$1(SettingsCache settingsCache, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = settingsCache;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
