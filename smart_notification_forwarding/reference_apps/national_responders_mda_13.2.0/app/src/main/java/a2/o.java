package a2;

/* loaded from: classes.dex */
public final class o extends UnsupportedOperationException {

    /* renamed from: f, reason: collision with root package name */
    private final z1.c f89f;

    public o(z1.c cVar) {
        this.f89f = cVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f89f));
    }
}
