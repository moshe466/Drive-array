package com.google.firebase.sessions;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionInfo {
    private final DataCollectionStatus dataCollectionStatus;
    private final long eventTimestampUs;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String sessionId, String firstSessionId, int i, long j2, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        j.e(sessionId, "sessionId");
        j.e(firstSessionId, "firstSessionId");
        j.e(dataCollectionStatus, "dataCollectionStatus");
        j.e(firebaseInstallationId, "firebaseInstallationId");
        j.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i;
        this.eventTimestampUs = j2;
        this.dataCollectionStatus = dataCollectionStatus;
        this.firebaseInstallationId = firebaseInstallationId;
        this.firebaseAuthenticationToken = firebaseAuthenticationToken;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i, long j2, DataCollectionStatus dataCollectionStatus, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sessionInfo.sessionId;
        }
        if ((i3 & 2) != 0) {
            str2 = sessionInfo.firstSessionId;
        }
        if ((i3 & 4) != 0) {
            i = sessionInfo.sessionIndex;
        }
        if ((i3 & 8) != 0) {
            j2 = sessionInfo.eventTimestampUs;
        }
        if ((i3 & 16) != 0) {
            dataCollectionStatus = sessionInfo.dataCollectionStatus;
        }
        if ((i3 & 32) != 0) {
            str3 = sessionInfo.firebaseInstallationId;
        }
        if ((i3 & 64) != 0) {
            str4 = sessionInfo.firebaseAuthenticationToken;
        }
        String str5 = str4;
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        long j3 = j2;
        int i4 = i;
        return sessionInfo.copy(str, str2, i4, j3, dataCollectionStatus2, str3, str5);
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
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final String component7() {
        return this.firebaseAuthenticationToken;
    }

    public final SessionInfo copy(String sessionId, String firstSessionId, int i, long j2, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        j.e(sessionId, "sessionId");
        j.e(firstSessionId, "firstSessionId");
        j.e(dataCollectionStatus, "dataCollectionStatus");
        j.e(firebaseInstallationId, "firebaseInstallationId");
        j.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionInfo(sessionId, firstSessionId, i, j2, dataCollectionStatus, firebaseInstallationId, firebaseAuthenticationToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return j.a(this.sessionId, sessionInfo.sessionId) && j.a(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && j.a(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && j.a(this.firebaseInstallationId, sessionInfo.firebaseInstallationId) && j.a(this.firebaseAuthenticationToken, sessionInfo.firebaseAuthenticationToken);
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
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

    public int hashCode() {
        return this.firebaseAuthenticationToken.hashCode() + AbstractC0008a.g(this.firebaseInstallationId, (this.dataCollectionStatus.hashCode() + ((Long.hashCode(this.eventTimestampUs) + ((Integer.hashCode(this.sessionIndex) + AbstractC0008a.g(this.firstSessionId, this.sessionId.hashCode() * 31, 31)) * 31)) * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.sessionId);
        sb.append(", firstSessionId=");
        sb.append(this.firstSessionId);
        sb.append(", sessionIndex=");
        sb.append(this.sessionIndex);
        sb.append(", eventTimestampUs=");
        sb.append(this.eventTimestampUs);
        sb.append(", dataCollectionStatus=");
        sb.append(this.dataCollectionStatus);
        sb.append(", firebaseInstallationId=");
        sb.append(this.firebaseInstallationId);
        sb.append(", firebaseAuthenticationToken=");
        return AbstractC0008a.s(sb, this.firebaseAuthenticationToken, ')');
    }
}
