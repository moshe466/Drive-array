package i8;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i8.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0199a extends Throwable {
        C0199a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        new C0199a("No further exceptions");
    }

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
