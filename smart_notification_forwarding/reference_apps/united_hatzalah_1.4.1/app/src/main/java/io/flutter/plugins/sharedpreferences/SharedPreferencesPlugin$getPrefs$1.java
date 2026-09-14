package io.flutter.plugins.sharedpreferences;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", f = "SharedPreferencesPlugin.kt", l = {UserVerificationMethods.USER_VERIFY_HANDPRINT, 258}, m = "getPrefs", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$getPrefs$1 extends AbstractC0787c {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getPrefs$1(SharedPreferencesPlugin sharedPreferencesPlugin, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = sharedPreferencesPlugin;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object prefs;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prefs = this.this$0.getPrefs(null, this);
        return prefs;
    }
}
