package org.apache.tika.pipes.async;

import java.util.List;
import java.util.function.Function;
import org.apache.tika.pipes.async.AsyncEmitter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        List lambda$add$0;
        lambda$add$0 = AsyncEmitter.EmitDataCache.lambda$add$0((String) obj);
        return lambda$add$0;
    }
}
