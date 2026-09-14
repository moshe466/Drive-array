package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
final class SessionEvent {
    public final Map<String, Object> customAttributes;
    public final String customType;
    public final Map<String, String> details;
    public final Map<String, Object> predefinedAttributes;
    public final String predefinedType;
    public final SessionEventMetadata sessionEventMetadata;
    private String stringRepresentation;
    public final long timestamp;
    public final Type type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Builder {
        final Type a;
        final long b = System.currentTimeMillis();
        Map<String, String> c = null;
        String d = null;
        Map<String, Object> e = null;
        String f = null;
        Map<String, Object> g = null;

        public Builder(Type type) {
            this.a = type;
        }

        public SessionEvent build(SessionEventMetadata sessionEventMetadata) {
            return new SessionEvent(sessionEventMetadata, this.b, this.a, this.c, this.d, this.e, this.f, this.g);
        }

        public Builder customAttributes(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public Builder customType(String str) {
            this.d = str;
            return this;
        }

        public Builder details(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public Builder predefinedAttributes(Map<String, Object> map) {
            this.g = map;
            return this;
        }

        public Builder predefinedType(String str) {
            this.f = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Type {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    private SessionEvent(SessionEventMetadata sessionEventMetadata, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.sessionEventMetadata = sessionEventMetadata;
        this.timestamp = j;
        this.type = type;
        this.details = map;
        this.customType = str;
        this.customAttributes = map2;
        this.predefinedType = str2;
        this.predefinedAttributes = map3;
    }

    public static Builder crashEventBuilder(String str) {
        return new Builder(Type.CRASH).details(Collections.singletonMap("sessionId", str));
    }

    public static Builder crashEventBuilder(String str, String str2) {
        return crashEventBuilder(str).customAttributes(Collections.singletonMap("exceptionName", str2));
    }

    public static Builder customEventBuilder(CustomEvent customEvent) {
        return new Builder(Type.CUSTOM).customType(customEvent.b()).customAttributes(customEvent.a());
    }

    public static Builder installEventBuilder(long j) {
        return new Builder(Type.INSTALL).details(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    public static Builder lifecycleEventBuilder(Type type, Activity activity) {
        return new Builder(type).details(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static Builder predefinedEventBuilder(PredefinedEvent<?> predefinedEvent) {
        return new Builder(Type.PREDEFINED).predefinedType(predefinedEvent.c()).predefinedAttributes(predefinedEvent.b()).customAttributes(predefinedEvent.a());
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            this.stringRepresentation = "[" + SessionEvent.class.getSimpleName() + ": timestamp=" + this.timestamp + ", type=" + this.type + ", details=" + this.details + ", customType=" + this.customType + ", customAttributes=" + this.customAttributes + ", predefinedType=" + this.predefinedType + ", predefinedAttributes=" + this.predefinedAttributes + ", metadata=[" + this.sessionEventMetadata + "]]";
        }
        return this.stringRepresentation;
    }
}
