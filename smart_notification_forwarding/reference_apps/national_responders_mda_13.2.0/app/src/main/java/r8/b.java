package r8;

/* loaded from: classes.dex */
public final class b implements p8.d<Object> {

    /* renamed from: f, reason: collision with root package name */
    public static final b f13793f = new b();

    private b() {
    }

    @Override // p8.d
    public void b(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // p8.d
    public p8.f c() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
