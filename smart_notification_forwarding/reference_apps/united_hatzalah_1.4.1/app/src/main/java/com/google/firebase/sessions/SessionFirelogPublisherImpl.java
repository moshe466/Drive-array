package com.google.firebase.sessions;

import P2.G;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final String TAG = "SessionFirelogPublisher";
    private final InterfaceC0768i backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;
    public static final Companion Companion = new Companion(null);
    private static final double randomValueForSampling = Math.random();

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, @Background InterfaceC0768i backgroundDispatcher) {
        j.e(firebaseApp, "firebaseApp");
        j.e(firebaseInstallations, "firebaseInstallations");
        j.e(sessionSettings, "sessionSettings");
        j.e(eventGDTLogger, "eventGDTLogger");
        j.e(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
        } catch (RuntimeException e4) {
            Log.e(TAG, "Error logging Session Start event to DataTransport: ", e4);
        }
    }

    private final boolean shouldCollectEvents() {
        if (randomValueForSampling <= this.sessionSettings.getSamplingRate()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object shouldLogSession(w2.InterfaceC0763d r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L13
            r0 = r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            a.AbstractC0228a.C(r5)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            a.AbstractC0228a.C(r5)
            com.google.firebase.sessions.settings.SessionsSettings r5 = r4.sessionSettings
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.updateSettings(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            com.google.firebase.sessions.settings.SessionsSettings r5 = r0.sessionSettings
            boolean r5 = r5.getSessionsEnabled()
            if (r5 != 0) goto L4f
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4f:
            boolean r5 = r0.shouldCollectEvents()
            if (r5 != 0) goto L58
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L58:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.shouldLogSession(w2.d):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void logSession(SessionDetails sessionDetails) {
        j.e(sessionDetails, "sessionDetails");
        G.r(G.b(this.backgroundDispatcher), null, new SessionFirelogPublisherImpl$logSession$1(this, sessionDetails, null), 3);
    }
}
