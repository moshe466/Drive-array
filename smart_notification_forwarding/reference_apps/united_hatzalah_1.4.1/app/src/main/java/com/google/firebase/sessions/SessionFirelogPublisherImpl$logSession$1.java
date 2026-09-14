package com.google.firebase.sessions;

import F2.p;
import P2.E;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {69, 70, 76}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl$logSession$1 extends AbstractC0793i implements p {
    final /* synthetic */ SessionDetails $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = sessionDetails;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r9 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r9 == r0) goto L23;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L43
            if (r1 == r4) goto L3f
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r0 = r8.L$5
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r8.L$4
            com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
            java.lang.Object r2 = r8.L$3
            com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
            java.lang.Object r3 = r8.L$2
            com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
            java.lang.Object r4 = r8.L$1
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r8.L$0
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            a.AbstractC0228a.C(r9)
            r7 = r3
            r3 = r0
            r0 = r7
            r7 = r2
            r2 = r1
            r1 = r7
        L30:
            r7 = r4
            goto L9b
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            a.AbstractC0228a.C(r9)
            goto L6a
        L3f:
            a.AbstractC0228a.C(r9)
            goto L51
        L43:
            a.AbstractC0228a.C(r9)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r9 = r8.this$0
            r8.label = r4
            java.lang.Object r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(r9, r8)
            if (r9 != r0) goto L51
            goto L93
        L51:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lae
            com.google.firebase.sessions.InstallationId$Companion r9 = com.google.firebase.sessions.InstallationId.Companion
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r8.this$0
            com.google.firebase.installations.FirebaseInstallationsApi r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseInstallations$p(r1)
            r8.label = r3
            java.lang.Object r9 = r9.create(r1, r8)
            if (r9 != r0) goto L6a
            goto L93
        L6a:
            r5 = r9
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r8.this$0
            com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.INSTANCE
            com.google.firebase.FirebaseApp r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseApp$p(r4)
            com.google.firebase.sessions.SessionDetails r1 = r8.$sessionDetails
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r8.this$0
            com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getSessionSettings$p(r6)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r8.L$0 = r5
            r8.L$1 = r4
            r8.L$2 = r3
            r8.L$3 = r9
            r8.L$4 = r1
            r8.L$5 = r6
            r8.label = r2
            java.lang.Object r2 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r8)
            if (r2 != r0) goto L94
        L93:
            return r0
        L94:
            r0 = r1
            r1 = r9
            r9 = r2
            r2 = r0
            r0 = r3
            r3 = r6
            goto L30
        L9b:
            r4 = r9
            java.util.Map r4 = (java.util.Map) r4
            r9 = r5
            java.lang.String r5 = r9.getFid()
            java.lang.String r6 = r9.getAuthToken()
            com.google.firebase.sessions.SessionEvent r9 = r0.buildSession(r1, r2, r3, r4, r5, r6)
            com.google.firebase.sessions.SessionFirelogPublisherImpl.access$attemptLoggingSessionEvent(r7, r9)
        Lae:
            s2.i r9 = s2.C0684i.f6340a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
