package com.google.firebase.database.ktx;

import F2.a;
import F2.p;
import a.AbstractC0228a;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.Query;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.database.ktx.DatabaseKt$childEvents$1", f = "Database.kt", l = {205}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DatabaseKt$childEvents$1 extends AbstractC0793i implements p {
    final /* synthetic */ Query $this_childEvents;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: com.google.firebase.database.ktx.DatabaseKt$childEvents$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends k implements a {
        final /* synthetic */ ChildEventListener $listener;
        final /* synthetic */ Query $this_childEvents;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Query query, ChildEventListener childEventListener) {
            super(0);
            this.$this_childEvents = query;
            this.$listener = childEventListener;
        }

        @Override // F2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m7invoke();
            return C0684i.f6340a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m7invoke() {
            this.$this_childEvents.removeEventListener(this.$listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatabaseKt$childEvents$1(Query query, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$this_childEvents = query;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        DatabaseKt$childEvents$1 databaseKt$childEvents$1 = new DatabaseKt$childEvents$1(this.$this_childEvents, interfaceC0763d);
        databaseKt$childEvents$1.L$0 = obj;
        return databaseKt$childEvents$1;
    }

    @Override // F2.p
    public final Object invoke(R2.p pVar, InterfaceC0763d interfaceC0763d) {
        return ((DatabaseKt$childEvents$1) create(pVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
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
            R2.p pVar = (R2.p) this.L$0;
            Query query = this.$this_childEvents;
            ChildEventListener addChildEventListener = query.addChildEventListener(new DatabaseKt$childEvents$1$listener$1(query, pVar));
            j.d(addChildEventListener, "Query.childEvents\n  get(…  }\n          }\n        )");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_childEvents, addChildEventListener);
            this.label = 1;
            if (AbstractC0228a.c(pVar, anonymousClass1, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
