package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f3020b = new d(new Throwable("Failure occurred while trying to finish a future."));

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3021a;

    public d(Throwable th) {
        this.f3021a = (Throwable) j.checkNotNull(th);
    }
}
