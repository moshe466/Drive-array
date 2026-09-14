package org.apache.tika.pipes.emitter;

import java.util.List;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

/* loaded from: classes.dex */
public interface Emitter {
    void emit(String str, List<Metadata> list, ParseContext parseContext);

    void emit(List<? extends EmitData> list);

    String getName();
}
