package io.opencensus.trace.export;

import io.opencensus.trace.export.SpanData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AutoValue_SpanData_TimedEvents<T> extends SpanData.TimedEvents<T> {
    private final int droppedEventsCount;
    private final List<SpanData.TimedEvent<T>> events;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SpanData_TimedEvents(List<SpanData.TimedEvent<T>> list, int i) {
        if (list == null) {
            throw new NullPointerException("Null events");
        }
        this.events = list;
        this.droppedEventsCount = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData.TimedEvents)) {
            return false;
        }
        SpanData.TimedEvents timedEvents = (SpanData.TimedEvents) obj;
        return this.events.equals(timedEvents.getEvents()) && this.droppedEventsCount == timedEvents.getDroppedEventsCount();
    }

    @Override // io.opencensus.trace.export.SpanData.TimedEvents
    public int getDroppedEventsCount() {
        return this.droppedEventsCount;
    }

    @Override // io.opencensus.trace.export.SpanData.TimedEvents
    public List<SpanData.TimedEvent<T>> getEvents() {
        return this.events;
    }

    public int hashCode() {
        return ((this.events.hashCode() ^ 1000003) * 1000003) ^ this.droppedEventsCount;
    }

    public String toString() {
        return "TimedEvents{events=" + this.events + ", droppedEventsCount=" + this.droppedEventsCount + "}";
    }
}
