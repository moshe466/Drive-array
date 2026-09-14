package com.google.firebase.sessions;

import J0.d;
import com.google.firebase.inject.Provider;
import e3.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import q1.C0620a;
import q1.C0622c;
import q1.g;
import t1.r;

/* loaded from: classes.dex */
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "EventGDTLogger";
    private final Provider<g> transportFactoryProvider;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public EventGDTLogger(Provider<g> transportFactoryProvider) {
        j.e(transportFactoryProvider, "transportFactoryProvider");
        this.transportFactoryProvider = transportFactoryProvider;
    }

    public static /* synthetic */ byte[] a(EventGDTLogger eventGDTLogger, SessionEvent sessionEvent) {
        return eventGDTLogger.encode(sessionEvent);
    }

    public final byte[] encode(SessionEvent sessionEvent) {
        String encode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        j.d(encode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        sessionEvent.getEventType().name();
        byte[] bytes = encode.getBytes(N2.a.f1508a);
        j.d(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void log(SessionEvent sessionEvent) {
        j.e(sessionEvent, "sessionEvent");
        ((r) this.transportFactoryProvider.get()).a(AQS_LOG_SOURCE, new C0622c("json"), new d(this, 17)).a(new C0620a(sessionEvent, q1.d.f6150a, null), new c(8));
    }
}
