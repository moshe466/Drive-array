package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes2.dex */
public interface Emitable {
    void emit(Event event) throws IOException;
}
