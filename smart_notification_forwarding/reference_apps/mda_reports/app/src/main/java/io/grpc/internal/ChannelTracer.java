package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ChannelTracer {
    static final Logger a = Logger.getLogger(ChannelLogger.class.getName());
    private final long channelCreationTimeNanos;

    @GuardedBy("lock")
    @Nullable
    private final Collection<InternalChannelz.ChannelTrace.Event> events;

    @GuardedBy("lock")
    private int eventsLogged;
    private final Object lock = new Object();
    private final InternalLogId logId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.ChannelTracer$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[InternalChannelz.ChannelTrace.Event.Severity.values().length];

        static {
            try {
                a[InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelTracer(InternalLogId internalLogId, final int i, long j, String str) {
        Preconditions.checkNotNull(str, "description");
        this.logId = (InternalLogId) Preconditions.checkNotNull(internalLogId, "logId");
        this.events = i > 0 ? new ArrayDeque<InternalChannelz.ChannelTrace.Event>() { // from class: io.grpc.internal.ChannelTracer.1
            @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
            @GuardedBy("lock")
            public boolean add(InternalChannelz.ChannelTrace.Event event) {
                if (size() == i) {
                    removeFirst();
                }
                ChannelTracer.a(ChannelTracer.this);
                return super.add((AnonymousClass1) event);
            }
        } : null;
        this.channelCreationTimeNanos = j;
        a(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(str + " created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(j).build());
    }

    static /* synthetic */ int a(ChannelTracer channelTracer) {
        int i = channelTracer.eventsLogged;
        channelTracer.eventsLogged = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(InternalLogId internalLogId, Level level, String str) {
        if (a.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + internalLogId + "] " + str);
            logRecord.setLoggerName(a.getName());
            logRecord.setSourceClassName(a.getName());
            logRecord.setSourceMethodName("log");
            a.log(logRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalLogId a() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InternalChannelz.ChannelStats.Builder builder) {
        synchronized (this.lock) {
            if (this.events == null) {
                return;
            }
            builder.setChannelTrace(new InternalChannelz.ChannelTrace.Builder().setNumEventsLogged(this.eventsLogged).setCreationTimeNanos(this.channelCreationTimeNanos).setEvents(new ArrayList(this.events)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InternalChannelz.ChannelTrace.Event event) {
        int i = AnonymousClass2.a[event.severity.ordinal()];
        Level level = i != 1 ? i != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        b(event);
        a(this.logId, level, event.description);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(InternalChannelz.ChannelTrace.Event event) {
        synchronized (this.lock) {
            if (this.events != null) {
                this.events.add(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        boolean z;
        synchronized (this.lock) {
            z = this.events != null;
        }
        return z;
    }
}
