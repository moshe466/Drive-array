package com.google.firebase.crashlytics.internal.metadata;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import t2.s;

/* loaded from: classes.dex */
public final class EventMetadata {
    private final Map<String, String> additionalCustomKeys;
    private final String sessionId;
    private final long timestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventMetadata(String sessionId, long j2) {
        this(sessionId, j2, null, 4, null);
        j.e(sessionId, "sessionId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventMetadata copy$default(EventMetadata eventMetadata, String str, long j2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventMetadata.sessionId;
        }
        if ((i & 2) != 0) {
            j2 = eventMetadata.timestamp;
        }
        if ((i & 4) != 0) {
            map = eventMetadata.additionalCustomKeys;
        }
        return eventMetadata.copy(str, j2, map);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Map<String, String> component3() {
        return this.additionalCustomKeys;
    }

    public final EventMetadata copy(String sessionId, long j2, Map<String, String> additionalCustomKeys) {
        j.e(sessionId, "sessionId");
        j.e(additionalCustomKeys, "additionalCustomKeys");
        return new EventMetadata(sessionId, j2, additionalCustomKeys);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return j.a(this.sessionId, eventMetadata.sessionId) && this.timestamp == eventMetadata.timestamp && j.a(this.additionalCustomKeys, eventMetadata.additionalCustomKeys);
    }

    public final Map<String, String> getAdditionalCustomKeys() {
        return this.additionalCustomKeys;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.additionalCustomKeys.hashCode() + ((Long.hashCode(this.timestamp) + (this.sessionId.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.sessionId + ", timestamp=" + this.timestamp + ", additionalCustomKeys=" + this.additionalCustomKeys + ')';
    }

    public EventMetadata(String sessionId, long j2, Map<String, String> additionalCustomKeys) {
        j.e(sessionId, "sessionId");
        j.e(additionalCustomKeys, "additionalCustomKeys");
        this.sessionId = sessionId;
        this.timestamp = j2;
        this.additionalCustomKeys = additionalCustomKeys;
    }

    public /* synthetic */ EventMetadata(String str, long j2, Map map, int i, f fVar) {
        this(str, j2, (i & 4) != 0 ? s.f6477a : map);
    }
}
