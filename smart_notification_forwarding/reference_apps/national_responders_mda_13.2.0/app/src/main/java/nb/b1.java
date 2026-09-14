package nb;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class b1 extends CancellationException implements s<b1> {

    /* renamed from: f, reason: collision with root package name */
    public final a1 f12365f;

    public b1(String str, Throwable th, a1 a1Var) {
        super(str);
        this.f12365f = a1Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // nb.s
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b1 a() {
        if (!d0.b()) {
            return null;
        }
        String message = getMessage();
        y8.k.b(message);
        return new b1(message, this, this.f12365f);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof b1) {
                b1 b1Var = (b1) obj;
                if (!y8.k.a(b1Var.getMessage(), getMessage()) || !y8.k.a(b1Var.f12365f, this.f12365f) || !y8.k.a(b1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (d0.b()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        y8.k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f12365f.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f12365f;
    }
}
