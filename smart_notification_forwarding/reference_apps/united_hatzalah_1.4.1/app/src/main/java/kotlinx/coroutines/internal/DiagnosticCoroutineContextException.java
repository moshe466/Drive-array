package kotlinx.coroutines.internal;

import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0768i f5317a;

    public DiagnosticCoroutineContextException(InterfaceC0768i interfaceC0768i) {
        this.f5317a = interfaceC0768i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f5317a.toString();
    }
}
