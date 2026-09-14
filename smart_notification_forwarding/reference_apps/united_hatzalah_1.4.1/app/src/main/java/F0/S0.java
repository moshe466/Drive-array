package F0;

/* loaded from: classes.dex */
public abstract class S0 extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f377a;

    public S0(String str) {
        super(str, null);
        this.f377a = null;
    }

    public abstract String a();

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f377a;
    }

    public S0(String str, Throwable th) {
        super(str, th);
        this.f377a = th;
    }
}
