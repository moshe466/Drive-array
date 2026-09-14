package com.google.firebase.sessions;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class FirebaseSessionsData {
    private final String sessionId;

    public FirebaseSessionsData(String str) {
        this.sessionId = str;
    }

    public static /* synthetic */ FirebaseSessionsData copy$default(FirebaseSessionsData firebaseSessionsData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firebaseSessionsData.sessionId;
        }
        return firebaseSessionsData.copy(str);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final FirebaseSessionsData copy(String str) {
        return new FirebaseSessionsData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseSessionsData) && j.a(this.sessionId, ((FirebaseSessionsData) obj).sessionId);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        String str = this.sessionId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return AbstractC0008a.s(new StringBuilder("FirebaseSessionsData(sessionId="), this.sessionId, ')');
    }
}
