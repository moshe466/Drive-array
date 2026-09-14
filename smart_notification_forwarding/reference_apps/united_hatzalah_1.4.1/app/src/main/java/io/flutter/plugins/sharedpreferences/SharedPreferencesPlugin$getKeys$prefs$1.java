package io.flutter.plugins.sharedpreferences;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import java.util.List;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getKeys$prefs$1", f = "SharedPreferencesPlugin.kt", l = {248}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$getKeys$prefs$1 extends AbstractC0793i implements p {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getKeys$prefs$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SharedPreferencesPlugin$getKeys$prefs$1(this.this$0, this.$allowList, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$getKeys$prefs$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object prefs;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
        List<String> list = this.$allowList;
        this.label = 1;
        prefs = sharedPreferencesPlugin.getPrefs(list, this);
        if (prefs == enumC0779a) {
            return enumC0779a;
        }
        return prefs;
    }
}
