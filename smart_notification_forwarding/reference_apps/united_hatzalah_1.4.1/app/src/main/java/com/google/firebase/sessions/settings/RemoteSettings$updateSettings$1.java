package com.google.firebase.sessions.settings;

import com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {177, 83, ChromeCustomTabsActivity.NO_HISTORY_CHROME_CUSTOM_TAB_REQUEST_CODE}, m = "updateSettings")
/* loaded from: classes.dex */
public final class RemoteSettings$updateSettings$1 extends AbstractC0787c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$1(RemoteSettings remoteSettings, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = remoteSettings;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSettings(this);
    }
}
