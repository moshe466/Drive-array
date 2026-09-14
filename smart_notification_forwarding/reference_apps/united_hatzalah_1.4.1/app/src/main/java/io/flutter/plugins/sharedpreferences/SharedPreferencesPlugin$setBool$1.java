package io.flutter.plugins.sharedpreferences;

import F2.p;
import P2.E;
import R.InterfaceC0183h;
import U.f;
import a.AbstractC0228a;
import android.content.Context;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1", f = "SharedPreferencesPlugin.kt", l = {81}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$setBool$1 extends AbstractC0793i implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ boolean $value;
    Object L$0;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    @InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$setBool$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        final /* synthetic */ f $boolKey;
        final /* synthetic */ boolean $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(f fVar, boolean z3, InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
            this.$boolKey = fVar;
            this.$value = z3;
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$boolKey, this.$value, interfaceC0763d);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // F2.p
        public final Object invoke(U.b bVar, InterfaceC0763d interfaceC0763d) {
            return ((AnonymousClass1) create(bVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
        }

        @Override // y2.AbstractC0785a
        public final Object invokeSuspend(Object obj) {
            U.b bVar = (U.b) this.L$0;
            EnumC0779a enumC0779a = EnumC0779a.f6740a;
            if (this.label == 0) {
                AbstractC0228a.C(obj);
                bVar.d(this.$boolKey, Boolean.valueOf(this.$value));
                return C0684i.f6340a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$setBool$1(String str, SharedPreferencesPlugin sharedPreferencesPlugin, boolean z3, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$key = str;
        this.this$0 = sharedPreferencesPlugin;
        this.$value = z3;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SharedPreferencesPlugin$setBool$1(this.$key, this.this$0, this.$value, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$setBool$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Context context;
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
            f c4 = T.b.c(this.$key);
            context = this.this$0.context;
            if (context != null) {
                InterfaceC0183h sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(c4, this.$value, null);
                this.L$0 = null;
                this.label = 1;
                if (AbstractC0228a.m(sharedPreferencesDataStore, anonymousClass1, this) == enumC0779a) {
                    return enumC0779a;
                }
            } else {
                j.i("context");
                throw null;
            }
        }
        return C0684i.f6340a;
    }
}
