package io.flutter.plugins.sharedpreferences;

import F2.p;
import P2.E;
import R.InterfaceC0183h;
import U.f;
import a.AbstractC0228a;
import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1", f = "SharedPreferencesPlugin.kt", l = {134}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$clear$1 extends AbstractC0793i implements p {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    @InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$clear$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        final /* synthetic */ List<String> $allowList;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
            this.$allowList = list;
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$allowList, interfaceC0763d);
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
                List<String> list = this.$allowList;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        f c4 = T.b.c((String) it.next());
                        bVar.getClass();
                        bVar.c();
                        bVar.f2308a.remove(c4);
                    }
                } else {
                    bVar.c();
                    bVar.f2308a.clear();
                }
                return C0684i.f6340a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$clear$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SharedPreferencesPlugin$clear$1(this.this$0, this.$allowList, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$clear$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Context context;
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
        context = this.this$0.context;
        if (context != null) {
            InterfaceC0183h sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$allowList, null);
            this.label = 1;
            Object m4 = AbstractC0228a.m(sharedPreferencesDataStore, anonymousClass1, this);
            if (m4 == enumC0779a) {
                return enumC0779a;
            }
            return m4;
        }
        j.i("context");
        throw null;
    }
}
