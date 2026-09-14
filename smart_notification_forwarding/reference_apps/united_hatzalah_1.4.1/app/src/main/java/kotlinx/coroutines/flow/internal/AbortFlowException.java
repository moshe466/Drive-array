package kotlinx.coroutines.flow.internal;

import S2.e;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class AbortFlowException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object f5316a;

    public AbortFlowException(e eVar) {
        super("Flow was aborted, no more elements needed");
        this.f5316a = eVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
