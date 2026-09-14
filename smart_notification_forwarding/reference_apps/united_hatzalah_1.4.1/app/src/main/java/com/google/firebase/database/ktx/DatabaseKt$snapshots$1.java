package com.google.firebase.database.ktx;

import F2.a;
import F2.p;
import a.AbstractC0228a;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.database.ktx.DatabaseKt$snapshots$1", f = "Database.kt", l = {161}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DatabaseKt$snapshots$1 extends AbstractC0793i implements p {
    final /* synthetic */ Query $this_snapshots;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: com.google.firebase.database.ktx.DatabaseKt$snapshots$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends k implements a {
        final /* synthetic */ ValueEventListener $listener;
        final /* synthetic */ Query $this_snapshots;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Query query, ValueEventListener valueEventListener) {
            super(0);
            this.$this_snapshots = query;
            this.$listener = valueEventListener;
        }

        @Override // F2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m8invoke();
            return C0684i.f6340a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m8invoke() {
            this.$this_snapshots.removeEventListener(this.$listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatabaseKt$snapshots$1(Query query, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$this_snapshots = query;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        DatabaseKt$snapshots$1 databaseKt$snapshots$1 = new DatabaseKt$snapshots$1(this.$this_snapshots, interfaceC0763d);
        databaseKt$snapshots$1.L$0 = obj;
        return databaseKt$snapshots$1;
    }

    @Override // F2.p
    public final Object invoke(R2.p pVar, InterfaceC0763d interfaceC0763d) {
        return ((DatabaseKt$snapshots$1) create(pVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
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
            Query query = this.$this_snapshots;
            ValueEventListener addValueEventListener = query.addValueEventListener(new DatabaseKt$snapshots$1$listener$1(query, pVar));
            j.d(addValueEventListener, "Query.snapshots\n  get() …  }\n          }\n        )");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_snapshots, addValueEventListener);
            this.label = 1;
            if (AbstractC0228a.c(pVar, anonymousClass1, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
