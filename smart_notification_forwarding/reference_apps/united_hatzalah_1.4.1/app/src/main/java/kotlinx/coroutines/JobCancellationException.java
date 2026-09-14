package kotlinx.coroutines;

import P2.InterfaceC0157i0;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class JobCancellationException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0157i0 f5314a;

    public JobCancellationException(String str, Throwable th, InterfaceC0157i0 interfaceC0157i0) {
        super(str);
        this.f5314a = interfaceC0157i0;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!j.a(jobCancellationException.getMessage(), getMessage()) || !j.a(jobCancellationException.f5314a, this.f5314a) || !j.a(jobCancellationException.getCause(), getCause())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int i;
        String message = getMessage();
        j.b(message);
        int hashCode = (this.f5314a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i = cause.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f5314a;
    }
}
