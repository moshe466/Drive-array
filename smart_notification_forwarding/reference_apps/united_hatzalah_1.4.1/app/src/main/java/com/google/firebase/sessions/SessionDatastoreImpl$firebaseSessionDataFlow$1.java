package com.google.firebase.sessions;

import F2.q;
import S2.e;
import a.AbstractC0228a;
import android.util.Log;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends AbstractC0793i implements q {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SessionDatastoreImpl$firebaseSessionDataFlow$1(InterfaceC0763d interfaceC0763d) {
        super(3, interfaceC0763d);
    }

    @Override // F2.q
    public final Object invoke(e eVar, Throwable th, InterfaceC0763d interfaceC0763d) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(interfaceC0763d);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$0 = eVar;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$1 = th;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.invokeSuspend(C0684i.f6340a);
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
            e eVar = (e) this.L$0;
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.L$1);
            U.b bVar = new U.b(true);
            this.L$0 = null;
            this.label = 1;
            if (eVar.emit(bVar, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
