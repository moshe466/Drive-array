package io.opencensus.trace;

import io.opencensus.internal.Utils;
import io.opencensus.trace.AutoValue_MessageEvent;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class MessageEvent extends BaseMessageEvent {

    /* loaded from: classes2.dex */
    public static abstract class Builder {
        abstract Builder a(long j);

        public abstract MessageEvent build();

        public abstract Builder setCompressedMessageSize(long j);

        public abstract Builder setUncompressedMessageSize(long j);
    }

    /* loaded from: classes2.dex */
    public enum Type {
        SENT,
        RECEIVED
    }

    public static Builder builder(Type type, long j) {
        return new AutoValue_MessageEvent.Builder().a((Type) Utils.checkNotNull(type, "type")).a(j).setUncompressedMessageSize(0L).setCompressedMessageSize(0L);
    }

    public abstract long getCompressedMessageSize();

    public abstract long getMessageId();

    public abstract Type getType();

    public abstract long getUncompressedMessageSize();
}
