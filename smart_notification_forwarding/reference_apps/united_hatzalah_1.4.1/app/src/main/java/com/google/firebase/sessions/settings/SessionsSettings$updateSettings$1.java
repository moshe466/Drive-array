package com.google.firebase.sessions.settings;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", l = {98, 99}, m = "updateSettings")
/* loaded from: classes.dex */
public final class SessionsSettings$updateSettings$1 extends AbstractC0787c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionsSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionsSettings$updateSettings$1(SessionsSettings sessionsSettings, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = sessionsSettings;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSettings(this);
    }
}
