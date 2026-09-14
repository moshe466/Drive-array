package org.apache.tika.pipes.emitter;

import java.util.List;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

/* loaded from: classes.dex */
public class EmptyEmitter implements Emitter {
    @Override // org.apache.tika.pipes.emitter.Emitter
    public void emit(String str, List<Metadata> list, ParseContext parseContext) {
    }

    @Override // org.apache.tika.pipes.emitter.Emitter
    public String getName() {
        return "empty";
    }

    @Override // org.apache.tika.pipes.emitter.Emitter
    public void emit(List<? extends EmitData> list) {
    }
}
