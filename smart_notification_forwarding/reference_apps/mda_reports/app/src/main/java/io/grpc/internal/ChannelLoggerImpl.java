package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ChannelLoggerImpl extends ChannelLogger {
    private final TimeProvider time;
    private final ChannelTracer tracer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.ChannelLoggerImpl$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ChannelLogger.ChannelLogLevel.values().length];

        static {
            try {
                a[ChannelLogger.ChannelLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ChannelLogger.ChannelLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelLoggerImpl(ChannelTracer channelTracer, TimeProvider timeProvider) {
        this.tracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "tracer");
        this.time = (TimeProvider) Preconditions.checkNotNull(timeProvider, "time");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(InternalLogId internalLogId, ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        Level javaLogLevel = toJavaLogLevel(channelLogLevel);
        if (ChannelTracer.a.isLoggable(javaLogLevel)) {
            ChannelTracer.a(internalLogId, javaLogLevel, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(InternalLogId internalLogId, ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        Level javaLogLevel = toJavaLogLevel(channelLogLevel);
        if (ChannelTracer.a.isLoggable(javaLogLevel)) {
            ChannelTracer.a(internalLogId, javaLogLevel, MessageFormat.format(str, objArr));
        }
    }

    private boolean isTraceable(ChannelLogger.ChannelLogLevel channelLogLevel) {
        return channelLogLevel != ChannelLogger.ChannelLogLevel.DEBUG && this.tracer.b();
    }

    private static Level toJavaLogLevel(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i = AnonymousClass1.a[channelLogLevel.ordinal()];
        return i != 1 ? i != 2 ? Level.FINEST : Level.FINER : Level.FINE;
    }

    private static InternalChannelz.ChannelTrace.Event.Severity toTracerSeverity(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i = AnonymousClass1.a[channelLogLevel.ordinal()];
        return i != 1 ? i != 2 ? InternalChannelz.ChannelTrace.Event.Severity.CT_INFO : InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING : InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR;
    }

    private void trace(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        if (channelLogLevel == ChannelLogger.ChannelLogLevel.DEBUG) {
            return;
        }
        this.tracer.b(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(str).setSeverity(toTracerSeverity(channelLogLevel)).setTimestampNanos(this.time.currentTimeNanos()).build());
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        a(this.tracer.a(), channelLogLevel, str);
        if (isTraceable(channelLogLevel)) {
            trace(channelLogLevel, str);
        }
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        log(channelLogLevel, (isTraceable(channelLogLevel) || ChannelTracer.a.isLoggable(toJavaLogLevel(channelLogLevel))) ? MessageFormat.format(str, objArr) : null);
    }
}
