package nb;

/* loaded from: classes.dex */
final class i0 extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    private final p8.f f12396f;

    public i0(p8.f fVar) {
        this.f12396f = fVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f12396f.toString();
    }
}
