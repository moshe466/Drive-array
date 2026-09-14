package com.google.firebase.sessions.api;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public interface SessionSubscriber {

    /* loaded from: classes.dex */
    public enum Name {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    /* loaded from: classes.dex */
    public static final class SessionDetails {
        private final String sessionId;

        public SessionDetails(String sessionId) {
            j.e(sessionId, "sessionId");
            this.sessionId = sessionId;
        }

        public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionDetails.sessionId;
            }
            return sessionDetails.copy(str);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final SessionDetails copy(String sessionId) {
            j.e(sessionId, "sessionId");
            return new SessionDetails(sessionId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && j.a(this.sessionId, ((SessionDetails) obj).sessionId);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return AbstractC0008a.s(new StringBuilder("SessionDetails(sessionId="), this.sessionId, ')');
        }
    }

    Name getSessionSubscriberName();

    boolean isDataCollectionEnabled();

    void onSessionChanged(SessionDetails sessionDetails);
}
