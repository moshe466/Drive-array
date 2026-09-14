package bc;

/* loaded from: classes.dex */
public abstract class h implements s {

    /* renamed from: f, reason: collision with root package name */
    private final s f4305f;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4305f = sVar;
    }

    public final s c() {
        return this.f4305f;
    }

    @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4305f.close();
    }

    @Override // bc.s
    public t e() {
        return this.f4305f.e();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4305f.toString() + ")";
    }
}
