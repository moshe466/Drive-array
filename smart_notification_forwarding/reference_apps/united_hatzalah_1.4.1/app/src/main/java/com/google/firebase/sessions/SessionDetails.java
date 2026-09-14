package com.google.firebase.sessions;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionDetails {
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;
    private final long sessionStartTimestampUs;

    public SessionDetails(String sessionId, String firstSessionId, int i, long j2) {
        j.e(sessionId, "sessionId");
        j.e(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i;
        this.sessionStartTimestampUs = j2;
    }

    public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, String str2, int i, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sessionDetails.sessionId;
        }
        if ((i3 & 2) != 0) {
            str2 = sessionDetails.firstSessionId;
        }
        if ((i3 & 4) != 0) {
            i = sessionDetails.sessionIndex;
        }
        if ((i3 & 8) != 0) {
            j2 = sessionDetails.sessionStartTimestampUs;
        }
        int i4 = i;
        return sessionDetails.copy(str, str2, i4, j2);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.sessionStartTimestampUs;
    }

    public final SessionDetails copy(String sessionId, String firstSessionId, int i, long j2) {
        j.e(sessionId, "sessionId");
        j.e(firstSessionId, "firstSessionId");
        return new SessionDetails(sessionId, firstSessionId, i, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return j.a(this.sessionId, sessionDetails.sessionId) && j.a(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public int hashCode() {
        return Long.hashCode(this.sessionStartTimestampUs) + ((Integer.hashCode(this.sessionIndex) + AbstractC0008a.g(this.firstSessionId, this.sessionId.hashCode() * 31, 31)) * 31);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }
}
