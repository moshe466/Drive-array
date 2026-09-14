package bc;

/* loaded from: classes.dex */
public abstract class g implements r {

    /* renamed from: f, reason: collision with root package name */
    private final r f4304f;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4304f = rVar;
    }

    @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4304f.close();
    }

    @Override // bc.r
    public t e() {
        return this.f4304f.e();
    }

    @Override // bc.r, java.io.Flushable
    public void flush() {
        this.f4304f.flush();
    }

    @Override // bc.r
    public void l(c cVar, long j10) {
        this.f4304f.l(cVar, j10);
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4304f.toString() + ")";
    }
}
