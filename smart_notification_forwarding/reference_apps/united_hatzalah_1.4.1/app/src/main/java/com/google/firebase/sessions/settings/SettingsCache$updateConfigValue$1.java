package com.google.firebase.sessions.settings;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {122}, m = "updateConfigValue")
/* loaded from: classes.dex */
public final class SettingsCache$updateConfigValue$1<T> extends AbstractC0787c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$1(SettingsCache settingsCache, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = settingsCache;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object updateConfigValue;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateConfigValue = this.this$0.updateConfigValue(null, null, this);
        return updateConfigValue;
    }
}
