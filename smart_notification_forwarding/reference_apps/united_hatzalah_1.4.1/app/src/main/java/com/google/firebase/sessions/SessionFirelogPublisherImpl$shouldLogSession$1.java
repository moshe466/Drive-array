package com.google.firebase.sessions;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {100}, m = "shouldLogSession")
/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl$shouldLogSession$1 extends AbstractC0787c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$shouldLogSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.this$0 = sessionFirelogPublisherImpl;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object shouldLogSession;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        shouldLogSession = this.this$0.shouldLogSession(this);
        return shouldLogSession;
    }
}
