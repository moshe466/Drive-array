package com.google.firebase.sessions;

import N2.n;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionGenerator {
    public static final Companion Companion = new Companion(null);
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final UuidGenerator uuidGenerator;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final SessionGenerator getInstance() {
            return ((FirebaseSessionsComponent) FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessionsComponent.class)).getSessionGenerator();
        }

        private Companion() {
        }
    }

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        j.e(timeProvider, "timeProvider");
        j.e(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        String uuid = this.uuidGenerator.next().toString();
        j.d(uuid, "uuidGenerator.next().toString()");
        String lowerCase = n.L(uuid, "-", "").toLowerCase(Locale.ROOT);
        j.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession() {
        String generateSessionId;
        int i = this.sessionIndex + 1;
        this.sessionIndex = i;
        if (i == 0) {
            generateSessionId = this.firstSessionId;
        } else {
            generateSessionId = generateSessionId();
        }
        this.currentSession = new SessionDetails(generateSessionId, this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        j.i("currentSession");
        throw null;
    }

    public final boolean getHasGenerateSession() {
        if (this.currentSession != null) {
            return true;
        }
        return false;
    }
}
