package org.yaml.snakeyaml.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes2.dex */
public abstract class Event {
    private final Mark endMark;
    private final Mark startMark;

    /* loaded from: classes2.dex */
    public enum ID {
        Alias,
        Comment,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getArguments() {
        return JsonProperty.USE_DEFAULT_NAME;
    }

    public abstract ID getEventId();

    public Event(Mark mark, Mark mark2) {
        this.startMark = mark;
        this.endMark = mark2;
    }

    public String toString() {
        return "<" + getClass().getName() + "(" + getArguments() + ")>";
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public boolean is(ID id) {
        return getEventId() == id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
