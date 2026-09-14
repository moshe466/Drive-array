package io.flutter.plugins.sharedpreferences;

import F2.p;
import U.f;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$dataStoreSetString$2 extends AbstractC0793i implements p {
    final /* synthetic */ f $stringKey;
    final /* synthetic */ String $value;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$dataStoreSetString$2(f fVar, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$stringKey = fVar;
        this.$value = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        SharedPreferencesPlugin$dataStoreSetString$2 sharedPreferencesPlugin$dataStoreSetString$2 = new SharedPreferencesPlugin$dataStoreSetString$2(this.$stringKey, this.$value, interfaceC0763d);
        sharedPreferencesPlugin$dataStoreSetString$2.L$0 = obj;
        return sharedPreferencesPlugin$dataStoreSetString$2;
    }

    @Override // F2.p
    public final Object invoke(U.b bVar, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$dataStoreSetString$2) create(bVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        U.b bVar = (U.b) this.L$0;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.label == 0) {
            AbstractC0228a.C(obj);
            bVar.d(this.$stringKey, this.$value);
            return C0684i.f6340a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
