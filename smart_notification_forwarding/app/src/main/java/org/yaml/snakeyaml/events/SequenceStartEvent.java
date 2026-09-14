package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes2.dex */
public final class SequenceStartEvent extends CollectionStartEvent {
    public SequenceStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(str, str2, z, mark, mark2, flowStyle);
    }

    @Deprecated
    public SequenceStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, Boolean bool) {
        this(str, str2, z, mark, mark2, DumperOptions.FlowStyle.fromBoolean(bool));
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.SequenceStart;
    }
}
