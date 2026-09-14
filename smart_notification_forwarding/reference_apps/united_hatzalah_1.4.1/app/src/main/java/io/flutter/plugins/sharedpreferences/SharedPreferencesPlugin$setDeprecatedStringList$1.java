package io.flutter.plugins.sharedpreferences;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setDeprecatedStringList$1", f = "SharedPreferencesPlugin.kt", l = {128}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$setDeprecatedStringList$1 extends AbstractC0793i implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ String $valueString;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$setDeprecatedStringList$1(SharedPreferencesPlugin sharedPreferencesPlugin, String str, String str2, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sharedPreferencesPlugin;
        this.$key = str;
        this.$valueString = str2;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SharedPreferencesPlugin$setDeprecatedStringList$1(this.this$0, this.$key, this.$valueString, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$setDeprecatedStringList$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object dataStoreSetString;
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
            SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
            String str = this.$key;
            String str2 = this.$valueString;
            this.label = 1;
            dataStoreSetString = sharedPreferencesPlugin.dataStoreSetString(str, str2, this);
            if (dataStoreSetString == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
