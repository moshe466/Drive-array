package com.google.firebase.sessions;

import F2.p;
import P2.E;
import R.InterfaceC0183h;
import a.AbstractC0228a;
import com.google.firebase.sessions.SessionDatastoreImpl;
import java.io.IOException;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", l = {91}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SessionDatastoreImpl$updateSessionId$1 extends AbstractC0793i implements p {
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ SessionDatastoreImpl this$0;

    @InterfaceC0789e(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        final /* synthetic */ String $sessionId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
            this.$sessionId = str;
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sessionId, interfaceC0763d);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // F2.p
        public final Object invoke(U.b bVar, InterfaceC0763d interfaceC0763d) {
            return ((AnonymousClass1) create(bVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
        }

        @Override // y2.AbstractC0785a
        public final Object invokeSuspend(Object obj) {
            EnumC0779a enumC0779a = EnumC0779a.f6740a;
            if (this.label == 0) {
                AbstractC0228a.C(obj);
                ((U.b) this.L$0).d(SessionDatastoreImpl.FirebaseSessionDataKeys.INSTANCE.getSESSION_ID(), this.$sessionId);
                return C0684i.f6340a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDatastoreImpl$updateSessionId$1(SessionDatastoreImpl sessionDatastoreImpl, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sessionDatastoreImpl;
        this.$sessionId = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SessionDatastoreImpl$updateSessionId$1(this.this$0, this.$sessionId, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SessionDatastoreImpl$updateSessionId$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        InterfaceC0183h interfaceC0183h;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    AbstractC0228a.C(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                AbstractC0228a.C(obj);
                interfaceC0183h = this.this$0.dataStore;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sessionId, null);
                this.label = 1;
                if (AbstractC0228a.m(interfaceC0183h, anonymousClass1, this) == enumC0779a) {
                    return enumC0779a;
                }
            }
        } catch (IOException e4) {
            e4.toString();
        }
        return C0684i.f6340a;
    }
}
